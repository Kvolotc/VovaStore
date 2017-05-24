angular.module('myApp').controller(
		'searchBrakes',
		function($scope, $rootScope, $http, $location, $routeParams,
				paginationService) {

			$scope.brakes = [];
			
			$scope.isEmpty = false;

			$scope.paginationService = paginationService;

			$scope.urlBrake = "#!/searchBrakes/word=" + $routeParams.word
					+ ";min=" + $routeParams.min + ";max=" + $routeParams.max
					+ ";page=";

			$scope.url = "/searchBrakes/word=" + $routeParams.word + ";min="
					+ $routeParams.min + ";max=" + $routeParams.max + ";page=";

			$scope.router = $routeParams;

			$scope.hideProduct = true;

			$scope.countBrakes = 1;

			$scope.activeBrake = {};

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

			$scope.price = function() {
				$scope.activeBrake.price = $scope.activeBrake.price
						* $scope.countBrakes;
			}

			$scope.changeActiveBrake = function(brake) {
				$scope.activeBrake = brake;
			}

		});