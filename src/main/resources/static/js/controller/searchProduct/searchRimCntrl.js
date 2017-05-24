angular.module('myApp').controller(
		'searchRims',
		function($scope, $rootScope, $http, $location, $routeParams,
				paginationService) {

			$scope.rims = [];
			
			$scope.isEmpty = false;

			$scope.paginationService = paginationService;

			$scope.urlRim = "#!/searchRims/word=" + $routeParams.word + ";min="
					+ $routeParams.min + ";max=" + $routeParams.max + ";page=";

			$scope.url = "/searchRims/word=" + $routeParams.word + ";min="
					+ $routeParams.min + ";max=" + $routeParams.max + ";page=";

			$scope.router = $routeParams;

			$scope.hideProduct = true;

			$scope.countRims = 1;

			$scope.activeRim = {};

			$scope.paginationParam = {
				masPages : [],
				isNext : false,
				isPrevious : false
			}

			paginationService.pagination('/countSearchRims/?word='
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

			$scope.price = function() {
				$scope.activeRim.price = $scope.activeRim.price
						* $scope.countRims;
			}

			$scope.changeActiveRim = function(rim) {
				$scope.activeRim = rim;
			}

		});