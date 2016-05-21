/**
 * Created by divya on 5/5/16.
 */

(function() {
    'use strict';

    angular
        .module('plunker', ['ngRoute'])
        .config(moduleConfig);

    function moduleConfig($routeProvider) {

        $routeProvider
            .when('/login', {
                templateUrl: 'app/views/login.tmpl.html',
                controller: 'loginController',
                controllerAs: 'loginVm'
            })
            .when('/register', {
                templateUrl: 'app/views/registerUser.tmpl.html',
                controller: 'registerController',
                controllerAs: 'registerVm'
            })
            .when('/navigation', {
                templateUrl: 'app/views/navigation.tmpl.html'
            })
            .when('/allDetail/:imdbID', {
                templateUrl: 'app/views/all-detail.tmpl.html',
                controller: 'MovieDetailController',
                controllerAs: 'movieDetailVm'
            })
            .when('/movieDetail/:imdbID', {
                templateUrl: 'app/views/movie-detail.tmpl.html',
                controller: 'MovieDetailController',
                controllerAs: 'movieDetailVm'
            })
            .when('/seriesDetail/:imdbID', {
                templateUrl: 'app/views/series-detail.tmpl.html',
                controller: 'MovieDetailController',
                controllerAs: 'movieDetailVm'
            })
            .when('/allMoviesSeries', {
                templateUrl: 'app/views/all.tmpl.html',
                controller: 'MovieDetailController',
                controllerAs: 'movieDetailVm'
            })
            .when('/onlyMovie', {
                templateUrl: 'app/views/movie-tmpl.html',
                controller: 'movieListController',
                controllerAs: 'movieVm'
            })
            .when('/onlySeries', {
                templateUrl: 'app/views/series-tmpl.html',
                controller: 'movieListController',
                controllerAs: 'movieVm'
            })
            .when('/topMovies', {
                templateUrl: 'app/views/topMovies-tmpl.html',
                controller: 'movieListController',
                controllerAs: 'movieVm'
            })
            .when('/topSeries', {
                templateUrl: 'app/views/topSeries-tmpl.html',
                controller: 'movieListController',
                controllerAs: 'movieVm'
            })
            .when('/createComment', {
                templateUrl: 'app/views/ratingComment.tmpl.html',
                controller: 'ratingAndCommentController',
                controllerAs: 'ratingVm'
            })
            .otherwise({
                redirectTo: '/login'
            });
    }

})();