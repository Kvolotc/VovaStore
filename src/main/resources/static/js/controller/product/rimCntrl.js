angular.module('myApp').controller(
		'rims',
		function($scope, $http, $routeParams, $location, $routeParams,
				paginationService, purchaseProductFactory) {

			$scope.rims = [];

			$scope.paginationService = paginationService;

			$scope.urlRim = "#!/rims/";

			$scope.url = "/rims/";

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

			paginationService.pagination('/getCountPage/rims',
					$routeParams.page, $scope.paginationParam)

			$http({
				method : "GET",
				url : '/rims/' + $routeParams.page
			}).then(function(response) {
				$scope.rims = response.data;

			}, function myError(response) {

			});

		});