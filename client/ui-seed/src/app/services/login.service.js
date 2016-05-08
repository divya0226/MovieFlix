/**
 * Created by divya on 5/7/16.
 */
(function() {
    'use strict';

    angular.module('movieFlix')
        .service('loginService', loginService);

    loginService.$inject = ['$http', '$q'];

    function loginService($http, $q) {
        
        var loginVm = this;
        
        loginVm.submitLoginForm = submitLoginForm;
        
        function submitLoginForm(email, password){

            $http({
                method  : 'POST',
                url     : '/register/login/',
                params   : {username: email, password:password},
                headers : { 'Content-Type': 'application/json ' }  // set the headers so angular passing info as form data (not request payload)
            })
                .success(function(data) {
                    var strJSON=data;
                    if(strJSON.status=="Success")
                    {
                        alert("success");
                        $window.location.href = '/movie.tmpl.html';
                        //$location.url('/movieList');
                    }

                    if (!data.success) {
                        // if not successful, bind errors to error variables
                        alert("Incorrect Login !!");
                    }
                });

        };
    }


})();