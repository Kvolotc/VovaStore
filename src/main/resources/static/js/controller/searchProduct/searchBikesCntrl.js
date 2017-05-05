angular.module('myApp').controller(
		'searchBikes',
		function($scope, $rootScope, $http, $location, $routeParams,
				paginationService) {

			$scope.bikes = [];

			$scope.paginationService = paginationService;

			$scope.urlBike = "#!/searchBikes/word=" + $routeParams.word
					+ ";min=" + $routeParams.min + ";max=" + $routeParams.max
					+ ";page=";

			$scope.url = "/searchBikes/word=" + $routeParams.word + ";min="
					+ $routeParams.min + ";max=" + $routeParams.max + ";page=";

			$scope.router = $routeParams;

			$scope.hideProduct = true;

			$scope.countBikes = 1;

			$scope.activeBike = {};

			$scope.paginationParam = {
				masPages : [],
				isNext : false,
				isPrevious : false
			}

			paginationService.pagination('/countSearchBikes/?word='
					+ $routeParams.word + '&min=' + $routeParams.min + '&max='
					+ $routeParams.max, $routeParams.page,
					$scope.paginationParam)

			$http(
					{
						method : "GET",
						url : '/searchBikes/?word=' + $routeParams.word
								+ '&min=' + $routeParams.min + '&max='
								+ $routeParams.max + '&page='
								+ $routeParams.page
					}).then(function(response) {
				$scope.bikes = response.data;
			}, function myError(response) {

			});

			$scope.price = function() {
				$scope.activeBike.price = $scope.activeBike.price
						* $scope.countBikes;
			}

			$scope.changeActiveBike = function(bike) {
				$scope.activeBike = bike;
			}

		});