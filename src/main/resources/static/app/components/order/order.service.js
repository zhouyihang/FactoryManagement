angular.module('appFactory')

.factory('orderFactory', function($resource) {
	
	var _private = $resource('/order/:orderId', null, {
		update : {
			method: 'POST'
		}
	});

	return {
		private: _private
	};
})

.service('orderService', function(orderFactory){
	
	this.saveOrder = function(order){
		return orderFactory.private.save(order);
	};
	
	this.updateOrder = function(order) {
		return orderFactory.private.update(order);
	};
	
	this.getById = function(orderId){
		return orderFactory.private.get({orderId: orderId});
	};
	
	this.findAll = function() {
		return orderFactory.private.query();
	};
	
	this.remove = function(orderId) {
		return orderFactory.private.delete({orderId: orderId});
	};

});