angular.module('myApp').controller(
		'tires',
		function($scope, $http, $routeParams, $location, $routeParams,
				paginationService, purchaseProductFactory) {

			$scope.tires = [];

			$scope.paginationService = paginationService;

			$scope.urlTire = "#!/tires/";

			$scope.url = "/tires/";
			
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

			paginationService.pagination('/getCountPage/tires',
					$routeParams.page, $scope.paginationParam)

			$http({
				method : "GET",
				url : '/tires/' + $routeParams.page
			}).then(function(response) {
				$scope.tires = response.data;

			}, function myError(response) {

			});

		});