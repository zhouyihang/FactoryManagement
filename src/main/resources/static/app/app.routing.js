appFactory.config(function($routeProvider) {

	$routeProvider.when("/login", {
		templateUrl : 'app/components/auth/login/login.html',
		controller: 'loginController'

	}).when("/signup", {
		templateUrl : 'app/components/auth/signup/signup.html',
		controller: 'SignUpController'

	}).when("/home", {
		templateUrl : 'app/components/home/home.html',
		controller : 'homeController'
		
	}).when("/viewOrder/:orderId", {
		templateUrl : 'app/components/order/order-detail.html',
		controller : 'orderController'	
			
	}).when("/updatedorder/", {
		templateUrl : 'app/components/order/order-detail.html',
		controller : 'orderController'
		
	}).when("/editOrder/:orderId", {
		templateUrl : 'app/components/order/order-edit.html',
		controller : 'orderController'
				
	}).when("/newOrder", {
		templateUrl : 'app/components/order/order-edit.html',
		controller : 'orderController'
				
	}).when("/viewOrders", {
		templateUrl : 'app/components/order/order.html',
		controller : 'ordersController'	

	}).when("/viewWork/:workId", {
		templateUrl : 'app/components/work/work-detail.html',
		controller : 'workController'	
			
	}).when("/updatedwork/", {
		templateUrl : 'app/components/work/work-detail.html',
		controller : 'workController'
		
	}).when("/editWork/:workId", {
		templateUrl : 'app/components/work/work-edit.html',
		controller : 'workController'
				
	}).when("/newWork", {
		templateUrl : 'app/components/work/work-edit.html',
		controller : 'workController'
				
	}).when("/viewWorks", {
		templateUrl : 'app/components/work/work.html',
		controller : 'worksController'	

	}).otherwise({
		redirectTo : '/home'
	});

});
