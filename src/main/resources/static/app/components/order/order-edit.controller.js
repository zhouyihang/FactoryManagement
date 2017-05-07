appFactory.controller('orderController', function($rootScope, $scope, orderService, productService, productListService, $location, $routeParams, growl, dialogs) {

	$scope.order = {};
	$scope.product = {};
	$scope.productMotalDisabled=false;
	$scope.disableProductInput=[true,true,true,true,true,true,true,true,true];
	//$scope.workIndex=0;

	$scope.saveOrder = function(order) {

		if ($scope.frmOrder.$valid) {
			if ($scope.order.orderId) {
				
				orderService.updateOrder(order).$promise.then(
				function(value) {
					$location.path('/viewOrders')
					growl.success("Order updated sucessfully!");

				}, function(error) {

				});

			} else {
				orderService.saveOrder(order).$promise.then(

					function(value) {
						$location.path('/viewOrders')
						growl.success("Order created sucessfully!");
	
					}, function(error) {

				});
			}
		} else {
			growl.error("Order invalid!");
		}
	};
	
	$scope.addWork = function(order) {
		$rootScope.order=order;
		$location.path('/newWork')
	}
	

	$scope.cancelarAlteracao = function() {
		$location.path('#/order')
	}

	if ($routeParams.orderId) {
		orderService.getById($routeParams.orderId).$promise.then(
			function(order) {
				$scope.order = order;

			}, function(response) {
				console.log("error order id " + response);
		});
	}
	

//	$scope.initProduct = function() {
//		$scope.getProductList();
//    };
    
    $scope.getProductList = function() {

//    	growl.success("see works" + $scope);
        angular.forEach($scope.order.orderWorks, function(index){
        	//$scope.disableProductInput[index]=true;
//        	growl.success("see index" + index);
        	$scope.disableProductInput.push(true);//this doesn't work. don't know why...???
        });
        
    	growl.success("init prod list");
        productListService.getProductList()
            .then(
                function( Products ) {
                    loadData( Products );
                }
            );

    };

    function loadData( newProducts ) {
        $scope.products = newProducts;
//        $scope.products.push({"productName":"new product..."})
    };

    $scope.productSelected = function(workIndex, selectedProduct) {
    	/*var workIndex = $scope.order.orderWorks.indexOf(work);*/
//    	growl.success("productIdSelected!"+workIndex+";"+selectedProduct);
    	$scope.order.orderWorks[workIndex].product=JSON.parse(selectedProduct);
    	$scope.disableProductInput[workIndex]=true;
//    	growl.success("productIdSelected!"+$scope.order);
    	/*$scope.selectedProduct = selectedProduct;*/
    };
    $scope.newProductClick = function(workIndex) {
    	$scope.order.orderWorks[workIndex].product={};
    	$scope.disableProductInput[workIndex]=false;
    }
    
	$scope.addRow = function(order) {
//		growl.success("addRow!");
		if ($scope.order.orderWorks) {
			$scope.order.orderWorks.push({expectDeliverDate:order.expectDeliverDate});
		} else {
			$scope.order.orderWorks=[{"expectDeliverDate":order.expectDeliverDate}];
		}
	}

	$scope.removeRow = function(work) {
		var dlg = dialogs.confirm('remove a work', 'confirm remove?');
		dlg.result.then(function(btn){
			remove(work);
		},function(btn){
		});
	};

	var remove = function(work) {
		
		if (work.workId) {
			growl.success("remove Row."+ work.workId);
			workService.remove(work.workId).$promise.then(
					function(response) {
						var index = $scope.order.orderWorks.indexOf(work);
						$scope.order.orderWorks.splice(index, 1);
					},
					function(response) {

				});
		} else {
			growl.success("remove Row. null workid");
			var index = $scope.order.orderWorks.indexOf(work);
			$scope.order.orderWorks.splice(index, 1);
		}
	};

	/* this is for edit product under the main order web page.*/
		$scope.addSourceRowForNewProduct = function(workIndex, product) {
			growl.success("add source for product!");
			//$scope.workIndex=workIndex;
			if ($scope.order.orderWorks[workIndex].product.productSource) {
				$scope.order.orderWorks[workIndex].product.productSource.push({"source":{}});
			} else {
				$scope.order.orderWorks[workIndex].product.productSource=[{"source":{}}];
			}
		}

		$scope.removeSourceRowForNewProduct = function(sourceIndex, productSource) {
			var dlg = dialogs.confirm('remove a row', 'confirm remove?');
			dlg.result.then(function(btn){
				removeSourceForNewProduct(sourceIndex, productSource);
			},function(btn){
			});
		};

		var removeSourceForNewProduct = function(sourceIndex, productSource) {
				growl.success("remove Row. null product source id");
//				var workIndex = $scope.workIndex
//				var index = $scope.order.orderWorks[workIndex].product.productSource.indexOf(productSource);
				$scope.order.orderWorks[$scope.workIndex].product.productSource.splice(sourceIndex, 1);
		};
		
/* this is for product editor*/
	$scope.addSourceRow = function(product) {
		growl.success("add source for product!");
		if ($scope.product.productSource) {
			$scope.product.productSource.push({"source":{}});
		} else {
			$scope.product.productSource=[{"source":{}}];
		}
	}

	$scope.removeSourceRow = function(productSource) {
		var dlg = dialogs.confirm('remove a row', 'confirm remove?');
		dlg.result.then(function(btn){
			removeSource(productSource);
		},function(btn){
		});
	};

	var removeSource = function(productSource) {
		
		if (productSource.productSourceId) {
			growl.success("remove Row."+ productSource.productSourceId);
			productService.remove(productSource.productSourceId).$promise.then(
					function(response) {
						var index = $scope.product.productSource.indexOf(productSource);
						$scope.product.productSource.splice(index, 1);
					},
					function(response) {

				});
		} else {
			growl.success("remove Row. null product source id");
			var index = $scope.product.productSource.indexOf(productSource);
			$scope.product.productSource.splice(index, 1);
		}
	};
	
	/* save product which under modal.*/
	$scope.saveProduct = function(product) {
		
		if ($scope.frmProduct.$valid) {
			$scope.productMotalDisabled="true";
			if ($scope.product.productId) {
				
				productService.updateProduct(product).$promise.then(
				function(value) {
//					$location.path('/viewProducts')
					growl.success("Product updated sucessfully!");

				}, function(error) {

				});

			} else {
				productService.saveProduct(product).$promise.then(

					function(value) {
//						$location.path('/viewProducts')
						growl.success("Product created sucessfully!");
	
					}, function(error) {

				});
			}
		} else {
			growl.error("Product invalid!");
		}
	};
	
	$scope.editProduct = function() {
		$scope.productMotalDisabled="enable";
		growl.success("edit product!");
	};

});