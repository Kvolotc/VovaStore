angular.module('myApp').controller(
		'searchRims',
		function($scope, $rootScope, $http, $location, $routeParams,
				paginationService, purchaseProductFactory, basketFactory, toastr) {

			$scope.rims = [];
			
			$scope.isEmpty = false;

			$scope.paginationService = paginationService;
			
			$scope.currentRimId;		
			
			
			$scope.filesChanged = function(elm) {
	
				document.getElementById('placeHolder '+$scope.currentRimId).placeholder =  elm.files[0].name;
				document.getElementById('send '+$scope.currentRimId).disabled = false;
				document.getElementById('formUpload '+$scope.currentRimId).action = /photo/+'Rim/'+$scope.currentRimId;
		
				$scope.$apply();
			}
			
			
			$scope.changeRimId = function(rimId) {
				
				$scope.currentRimId = rimId;			
			}
			
			
            $scope.addToBacket = function(product) {
            	
				toastr.success('Rim '+product.brand +' '+ product.model+' was added in basket');
				
				var ind = basketFactory.map(function(e) { return e.imageName; }).indexOf(product.imageName);

				if(ind != -1) {
					basketFactory[ind].amount++;
					basketFactory[ind].price += product.price;
					return;
				}
				
				basketFactory.push({
					amount:1,
					product:'rims',
					imageName: product.imageName,
					brand:product.brand,
					model:product.model,
					productPrice:product.price,
					price:product.price
				});
			};
			
			

			$scope.urlRim = "#!/searchRims/word=" + $routeParams.word + ";min="
					+ $routeParams.min + ";max=" + $routeParams.max + ";page=";

			$scope.url = "/searchRims/word=" + $routeParams.word + ";min="
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

			paginationService.pagination('/getAmountPageSearchRims/?word='
					+ $routeParams.word + '&min=' + $routeParams.min + '&max='
					+ $routeParams.max, $routeParams.page,
					$scope.paginationParam)

			$http(
					{
						method : "GET",
						url : '/searchRims/?word=' + $routeParams.word
								+ '&min=' + $routeParams.min + '&max='
								+ $routeParams.max + '&page='
								+ $routeParams.page
					}).then(function(response) {
				$scope.rims = response.data;
				if($scope.rims.length == 0) {
					$scope.isEmpty = true;
				}
			}, function myError(response) {

			});

		});