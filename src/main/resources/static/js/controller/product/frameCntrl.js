angular.module('myApp').controller(
		'frames',
		function($scope, $http, $routeParams, $location, $routeParams,
				paginationService) {

			$scope.frames = [];

			$scope.paginationService = paginationService;

			$scope.urlFrame = "#!/frames/";

			$scope.url = "/frames/";

			$scope.countFrames = 1;

			$scope.activeFrame = {};

			$scope.paginationParam = {
				masPages : [],
				isNext : false,
				isPrevious : false
			}

			paginationService.pagination('/getCountPage/frames',
					$routeParams.page, $scope.paginationParam)

			$http({
				method : "GET",
				url : '/frames/' + $routeParams.page
			}).then(function(response) {
				$scope.frames = response.data;

			}, function myError(response) {

			});

			$scope.price = function() {
				$scope.activeFrame.price = $scope.activeFrame.price
						* $scope.countFrames;
			}

			$scope.changeActiveFrame = function(frame) {
				$scope.activeFrame = frame;
			}

		});