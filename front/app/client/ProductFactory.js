var app = angular.module('myApp.client', []);

app.factory('messageFactory', function () {

    var alretMessage = function () {
        return 'Alert message';
    };

    var warningMessage = function () {
        return 'Warning message';
    };

    return {
        alretMessage : alretMessage,
        warningMessage  : warningMessage
    };
});