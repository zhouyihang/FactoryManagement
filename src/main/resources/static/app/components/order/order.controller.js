appFactory.controller('ordersController', function($scope, orderService, orderListService, orderSummaryService, orderSummaryCompletedService, dialogs) {
	
	
	$scope.initOrder = function() {
		$scope.getOrderList();
		$scope.getOrderSummary();
		$scope.getOrderSummaryCompleted();
    };
    
    $scope.getOrderList = function() {
        orderListService.getOrderList()
            .then(
                function( Orders ) {
                    loadData( Orders );
                }
            )
    };

    $scope.getOrderSummary = function() {
        orderSummaryService.getOrderSummary()
            .then(
                function( OrderSummary ) {
                    loadOrderSummary( OrderSummary );
                }
            )
    };
    

    $scope.getOrderSummaryCompleted = function() {
        orderSummaryCompletedService.getOrderSummary()
            .then(
                function( OrderSummaryCompleted ) {
                    loadOrderSummaryCompleted( OrderSummaryCompleted );
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

    function loadOrderSummary( orderSummary ) {
        $scope.orderSummary = orderSummary;
//		  $scope.order_chart1_labels = ["January", "February", "March", "April", "May", "June", "July"];
		  $scope.order_chart1_series = ['Active'];
//		  $scope.order_chart1_data = [
//		    [65, 59, 80, 81, 56, 55, 40],
//		    [28, 48, 40, 19, 86, 27, 90]
//		  ];
        	// LOOP THROUGH DATA IN THE JSON FILE.
		  $scope.order_chart1_labels_arr = new Array;
		  $scope.order_chart1_data_arr = new Array;
          angular.forEach(orderSummary, function (item) {
        	  $scope.order_chart1_labels_arr.push(item.label);
        	  $scope.order_chart1_data_arr.push(item.count);
          });

          $scope.order_chart1_labels = new Array;
          $scope.order_chart1_data = new Array;

          // UPDATE SCOPE PROPERTIES “data” and “label” FOR DATA.
          $scope.order_chart1_data.push($scope.order_chart1_data_arr.slice(0));

          for (var i = 0; i < $scope.order_chart1_labels_arr.length; i++) {
        	  $scope.order_chart1_labels.push($scope.order_chart1_labels_arr[i]);
          }
    };
    
    function loadOrderSummaryCompleted( OrderSummaryCompleted ) {
        $scope.OrderSummaryCompleted = OrderSummaryCompleted;
		  $scope.order_chart2_series = ['completed'];
        	// LOOP THROUGH DATA IN THE JSON FILE.
		  $scope.order_chart2_labels_arr = new Array;
		  $scope.order_chart2_data_arr = new Array;
          angular.forEach(OrderSummaryCompleted, function (item) {
        	  $scope.order_chart2_labels_arr.push(item.label);
        	  $scope.order_chart2_data_arr.push(item.count);
          });

          $scope.order_chart2_labels = new Array;
          $scope.order_chart2_data = new Array;

          // UPDATE SCOPE PROPERTIES “data” and “label” FOR DATA.
          $scope.order_chart2_data.push($scope.order_chart2_data_arr.slice(0));

          for (var i = 0; i < $scope.order_chart2_labels_arr.length; i++) {
        	  $scope.order_chart2_labels.push($scope.order_chart2_labels_arr[i]);
          }
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
