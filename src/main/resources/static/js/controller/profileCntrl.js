angular.module('myApp').controller('profile',
		function(currentUser, $scope, $http) {

			$scope.newUser = {					
					currentEmail :  currentUser.email,
					firstName : currentUser.firstName,
					lastName : currentUser.lastName,
					email : currentUser.email
			}	
			
			$scope.changeEmail = true;
			

			$scope.hideModal = function() {
				$("#profileModal").modal("hide")
			}
			
			jQuery.validator.addMethod(
		            'regex',
		            function(value, element){
		                return this.optional(element) || /(^[-!#$%&'*+/=?^_`{}|~0-9A-Z]+(\.[-!#$%&'*+/=?^_`{}|~0-9A-Z]+)*|^"([\001-\010\013\014\016-\037!#-\[\]-\177]|\\[\001-\011\013\014\016-\177])*")@((?:[A-Z0-9](?:[A-Z0-9-]{0,61}[A-Z0-9])?\.)+(?:[A-Z]{2,6}\.?|[A-Z0-9-]{2,}\.?)$)|\[(25[0-5]|2[0-4]\d|[0-1]?\d?\d)(\.(25[0-5]|2[0-4]\d|[0-1]?\d?\d)){3}\]$/i.test(value);
		            },
		            'Verify you have a valid email address.'
		        );
		    
		    jQuery.validator.addMethod(
		            'checkForEqual',
		            function(value, element){
		                return $scope.currentUser.firstName == currentUser.firstName && $scope.currentUser.lastName == currentUser.lastName
		            },
		            'You have not change nothing'
		        );
		    
		    
			$(document).ready(function() {
				console.log($scope.currentUser.email)
				$("#profile-form").validate({

					rules : {
						email : {
							required : true,
							regex : true,
							remote : {
								url : '/email',
								type : "post",
								async : false,
								contentType : 'application/json;charset-UTF-8',
								dataType : 'json',

							}

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

						}
					},
					messages : {
						email : {
							required : "Please enter an Email address",
							remote : 'This Email allready used'
						}
					}
				
				});
			});

			$("#changeSubmit").click(function() {
			
				if ($("#profile-form").valid()) {
					
					$("#profileModal").modal("show")

					$http({
						method : 'PUT',
						url : '/updateUser',
						contentType : 'application/json',
						dataType : 'json',
						async : true,
						data : $scope.newUser
					}).
					then(function(response) {	
						
						currentUser.firstName = response.data.firstName;
						currentUser.lastName = response.data.lastName;
						currentUser.email = response.data.email;

					return true;
					
					})
					

				} else {

					return false;
				}
			});
		})
		
		
