var myApp = angular.module('myApp', [ "ngRoute" ])

.config(function($routeProvider, $locationProvider) {
	$routeProvider
	
	.when('', {
		templateUrl : 'home.html',
		controller : 'home'
	})

	
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

	.when('/actived/:name', {
		templateUrl : 'view/activate.html',
		controller : 'active'
	})

	.when('/forgotPassword', {
		templateUrl : 'view/forgotPassword.html',
		controller : 'forgotPassword'
	})

	.otherwise({
		redirectTo : '/'
	})

	
	$locationProvider.html5Mode({
		  enabled: true,
		  requireBase: true
		});
	$locationProvider.hashPrefix('!');

});