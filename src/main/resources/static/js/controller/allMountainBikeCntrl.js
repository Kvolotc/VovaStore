angular.module('myApp')
.controller('allMountainBike', function($scope, $http, $routeParams) {

	$scope.bikes = [];
	
	$http({
		method : "GET",
		url : '/bike/allMountain'
	}).then(function (response) {
		$scope.bikes = response.data;
	}, function myError(response) {
		
	});

});	