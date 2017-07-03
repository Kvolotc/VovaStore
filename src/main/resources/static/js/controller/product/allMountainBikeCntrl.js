angular.module('myApp').controller('allMountainsBikes',
		function($scope, $rootScope, $http, $location, $routeParams,
				paginationService, purchaseProductFactory, basketFactory, toastr, currentUser) {
				       
			$scope.bikes = [];
			
			$scope.currentUser = currentUser;

			$scope.paginationService = paginationService;
			
			$scope.photo;

			$scope.urlBike = "#!/allMountainBikes/";

			$scope.url = "/allMountainBikes/";
			
			$scope.currentBikeId;		
			
			
			$scope.filesChanged = function(elm) {
	
				document.getElementById('placeHolder '+$scope.currentBikeId).placeholder =  elm.files[0].name;
				document.getElementById('send '+$scope.currentBikeId).disabled = false;
				document.getElementById('formUpload '+$scope.currentBikeId).action = /photo/+'bike/'+$scope.currentBikeId;
		
				$scope.$apply();
			}
			
			
			$scope.changeBikeId = function(bikeId) {
				
				$scope.currentBikeId = bikeId;			
			}


//			$(document).off().on('click', '.browse', function(){
//				  $(this).parent().parent().parent().find('.file').trigger('click')
//			});
//			
//			$(document).on('change', '.file', function(){
//				 $(this).parent().find('.form-control').val($(this).val().replace(/C:\\fakepath\\/i, ''));
//			  
//			 if (!document.getElementById($scope.inputFile).files[0].name.match(/.(jpg|jpeg|png|gif)$/i)) {
//				  toastr.error('U have to choose image file');
//				  document.getElementById($scope.buttonSend).disabled = true;
//			 }	
//			 else {
//				 document.getElementById($scope.buttonSend).disabled = false;
//			 }
//		});
			
//			$(document).on('change', '.file', function(){
//				console.log(  $(this).parent().find('.form-control').val($(this).val().context))
//				 $(this).parent().find('.form-control').val($(this).val().replace(/C:\\fakepath\\/i, ''))
//				 console.log( $(this).parent().find('.form-control').val($(this).val().replace(/C:\\fakepath\\/i, '')))
//				var file = document.getElementById('file '+$scope.currentImageName).files[0];
//				console.log(file)
//				document.getElementById('placeHolder '+$scope.currentImageName).placeholder = file.name;
//				document.getElementById('send '+$scope.currentImageName).disabled = false;
//			});

			
			
			

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