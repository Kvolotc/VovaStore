angular.module('myApp').controller(
		'searchTires',
		function($scope, $rootScope, $http, $location, $routeParams,
				paginationService, purchaseProductFactory, basketFactory, toastr) {

			$scope.tires = [];
			
			$scope.isEmpty = false;

			$scope.paginationService = paginationService;
			
			$scope.currentTireId;		
			
			
			$scope.filesChanged = function(elm) {
	
				document.getElementById('placeHolder '+$scope.currentTireId).placeholder =  elm.files[0].name;
				document.getElementById('send '+$scope.currentTireId).disabled = false;
				document.getElementById('formUpload '+$scope.currentTireId).action = /photo/+'Tire/'+$scope.currentTireId;
		
				$scope.$apply();
			}
			
			
			$scope.changeTireId = function(tireId) {
				
				$scope.currentTireId = tireId;			
			}
			
			
            $scope.addToBacket = function(product) {
            	
				toastr.success('Tire '+product.brand +' '+ product.model+' was added in basket');
				
				var ind = basketFactory.map(function(e) { return e.imageName; }).indexOf(product.imageName);
				
				if(ind != -1) {
					basketFactory[ind].amount++;
					basketFactory[ind].price += product.price;
					return;
				}
				
				basketFactory.push({
					amount:1,
					product:'tires',
					imageName: product.imageName,
					brand:product.brand,
					model:product.model,
					productPrice:product.price,
					sumPurchase:product.price
				});
			};
			

			$scope.urlTire = "/searchTires/word=" + $routeParams.word
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
							product:'tires',
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

			paginationService.pagination('/getAmountPageSearchTires/?word='
					+ $routeParams.word + '&min=' + $routeParams.min + '&max='
					+ $routeParams.max, $routeParams.page,
					$scope.paginationParam)

			$http(
					{
						method : "GET",
						url : '/searchTires/?word=' + $routeParams.word
								+ '&min=' + $routeParams.min + '&max='
								+ $routeParams.max + '&page='
								+ $routeParams.page
					}).then(function(response) {
				$scope.tires = response.data;
				if($scope.tires.length == 0) {
					$scope.isEmpty = true;
				}
			}, function myError(response) {

			});

		});