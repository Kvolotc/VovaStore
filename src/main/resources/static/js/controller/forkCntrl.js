angular.module('myApp')
.controller('forks', function($scope, $http, $routeParams,$location, $routeParams, productFactory, padination) {

			$scope.forks = [];
			
            $scope.productFactory = productFactory;
			
			$scope.padination = padination;
			
			$scope.url = "/forks/";
			
			$scope.countForks = 1;
			
			$scope.activeFork = {};

			$http({
				method : "GET",
				url : '/forks/' + $routeParams.page
			}).then(function(response) {
				$scope.forks = response.data;

			}, function myError(response) {

			});
			
            $scope.padination.firstPadination('/getCountPage/forks', $routeParams.page, $scope.productFactory);	 				

			
			$scope.padination.updatePadination('/getCountPage/forks', $routeParams.page, $scope.productFactory);
			
	

			$scope.price = function() {
				$scope.activeFork.price = $scope.activeFork.price
						* $scope.countForks;
			}


			$scope.changeActiveFork = function(fork) {
				$scope.activeFork = fork;
			}


		});