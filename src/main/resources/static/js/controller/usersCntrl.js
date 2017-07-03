angular.module('myApp').controller('users', function($scope, $http, $routeParams, paginationService) {
	
	$scope.users = [];
	
	$scope.paginationService = paginationService;
	
	$scope.urlUser = "#!/users/";

	$scope.url = "/users/";
	
	$scope.paginationParam = {
		masPages : [],
		isNext : false,
		isPrevious : false
	}
	
	
	$http({
		method : "GET",
		url : '/users/' + $routeParams.page
	}).then(function(response) {
		
		$scope.users = response.data;		

	}, function myError(response) {

	});
	
	
	paginationService.pagination('/getAmountPageUsers',
			$routeParams.page, $scope.paginationParam)
	
	

})
