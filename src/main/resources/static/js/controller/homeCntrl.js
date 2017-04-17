var myApp = angular.module('myApp')
.controller('home', function($scope, $route, $location) {

	$scope.hello = 'Hello World';

	
	$scope.location = $location;

});	

