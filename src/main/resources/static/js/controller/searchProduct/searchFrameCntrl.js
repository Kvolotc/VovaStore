angular.module('myApp').controller(
		'searchFrames',
		function($scope, $rootScope, $http, $location, $routeParams,
				paginationService, purchaseProductFactory, basketFactory, toastr) {

			$scope.frames = [];
			
			$scope.isEmpty = false;

			$scope.paginationService = paginationService;
			
			$scope.currentFrameId;		
			
			
			$scope.filesChanged = function(elm) {
	
				document.getElementById('placeHolder '+$scope.currentFrameId).placeholder =  elm.files[0].name;
				document.getElementById('send '+$scope.currentFrameId).disabled = false;
				document.getElementById('formUpload '+$scope.currentFrameId).action = /photo/+'Frame/'+$scope.currentFrameId;
		
				$scope.$apply();
			}
			
			
			$scope.changeFrameId = function(frameId) {
				
				$scope.currentFrameId = frameId;			
			}
			
			
			$scope.addToBacket = function(product) {
				
				toastr.success('Frame '+product.brand +' '+ product.model+' was added in basket');
				
				var ind = basketFactory.map(function(e) { return e.imageName; }).indexOf(product.imageName);
				
				if(ind != -1) {
					basketFactory[ind].amount++;
					basketFactory[ind].price += product.price;
					return;
				}
				
				basketFactory.push({
					amount:1,
					product:'frames',
					imageName: product.imageName,
					brand:product.brand,
					model:product.model,
					productPrice:product.price,
					sumPurchase:product.price
				});
			};
			
			

			$scope.urlFrame = "/searchFrames/word=" + $routeParams.word
					+ ";min=" + $routeParams.min + ";max=" + $routeParams.max
					+ ";page=";

			$scope.router = $routeParams;
			
			$scope.buyProduct = function(product) {
				if($scope.currentUser.role != 'USER' && $scope.currentUser.role != 'ADMIN') {
					toastr.error('First , you have to login');
					return;
				}
				
				if(purchaseProductFactory.length >=1) {
					purchaseProductFactory.splice(0, purchaseProductFactory.length)
				}
				purchaseProductFactory.push(
						{
							amount:1,
							product:'frames',
							productId:product.id,
							imageName: product.imageName,
							brand:product.brand,
							model:product.model,
							productPrice:product.price,
							sumPurchase:product.price
						})
				$location.path('/purchaseProduct')
			}

			$scope.hideProduct = true;


			$scope.paginationParam = {
				masPages : [],
				isNext : false,
				isPrevious : false
			}

			paginationService.pagination('/getAmountPageSearchFrames/?word='
					+ $routeParams.word + '&min=' + $routeParams.min + '&max='
					+ $routeParams.max, $routeParams.page,
					$scope.paginationParam)

			$http(
					{
						method : "GET",
						url : '/searchFrames/?word=' + $routeParams.word
								+ '&min=' + $routeParams.min + '&max='
								+ $routeParams.max + '&page='
								+ $routeParams.page
					}).then(function(response) {
				$scope.frames = response.data;
				if($scope.frames.length == 0) {
					$scope.isEmpty = true;
				}
			}, function myError(response) {

			});

		});