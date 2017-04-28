angular.module('myApp')
.controller('frames', function($scope, $http, $routeParams,$location, $routeParams, productFactory, padination) {

			$scope.frames = [];
			
            $scope.productFactory = productFactory;
			
			$scope.padination = padination;
			
			$scope.url = "/frames/";
			
			$scope.countFrames = 1;
			
			$scope.activeFrame = {};

			$http({
				method : "GET",
				url : '/frames/' + $routeParams.page
			}).then(function(response) {
				$scope.frames = response.data;

			}, function myError(response) {

			});
			
            $scope.padination.firstPadination('/getCountPage/frames', $routeParams.page, $scope.productFactory);	 				

			
			$scope.padination.updatePadination('/getCountPage/frames', $routeParams.page, $scope.productFactory);
			
	

			$scope.price = function() {
				$scope.activeFrame.price = $scope.activeFrame.price
						* $scope.countFrames;
			}


			$scope.changeActiveFrame = function(frame) {
				$scope.activeFrame = frame;
			}


		});