angular.module('myApp').controller(
		'brakes',
		function($scope, $http, $routeParams, $location, $routeParams,
				paginationService) {

			$scope.brakes = [];

			$scope.paginationService = paginationService;

			$scope.urlBrake = "#!/brakes/";

			$scope.url = "/brakes/";

			$scope.countBrakes = 1;

			$scope.activeBrake = {};

			$scope.paginationParam = {
				masPages : [],
				isNext : false,
				isPrevious : false
			}

			paginationService.pagination('/getCountPage/brakes',
					$routeParams.page, $scope.paginationParam)

			$http({
				method : "GET",
				url : '/brakes/' + $routeParams.page
			}).then(function(response) {
				$scope.brakes = response.data;

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