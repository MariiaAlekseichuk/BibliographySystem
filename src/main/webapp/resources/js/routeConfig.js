app.config(function($stateProvider, $locationProvider, $httpProvider, $routeProvider, $urlRouterProvider) {

 $locationProvider.html5Mode(true);
 $httpProvider.defaults.cache = false;

 if (!$httpProvider.defaults.headers.get) {
    $httpProvider.defaults.headers.get = {};
 }

 $httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';

 $stateProvider
 .state('login', {
    url: '/login',
    templateUrl: 'login/layout.html',
    controller: 'LoginController'
 })

 $urlRouterProvider.otherwise("/login");
});