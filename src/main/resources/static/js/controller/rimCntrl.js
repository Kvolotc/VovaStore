angular.module('myApp')
.controller('rims', function($scope, $http, $routeParams) {

	$scope.rims = [];
	
	$http({
		method : "GET",
		url : '/rims'
	}).then(function (response) {
		console.log(response);
		$scope.rims = response.data;
		console.log($scope.frames)
		
	}, function myError(response) {
		
	});

});	