angular.module('myApp').controller(
		'searchForks',
		function($scope, $rootScope, $http, $location, $routeParams,
				paginationService) {

			$scope.forks = [];

			$scope.paginationService = paginationService;

			$scope.urlFork = "#!/searchForks/word=" + $routeParams.word
					+ ";min=" + $routeParams.min + ";max=" + $routeParams.max
					+ ";page=";

			$scope.url = "/searchForks/word=" + $routeParams.word + ";min="
					+ $routeParams.min + ";max=" + $routeParams.max + ";page=";

			$scope.router = $routeParams;

			$scope.hideProduct = true;

			$scope.countForks = 1;

			$scope.activeFork = {};

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