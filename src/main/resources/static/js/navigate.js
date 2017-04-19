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
		controller : 'mountainBike'
	})
	
	.when('/allMountainBikes', {
		templateUrl : 'view/bikes.html',
		controller : 'allMountainBike'
	})
	
	.when('/racingBikes', {
		templateUrl : 'view/bikes.html',
		controller : 'racingBike'
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

	.when('/frames', {
		templateUrl : 'view/frames.html',
		controller : 'frames'
	})

	.otherwise({
		redirectTo : '/'
	})

	$locationProvider.html5Mode({
		enabled : true,
		requireBase : true
	});
	$locationProvider.hashPrefix('!');

});