angular.module('myApp')
.controller('racingBike', function($scope, $http, $routeParams) {

	$scope.bikes = [];
	
	$http({
		method : "GET",
		url : '/bike/racing'
	}).then(function (response) {
		$scope.bikes = response.data;
	}, function myError(response) {
		
	});

});	