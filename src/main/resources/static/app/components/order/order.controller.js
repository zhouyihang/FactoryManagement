appFactory.controller('ordersController', function($scope, orderService, orderListService, dialogs) {
	
	
	$scope.initOrder = function() {
		$scope.getOrderList();
    };
    
    $scope.getOrderList = function() {
        orderListService.getOrderList()
            .then(
                function( Orders ) {
                    loadData( Orders );
                }
            )
    };

    $scope.valueChanged = function() {
        orderListService.getOrderList($scope.selectedOrderStatus)
            .then(
                loadOrderList,
                function( errorMessage ) {
                    alert( errorMessage );
                }
            )
    };

    function loadData( newOrders ) {
        $scope.orders = newOrders;
    };

    function loadOrderList( orderList ) {
        console.log(orderList);
        $scope.orderList = orderList;
    };
    
	$scope.removerOrder = function(order) {
		var dlg = dialogs.confirm('remove a order', 'confirm remove?');
		dlg.result.then(function(btn){
			remover(order);
		},function(btn){
		});
	};
	
	var remover = function(order) {
		orderService.remove(order.id).$promise.then(
			function(response) {
				var index = $scope.orders.indexOf(order);
				$scope.orders.splice(index, 1);
			},
			function(response) {

		});
	};
});