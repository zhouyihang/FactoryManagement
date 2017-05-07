appFactory.controller('worksController', function($scope, workService, workListService, dialogs) {
	
	
	$scope.initWork = function() {
		$scope.getWorkList();
    };
    
    $scope.getWorkList = function() {
        workListService.getWorkList()
            .then(
                function( Works ) {
                    loadWorkData( Works );
                }
            )
    };

    function loadWorkData( newWorks ) {
        $scope.works = newWorks;
    };
    
	$scope.removerWork = function(work) {
		var dlg = dialogs.confirm('remove a work', 'confirm remover?');
		dlg.result.then(function(btn){
			remover(work);
		},function(btn){
		});
	};
	
	var remover = function(work) {
		workService.remove(work.id).$promise.then(
			function(response) {
				var index = $scope.works.indexOf(work);
				$scope.works.splice(index, 1);
			},
			function(response) {

		});
	};
});