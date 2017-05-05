myApp.service('paginationService', function($http, $location) {

	this.pagination = function(url, numPage, paginationParam) {
		
		$http({
			method : "GET",
			url : url
		}).then(function(response) {
			var pages = response.data;
			var startedStage = 1;
			var finishStage = pages;
			var divider = 0;
			var sizePage = 5;
			
			if(numPage > sizePage) {
				paginationParam.isPrevious = true;
			}
				
			if(pages > sizePage) {
				
				if (numPage % sizePage == 0) {
					divider = 1;
				}
				
				var stateNext = (Math.floor(numPage / sizePage) - divider) * sizePage;
				pages-= stateNext;
				
				if(pages > sizePage) {
					paginationParam.isNext = true;
					startedStage = stateNext+1;
					finishStage = startedStage + 4;
				}
				else{
					
					startedStage = stateNext+1;
					finishStage = startedStage + pages-1;
				
				}
			}
			
			for (var ind = startedStage; finishStage >= ind; ind++) {
				paginationParam.masPages.push(ind);			
			}
			
		}, function myError(response) {

		});
	}
	
	this.next = function (url, numPage) {
		$location.path(url+numPage);
	}
	

	this.previous = function(url, numPage) {
		$location.path(url+numPage);
	}

});