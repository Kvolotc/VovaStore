angular.module('myApp').controller(
		'racingBikes',
		function($scope, $rootScope, $http, $location, $routeParams,
				paginationService, purchaseProductFactory) {

			$scope.bikes = [];

			$scope.paginationService = paginationService;

			$scope.urlBike = "#!/racingBikes/";

			$scope.url = "/racingBikes/";
			
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

			paginationService.pagination('/getCountPage/racingBikes',
					$routeParams.page, $scope.paginationParam)

			$http({
				method : "GET",
				url : '/racingBikes/' + $routeParams.page
			}).then(function(response) {
				$scope.bikes = response.data;
			}, function myError(response) {

			});

		});