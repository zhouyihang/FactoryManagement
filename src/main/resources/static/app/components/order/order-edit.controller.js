appCliente.controller('orderController', function($scope, orderService, $location, $routeParams, growl) {

	$scope.order = {};

	
	
	$scope.saveOrder = function(order) {

		if ($scope.frmOrder.$valid) {
			if ($scope.order.orderId) {
				
				orderService.updateOrder(order).$promise.then(
				function(value) {
					$location.path('/viewOrder/')
					growl.success("Order updated sucessfully!");

				}, function(error) {

				});

			} else {
				var locr = "'/viewOrder/'";
				var loc = locr.concat($scope.order.orderId);
				orderService.saveOrder(order).$promise.then(

					function(value) {
						$location.path(loc)
						growl.success("Order created 2 sucessfully!");
	
					}, function(error) {

				});
			}
		} else {
			growl.error("Order invalid!");
		}
	};

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

});