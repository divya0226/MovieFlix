/**
 * Created by divya on 5/6/16.
 */
// Code goes here

angular.module('movieFlix', ['angularUtils.directives.dirPagination']).controller('MyController',MyController );

MyController.$inject = ['movieService'];

function MyController(movieService) {

    var movieVm = this;

    movieVm.currentPage = 1;
    movieVm.pageSize = 10;

    movieVm.items = ['imdbRating', 'imdbVotes', 'year'];
    movieVm.movies = [];

    movieVm.changeSort = changeSort;

    movieVm.getAllMovieAndSeries = getAllMovieAndSeries;
    movieVm.getMovies = getMovies;
    movieVm.getSeries = getSeries;
    movieVm.getTopMovies = getTopMovies;
    movieVm.getTopSeries = getTopSeries;

    /*init();

    function init() {
        movieService.getMovies()
            .then(function (movies) {
                movieVm.movies = movies;
            }, function (error) {
                console.log(error);
            });

        movieVm.sorter = {
            by: 'Title',
            reverse: false
        };
    }*/
    moviesVm.sorter = {
        by: 'year',
        reverse: false
    }

    movieVm.changeSort = function(prop) {

        movieVm.sorter.by = prop;
        movieVm.sorter.reverse = !$scope.sorter.reverse;
    }
    

    movieVm.getAllMovieAndSeries = function(){
        movieService.getAllMovieAndSeries()
            .then(function (movies) {
                movieVm.movies = movies;
            }, function (error) {
                console.log(error);
            });
    }

    movieVm.getMovies = function(){
        movieService.getMovies()
            .then(function (movies) {
                movieVm.movies = movies;
            }, function (error) {
                console.log(error);
            });
    }
    movieVm.getSeries = function(){
        movieService.getSeries()
            .then(function (movies) {
                movieVm.movies = movies;
            }, function (error) {
                console.log(error);
            });
        
    }
    movieVm.getTopMovies = function(){
        movieService.getTopMovies()
            .then(function (movies) {
                movieVm.movies = movies;
            }, function (error) {
                console.log(error);
            });

        movieVm.sorter = {
            by: 'Title',
            reverse: false
        };
    }
    movieVm.getTopSeries = function(){
        movieService.getTopSeries()
            .then(function (movies) {
                movieVm.movies = movies;
            }, function (error) {
                console.log(error);
            });
    }

    movieVm.pageChangeHandler = function(num) {
        console.log('meals page changed to ' + num);
    };
}

function OtherController($scope) {
    movieVm.pageChangeHandler = function(num) {
        console.log('going to page ' + num);
    };
}

myApp.controller('OtherController', OtherController);