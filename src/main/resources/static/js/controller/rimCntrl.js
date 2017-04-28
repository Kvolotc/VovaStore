angular.module('myApp')
.controller('rims', function($scope, $http, $routeParams,$location, $routeParams, productFactory, padination) {

			$scope.rims = [];
			
            $scope.productFactory = productFactory;
			
			$scope.padination = padination;
			
			$scope.url = "/rims/";
			
			$scope.countRims = 1;
			
			$scope.activeRim = {};

			$http({
				method : "GET",
				url : '/rims/' + $routeParams.page
			}).then(function(response) {
				$scope.rims = response.data;

			}, function myError(response) {

			});
			
            $scope.padination.firstPadination('/getCountPage/rims', $routeParams.page, $scope.productFactory);	 				

			
			$scope.padination.updatePadination('/getCountPage/rims', $routeParams.page, $scope.productFactory);
			
	

			$scope.price = function() {
				$scope.activeRims.price = $scope.activeRims.price
						* $scope.countRims;
			}


			$scope.changeActiveRim = function(rim) {
				$scope.activeRim = rim;
			}


		});