'use strict';
(function() {
    app.controller('LoginController', function($rootScope, $http, $location, $scope) {

    $scope.login = function() {
        var headers = $scope.credentials ? {authorization: "Basic " +
                        btoa($scope.credentials.username +
                        ":" +
                        $scope.credentials.password)} : {};
        $http({
            url: './login/user',
            method: "POST",
            headers:headers
        })
        .success(function(){
            $location.path("/books");
        })
        .error(function(err){
            console.log(err);
        })
    }

    $scope.logout = function(){
        $http({
            url: './logout',
            method: "GET",
        })
        .success(function(data){
            $location.path("/login");
        })
        .error(function(err){
            console.log(err);
        })
    }
   });
})();

