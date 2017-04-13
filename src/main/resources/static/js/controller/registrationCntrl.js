myApp.controller('registration', function($scope, $http) {

	$scope.user = {
		firstName : $scope.firstName,
		lastName : $scope.lastName,
		gender : $scope.gender,
		date : $scope.date,
		eMail : $scope.eMail,
		password : $scope.pasword,
		role : 'USER'
	};

	$scope.mail = {
		to : $scope.to,
		text : 'You are registration on my VovaStore thx :)',
		subject : 'Registration on VovaStore'
	}

	$scope.confPassword;

	$scope.genders = [ 'Male', 'Female' ];

	//	$scope.registration = function() {
	//		
	//		cobsole.log('444444444');
	//		
	//		$('#loginModal').modal('hide')
	//		
	//	}

	$(function() {

		$.validator.setDefaults({
			errorClass : 'help-block',
			highlight : function(element) {
				$(element).closest('.form-group').addClass('has-error');
			},
			unhighlight : function(element) {
				$(element).closest('.form-group').removeClass('has-error');
			}
		});



		jQuery.validator.addMethod('selectcheck', function(value) {

			return (value == 'Female' || value == 'Male');
		}, "Please select gender");

		$(document).ready(function() {

			$("#registration-form").validate({

				rules : {
					email : {
						required : true,
						email : true,
						uniqueUsername : false,
						remote : {
							url : 'http://localhost:8080/email',
							data : $scope.user.eMail,
							type : "post",
							async : true,
							contentType : 'application/json;charset-UTF-8',
							dataType : 'json',

						}

					},
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
					firstName : {
						minlength : 3,
						maxlength : 20,
						required : true,
						nowhitespace : true,

					},
					lastName : {
						minlength : 3,
						maxlength : 20,
						required : true,
						nowhitespace : true,

					},
					birtday : {
						required : true,
					},
					gender : {
						selectcheck : true,

					}
				},
				messages : {
					email : {
						required : "Please enter an email address",
						email : "Please enter <em>valid<em> an email address",
						remote : 'This email allready used'
					}
				}

			});
		});

		$("#submitButton").click(function() {

			if ($("#registration-form").valid()) {

				$http({
					method : 'POST',
					url : '/newUser',
					contentType : 'application/json',
					dataType : 'json',
					async : true,
					data : $scope.user
				}).then(function(response) {
					console.log(response);
				}, function errorCallback(response) {
				});

				$http({
					method : 'POST',
					url : '/mailsender',
					async : true,
					contentType : 'application/json',
					dataType : 'json',
					data : $scope.mail
				});

				return true;

			} else {

				return false;
			}
		});

	})

});