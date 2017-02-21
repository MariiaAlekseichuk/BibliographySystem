'use strict';
(function() {
    app.controller('LoginController', function($rootScope, $http, $location, $scope) {

$scope.credentials = {};
    $scope.credentials.username = "rob"
    $scope.credentials.password = "123"

    $scope.login = function() {
        var headers = $scope.credentials ? {authorization: "Basic " + btoa($scope.credentials.username +":" +$scope.credentials.password)} : {};
        $http({
            url: './login/user',
            method: "POST",
            headers:headers
        })
        .success(function(data){
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

