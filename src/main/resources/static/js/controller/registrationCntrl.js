angular.module('myApp').controller('registration', function($scope, $http) {

	
	$scope.user = {
			firstName : $scope.firstName,
			lastName : $scope.lastName,
			gender : $scope.gender,
			birthDate : $scope.birthDate,
			email : $scope.email,
			password : $scope.pasword,
	        role : 'USER'
	};


	$scope.mail = {
		to : $scope.to,
		text : '',
		subject : 'Registration on VovaStore'
	}
	
	$scope.link = '';

	$scope.confPassword;

	$scope.genders = [ 'MALE', 'FEMALE' ];


	$scope.hideModal = function() {
		$("#successModal").modal("hide")
	}	
		
		
		
		jQuery.validator.addMethod(
	            'regex',
	            function(value, element){
	                return this.optional(element) || /(^[-!#$%&'*+/=?^_`{}|~0-9A-Z]+(\.[-!#$%&'*+/=?^_`{}|~0-9A-Z]+)*|^"([\001-\010\013\014\016-\037!#-\[\]-\177]|\\[\001-\011\013\014\016-\177])*")@((?:[A-Z0-9](?:[A-Z0-9-]{0,61}[A-Z0-9])?\.)+(?:[A-Z]{2,6}\.?|[A-Z0-9-]{2,}\.?)$)|\[(25[0-5]|2[0-4]\d|[0-1]?\d?\d)(\.(25[0-5]|2[0-4]\d|[0-1]?\d?\d)){3}\]$/i.test(value);
	            },
	            'Verify you have a valid email address.'
	        );
	    
	    

		jQuery.validator.addMethod('selectcheck', function(value) {

			return (value == 'FEMALE' || value == 'MALE');
		}, "Please select gender");
	

		$(document).ready(function() {
			
			$("#registration-form").validate({

				rules : {
					email : {
						required : true,
						regex: true,
						remote : {
							url : '/email',
							type : "post",
							async : false,
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
						max:"2005-05-01",
						min:"1920-12-31",
						required : true,
					},
					gender : {
						selectcheck : true,

					}
				},
				messages : {
					email : {
						required : "Please enter an email address",
						remote : 'This email allready used'
					},
					birtday: {
					   max: "You can not register if you do not have at least 12 years",
					   min:	"Wrong date", 
				   }
				}

			});
		});
		
		

		$("#submitButton").click(function() {

			if ($("#registration-form").valid()) {
				
				$("#successModal").modal("show")

				$http({
					method : 'POST',
					url : '/newUser',
					contentType : 'application/json',
					dataType : 'json',
					async : true,
					data : $scope.user
				}).then(function(response) {
					
					$scope.link  = 'http://localhost:8080/actived/'+response.data;
					
					$scope.mail.text = $scope.user.firstName+' '+$scope.user.lastName+' you are registration on my VovaStore thx :). plz follow this link for activate in VovaStore <a href = " '+ $scope.link + ' "> Follow in</a>';
					
					$http({
						method : 'POST',
						url : '/mailsender',
						async : true,
						contentType : 'application/json',
						dataType : 'json',
						data : $scope.mail
					});
					
					
				}, function errorCallback(response) {
					
					
				});
				

				return true;

			} else {

				return false;
			}
		});

});