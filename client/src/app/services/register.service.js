/**
 * Created by divya on 5/7/16.
 */
/**
 * Created by divya on 5/7/16.
 */
(function() {
    'use strict';

    angular.module('movieFlix')
        .service('registerService', registerService);

    registerService.$inject = ['$http', '$q', '$location'];

    function registerService($http, $q, $location) {

        var registerVm = this;

        registerVm.submitRegisterForm = submitRegisterForm;

        function submitRegisterForm(dataObj){

            $$http({
                method  : 'POST',
                url     : '/register/create/',
                data    : 'dataObj',
                headers : { 'Content-Type': 'application/json' }  // set the headers so angular passing info as form data (not request payload)
            })
                .success(function(data) {
                    var strJSON=data;
                    if(strJSON.status=="Success")
                    {
                        alert("success");
                        //$window.location.href = '/movie-tmpl.html';
                        $location.path('/navigation');
                    }

                    if (!data.success) {
                        // if not successful, bind errors to error variables
                        alert("Error");
                        $location.path('/register');
                    }
                });

        };
    }


})();