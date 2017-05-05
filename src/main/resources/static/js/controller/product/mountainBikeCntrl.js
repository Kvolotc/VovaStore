angular.module('myApp').controller(
		'mountainBike',
		function($scope, $rootScope, $http, $location, $routeParams,
				paginationService) {

			$scope.bikes = [];

			$scope.paginationService = paginationService;

			$scope.urlBike = "#!/mountainBikes/";

			$scope.url = "/mountainBikes/";

			$scope.countBikes = 1;

			$scope.activeBike = {};

			$scope.paginationParam = {
				masPages : [],
				isNext : false,
				isPrevious : false
			}

			paginationService.pagination('/getCountPage/mountainBikes',
					$routeParams.page, $scope.paginationParam)

			$http({
				method : "GET",
				url : '/mountainBikes/' + $routeParams.page
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