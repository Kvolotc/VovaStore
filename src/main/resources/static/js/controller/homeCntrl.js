angular.module('myApp',[])
.controller('home', function($scope, $http, $routeParams) {
	var id = $routeParams.id;
	var name = $routeParams.name;
	
	$scope.hello = 'Hello World';

});	