myApp
.controller('bikes', function($scope, $http, $routeParams) {

	$scope.tires = [];
	
	$http({
		method : "GET", url : '/tires'
	}).then(function (response) {
		$scope.tires = response.data;
	}, function myError(response) {
		
	});

});	