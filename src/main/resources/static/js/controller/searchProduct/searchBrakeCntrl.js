angular.module('myApp').controller(
		'searchBrakes',
		function($scope, $rootScope, $http, $location, $routeParams,
				paginationService, purchaseProductFactory) {

			$scope.brakes = [];
			
			$scope.isEmpty = false;

			$scope.paginationService = paginationService;

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

			paginationService.pagination('/countSearchBrakes/?word='
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