angular.module('myApp').controller('purchaseProduct',
		function(currentUser, $scope, $http, purchaseProductFactory) {

			$scope.products = purchaseProductFactory;
			
			$scope.purchaseProduct = {
					userId : currentUser.id,
					contry : $scope.contry,
					city : $scope.city,
					payment : $scope.payment,
					newPost : $scope.newPost,
					productParams : purchaseProductFactory,
			};
			
			$scope.mail = {
					to : currentUser.email,
					text : 'Expect your product to be viewed by the administrator. After confirmation we will contact you',
					subject : 'Purchase product'
			}
			
			$scope.cash = 0;
			
			$scope.credit = 0;
			
			$(document).ready(function() {
				
				for(var ind = 0; ind < $scope.products.length; ind++) {
					$scope.cash += $scope.products[ind].sumPurchase;
				}
				
				$scope.credit = Math.round($scope.cash/12 + ($scope.cash/10)/12);
			
			})
			

			$scope.hideModal = function() {
				$("#purchaseModal").modal("hide")
			};
			
			
			$scope.buyProduct = function() {
				
				
				$http({
					method : 'POST',
					url : '/purchaseProduct',
					contentType : 'application/json',
					dataType : 'json',
					async : true,
					data : $scope.purchaseProduct
				}).then(function(response) {
					
					$http({
						method : 'POST',
						url : '/mailsender',
						async : true,
						contentType : 'application/json',
						dataType : 'json',
						data : $scope.mail
					});
	
					
				}, function errorCallback(response) {
					
					
				});
				
			} 		

		})
