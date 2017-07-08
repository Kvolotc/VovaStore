angular.module('myApp').controller('changeImageBrake',
		function($scope, $rootScope, $http, $location, $routeParams,
				paginationService, purchaseProductFactory, basketFactory, toastr, currentUser) {
				       
			$scope.brakes = [];
			
			$scope.urlBrake = "#/changeImageBrakes/";

			$scope.url = "/changeImageBrakes/";
			
			$scope.currentBrakeId;
			
			$scope.paginationParam = {
					masPages : [],
					isNext : false,
					isPrevious : false
				}

			paginationService.pagination('/getAmountPage/brakes',
						$routeParams.page, $scope.paginationParam)
			
			
			$scope.filesChanged = function(elm) {
	
				document.getElementById('placeHolder '+$scope.currentBrakeId).placeholder =  elm.files[0].name;
				document.getElementById('send '+$scope.currentBrakeId).disabled = false;
				document.getElementById('formUpload '+$scope.currentBrakeId).action = /photo/+'brake/'+$scope.currentBrakeId;
		
				$scope.$apply();
			}
			
			
			$scope.changeBrakeId = function(brakeId) {
				
				$scope.currentBrakeId = brakeId;			
			}
			
			

			$http({
				method : "GET",
				url : '/brakes/' + $routeParams.page
			}).then(function(response) {

				$scope.brakes = response.data;

			}, function myError(response) {

			});
})