'use strict';

describe('myApp.client module', function() {

  beforeEach(module('myApp.client'));

  describe('client controller', function(){

    it('should ....', inject(function($controller) {
      //spec body
      var view1Ctrl = $controller('ClientCtrl');
      expect(view1Ctrl).toBeDefined();
    }));

  });
});