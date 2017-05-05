angular.module('myApp').controller(
		'allMountainsBikes',
		function($scope, $rootScope, $http, $location, $routeParams,
				paginationService) {

			$scope.bikes = [];

			$scope.paginationService = paginationService;

			$scope.urlBike = "#!/allMountainBikes/";

			$scope.url = "/allMountainBikes/";

			$scope.countBikes = 1;

			$scope.activeBike = {};

			$scope.paginationParam = {
				masPages : [],
				isNext : false,
				isPrevious : false
			}

			paginationService.pagination('/getCountPage/allMountainBikes',
					$routeParams.page, $scope.paginationParam)

			$http({
				method : "GET",
				url : '/allMountainBikes/' + $routeParams.page
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