var myApp = angular.module('myApp');
myApp.controller('home',
		function($scope, $route, $location, $routeParams, $http) {

			$scope.searchProducts = [ 'Bikes', 'Brakes', 'Forks', 'Frames', 'Rims',
					'Tires' ];

			$scope.searchProduct = '';

			$scope.searchWord = '';

			$scope.showSearchForm = false;
			
			$scope.location = $location;

			$scope.slider = {
				minValue : 1,
				maxValue : 	0,
				options : {
					floor : 1,
					ceil : 	0,
					step : 1,
					noSwitching : true,
					translate : function(value) {
						return '$' + value;
					}
				}
			};
			
			$scope.change = function(product) {
				$http({
					method : 'GET',
					url : '/maxPrice'+product,
				}).then(function(response) {
					$scope.slider.maxValue = response.data;
					$scope.slider.options.ceil = response.data;
				}, function errorCallback(response) {});
			}
					
			

			$scope.changeSearchForm = function() {
				$scope.showSearchForm = !$scope.showSearchForm;
			}

			jQuery.validator.addMethod('selectProduct',
					function(value) {

						return (value == 'Bikes' || value == 'Brakes'
								|| value == 'Forks' || value == 'Frames'
								|| value == 'Rims' || value == 'Tires');
					}, "Please select Product");

			$.validator.setDefaults({
				errorClass : 'help-block',
				highlight : function(element) {
					$(element).closest('.form-group').addClass('has-error');
				},
				unhighlight : function(element) {
					$(element).closest('.form-group').removeClass('has-error');
				}
			});

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

			$("#searchSubmit").click(
					function() {

						if ($("#search-form").valid()) {

							switch ($scope.searchProduct) {
							case 'Bikes': {

								$location.path('/searchBikes/word='
										+ $scope.searchWord + ';min='
										+ $scope.slider.minValue + ';max='
										+ $scope.slider.maxValue + ';page=1');							
								break;

							}
							case 'Brakes': {

								$location.path('/searchBrakes/word='
										+ $scope.searchWord + ';min='
										+ $scope.slider.minValue + ';max='
										+ $scope.slider.maxValue + ';page=1');
								break;
							}
							case 'Forks': {

								$location.path('/searchForks/word='
										+ $scope.searchWord + ';min='
										+ $scope.slider.minValue + ';max='
										+ $scope.slider.maxValue + ';page=1');
								break;
							}
							case 'Frames': {

								$location.path('/searchFrames/word='
										+ $scope.searchWord + ';min='
										+ $scope.slider.minValue + ';max='
										+ $scope.slider.maxValue + ';page=1');
								break;
							}
							case 'Rims': {

								$location.path('/searchRims/word='
										+ $scope.searchWord + ';min='
										+ $scope.slider.minValue + ';max='
										+ $scope.slider.maxValue + ';page=1');
								break;
							}
							case 'Tires': {

								$location.path('/searchTires/word='
										+ $scope.searchWord + ';min='
										+ $scope.slider.minValue + ';max='
										+ $scope.slider.maxValue + ';page=1');
								break;
							}
							default:
								break;
							}

							return true;

						} else {

							return false;
						}
					});

		});
