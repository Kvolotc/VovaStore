angular.module('myApp').controller('changeImageRim',
		function($scope, $rootScope, $http, $location, $routeParams,
				paginationService, purchaseProductFactory, basketFactory, toastr, currentUser) {
				       
			$scope.rims = [];
			
			$scope.urlRim = "/changeImageRims/";

			$scope.currentRimId;
			
			$scope.paginationParam = {
					masPages : [],
					isNext : false,
					isPrevious : false
				}

			paginationService.pagination('/getAmountPage/rims',
						$routeParams.page, $scope.paginationParam)
			
			
			$scope.filesChanged = function(elm) {
	
				document.getElementById('placeHolder '+$scope.currentRimId).placeholder =  elm.files[0].name;
				document.getElementById('send '+$scope.currentRimId).disabled = false;
				document.getElementById('formUpload '+$scope.currentRimId).action = /photo/+'rim/'+$scope.currentRimId;
		
				$scope.$apply();
			}
			
			
			$scope.changeRimId = function(rimId) {
				
				$scope.currentRimId = rimId;			
			}
			
			

			$http({
				method : "GET",
				url : '/rims/' + $routeParams.page
			}).then(function(response) {

				$scope.rims = response.data;

			}, function myError(response) {

			});
})