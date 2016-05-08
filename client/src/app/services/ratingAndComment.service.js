/**
 * Created by divya on 5/8/16.
 */

/**
 * Created by divya on 5/7/16.
 */
(function() {
    'use strict';

    angular.module('movieFlix')
        .service('ratingService', ratingService);

    ratingService.$inject = ['$http', '$q'];

    function ratingService($http, $q) {

        var ratingVm = this;

        ratingVm.formData = {};

        ratingVm.submitRatingForm = submitRatingForm;

        function submitRatingForm(){

            $http({
                method  : 'POST',
                url     : '/api/enter/ ',
                data    : 'formData',  // pass in data as strings
                headers : { 'Content-Type': 'application/json' }  // set the headers so angular passing info as form data (not request payload)
            })
                .success(function(data) {
                    var strJSON=data;
                    if(strJSON.status=="Success")
                    {
                        alert("success");
                        $window.location.href = '/movie-tmpl.html';
                        //$location.url('/movieList');
                    }

                    if (!data.success) {
                        // if not successful, bind errors to error variables
                        alert("Error");
                    }
                });

        };
    }


})();