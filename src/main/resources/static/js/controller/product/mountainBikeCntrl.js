angular.module('myApp').controller(
		'mountainBike',
		function($scope, $rootScope, $http, $location, $routeParams,
				paginationService, purchaseProductFactory) {

			$scope.bikes = [];

			$scope.paginationService = paginationService;

			$scope.urlBike = "#!/mountainBikes/";

			$scope.url = "/mountainBikes/";

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

			paginationService.pagination('/getCountPage/mountainBikes',
					$routeParams.page, $scope.paginationParam)

			$http({
				method : "GET",
				url : '/mountainBikes/' + $routeParams.page
			}).then(function(response) {
				$scope.bikes = response.data;
			}, function myError(response) {

			});

		});