angular.module('myApp').controller(
		'searchTires',
		function($scope, $rootScope, $http, $location, $routeParams,
				paginationService, purchaseProductFactory) {

			$scope.tires = [];
			
			$scope.isEmpty = false;

			$scope.paginationService = paginationService;

			$scope.urlTire = "#!/searchTires/word=" + $routeParams.word
					+ ";min=" + $routeParams.min + ";max=" + $routeParams.max
					+ ";page=";

			$scope.url = "/searchTires/word=" + $routeParams.word + ";min="
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

			paginationService.pagination('/countSearchTires/?word='
					+ $routeParams.word + '&min=' + $routeParams.min + '&max='
					+ $routeParams.max, $routeParams.page,
					$scope.paginationParam)

			$http(
					{
						method : "GET",
						url : '/searchTires/?word=' + $routeParams.word
								+ '&min=' + $routeParams.min + '&max='
								+ $routeParams.max + '&page='
								+ $routeParams.page
					}).then(function(response) {
				$scope.tires = response.data;
				if($scope.tires.length == 0) {
					$scope.isEmpty = true;
				}
			}, function myError(response) {

			});

		});