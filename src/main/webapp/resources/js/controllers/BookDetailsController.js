'use strict';
(function() {
    app.controller('BookDetailsController', function($scope, $state, $http, $stateParams, $location) {

        $scope.showBookDetails = function(bookId){
                    $http({
                        url: './book/show_book_details',
                        method: "GET",
                        params: {
                            'bookId':bookId
                        }
                    })
                    .success(function(data){
                            $scope.book = data;
                    })
                    .error(function(err){
                            console.log(err);
                    })
        }
        $scope.showBookDetails($stateParams.bookId);
    });
})();