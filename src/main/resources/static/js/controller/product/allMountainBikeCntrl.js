angular.module('myApp').controller(
		'allMountainsBikes',
		function($scope, $rootScope, $http, $location, $routeParams,
				paginationService, purchaseProductFactory, basketFactory, toastr) {
		
			$scope.bikes = [];

			$scope.paginationService = paginationService;

			$scope.urlBike = "#!/allMountainBikes/";

			$scope.url = "/allMountainBikes/";
			

			$scope.buyProduct = function(product) {			
				if(purchaseProductFactory.length >=1) {
					purchaseProductFactory.splice(0, purchaseProductFactory.length)
				}			
				purchaseProductFactory.push(product)			
			};
			
			
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
					price:product.price
				});
			};
			

			$scope.paginationParam = {
				masPages : [],
				isNext : false,
				isPrevious : false
			}

			paginationService.pagination('/getCountPage/allMountainBikes',
					$routeParams.page, $scope.paginationParam)

			$http({
				method : "GET",
				url : '/allMountainBikes/' + $routeParams.page
			}).then(function(response) {

				$scope.bikes = response.data;

			}, function myError(response) {

			});


		});