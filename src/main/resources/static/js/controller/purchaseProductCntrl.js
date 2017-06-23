angular.module('myApp').controller('purchaseProduct',
		function(currentUser, $scope, $http, purchaseProductFactory) {

			$scope.product = purchaseProductFactory;

			$scope.contry;

			$scope.city;

			$scope.newPost = 0;

			$scope.payment;
			
			$scope.cash = 0;
			
			$scope.credit = 0;
			
			$(document).ready(function() {
				
				for(var ind = 0; ind < $scope.product.length; ind++) {
					$scope.cash += $scope.product[ind].price;
				}
				
				$scope.credit = Math.round($scope.cash/12 + ($scope.cash/10)/12);
			
			})

			$scope.hideModal = function() {
				$("#purchaseModal").modal("hide")
			}

		})
