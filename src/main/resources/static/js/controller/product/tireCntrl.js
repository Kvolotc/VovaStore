angular.module('myApp').controller(
		'tires',
		function($scope, $http, $routeParams, $location, $routeParams,
				paginationService, purchaseProductFactory, basketFactory, toastr) {

			$scope.tires = [];

			$scope.paginationService = paginationService;

			$scope.urlTire = "#!/tires/";

			$scope.url = "/tires/";
			
			$scope.currentTireId;		
			
			
			$scope.filesChanged = function(elm) {
	
				document.getElementById('placeHolder '+$scope.currentTireId).placeholder =  elm.files[0].name;
				document.getElementById('send '+$scope.currentTireId).disabled = false;
				document.getElementById('formUpload '+$scope.currentTireId).action = /photo/+'tire/'+$scope.currentTireId;
		
				$scope.$apply();
			}
			
			
			$scope.changeTireId = function(tireId) {
				
				$scope.currentTireId = tireId;			
			}
			
			
            $scope.addToBacket = function(product) {
            	
				toastr.success('Tire '+product.brand +' '+ product.model+' was added in basket');
				
				var ind = basketFactory.map(function(e) { return e.imageName; }).indexOf(product.imageName);
				
				console.log(ind)
				
				if(ind != -1) {
					basketFactory[ind].amount++;
					basketFactory[ind].price += product.price;
					return;
				}
				
				basketFactory.push({
					amount:1,
					product:'tires',
					imageName: product.imageName,
					brand:product.brand,
					model:product.model,
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

			paginationService.pagination('/getAmountPage/tires',
					$routeParams.page, $scope.paginationParam)

			$http({
				method : "GET",
				url : '/tires/' + $routeParams.page
			}).then(function(response) {
				$scope.tires = response.data;

			}, function myError(response) {

			});

		});