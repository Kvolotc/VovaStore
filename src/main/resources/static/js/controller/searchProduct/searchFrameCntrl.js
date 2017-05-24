angular.module('myApp').controller(
		'searchFrames',
		function($scope, $rootScope, $http, $location, $routeParams,
				paginationService) {

			$scope.frames = [];
			
			$scope.isEmpty = false;

			$scope.paginationService = paginationService;

			$scope.urlFrame = "#!/searchFrames/word=" + $routeParams.word
					+ ";min=" + $routeParams.min + ";max=" + $routeParams.max
					+ ";page=";

			$scope.url = "/searchFrames/word=" + $routeParams.word + ";min="
					+ $routeParams.min + ";max=" + $routeParams.max + ";page=";

			$scope.router = $routeParams;

			$scope.hideProduct = true;

			$scope.countFrames = 1;

			$scope.activeFrame = {};

			$scope.paginationParam = {
				masPages : [],
				isNext : false,
				isPrevious : false
			}

			paginationService.pagination('/countSearchFrames/?word='
					+ $routeParams.word + '&min=' + $routeParams.min + '&max='
					+ $routeParams.max, $routeParams.page,
					$scope.paginationParam)

			$http(
					{
						method : "GET",
						url : '/searchFrames/?word=' + $routeParams.word
								+ '&min=' + $routeParams.min + '&max='
								+ $routeParams.max + '&page='
								+ $routeParams.page
					}).then(function(response) {
				$scope.frames = response.data;
				if($scope.frames.length == 0) {
					$scope.isEmpty = true;
				}
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