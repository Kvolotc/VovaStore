angular.module('myApp').controller(
		'forks',
		function($scope, $http, $routeParams, $location, $routeParams,
				paginationService, purchaseProductFactory) {

			$scope.forks = [];

			$scope.paginationService = paginationService;

			$scope.urlFork = "#!/forks/";

			$scope.url = "/forks/";
			
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

			paginationService.pagination('/getCountPage/forks',
					$routeParams.page, $scope.paginationParam)

			$http({
				method : "GET",
				url : '/forks/' + $routeParams.page
			}).then(function(response) {
				$scope.forks = response.data;

			}, function myError(response) {

			});


		});