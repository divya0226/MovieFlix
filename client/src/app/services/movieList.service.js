(function() {
    'use strict';

    angular.module('movieFlix')
        .service('movieService', movieService);

    movieService.$inject = ['$http', '$q'];

    function movieService($http, $q) {

        var movieServiceVm = this;

        movieServiceVm.getAllMovieAndSeries = getAllMovieAndSeries;
        movieServiceVm.getMovies = getMovies;
        movieServiceVm.getSeries = getSeries;
        movieServiceVm.getTopMovies = getTopMovies;
        movieServiceVm.getTopSeries = getTopSeries;
        movieServiceVm.getMovieById = getMovieById;


        function getAllMovieAndSeries() {
            return $http.get('/api/list/initialList')
                .then(successFn, errorFn);
        }

        function getMovies() {
            return $http.get('/api/list/initialList')
                .then(successFn, errorFn);
        }

        function getSeries() {
            return $http.get('/api/list/initialList')
                .then(successFn, errorFn);
        }
        
        function getTopMovies() {
            return $http.get('/api/list/topRatedMovies')
                .then(successFn, errorFn);
        }

        function getTopSeries() {
            return $http.get('/api/list/topRatedTvseries')
                .then(successFn, errorFn);
        }
        
        function getMovieById(id) {
            return $http.get('/api/list/getDetail/' + id)
                .then(successFn, errorFn);
        }
        
        function submitRatingForm(){
            
        }
        
        function successFn(response) {
            return response.data;
        }

        function errorFn(response) {
            return $q.reject('ERROR: ' + response.statusText);
        }
    }

})();