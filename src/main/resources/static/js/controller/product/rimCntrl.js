angular.module('myApp').controller(
		'rims',
		function($scope, $http, $routeParams, $location, $routeParams,
				paginationService) {

			$scope.rims = [];

			$scope.paginationService = paginationService;

			$scope.urlRim = "#!/rims/";

			$scope.url = "/rims/";

			$scope.countRims = 1;

			$scope.activeRim = {};

			$scope.paginationParam = {
				masPages : [],
				isNext : false,
				isPrevious : false
			}

			paginationService.pagination('/getCountPage/rims',
					$routeParams.page, $scope.paginationParam)

			$http({
				method : "GET",
				url : '/rims/' + $routeParams.page
			}).then(function(response) {
				$scope.rims = response.data;

			}, function myError(response) {

			});

			$scope.price = function() {
				$scope.activeRims.price = $scope.activeRims.price
						* $scope.countRims;
			}

			$scope.changeActiveRim = function(rim) {
				$scope.activeRim = rim;
			}

		});