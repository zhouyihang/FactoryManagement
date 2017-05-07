appFactory.controller('workController', function($rootScope, $scope, workService, $location, $routeParams, growl) {

	$scope.order=$rootScope.order;

	$scope.saveWork = function(work) {

		if ($scope.frmWork.$valid) {
			$scope.work.order=$scope.order;
			if ($scope.work.workId) {
				workService.updateWork(work).$promise.then(
				function(value) {
					$location.path('/viewWorks')
					growl.success("Work updated sucessfully!");

				}, function(error) {

				});

			} else {
				workService.saveWork(work).$promise.then(

					function(value) {
						$location.path('/viewWorks')
						growl.success("Work created sucessfully!");
	
					}, function(error) {

				});
			}
		} else {
			growl.error("Work invalid!");
		}
	};

	$scope.cancelarAlteracao = function() {
		$location.path('#/work')
	}

	if ($routeParams.workId) {
		workService.getById($routeParams.workId).$promise.then(
			function(work) {
				$scope.work = work;

			}, function(response) {
				console.log("error work id " + response);
		});
	}

});