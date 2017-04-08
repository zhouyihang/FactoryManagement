appCliente.controller('orderController', function($scope, orderService, $location, $routeParams, growl) {

	$scope.order = {};

	$scope.salvarOrder = function(order) {

		if ($scope.frmOrder.$valid) {
			if ($scope.order.id) {
				
				orderService.updateOrder(order).$promise.then(
				function(value) {
					$location.path('#/order')
					growl.success("Order update sucessfully!");

				}, function(error) {

				});

			} else {
				orderService.saveOrder(order).$promise.then(

					function(value) {
						$location.path('#/order')
						growl.success("Order save sucessfully!");
	
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