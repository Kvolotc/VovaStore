angular.module('myApp').controller(
		'forks',
		function($scope, $http, $routeParams, $location, $routeParams,
				paginationService) {

			$scope.forks = [];

			$scope.paginationService = paginationService;

			$scope.urlFork = "#!/forks/";

			$scope.url = "/forks/";

			$scope.countForks = 1;

			$scope.activeFork = {};

			$scope.paginationParam = {
				masPages : [],
				isNext : false,
				isPrevious : false
			}

			paginationService.pagination('/getCountPage/forks',
					$routeParams.page, $scope.paginationParam)

			$http({
				method : "GET",
				url : '/forks/' + $routeParams.page
			}).then(function(response) {
				$scope.forks = response.data;

			}, function myError(response) {

			});

			$scope.price = function() {
				$scope.activeFork.price = $scope.activeFork.price
						* $scope.countForks;
			}

			$scope.changeActiveFork = function(fork) {
				$scope.activeFork = fork;
			}

		});