angular.module('myApp')
.controller('tires', function($scope, $http, $routeParams,$location, $routeParams, productFactory, padination) {

			$scope.tires = [];
			
            $scope.productFactory = productFactory;
			
			$scope.padination = padination;
			
			$scope.url = "/tires/";
			
			$scope.counTires = 1;
			
			$scope.activeTire = {};

			$http({
				method : "GET",
				url : '/tires/' + $routeParams.page
			}).then(function(response) {
				$scope.tires = response.data;

			}, function myError(response) {

			});
			
            $scope.padination.firstPadination('/getCountPage/tires', $routeParams.page, $scope.productFactory);	 				

			
			$scope.padination.updatePadination('/getCountPage/tires', $routeParams.page, $scope.productFactory);
			
	

			$scope.price = function() {
				$scope.activeTires.price = $scope.activeTires.price
						* $scope.counTires;
			}


			$scope.changeActiveTire = function(tire) {
				$scope.activeTire = tire;
			}


		});