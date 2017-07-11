angular.module('myApp').controller(
		'mountainBike',
		function($scope, $rootScope, $http, $location, $routeParams,
				paginationService, purchaseProductFactory, basketFactory, toastr) {

			$scope.bikes = [];

			$scope.paginationService = paginationService;

			$scope.urlBike = "/mountainBikes/";
	 		
	        $scope.addToBacket = function(product) {
	        	
	        	toastr.success('Bike '+product.frame.brand +' '+ product.frame.model+' was added in basket');
				
				var ind = basketFactory.map(function(elem) { return elem.imageName;}).indexOf(product.imageName);
				
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

			$scope.paginationParam = {
				masPages : [],
				isNext : false,
				isPrevious : false
			}

			paginationService.pagination('/getAmountPage/mountainBikes',
					$routeParams.page, $scope.paginationParam)

			$http({
				method : "GET",
				url : '/mountainBikes/' + $routeParams.page
			}).then(function(response) {
				$scope.bikes = response.data;
			}, function myError(response) {

			});

		});