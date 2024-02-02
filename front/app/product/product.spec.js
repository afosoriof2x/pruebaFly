'use strict';

describe('myApp.product module', function() {

  beforeEach(module('myApp.product'));

  describe('product controller', function(){

    it('should ....', inject(function($controller) {
      var productCtrl = $controller('ProductCtrl');
      expect(productCtrl).toBeDefined();
    }));

  });
});