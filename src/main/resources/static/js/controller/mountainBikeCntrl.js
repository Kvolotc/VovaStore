angular.module('myApp')
.controller('mountainBike', function($scope, $http, $routeParams) {

	$scope.bikes = [];
	
	$http({
		method : "GET",
		url : '/bike/mountain'
	}).then(function (response) {
		$scope.bikes = response.data;
	}, function myError(response) {
		
	});

});	