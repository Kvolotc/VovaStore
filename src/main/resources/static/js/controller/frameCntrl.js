angular.module('myApp')
.controller('frames', function($scope, $http, $routeParams) {

	$scope.frames = [];
	
	$http({
		method : "GET",
		url : '/frames'
	}).then(function (response) {
		console.log(response);
		$scope.frames = response.data;
		console.log($scope.frames)
		
	}, function myError(response) {
		
	});

});	