angular.module('myApp').controller(
		'frames',
		function($scope, $http, $routeParams, $location, $routeParams,
				paginationService, purchaseProductFactory, basketFactory, toastr) {

			$scope.frames = [];

			$scope.paginationService = paginationService;

			$scope.urlFrame = "#!/frames/";

			$scope.url = "/frames/";
			
			
			$scope.addToBacket = function(product) {
				
				toastr.success('Frame '+product.brand +' '+ product.model+' was added in basket');
				
				var ind = basketFactory.map(function(e) { return e.imageName; }).indexOf(product.imageName);
				
				console.log(ind)
				
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

			paginationService.pagination('/getCountPage/frames',
					$routeParams.page, $scope.paginationParam)

			$http({
				method : "GET",
				url : '/frames/' + $routeParams.page
			}).then(function(response) {
				$scope.frames = response.data;

			}, function myError(response) {

			});


		});