(function() {
    'use strict';

    angular.module('movieFlix')
        .service('movieService', movieService);

    movieService.$inject = ['$http', '$q'];

    function movieService($http, $q) {

        var movieServiceVm = this;

        movieServiceVm.getMovies = getMovies;
        movieServiceVm.getTopRatedMovies = getTopRatedMovies;
        movieServiceVm.getTopRatedSeries = getTopRatedSeries;
        movieServiceVm.getMovieById = getMovieById;
        movieServiceVm.getMovieByType = getMovieByType;

        function getMovies() {
            return $http.get('/api/list/initialList')
                .then(successFn, errorFn);
        }
        
        function getTopRatedMovies() {
            return $http.get('/api/list/topRatedMovies')
                .then(successFn, errorFn);
        }

        function getTopRatedSeries() {
            return $http.get('/api/list/topRatedTvseries')
                .then(successFn, errorFn);
        }

        function getMovieByType(type) {
            return $http.get('/api/list/getMovieByType/' + type)
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