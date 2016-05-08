/**
 * Created by divya on 5/3/16.
 */

(function() {
    'use strict';

    angular.module('movieFlix')
        .controller('MovieDetailController', MovieDetailController);

    MovieDetailController.$inject = ['movieService', '$routeParams'];

    function MovieDetailController(movieService, $routeParams) {
        var movieDetailVm = this;

        init();

        function init() {
            console.log('UserDetailController');

            movieService
                .getMovieById($routeParams.imdbID)
                .then(function (movie){
                    movieDetailVm.movie = movie;
                }, function (error) {
                    console.log(error);
                });
        }
    }

})();