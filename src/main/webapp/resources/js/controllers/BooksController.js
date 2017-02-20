'use strict';
(function() {
    app.controller('BooksController', function($scope, $state, $http, $location) {

        $scope.getAllBooksNames = function(){
            $http({
                url: './books/all_books',
                method: "GET"
            })
            .success(function(data){
                    $scope.books = data;
                    if(data = null)
                        location.path("errors/403");
            })
            .error(function(err){
                   location.path("errors/403");
            })
        }

        $scope.showBookDetails = function(bookId) {
            $state.go("bookDetails", {'bookId': bookId},{ reload: true});
        }

        $scope.getAllBooksNames();
    });
})();
