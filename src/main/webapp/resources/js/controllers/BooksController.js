'use strict';
(function() {
    app.controller('BooksController', function($scope, $state, $http, $location) {

        $scope.getAllBooksNames = function(){
        console.log("in books");
            $http({
                url: './books/all_books',
                method: "GET"
            })
            .success(function(data){
                    $scope.books = data;
            })
            .error(function(err){
                  console.log(err);
            })
        }

        $scope.showBookDetails = function(bookId) {
            $state.go("bookDetails", {'bookId': bookId},{ reload: true});
        }

        $scope.getAllBooksNames();
    });
})();
