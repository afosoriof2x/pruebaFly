'use strict';

angular.module('myApp.product', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/product', {
    templateUrl: 'product/product.html',
    controller: 'ProductCtrl'
  });
}])

.controller('ProductCtrl', [function() {

}]);