angular.module('myApp').controller('changeImageBike',
		function($scope, $rootScope, $http, $location, $routeParams,
				paginationService, purchaseProductFactory, basketFactory, toastr, currentUser) {
				       
			$scope.bikes = [];
			
			$scope.urlBike = "/changeImageBikes/";
			
			$scope.currentBikeId;				

			$scope.paginationParam = {
				masPages : [],
				isNext : false,
				isPrevious : false
			}

			paginationService.pagination('/getAmountPage/AllBikes',
					$routeParams.page, $scope.paginationParam)
			
			
			$scope.filesChanged = function(elm) {
	
				document.getElementById('placeHolder '+$scope.currentBikeId).placeholder =  elm.files[0].name;
				document.getElementById('send '+$scope.currentBikeId).disabled = false;
				document.getElementById('formUpload '+$scope.currentBikeId).action = /photo/+'bike/'+$scope.currentBikeId;
		
				$scope.$apply();
			}
			
			
			$scope.changeBikeId = function(bikeId) {
				
				$scope.currentBikeId = bikeId;			
			}
			
			

			$http({
				method : "GET",
				url : '/getAllBikes/' + $routeParams.page
			}).then(function(response) {

				$scope.bikes = response.data;

			}, function myError(response) {

			});
})