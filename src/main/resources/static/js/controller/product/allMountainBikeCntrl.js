angular.module('myApp').controller(
		'allMountainsBikes',
		function($scope, $rootScope, $http, $location, $routeParams,
				paginationService, purchaseProductFactory) {
		
			$scope.bikes = [];

			$scope.paginationService = paginationService;

			$scope.urlBike = "#!/allMountainBikes/";

			$scope.url = "/allMountainBikes/";

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

			paginationService.pagination('/getCountPage/allMountainBikes',
					$routeParams.page, $scope.paginationParam)

			$http({
				method : "GET",
				url : '/allMountainBikes/' + $routeParams.page
			}).then(function(response) {

				$scope.bikes = response.data;

			}, function myError(response) {

			});


		});