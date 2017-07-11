angular.module('myApp').controller(
		'tires',
		function($scope, $http, $routeParams, $location, $routeParams,
				paginationService, purchaseProductFactory, basketFactory, toastr) {

			$scope.tires = [];

			$scope.paginationService = paginationService;

			$scope.urlTire = "/tires/";
	
            $scope.addToBacket = function(product) {
            	
				toastr.success('Tire '+product.brand +' '+ product.model+' was added in basket');
				
				var ind = basketFactory.map(function(e) { return e.imageName; }).indexOf(product.imageName);
				
				console.log(ind)
				
				if(ind != -1) {
					basketFactory[ind].amount++;
					basketFactory[ind].sumPurchase += product.price;
					return;
				}
				
				basketFactory.push({
					amount:1,
					product:'tires',
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
							product:'tires',
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

			paginationService.pagination('/getAmountPage/tires',
					$routeParams.page, $scope.paginationParam)

			$http({
				method : "GET",
				url : '/tires/' + $routeParams.page
			}).then(function(response) {
				$scope.tires = response.data;

			}, function myError(response) {

			});

		});