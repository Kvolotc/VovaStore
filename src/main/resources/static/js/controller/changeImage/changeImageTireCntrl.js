angular.module('myApp').controller('changeImageTire',
		function($scope, $rootScope, $http, $location, $routeParams,
				paginationService, purchaseProductFactory, basketFactory, toastr, currentUser) {
				       
			$scope.tires = [];
			
			$scope.urlTire = "#/changeImageTires/";

			$scope.url = "/changeImageTires/";
			
			$scope.currentTireId;	
			
			$scope.paginationParam = {
					masPages : [],
					isNext : false,
					isPrevious : false
				}

			paginationService.pagination('/getAmountPage/tires',
						$routeParams.page, $scope.paginationParam)
			
			
			$scope.filesChanged = function(elm) {
	
				document.getElementById('placeHolder '+$scope.currentTireId).placeholder =  elm.files[0].name;
				document.getElementById('send '+$scope.currentTireId).disabled = false;
				document.getElementById('formUpload '+$scope.currentTireId).action = /photo/+'tire/'+$scope.currentTireId;
		
				$scope.$apply();
			}
			
			
			$scope.changeTireId = function(tireId) {
				
				$scope.currentTireId = tireId;			
			}
			
			

			$http({
				method : "GET",
				url : '/tires/' + $routeParams.page
			}).then(function(response) {

				$scope.tires = response.data;

			}, function myError(response) {

			});
})