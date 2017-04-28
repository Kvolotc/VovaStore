var myApp = angular.module('myApp');
myApp.controller('home', function($scope, $route, $location, $routeParams) {

	$scope.searchObjects = [ 'Bike', 'Brake', 'Fork', 'Frame', 'Rim', 'Tire'];
	
	$scope.searchObject = '';
	
	$scope.searchWord = '';
	
	$scope.showSearchForm = false;
	
	$scope.location = $location;
	
	$scope.changeSearchForm = function() {
		$scope.showSearchForm = !$scope.showSearchForm;
	}
	

});	

