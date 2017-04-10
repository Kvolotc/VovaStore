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
	
	.when('/tires', {
		templateUrl : 'view/bikes.html',
		controller : 'bikes'
	})
	
	.otherwise({
		redirectTo : '/'
	})
	
	$locationProvider.html5Mode({
		  enabled: true,
		  requireBase: false
		});

});