angular.module('myApp').controller(
		'mountainBike',
		function($scope, $rootScope, $http, $location, $routeParams,
				paginationService, purchaseProductFactory, basketFactory, toastr) {

			$scope.bikes = [];

			$scope.paginationService = paginationService;

			$scope.urlBike = "#!/mountainBikes/";

			$scope.url = "/mountainBikes/";
			
			$scope.currentBikeId;		
			
			
			$scope.filesChanged = function(elm) {
	
				document.getElementById('placeHolder '+$scope.currentBikeId).placeholder =  elm.files[0].name;
				document.getElementById('send '+$scope.currentBikeId).disabled = false;
				document.getElementById('formUpload '+$scope.currentBikeId).action = /photo/+'bike/'+$scope.currentBikeId;
		
				$scope.$apply();
			}
			
			
			$scope.changeBikeId = function(bikeId) {
				
				$scope.currentBikeId = bikeId;			
			}
			
	 		
	        $scope.addToBacket = function(product) {
	        	
	        	toastr.success('Bike '+product.frame.brand +' '+ product.frame.model+' was added in basket');
				
				var ind = basketFactory.map(function(e) { return e.imageName; }).indexOf(product.imageName);
				
				if(ind != -1) {
					basketFactory[ind].amount++;
					basketFactory[ind].price += product.price;
					return;
				}
				
				basketFactory.push({
					amount:1,
					product:'bikes',
					imageName: product.imageName,
					brand:product.frame.brand,
					model:product.frame.model,
					productPrice:product.price,
					price:product.price
				});
			};
			
			

			$scope.buyProduct = function(product) {
				if(purchaseProductFactory.length >=1) {
					purchaseProductFactory.splice(0, purchaseProductFactory.length)
				}
				purchaseProductFactory.push(product)
			}

			$scope.paginationParam = {
				masPages : [],
				isNext : false,
				isPrevious : false
			}

			paginationService.pagination('/getAmountPage/mountainBikes',
					$routeParams.page, $scope.paginationParam)

			$http({
				method : "GET",
				url : '/mountainBikes/' + $routeParams.page
			}).then(function(response) {
				$scope.bikes = response.data;
			}, function myError(response) {

			});

		});