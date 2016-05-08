/**
 * Created by divya on 5/6/16.
 */
// Code goes here

angular.module('myApp', ['angularUtils.directives.dirPagination']).controller('MyController',MyController );

movieListByTypeController.$inject = ['movieService'];

function MyController(movieService) {

    var movieVm = this;

    movieVm.currentPage = 1;
    movieVm.pageSize = 10;

    movieVm.items = ['type','year'];
    movieVm.movies = [];

    movieVm.changeSort = changeSort;
    movieVm.changedValue = changedValue;

    init();

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
    }

    movieVm.changeSort = function(prop) {

        movieVm.sorter.by = prop;
        movieVm.sorter.reverse = !$scope.sorter.reverse;
    }
    
    movieVm.changedValue = function(item){
        movieService.getMovieByType(item)
        then(function(movies) {
            movieVm.movies = movies;
        }, function(error) {
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