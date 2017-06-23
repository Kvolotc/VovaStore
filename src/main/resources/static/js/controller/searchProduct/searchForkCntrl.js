angular.module('myApp').controller(
		'searchForks',
		function($scope, $rootScope, $http, $location, $routeParams,
				paginationService, purchaseProductFactory) {

			$scope.forks = [];
			
			$scope.isEmpty = false;

			$scope.paginationService = paginationService;

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

			paginationService.pagination('/countSearchForks/?word='
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