var myApp = angular.module('myApp', [ "ngRoute", "rzModule", "ui.bootstrap", "toastr", ]);

myApp.config(function($routeProvider, $locationProvider, toastrConfig) {
	
	angular.extend(toastrConfig, {
	    allowHtml: false,
	    closeButton: false,
	    extendedTimeOut: 1000,
	    iconClasses: {
	      error: 'toast-error',
	      info: 'toast-info',
	      success: 'toast-success',
	      warning: 'toast-warning'
	    },  

	    timeOut: 2000,
	    titleClass: 'toast-title',
	    toastClass: 'toast'
	  });
	
	
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
		templateUrl : 'view/product/bikes.html',
		controller : 'mountainBike',
	})

	.when('/allMountainBikes/:page', {
		templateUrl : 'view/product/bikes.html',
		controller : 'allMountainsBikes'
	})

	.when('/racingBikes/:page', {
		templateUrl : 'view/product/bikes.html',
		controller : 'racingBikes'
	})

	.when('/purchaseProduct', {
		templateUrl : 'view/purchaseProduct.html',
		controller : 'purchaseProduct'
	})

	.when('/searchBikes/word=:word;min=:min;max=:max;page=:page', {
		templateUrl : 'view/product/bikes.html',
		controller : 'searchBikes'
	})

	.when('/searchBrakes/word=:word;min=:min;max=:max;page=:page', {
		templateUrl : 'view/product/brakes.html',
		controller : 'searchBrakes'
	})

	.when('/searchFrames/word=:word;min=:min;max=:max;page=:page', {
		templateUrl : 'view/product/frames.html',
		controller : 'searchFrames'
	})

	.when('/searchForks/word=:word;min=:min;max=:max;page=:page', {
		templateUrl : 'view/product/forks.html',
		controller : 'searchForks'
	}).

	when('/searchRims/word=:word;min=:min;max=:max;page=:page', {
		templateUrl : 'view/product/rims.html',
		controller : 'searchRims'
	})

	.when('/searchTires/word=:word;min=:min;max=:max;page=:page', {
		templateUrl : 'view/product/tires.html',
		controller : 'searchTires'
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
		templateUrl : 'view/product/frames.html',
		controller : 'frames'
	})

	.when('/forks/:page', {
		templateUrl : 'view/product/forks.html',
		controller : 'forks'
	})

	.when('/rims/:page', {
		templateUrl : 'view/product/rims.html',
		controller : 'rims'
	})

	.when('/tires/:page', {
		templateUrl : 'view/product/tires.html',
		controller : 'tires'
	})

	.when('/brakes/:page', {
		templateUrl : 'view/product/brakes.html',
		controller : 'brakes'
	})

	.when('/profile', {
		templateUrl : 'view/profile.html',
		controller : 'profile'
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
