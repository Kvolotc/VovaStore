var myApp = angular.module('myApp');
myApp.controller('home',
		function($scope, $route, $location, $routeParams) {

			$scope.searchProducts = [ 'Bike', 'Brake', 'Fork', 'Frame', 'Rim',
					'Tire' ];

			$scope.searchProduct = '';

			$scope.searchWord = '';

			$scope.showSearchForm = false;

			$scope.hideProduct = false;

			$scope.location = $location;

			$scope.slider = {
				minValue : 0,
				maxValue : 10000,
				options : {
					floor : 0,
					ceil : 10000,
					step : 1,
					noSwitching : true,
					translate : function(value) {
						return '$' + value;
					}
				}
			};

			$scope.changeSearchForm = function() {
				$scope.showSearchForm = !$scope.showSearchForm;
			}

			jQuery.validator.addMethod('selectProduct',
					function(value) {

						return (value == 'Bike' || value == 'Brake'
								|| value == 'Fork' || value == 'Frame'
								|| value == 'Rim' || value == 'Tire');
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
							case 'Bike': {

								$location
										.path('/searchBikes/word='
												+ $scope.searchWord + ';min='
												+ $scope.slider.minValue
												+ ';max='
												+ $scope.slider.maxValue
												+ ';page=1');
								break;

							}
							case 'Brake': {

								$location
										.path('/searchBrakes/word='
												+ $scope.searchWord + ';min='
												+ $scope.slider.minValue
												+ ';max='
												+ $scope.slider.maxValue
												+ ';page=1');
								break;
							}
							case 'Fork': {

								$location
										.path('/searchForks/word='
												+ $scope.searchWord + ';min='
												+ $scope.slider.minValue
												+ ';max='
												+ $scope.slider.maxValue
												+ ';page=1');
								break;
							}
							case 'Frame': {

								$location
										.path('/searchFrames/word='
												+ $scope.searchWord + ';min='
												+ $scope.slider.minValue
												+ ';max='
												+ $scope.slider.maxValue
												+ ';page=1');
								break;
							}
							case 'Rim': {

								$location
										.path('/searchRims/word='
												+ $scope.searchWord + ';min='
												+ $scope.slider.minValue
												+ ';max='
												+ $scope.slider.maxValue
												+ ';page=1');
								break;
							}
							case 'Tire': {

								$location
										.path('/searchTires/word='
												+ $scope.searchWord + ';min='
												+ $scope.slider.minValue
												+ ';max='
												+ $scope.slider.maxValue
												+ ';page=1' );
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
