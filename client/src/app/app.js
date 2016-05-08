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
            .when('/movieListDetail', {
                templateUrl: 'app/views/movie-detail.tmpl.html',
                controller: 'MovieDetailController',
                controllerAs: 'movieDetailVm'
            })
            .when('/movieList', {
                templateUrl: 'app/views/movie-list.tmpl.html',
                controller: 'movieListController',
                controllerAs: 'movieVm'
            })
            .when('/rating', {
                templateUrl: 'app/views/ratingComment.tmpl.html',
                controller: 'ratingAndCommentController',
                controllerAs: 'ratingVm'
            })
            .otherwise({
                redirectTo: '/movieList'
            });
    }

})();