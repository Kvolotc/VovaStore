var myApp = angular.module('myApp');
myApp.controller('home', function(currentUser, basketFactory, purchaseProductFactory, toastr, $scope, $route, $location, $routeParams, $window,
		$http) {

	$scope.searchProducts = [ 'Bikes', 'Brakes', 'Forks', 'Frames', 'Rims',
			'Tires' ];

	$scope.searchProduct = '';

	$scope.searchWord = '';
	
	$scope.basketFactory = basketFactory;

	$scope.showSearchForm = false;

	$scope.location = $location;
	
	$scope.currentUser = currentUser;
	
	$scope.price = 0;

	$scope.slider = {
		minValue : 1,
		maxValue : 0,
		options : {
			floor : 1,
			ceil : 0,
			step : 1,
			noSwitching : true,
			translate : function(value) {
				return '$' + value;
			}
		}
	};
	
	
	$scope.countPrice = function() {
		
		$scope.price = 0;
		
		for(var ind = 0; ind < basketFactory.length; ind++) {
			$scope.price += basketFactory[ind].price;
		}
	} 
	
	
	$scope.buyProductInBasket = function() {
		
		if(purchaseProductFactory.length >=1) {
			purchaseProductFactory.splice(0, purchaseProductFactory.length)
		}
		
		for(var ind = 0; ind < basketFactory.length; ind++) {
			purchaseProductFactory.push(basketFactory[ind]);
		}
	}
	
	
	$scope.deleteAllProduct = function() {
		basketFactory.splice(0, basketFactory.length);
		$("#backetModal").modal("hide");
		
		toastr.info('All products was deleted');
	}
	
	
	$scope.changePriceProduct = function(product, amount) {
		
		product.price = product.productPrice * amount;
		
		$scope.countPrice();	
	}
	
	
	$scope.deleteProduct = function(product) {
		var ind = $scope.basketFactory.map(function(e) { return e.imageName; }).indexOf(product.imageName);
		
		$scope.price = $scope.price - basketFactory[ind].price;
		
		$scope.basketFactory.splice(ind, 1);
		
		toastr.info(product.brand+' '+product.model+' was deleted');
		
		if(basketFactory.length == 0) {
			$("#backetModal").modal("hide");
		}
	}
	

	$scope.change = function(product) {
		$http({
			method : 'GET',
			url : '/maxPrice' + product,
		}).then(function(response) {
			$scope.slider.maxValue = response.data;
			$scope.slider.minValue = 1;
			$scope.slider.options.ceil = response.data;
		}, function errorCallback(response) {
		});
	}

	$scope.changeSearchForm = function() {

		$scope.showSearchForm = !$scope.showSearchForm;
	}

	jQuery.validator.addMethod('selectProduct', function(value) {

		return (value == 'Bikes' || value == 'Brakes' || value == 'Forks'
				|| value == 'Frames' || value == 'Rims' || value == 'Tires');
	}, "Please select Product");

	
	
	jQuery.validator.setDefaults({
		errorClass : 'help-block',
		highlight : function(element) {
			$(element).closest('.form-group').addClass('has-error');
		},
		unhighlight : function(element) {
			$(element).closest('.form-group').removeClass('has-error');
		}
	});
	
	
	
	$scope.logout = function() {
		$location.path('/');
		$http({
			method : 'GET',
			url : '/logoutUser',

		}).then(function(response) {
					
			$window.location.reload();	
			
		}, function errorCallback(response) {
		

		});
	}
	
	
//	function fun() {
//		console.log('INNN')
//		if($scope.basketFactory.length == 0) {
//			var eml = document.getElementById('basket');
//			eml.style.color = "#8d8c8c";
//		}
//		else {
//			var eml = document.getElementById('basket');
//			eml.style.color = "green";
//		}
//	}

	$(document).ready(function() {

		$("#search-form").validate({

			rules : {
				searchWord : {
					required : true,
				},
				selectProduct : {
					selectProduct : true,
				},
			}
		});
	});
	
	
	
	$("#buyProduct").click(
		function() {
			$("#backetModal").modal("hide")
	})

	
	
	$("#searchSubmit").click(
			function() {
				if ($("#search-form").valid()) {

					$location.path('/search' + $scope.searchProduct + '/word='
							+ $scope.searchWord + ';min='
							+ $scope.slider.minValue + ';max='
							+ $scope.slider.maxValue + ';page=1');

					return true;

				} else {

					return false;
				}
			});

});
