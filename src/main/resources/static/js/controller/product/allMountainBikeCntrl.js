angular.module('myApp').controller('allMountainsBikes',
		function($scope, $rootScope, $http, $location, $routeParams,
				paginationService, purchaseProductFactory, basketFactory, toastr, currentUser) {
				       
			$scope.bikes = [];
			
			$scope.currentUser = currentUser;

			$scope.paginationService = paginationService;
			
			$scope.photo;

			$scope.urlBike = "/allMountainBikes/";
			

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
			};
			
			
			$scope.addToBacket = function(product) {
				
				toastr.success('Bike '+product.frame.brand +' '+ product.frame.model+' was added in basket');
						
				var ind = basketFactory.map(function(e) { return e.imageName; }).indexOf(product.imageName);
				
				if(ind != -1) {
					basketFactory[ind].amount++;
					basketFactory[ind].sumPurchase += product.price;
					return;
				}
				
				basketFactory.push({
					amount:1,
					product:'bikes',
					productId:product.id,
					imageName: product.imageName,
					brand:product.frame.brand,
					model:product.frame.model,
					productPrice:product.price,
					sumPurchase:product.price
				});
			};
			

			$scope.paginationParam = {
				masPages : [],
				isNext : false,
				isPrevious : false
			}

			paginationService.pagination('/getAmountPage/allMountainBikes',
					$routeParams.page, $scope.paginationParam)

			$http({
				method : "GET",
				url : '/allMountainBikes/' + $routeParams.page
			}).then(function(response) {

				$scope.bikes = response.data;

			}, function myError(response) {


			});


		});