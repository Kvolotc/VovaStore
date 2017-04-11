myApp.controller('registration', function($scope, $http) {

	$scope.user = {
		firstName : $scope.firstName,
		lastName : $scope.lastName,
		gender : $scope.gender,
		date : $scope.date,
		eMail : $scope.email,
		password : $scope.pasword,
		role : 'USER'
	};

	$scope.genders = [ 'Male', 'Female' ];

	$scope.showUser = function() {
		console.log($scope.user);
	}

	$scope.registration = function() {

		$http({
			method : 'POST',
			url : '/newUser',
			headers : {
				'Content-Type' : 'application/json'
			},
			data : $scope.user
		}).then(function(response) {
			console.log(response);
		}, function errorCallback(response) {
		});
	}

});