var myApp = angular.module('myApp', [ "ngRoute" ])

.config(function($routeProvider, $locationProvider) {
	$routeProvider
	
	.when('/registration', {
		templateUrl : 'view/registration.html',
		controller : 'registration'
	})

	.when('/login', {
		templateUrl : 'view/login.html',
		controller : 'login'
	})
	
	.when('/bikes', {
		templateUrl : 'view/bikes.html',
		controller : 'bikes'
	})
	
	.when('/newUser', {
		templateUrl : 'view/newUser.html',
		controller : 'registration'
	})
	
	.when('/popup', {
		templateUrl : 'view/popup.html',
	})
	
	.otherwise({
		redirectTo : '/'
	})
	
	$locationProvider.html5Mode({
		  enabled: true,
		  requireBase: false
		});

});