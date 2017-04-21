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

	.when('/mountainBikes', {
		templateUrl : 'view/bikes.html',
		controller : 'bikes'
	})
	
	.when('/allMountainBikes', {
		templateUrl : 'view/bikes.html',
		controller : 'bikes'
	})
	
	.when('/racingBikes', {
		templateUrl : 'view/bikes.html',
		controller : 'bikes'
	})

//	.when('/actived/:name', {
//		templateUrl : 'view/activate.html',
//		controller : 'active'
//	})

	.when('/forgotPassword', {
		templateUrl : 'view/forgotPassword.html',
		controller : 'forgotPassword'
	})

	.when('/frames', {
		templateUrl : 'view/frames.html',
		controller : 'frames'
	})
	
	.when('/forks', {
		templateUrl : 'view/forks.html',
		controller : 'forks'
	})

	.when('/rims', {
		templateUrl : 'view/rims.html',
		controller : 'rims'
	})

	.when('/tires', {
		templateUrl : 'view/tires.html',
		controller : 'tires'
	})

	.when('/brakes', {
		templateUrl : 'view/brakes.html',
		controller : 'brakes'
	})

	.otherwise({
		redirectTo : '/'
	})

//	$locationProvider.html5Mode({
//		enabled : true,
//		requireBase : true
//	});
//	$locationProvider.hashPrefix('!');

});