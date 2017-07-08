angular.module('myApp').controller('changeImageFork',
		function($scope, $rootScope, $http, $location, $routeParams,
				paginationService, purchaseProductFactory, basketFactory, toastr, currentUser) {
				       
			$scope.forks = [];
			
			$scope.urlFork = "#/changeImageForks/";

			$scope.url = "/changeImageForks/";
			
			$scope.currentForkId;
			
			$scope.paginationParam = {
					masPages : [],
					isNext : false,
					isPrevious : false
				}

			paginationService.pagination('/getAmountPage/forks',
						$routeParams.page, $scope.paginationParam)
			
		
			
			$scope.filesChanged = function(elm) {
	
				document.getElementById('placeHolder '+$scope.currentForkId).placeholder =  elm.files[0].name;
				document.getElementById('send '+$scope.currentForkId).disabled = false;
				document.getElementById('formUpload '+$scope.currentForkId).action = /photo/+'fork/'+$scope.currentForkId;
		
				$scope.$apply();
			}
			
			
			$scope.changeForkId = function(forkId) {
				
				$scope.currentForkId = forkId;			
			}
			
			

			$http({
				method : "GET",
				url : '/forks/' + $routeParams.page
			}).then(function(response) {

				$scope.forks = response.data;

			}, function myError(response) {

			});
})