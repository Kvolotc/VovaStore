angular.module('myApp').controller(
		'rims',
		function($scope, $http, $routeParams, $location, $routeParams,
				paginationService, purchaseProductFactory, basketFactory, toastr) {

			$scope.rims = [];

			$scope.paginationService = paginationService;

			$scope.urlRim = "#!/rims/";

			$scope.url = "/rims/";
			
			
            $scope.addToBacket = function(product) {
            	
				toastr.success('Rim '+product.brand +' '+ product.model+' was added in basket');
				
				var ind = basketFactory.map(function(e) { return e.imageName; }).indexOf(product.imageName);
				
				console.log(ind)
				
				if(ind != -1) {
					basketFactory[ind].amount++;
					basketFactory[ind].price += product.price;
					return;
				}
				
				basketFactory.push({
					amount:1,
					product:'rims',
					imageName: product.imageName,
					brand:product.brand,
					model:product.model,
					productPrice:product.price,
					price:product.price
				});
			};
			

			$scope.buyProduct = function(product) {
				if(purchaseProductFactory.length >=1) {
					purchaseProductFactory.splice(0, purchaseProductFactory.length)
				}
				purchaseProductFactory.push(product)
			}

			$scope.paginationParam = {
				masPages : [],
				isNext : false,
				isPrevious : false
			}

			paginationService.pagination('/getAmountPage/rims',
					$routeParams.page, $scope.paginationParam)

			$http({
				method : "GET",
				url : '/rims/' + $routeParams.page
			}).then(function(response) {
				$scope.rims = response.data;

			}, function myError(response) {

			});

		});