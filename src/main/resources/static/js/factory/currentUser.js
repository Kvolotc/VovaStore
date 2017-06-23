myApp.factory('currentUser', function($http) {
	var currentUser = {
		role : null,
		isLogged : null,
		firstName: null,
		lastName: null,
		email: null
	}

	$http({
		method : "GET",
		url : '/getCurrentUser'
	}).then(function(response) {
		console.log(response)

		currentUser.role = response.data.role;
		currentUser.isLogged = response.data.logged;
		currentUser.firstName = response.data.firstName
		currentUser.lastName = response.data.lastName
		currentUser.email = response.data.email

	}, function myError(response) {
		
		currentUser.role = 'USER';
		currentUser.isLogged = false;

	});

	return currentUser;

});