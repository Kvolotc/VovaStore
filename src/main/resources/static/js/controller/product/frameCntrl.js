angular.module('myApp').controller(
		'frames',
		function($scope, $http, $routeParams, $location, $routeParams,
				paginationService, purchaseProductFactory) {

			$scope.frames = [];

			$scope.paginationService = paginationService;

			$scope.urlFrame = "#!/frames/";

			$scope.url = "/frames/";
			
			$scope.buyProduct = function(product) {
				if(purchaseProductFactory.length >=1) {
					purchaseProductFactory.splice(0, purchaseProductFactory.length)
				}
				purchaseProductFactory.push(product)
			}

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


		});