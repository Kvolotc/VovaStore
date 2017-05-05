angular.module('myApp').controller(
		'racingBikes',
		function($scope, $rootScope, $http, $location, $routeParams,
				paginationService) {

			$scope.bikes = [];

			$scope.paginationService = paginationService;

			$scope.urlBike = "#!/racingBikes/";

			$scope.url = "/racingBikes/";

			$scope.countBikes = 1;

			$scope.activeBike = {};

			$scope.paginationParam = {
				masPages : [],
				isNext : false,
				isPrevious : false
			}

			paginationService.pagination('/getCountPage/racingBikes',
					$routeParams.page, $scope.paginationParam)

			$http({
				method : "GET",
				url : '/racingBikes/' + $routeParams.page
			}).then(function(response) {
				$scope.bikes = response.data;
			}, function myError(response) {

			});

			$scope.price = function() {
				$scope.activeBike.price = $scope.activeBike.price
						* $scope.count;
			}

			$scope.changeActiveBike = function(bike) {
				$scope.activeBike = bike;
			}

		});