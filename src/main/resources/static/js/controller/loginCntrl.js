angular.module('myApp').controller('login', function(currentUser, $scope, $http, $location) {

	$scope.loginParam = {
		eMail : $scope.eMail,
		password : $scope.password
	};

	$scope.forgotPasswordParam = {
		eMail : $scope.eMail,
		password : $scope.password

	}

	$scope.message = '';

	$scope.isWarning = false;
	
	$scope.confPassword;
		

	$scope.login = function() {

			$http({
				method : 'POST',
				url : '/login',
				contentType : 'application/json',
				dataType : 'json',
				async : true,
				data : $scope.loginParam

			}).then(function(response) {

				console.log(response.data)
				currentUser.isLogged = response.data.logged;
				currentUser.role = response.data.role;
				currentUser.firstName = response.data.firstName
				currentUser.lastName = response.data.lastName
				currentUser.email = response.data.email
				
				$scope.isWarning = false;
				$location.path("/");

			}, function errorCallback(response) {

				if (response.status == 409) {
					$scope.message = 'You have not activated the account';
				} else {
					$scope.message = 'Invalid password or Email';
				}

				$scope.isWarning = true;

			});

		}

})

