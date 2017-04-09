angular.module('appCliente')

.factory('resourceFactory', function($resource) {
	
	var _private = $resource('/order/:orderId', null, {
		update : {
			method: 'POST'
		}
	});

	return {
		private: _private
	};
})

.service('orderService', function(resourceFactory){
	
	this.saveOrder = function(order){
		return resourceFactory.private.save(order);
	};
	
	this.updateOrder = function(order) {
		return resourceFactory.private.update(order);
	};
	
	this.getById = function(orderId){
		return resourceFactory.private.get({orderId: orderId});
	};
	
	this.findAll = function() {
		return resourceFactory.private.query();
	};
	
	this.remove = function(orderId) {
		return resourceFactory.private.delete({orderId: orderId});
	};

});