/**
 * Created by divya on 5/3/16.
 */


(function() {
    'use strict';

    angular.module('movieFlix', ['ngMessages'])
        .controller('registerController', registerController);

    registerController.$inject = ['registerService'];

    function registerController(registerService){
        var registerVm = this;

        registerVm.processRegisterForm = processRegisterForm;


        function processRegisterForm(){
            registerService.submitRegisterForm(registerVm.register);
        }
    }
})();
