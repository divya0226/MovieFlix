/**
 * Created by divya on 5/3/16.
 */

/**
 * Created by divya on 5/3/16.
 */

(function() {
    'use strict';

    angular.module('movieFlix', ['ngMessages'])
        .controller('loginController', loginController);

    loginController.$inject = ['loginService'];

    function loginController(loginService){
        var loginVm = this;

        loginVm.processLoginForm = processLoginForm;


        function processLoginForm(){
            loginService.submitLoginForm(loginVm.emailid,loginVm.password);
        }
    }
})();
