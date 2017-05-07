angular.module('appFactory').service(
    "workListService",
    function ($http, $q) {
        // API
        return ({
            getWorkList: getWorkList
        });

        // PUBLIC METHODS.

        // Get work list
        function getWorkList() {
            console.log();
            var request = $http({
                method: "get",
                url: "work",
                params: {
                    action: "get"
                }
            });
            return ( request.then(handleSuccess, handleError) );
        }

        // PRIVATE METHODS.

        // Transform the error response, unwrapping the application dta from
        // the API response payload.
        function handleError(response) {
            if (
                !angular.isObject(response.data) || !response.data.message
            ) {
                return ( $q.reject("An unknown error occurred.") );
            }
            return ( $q.reject(response.data.message) );
        }

        // I transform the successful response, unwrapping the application data
        // from the API response payload.
        function handleSuccess(response) {
            return ( response.data );
        }
    }
);