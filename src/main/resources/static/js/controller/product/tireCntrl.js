angular.module('myApp').controller(
		'tires',
		function($scope, $http, $routeParams, $location, $routeParams,
				paginationService) {

			$scope.tires = [];

			$scope.paginationService = paginationService;

			$scope.urlTire = "#!/tires/";

			$scope.url = "/tires/";

			$scope.counTires = 1;

			$scope.activeTire = {};

			$scope.paginationParam = {
				masPages : [],
				isNext : false,
				isPrevious : false
			}

			paginationService.pagination('/getCountPage/tires',
					$routeParams.page, $scope.paginationParam)

			$http({
				method : "GET",
				url : '/tires/' + $routeParams.page
			}).then(function(response) {
				$scope.tires = response.data;

			}, function myError(response) {

			});

			$scope.price = function() {
				$scope.activeTires.price = $scope.activeTires.price
						* $scope.counTires;
			}

			$scope.changeActiveTire = function(tire) {
				$scope.activeTire = tire;
			}

		});