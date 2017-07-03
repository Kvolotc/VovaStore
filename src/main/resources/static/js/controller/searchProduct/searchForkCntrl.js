angular.module('myApp').controller(
		'searchForks',
		function($scope, $rootScope, $http, $location, $routeParams,
				paginationService, purchaseProductFactory, basketFactory, toastr) {

			$scope.forks = [];
			
			$scope.isEmpty = false;

			$scope.paginationService = paginationService;
			
			$scope.currentForkId;		
			
			
			$scope.filesChanged = function(elm) {
	
				document.getElementById('placeHolder '+$scope.currentForkId).placeholder =  elm.files[0].name;
				document.getElementById('send '+$scope.currentForkId).disabled = false;
				document.getElementById('formUpload '+$scope.currentForkId).action = /photo/+'fork/'+$scope.currentForkId;
		
				$scope.$apply();
			}
			
			
			$scope.changeForkId = function(forkId) {
				
				$scope.currentForkId = forkId;			
			}
			
			
			$scope.addToBacket = function(product) {
				
				toastr.success('Fork'+product.brand +' '+ product.model+' was added in basket');
				
				var ind = basketFactory.map(function(e) { return e.imageName; }).indexOf(product.imageName);
				
				if(ind != -1) {
					basketFactory[ind].amount++;
					basketFactory[ind].price += product.price;
					return;
				}
				
				basketFactory.push({
					amount:1,
					product:'forks',
					imageName: product.imageName,
					brand:product.brand,
					model:product.model,
					productPrice:product.price,
					price:product.price
				});
			};
			
			

			$scope.urlFork = "#!/searchForks/word=" + $routeParams.word
					+ ";min=" + $routeParams.min + ";max=" + $routeParams.max
					+ ";page=";

			$scope.url = "/searchForks/word=" + $routeParams.word + ";min="
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

			paginationService.pagination('/getAmountPageSearchForks/?word='
					+ $routeParams.word + '&min=' + $routeParams.min + '&max='
					+ $routeParams.max, $routeParams.page,
					$scope.paginationParam)

			$http(
					{
						method : "GET",
						url : '/searchForks/?word=' + $routeParams.word
								+ '&min=' + $routeParams.min + '&max='
								+ $routeParams.max + '&page='
								+ $routeParams.page
					}).then(function(response) {
				$scope.forks = response.data;
				if($scope.forks.length == 0) {
					$scope.isEmpty = true;
				}
			}, function myError(response) {

			});

		});