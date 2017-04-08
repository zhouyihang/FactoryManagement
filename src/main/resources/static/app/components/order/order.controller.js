appCliente.controller('orderController', function($scope, orderService, dialogs) {
	
	$scope.orders = [];
	
	orderService.findAll().$promise.then(
		function (orders) {
			$scope.orders = orders;
		}, 
		function (response) {

	});

	$scope.removerOrder = function(order) {
		var dlg = dialogs.confirm('Remoção de Order', 'Deseja remover?');
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