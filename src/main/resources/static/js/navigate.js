var myApp = angular.module('myApp', [ "ngRoute", "ngTable", "ui.bootstrap"]);

myApp.config(function($routeProvider, $locationProvider) {
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

	.when('/mountainBikes/:page', {
		templateUrl : 'view/bikes.html',
		controller : 'mountainBike',
	})
	
	.when('/allMountainBikes/:page', {
		templateUrl : 'view/bikes.html',
		controller : 'allMountainsBikes'
	})
	
	.when('/racingBikes/:page', {
		templateUrl : 'view/bikes.html',
		controller : 'racingBikes'
	})

//	.when('/actived/:name', {
//		templateUrl : 'view/activate.html',
//		controller : 'active'
//	})

	.when('/forgotPassword', {
		templateUrl : 'view/forgotPassword.html',
		controller : 'forgotPassword'
	})

	.when('/frames/:page', {
		templateUrl : 'view/frames.html',
		controller : 'frames'
	})
	
	.when('/forks/:page', {
		templateUrl : 'view/forks.html',
		controller : 'forks'
	})

	.when('/rims/:page', {
		templateUrl : 'view/rims.html',
		controller : 'rims'
	})

	.when('/tires/:page', {
		templateUrl : 'view/tires.html',
		controller : 'tires'
	})

	.when('/brakes/:page', {
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