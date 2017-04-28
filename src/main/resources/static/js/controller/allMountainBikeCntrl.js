angular.module('myApp').controller(	'allMountainsBikes',function($scope, $rootScope, $http, $location, $routeParams, productFactory, padination) {

			$scope.bikes = [];
			
			$scope.productFactory = productFactory;
			
			$scope.padination = padination;
			
			$scope.urlBike = "#!/allMountainBikes/";
			
			$scope.url = "/allMountainBikes/";
			
			$scope.countBikes = 1;
			
			$scope.activeBike = {};
			

			$http({
				method : "GET",
				url : '/allMountainBikes/' + $routeParams.page
			}).then(function(response) {
				$scope.bikes = response.data;
			}, function myError(response) {

			});
			
			$scope.padination.firstPadination('/getCountPage/allMountainBikes', $routeParams.page, $scope.productFactory);	 				

			
			$scope.padination.updatePadination('/getCountPage/allMountainBikes', $routeParams.page, $scope.productFactory);
			
	

			$scope.price = function() {
				$scope.activeBike.price = $scope.activeBike.price
						* $scope.countBikes;
			}


			$scope.changeActiveBike = function(bike) {
				$scope.activeBike = bike;
			}


		});