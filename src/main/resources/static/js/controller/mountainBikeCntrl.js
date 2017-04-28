angular.module('myApp').controller('mountainBike',function($scope, $rootScope, $http, $location, $routeParams, productFactory, padination) {

			$scope.bikes = [];
			
			$scope.productFactory = productFactory;
			
			$scope.padination = padination;
			
			$scope.urlBike = "#!/mountainBikes/";
			
			$scope.url = "/mountainBikes/";
			
			$scope.countBikes = 1;
			
			$scope.activeBike = {};
			

			$http({
				method : "GET",
				url : '/mountainBikes/' + $routeParams.page
			}).then(function(response) {
				$scope.bikes = response.data;
			}, function myError(response) {

			});
			
			$scope.padination.firstPadination('/getCountPage/mountainBikes', $routeParams.page, $scope.productFactory);	 				

			
			$scope.padination.updatePadination('/getCountPage/mountainBikes', $routeParams.page, $scope.productFactory);
				

			$scope.price = function() {
				$scope.activeBike.price = $scope.activeBike.price
						* $scope.count;
			}


			$scope.changeActiveBike = function(bike) {
				$scope.activeBike = bike;
			}


		});