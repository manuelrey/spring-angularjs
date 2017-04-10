var App=angular.module("App", []);
App.controller("MyController", function($scope, $http){
    $scope.pageCompanies = [];
    $http({
      method: 'GET',
      url: 'http://localhost:8095/companyList?page=1&size=3'
    }).then(function successCallback(response) {
        // this callback will be called asynchronously
        // when the response is available
        $scope.pageCompanies = response.data;
        console.log(response);
        console.log("test-get");
      }, function errorCallback(response) {
        // called asynchronously if an error occurs
        // or server returns response with an error status.
        console.log(response);
        console.log("test-error");
      });
});