angular.module('myApp', [ 'ngRoute']).

config(function($routeProvider, $locationProvider) {
	$routeProvider
	
	.when('/registration', {
		templateUrl : 'view/registration.html',
		controller : 'registration'
	})

	.when('/login', {
		templateUrl : 'view/login.html',
		controller : 'login'
	})
	
	.otherwise({
		redirectTo : '/'
	})
	
	$locationProvider.html5Mode(true);

});