angular.module('myApp').controller(
		'brakes',
		function($scope, $http, $routeParams, $location, $routeParams,
				paginationService, purchaseProductFactory) {

			$scope.brakes = [];

			$scope.paginationService = paginationService;

			$scope.urlBrake = "#!/brakes/";

			$scope.url = "/brakes/";
			
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

			paginationService.pagination('/getCountPage/brakes',
					$routeParams.page, $scope.paginationParam)

			$http({
				method : "GET",
				url : '/brakes/' + $routeParams.page
			}).then(function(response) {
				$scope.brakes = response.data;

			}, function myError(response) {

			});


		});