var myApp = angular.module('myApp').controller(
		'forgotPassword',
		function($scope, $route,$http, $location) {

			$scope.forgotPasswordParam = {
				eMail : $scope.eMail,
				password : $scope.password

			}

			$scope.message = '';

			$scope.isWarning = false;

			$scope.confPassword;
			
			
			
			$scope.hideModal = function() {
				$("#forgotPasswordModal").modal("hide")
			}
			

			$(function() {

				$.validator
						.setDefaults({
							errorClass : 'help-block',
							highlight : function(element) {
								$(element).closest('.form-group').addClass(
										'has-error');
							},
							unhighlight : function(element) {
								$(element).closest('.form-group').removeClass(
										'has-error');
							}
						});

				$(document).ready(function() {

					$("#forgotPassword-form").validate({

						rules : {
							password : {
								minlength : 4,
								maxlength : 16,
								required : true,
							},
							confirmPassword : {
								minlength : 4,
								maxlength : 16,
								required : true,
								equalTo : "#password"
							},
						}
					});
				});

				$("#fordotPasswordSubmit").click(function() {

					if ($("#forgotPassword-form").valid()) {
						
						$http({
							method : 'POST',
							url : '/userForgotPassword',
							contentType : 'application/json',
							dataType : 'json',
							async : true,
							data : $scope.forgotPasswordParam
							
						}).then(function(response) {
							console.log(response);
							$("#forgotPasswordModal").modal("show");

						}, function errorCallback(response) {

							$scope.message = 'Invalid Email';
							$scope.isWarning = true;
							console.log(response);

						});

						return true;

					} else {

						return false;
					}
				});

			})
		});
