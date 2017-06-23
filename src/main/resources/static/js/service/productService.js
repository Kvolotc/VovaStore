//myApp
//		.service(
//				'padination',
//				function($http, $location) {
//
//					this.firstPadination = function(url, numPage, factory) {
//						if (numPage == 1) {
//
//							$http({
//								method : "GET",
//								url : url
//							})
//									.then(
//											function(response) {
//												
//												factory.isNext = false;
//												factory.isPrevious = false;
//												var pages = response.data;
//												var sizePage = 5;
//												var maxLengthPage = 0;
//												factory.masPage = [];
//												factory.countPage = pages;
//
//												if (pages > sizePage) {
//													maxLengthPage = 5;
//													factory.isNext = true;
//
//												} else {
//													maxLengthPage = pages;
//												}
//
//												for (var ind = numPage; maxLengthPage >= ind; ind++) {
//													factory.masPage.push(ind);
//												}
//											}, function myError(response) {
//											});
//						}
//					}
//
//					this.updatePadination = function(url, numPage, factory) {
//						if (factory.countPage == 0 && numPage != 1) {
//
//							$http({
//								method : "GET",
//								url : url
//							})
//								.then(
//										function(response) {
//
//											var pages = response.data;
//											var sizePage = 5;
//											var divider = 0
//											var maxLengthPage = 0;
//
//											if (numPage % sizePage == 0) {
//												divider = 1;
//											}
//
//											var stateNext = (Math.floor(numPage/ sizePage) - divider) * sizePage;
//											factory.countPage = pages - stateNext;
//
//											if (numPage > 5) {
//												factory.isPrevious = true;
//											}
//
//											if (factory.countPage > sizePage) {
//												maxLengthPage = stateNext + sizePage;
//												factory.isNext = true;
//											} else {
//													maxLengthPage = stateNext + factory.countPage;
//											}
//
//											for (var ind = stateNext + 1; maxLengthPage >= ind; ind++) {
//												factory.masPage.push(ind);
//											}
//
//										}, function myError(response) {
//										});
//
//						}
//					}
//
//					this.next = function(url, numPage, factory) {
//
//						factory.isPrevious = true;
//						var maxLengthPage = 0;
//						factory.masPage = [];
//						var sizePage = 5;
//						factory.countPage = factory.countPage - sizePage;
//						var pages = factory.countPage;
//
//						if (pages > sizePage) {
//							factory.isNext = true;
//							maxLengthPage = numPage + 5;
//						} else {
//							factory.isNext = false;
//							maxLengthPage = pages + numPage;
//						}
//						for (var ind = numPage; maxLengthPage > ind; ind++) {
//							factory.masPage.push(ind);
//						}
//
//						$location.path(url + numPage);
//					}
//
//					this.previous = function(url, numPage, factory) {
//
//						factory.isNext = true;
//						factory.masPage = [];
//						minLengthPage = numPage - 4;
//						var sizePage = 5;
//						factory.countPage = factory.countPage + sizePage;
//						var pages = factory.countPage;
//
//						if (numPage > sizePage) {
//							factory.isPrevious = true;
//
//						} else {
//							factory.isPrevious = false;
//						}
//						for (var ind = minLengthPage; numPage >= ind; ind++) {
//							factory.masPage.push(ind);
//						}
//
//						$location.path(url + numPage);
//					}
//
//				});