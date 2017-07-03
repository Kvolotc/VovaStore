angular.module('myApp').controller(
		'searchBrakes',
		function($scope, $rootScope, $http, $location, $routeParams,
				paginationService, purchaseProductFactory, basketFactory, toastr) {

			$scope.brakes = [];
			
			$scope.isEmpty = false;

			$scope.paginationService = paginationService;
			
			$scope.currentBrakeId;		
			
			
			$scope.filesChanged = function(elm) {
	
				document.getElementById('placeHolder '+$scope.currentBrakeId).placeholder =  elm.files[0].name;
				document.getElementById('send '+$scope.currentBrakeId).disabled = false;
				document.getElementById('formUpload '+$scope.currentBrakeId).action = /photo/+'Brake/'+$scope.currentBrakeId;
		
				$scope.$apply();
			}
			
			
			$scope.changeBrakeId = function(brakeId) {
				
				$scope.currentBrakeId = brakeId;			
			}
			
			
			$scope.addToBacket = function(product) {
				
				toastr.success('Brake '+product.brand +' '+ product.model+' was added in basket');
				
				var ind = basketFactory.map(function(e) { return e.imageName; }).indexOf(product.imageName);
				
				if(ind != -1) {
					basketFactory[ind].amount++;
					basketFactory[ind].price += product.price;
					return;
				}
				
				basketFactory.push({
					amount:1,
					product:'brakes',
					imageName: product.imageName,
					brand:product.brand,
					model:product.model,
					productPrice:product.price,
					price:product.price
				});
			};
			

			$scope.urlBrake = "#!/searchBrakes/word=" + $routeParams.word
					+ ";min=" + $routeParams.min + ";max=" + $routeParams.max
					+ ";page=";

			$scope.url = "/searchBrakes/word=" + $routeParams.word + ";min="
					+ $routeParams.min + ";max=" + $routeParams.max + ";page=";

			$scope.router = $routeParams;
			
			$scope.buyProduct = function(product) {
				if(purchaseProductFactory.length >=1) {
					purchaseProductFactory.splice(0, purchaseProductFactory.length)
				}
				purchaseProductFactory.push(product)
			}

			$scope.hideProduct = true;


			$scope.paginationParam = {
				masPages : [],
				isNext : false,
				isPrevious : false
			}

			paginationService.pagination('/getAmountPageSearchBrakes/?word='
					+ $routeParams.word + '&min=' + $routeParams.min + '&max='
					+ $routeParams.max, $routeParams.page,
					$scope.paginationParam)

			$http(
					{
						method : "GET",
						url : '/searchBrakes/?word=' + $routeParams.word
								+ '&min=' + $routeParams.min + '&max='
								+ $routeParams.max + '&page='
								+ $routeParams.page
					}).then(function(response) {
				$scope.brakes = response.data;
				if($scope.brakes.length == 0) {
					$scope.isEmpty = true;
				}
			}, function myError(response) {

			});

		});