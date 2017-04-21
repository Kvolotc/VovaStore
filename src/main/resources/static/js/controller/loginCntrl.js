angular.module('myApp').controller('login', function($scope, $http, $location) {

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

