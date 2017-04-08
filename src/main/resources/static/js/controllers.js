factoryManagementApp.controller('OrderController', function($scope, orderService) {

    $scope.init = function() {
        $scope.getList();
		$scope.valueChanged();
    };

    $scope.getList = function() {
        orderService.getOrderList()
            .then(
                function( Orders ) {
                    loadData( Orders );
                }
            )
    };

    $scope.valueChanged = function() {
        orderService.getOrderList($scope.selectedOrderStatus)
            .then(
                loadOrderList,
                function( errorMessage ) {
                    alert( errorMessage );
                }
            )
    };

    function loadData( newOrders ) {
        $scope.Orders = newOrders;
    };

    function loadOrderList( orderList ) {
        console.log(orderList);
        $scope.orderList = orderList;
    };
});