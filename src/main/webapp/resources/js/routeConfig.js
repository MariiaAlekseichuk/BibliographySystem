app.config(function($stateProvider, $locationProvider, $httpProvider, $routeProvider, $urlRouterProvider) {

    $httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';
    $httpProvider.defaults.cache = false;

    if (!$httpProvider.defaults.headers.get) {
        $httpProvider.defaults.headers.get = {};
    }

    $stateProvider
    .state('login', {
        url: '/login',
         templateUrl: 'login/layout.html',
        controller: 'LoginController'
    })
    .state('books', {
        url: '/books',
        templateUrl: 'books/layout.html',
        controller: 'BooksController',

    })
    .state('bookDetails', {
        url: '/book/:bookId',
        templateUrl: 'books/book_details.html',
        controller: 'BookDetailsController'
    })

    $urlRouterProvider.otherwise("/login");
});
