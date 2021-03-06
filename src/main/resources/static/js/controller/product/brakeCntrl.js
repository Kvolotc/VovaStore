angular.module('myApp').controller(
		'brakes',
		function($scope, $http, $routeParams, $location, $routeParams,
				paginationService, purchaseProductFactory, basketFactory, toastr) {

			$scope.brakes = [];

			$scope.paginationService = paginationService;

			$scope.urlBrake = "/brakes/";

			$scope.addToBacket = function(product) {
				
				toastr.success('Brake '+product.brand +' '+ product.model+' was added in basket');
				
				var ind = basketFactory.map(function(e) { return e.imageName; }).indexOf(product.imageName);
				
				if(ind != -1) {
					basketFactory[ind].amount++;
					basketFactory[ind].sumPurchase += product.price;
					return;
				}
				
				basketFactory.push({
					amount:1,
					product:'brakes',
					productId:product.id,
					imageName: product.imageName,
					brand:product.brand,
					model:product.model,
					productPrice:product.price,
					sumPurchase:product.price
				});
			};
			
			
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
							product:'BRAKES',
							productId:product.id,
							imageName: product.imageName,
							brand:product.brand,
							model:product.model,
							productPrice:product.price,
							sumPurchase:product.price
						})
						
				$location.path('/purchaseProduct')
			};

			$scope.paginationParam = {
				masPages : [],
				isNext : false,
				isPrevious : false
			}

			paginationService.pagination('/getAmountPage/brakes',
					$routeParams.page, $scope.paginationParam)

			$http({
				method : "GET",
				url : '/brakes/' + $routeParams.page
			}).then(function(response) {
				$scope.brakes = response.data;

			}, function myError(response) {

			});


		});