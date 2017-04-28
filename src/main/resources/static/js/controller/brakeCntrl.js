angular.module('myApp')
.controller('brakes', function($scope, $http, $routeParams,$location, $routeParams, productFactory, padination) {

			$scope.brakes = [];
			
            $scope.productFactory = productFactory;
			
			$scope.padination = padination;
			
			$scope.url = "/brakes/";
			
			$scope.countBrakes = 1;
			
			$scope.activeBrake = {};

			$http({
				method : "GET",
				url : '/brakes/' + $routeParams.page
			}).then(function(response) {
				$scope.brakes = response.data;

			}, function myError(response) {

			});
			
            $scope.padination.firstPadination('/getCountPage/brakes', $routeParams.page, $scope.productFactory);	 				

			
			$scope.padination.updatePadination('/getCountPage/brakes', $routeParams.page, $scope.productFactory);
			
	

			$scope.price = function() {
				$scope.activeBrake.price = $scope.activeBrake.price
						* $scope.countBrakes;
			}


			$scope.changeActiveBrake = function(brake) {
				$scope.activeBrake = brake;
			}


		});