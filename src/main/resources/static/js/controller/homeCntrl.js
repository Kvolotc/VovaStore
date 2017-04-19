var myApp = angular.module('myApp')
.controller('home', function($scope, $route, $location) {

	$scope.hello = 'Hello World';
	
	$scope.searchObjects = [ 'Bike', 'Brake', 'Fork', 'Frame', 'Rim', 'Tire'];
	
	$scope.searchObject = '';
	
	$scope.searchWord = '';

	
	$scope.location = $location;

});	

