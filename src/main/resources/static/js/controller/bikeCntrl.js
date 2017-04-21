angular.module('myApp').controller('bikes', function($scope, $http, $location) {

	$scope.bikes = [];

	switch ($location.path()) {

	case "/mountainBikes":

		$http({
			method : "GET",
			url : '/mountainBikes'
		}).then(function(response) {
			$scope.bikes = response.data;
		}, function myError(response) {

		});

		break;
	case "/allMountainBikes":

		$http({
			method : "GET",
			url : '/allMountainBikes'
		}).then(function(response) {
			$scope.bikes = response.data;
		}, function myError(response) {

		});

		break;
	case "/racingBikes":
	
		$http({
			method : "GET",
			url : '/racingBikes'
		}).then(function(response) {
			$scope.bikes = response.data;
		}, function myError(response) {

		});

		break;
	default:
		break;

	}
	
	$scope.count = 1;
	
	$scope.price = function() {
		$scope.activeBike.price = $scope.activeBike.price * $scope.count;
	}

	$scope.activeBike = {

	};

	$scope.changeActieBike = function(bike) {
		console.log(bike);
		$scope.activeBike = bike;
	}

});