const gulp = require('gulp');
const sass = require('gulp-sass');
const sassdoc = require('sassdoc');

// Generar la documentación con Sassdoc
gulp.task('sassdoc', function () {
    return gulp.src('scss/**/*.scss')
        .pipe(sassdoc())
        .resume();
});

// Generar el archivo CSS a partir del archivo general.scss
gulp.task('generate-css', function () {
    return gulp.src('scss/general.scss')
        .pipe(sass())
        .pipe(gulp.dest('dist/css'));
});

// Tarea para copiar archivos HTML y CSS a la carpeta dist/
gulp.task('copy-files', function () {
    return gulp.src(['*.html', 'dist/css/*.css'])
        .pipe(gulp.dest('dist/'));
});

// Tarea por defecto
gulp.task('default', gulp.parallel('sassdoc', 'generate-css', 'copy-files'));

