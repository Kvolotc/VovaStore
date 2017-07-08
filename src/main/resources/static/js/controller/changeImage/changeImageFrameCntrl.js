angular.module('myApp').controller('changeImageFrame',
		function($scope, $rootScope, $http, $location, $routeParams,
				paginationService, purchaseProductFactory, basketFactory, toastr, currentUser) {
				       
			$scope.frames = [];
			
			$scope.urlFrame= "#/changeImageFrames/";

			$scope.url = "/changeImageFrames/";
			
			$scope.currentFrameId;		
			
			$scope.paginationParam = {
					masPages : [],
					isNext : false,
					isPrevious : false
				}

			paginationService.pagination('/getAmountPage/frames',
						$routeParams.page, $scope.paginationParam)
			
			
			$scope.filesChanged = function(elm) {
	
				document.getElementById('placeHolder '+$scope.currentFrameId).placeholder =  elm.files[0].name;
				document.getElementById('send '+$scope.currentFrameId).disabled = false;
				document.getElementById('formUpload '+$scope.currentFrameId).action = /photo/+'frame/'+$scope.currentFrameId;
		
				$scope.$apply();
			}
			
			
			$scope.changeFrameId = function(frameId) {
				
				$scope.currentFrameId = frameId;			
			}
			
			

			$http({
				method : "GET",
				url : '/frames/' + $routeParams.page
			}).then(function(response) {

				$scope.frames = response.data;

			}, function myError(response) {

			});
})