var app = angular.module('app',[]);

app.controller('UrlShorterCtrl', ['$scope','UrlShorterService', function ($scope,UrlShorterService) {
    
    $scope.generateShortUrl = function () {
        if ($scope.fullUrl != null) {
            UrlShorterService.generateShortUrl($scope.fullUrl)
              .then (function success(response){
                  $scope.fullUrl = response.data.fullUrl;
                  $scope.shortUrl = response.data.shortUrl;
              },
              function error(response){
                  $scope.errorMessage = 'Something went wrong!';
            });
        } else {
            $scope.errorMessage = 'Please enter Url!';
        }
    }
}]);

app.service('UrlShorterService',['$http', function ($http) {
    this.generateShortUrl = function generateShortUrl(fullUrl){
        return $http({
          method: 'POST',
          url: '/?url='+fullUrl
        });
    }
}]);