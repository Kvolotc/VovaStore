var myApp = angular.module('myApp', [ "ngRoute", "rzModule", "ui.bootstrap",
		"toastr" ]);

myApp.config(function($routeProvider, $locationProvider, toastrConfig) {

	angular.extend(toastrConfig, {
		allowHtml : false,
		closeButton : true,
		extendedTimeOut : 1000,
		positionClass : 'toast-bottom-right',
		iconClasses : {
			error : 'toast-error',
			info : 'toast-info',
			success : 'toast-success',
			warning : 'toast-warning'
		},

		timeOut : 3000,
		titleClass : 'toast-title',
		toastClass : 'toast'
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

	.when('/users/:page', {
		templateUrl : 'view/users.html',
		controller : 'users'
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

	.when('/changeImageBikes/:page', {
		templateUrl : 'view/changeImage/changeImageBike.html',
		controller : 'changeImageBike'
	})

	.when('/changeImageFrames/:page', {
		templateUrl : 'view/changeImage/changeImageFrame.html',
		controller : 'changeImageFrame'
	})

	.when('/changeImageForks/:page', {
		templateUrl : 'view/changeImage/changeImageFork.html',
		controller : 'changeImageFork'
	})

	.when('/changeImageRims/:page', {
		templateUrl : 'view/changeImage/changeImageRim.html',
		controller : 'changeImageRim'
	})

	.when('/changeImageTires/:page', {
		templateUrl : 'view/changeImage/changeImageTire.html',
		controller : 'changeImageTire'
	})

	.when('/changeImageBrakes/:page', {
		templateUrl : 'view/changeImage/changeImageBrake.html',
		controller : 'changeImageBrake'
	})

	.when('/profile', {
		templateUrl : 'view/profile.html',
		controller : 'profile'
	})

	.otherwise({
		redirectTo : ''
	})

	$locationProvider.html5Mode({
		enabled : true,
		requireBase : true
	});

	$locationProvider.hashPrefix('');

});
