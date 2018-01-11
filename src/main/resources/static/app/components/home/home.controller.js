appFactory.controller('homeController', function($scope, homeSummaryService, dialogs) {
	
	
	$scope.initHome = function() {
		$scope.getHomeSummary();
    };
    
    $scope.getHomeSummary = function() {
        homeSummaryService.getHomeSummary()
            .then(
                function( Homes ) {
                    loadData( Homes );
                }
            )
    };

    function loadData( newHomes ) {
        $scope.homeSummary = newHomes;
    };

    
});
