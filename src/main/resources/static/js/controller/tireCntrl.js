angular.module('myApp')
.controller('tires', function($scope, $http, $routeParams) {

	$scope.tires = [];
	
	$http({
		method : "GET",
		url : '/tires'
	}).then(function (response) {
		console.log(response);
		$scope.tires = response.data;
		console.log($scope.frames)
		
	}, function myError(response) {
		
	});

});	