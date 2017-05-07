angular.module('appFactory')

.factory('productFactory', function($resource) {
	
	return $resource('/product/:productId', null, {
		update : {
			method: 'POST',
            params:{
                update:true
            }
		}
	});
})
.service('productService', function(productFactory){
	
	this.saveProduct = function(product){
		return productFactory.save(product);
	};
	
	this.updateProduct = function(product) {
		return productFactory.private.update(product);
	};
	
	this.getById = function(productId){
		return productFactory.private.get({productId: productId});
	};
	
	this.findAll = function() {
		return productFactory.private.query();
	};
	
	this.remove = function(productId) {
		return productFactory.private.delete({productId: productId});
	};

});