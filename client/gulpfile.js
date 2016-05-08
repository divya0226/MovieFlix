var gulp = require('gulp'),
    clean = require('gulp-clean');
inject = require('gulp-inject');
bowerFiles = require('main-bower-files');
browserSync = require('browser-sync').create();

var config = {
    paths:{
        src: './src',
        build: './build',
        bower: './bower_components'
    }
};

gulp.task('clean', function () {
    return gulp.src(config.paths.build, {read: false}) //This will collect all the build, by not reading it and pipe that to clean
        .pipe(clean());
});

gulp.task('inject', function () {

    var cssFiles = gulp.src([
        config.paths.src + '/**/*.css'
    ], {read:false});


    var jsFiles = gulp.src([
        config.paths.src + '/**/*.js'
    ], {read:false});


    return gulp.src(config.paths.src+'/index.html')
        .pipe(inject(gulp.src(bowerFiles(),{read:false}, {name:'bower'})))
        .pipe(inject(cssFiles, {ignorePath: 'src', addRootSlash: false}))
        .pipe(inject(jsFiles, {ignorePath: 'src', addRootSlash: false}))
        .pipe(gulp.dest(config.paths.build));


});

gulp.task('serve', ['inject'], function () {
    browserSync.init({
        server: {
            baseDir: [config.paths.src, config.paths.build, config.paths.bower],
            routes: {
                '/bower_components':'bower_components'
            }
        },
        files:[
            config.paths.src + '/**'
        ]
    });
});