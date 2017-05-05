angular.module('myApp').controller(
		'searchTires',
		function($scope, $rootScope, $http, $location, $routeParams,
				paginationService) {

			$scope.tires = [];

			$scope.paginationService = paginationService;

			$scope.urlTire = "#!/searchTires/word=" + $routeParams.word
					+ ";min=" + $routeParams.min + ";max=" + $routeParams.max
					+ ";page=";

			$scope.url = "/searchTires/word=" + $routeParams.word + ";min="
					+ $routeParams.min + ";max=" + $routeParams.max + ";page=";

			$scope.router = $routeParams;

			$scope.hideProduct = true;

			$scope.countTires = 1;

			$scope.activeTire = {};

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
			}, function myError(response) {

			});

			$scope.price = function() {
				$scope.activeTire.price = $scope.activeTire.price
						* $scope.countTires;
			}

			$scope.changeActiveTire = function(tire) {
				$scope.activeTire = tire;
			}

		});