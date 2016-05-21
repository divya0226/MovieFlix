/**
 * Created by divya on 5/3/16.
 */

/**
 * Created by divya on 5/3/16.
 */

(function() {
    'use strict';

    angular.module('movieFlix', ['ngMessages'])
        .controller('ratingController', ratingController);


    ratingController.$inject = ['ratingService'];

    function ratingController(ratingService){
        var ratingVm = this;
        ratingVm.rating = {};

        ratingVm.processRatingForm = processRatingForm;


        function processRatingForm(){
            ratingService.submitRatingForm(rating);
        }
    }
})();
