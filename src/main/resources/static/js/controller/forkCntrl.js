angular.module('myApp')
.controller('forks', function($scope, $http, $routeParams) {

	$scope.forks = [];
	
	$http({
		method : "GET",
		url : '/forks'
	}).then(function (response) {
		console.log(response);
		$scope.forks = response.data;
		console.log($scope.frames)
		
	}, function myError(response) {
		
	});

});	