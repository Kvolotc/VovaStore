myApp
.controller('bikes', function($scope, $http, $routeParams) {

	$scope.bikes = [];
	
	$http({
		method : "GET", url : '/bikes'
	}).then(function (response) {
		$scope.bikes = response.data;
	}, function myError(response) {
		
	});

});	