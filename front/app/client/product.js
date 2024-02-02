'use strict';

var app = angular.module('myApp.client', ['ngRoute'])

app.config(['$routeProvider','$locationProvider', function($routeProvider,$locationProvider) {
  $routeProvider.when('/client', {
    templateUrl: 'client/client.html',
    controller: 'ClientCtrl'
  });
  
  $locationProvider.html5Mode({
    enabled: true,
    requireBase: false
   });
}])

app.controller('ClientCtrl', ['$scope', 'messageFactory', function($scope, messageFactory) {

  $scope.message = messageFactory.alretMessage() + ' , ' + messageFactory.warningMessage();
}]);