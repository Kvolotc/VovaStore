angular.module('myApp')
.controller('brakes', function($scope, $http, $routeParams) {

	$scope.brakes = [];
	
	$http({
		method : "GET",
		url : '/brakes'
	}).then(function (response) {
		console.log(response);
		$scope.brakes = response.data;
		console.log($scope.frames)
		
	}, function myError(response) {
		
	});

});	