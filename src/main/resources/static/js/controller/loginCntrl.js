angular.module('myApp').controller('login', function(currentUser, $scope, $http, $location, $timeout, $window, toastr) {

	$scope.loginParam = {
		username : $scope.username,
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
				async : false,
				data : $scope.loginParam

			}).then(function(response) {
				
				$scope.isWarning = false;
				$location.path("/");
				$timeout(function() {
					$window.location.reload();	
				}, 100);
				toastr.success('Hello '+response.data.firstName +' '+response.data.lastName);

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

