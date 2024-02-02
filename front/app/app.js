'use strict';

angular.module('myApp', [
  'ngRoute',
  'myApp.client',
  'myApp.product',
  'myApp.version'
]).
config(['$locationProvider', '$routeProvider', function($locationProvider, $routeProvider) {
  $locationProvider.hashPrefix('!');

  $routeProvider.otherwise({redirectTo: '/client'});
}]);
