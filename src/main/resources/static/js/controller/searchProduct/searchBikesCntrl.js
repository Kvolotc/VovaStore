angular.module('myApp').controller(
		'searchBikes',
		function($scope, $rootScope, $http, $location, $routeParams,
				paginationService, purchaseProductFactory, basketFactory, toastr) {

			$scope.bikes = [];

			$scope.isEmpty = false;

			$scope.paginationService = paginationService;
			
			$scope.currentBikeId;		
			
			
			$scope.filesChanged = function(elm) {
	
				document.getElementById('placeHolder '+$scope.currentBikeId).placeholder =  elm.files[0].name;
				document.getElementById('send '+$scope.currentBikeId).disabled = false;
				document.getElementById('formUpload '+$scope.currentBikeId).action = /photo/+'bike/'+$scope.currentBikeId;
		
				$scope.$apply();
			}
			
			
			$scope.changeBikeId = function(bikeId) {
				
				$scope.currentBikeId = bikeId;			
			}
			
			
	        $scope.addToBacket = function(product) {
	        	
	        	toastr.success('Bike '+product.frame.brand +' '+ product.frame.model+' was added in basket');
				
				var ind = basketFactory.map(function(e) { return e.imageName; }).indexOf(product.imageName);
				
				if(ind != -1) {
					basketFactory[ind].amount++;
					basketFactory[ind].price += product.price;
					return;
				}
				
				basketFactory.push({
					amount:1,
					product:'bikes',
					imageName: product.imageName,
					brand:product.frame.brand,
					model:product.frame.model,
					productPrice:product.price,
					sumPurchase:product.price
				});
			};
			
			

			$scope.urlBike = "/searchBikes/word=" + $routeParams.word
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
							product:'bikes',
							productId:product.id,
							imageName: product.imageName,
							brand:product.frame.brand,
							model:product.frame.model,
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

			paginationService.pagination('/getAmountPageSearchBikes/?word='
					+ $routeParams.word + '&min=' + $routeParams.min + '&max='
					+ $routeParams.max, $routeParams.page,
					$scope.paginationParam)

			$http(
					{
						method : "GET",
						url : '/searchBikes/?word=' + $routeParams.word
								+ '&min=' + $routeParams.min + '&max='
								+ $routeParams.max + '&page='
								+ $routeParams.page
					}).then(function(response) {
				$scope.bikes = response.data;
				if ($scope.bikes.length == 0) {
					$scope.isEmpty = true;
				}
			}, function myError(response) {

			});

		});