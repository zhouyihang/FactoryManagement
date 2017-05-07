angular.module('appFactory')

.factory('workFactory', function($resource) {
	
	return $resource('/work/:workId', null, {
		update : {
			method: 'POST',
            params:{
                update:true
            }
		}
	});
})
.service('workService', function(workFactory){
	
	this.saveWork = function(work){
		return workFactory.save(work);
	};
	
	this.updateWork = function(work) {
		return workFactory.private.update(work);
	};
	
	this.getById = function(workId){
		return workFactory.private.get({workId: workId});
	};
	
	this.findAll = function() {
		return workFactory.private.query();
	};
	
	this.remove = function(workId) {
		return workFactory.private.delete({workId: workId});
	};

});