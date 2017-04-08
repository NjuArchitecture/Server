/**
 * Created by duanzhengmou on 4/8/17.
 */
init();
function init() {
    $('#good-name').text(localStorage.getItem('abj-title'));
    $('#good-description').text(localStorage.getItem('abj-description'));
    $('#good-from-shop').text(localStorage.getItem('abj-sourceName'))
        .attr('href', localStorage.getItem('abj-sourceURL'));
    $('#good-price').text(localStorage.getItem('abj-price'));
    $('.good-image').css('background-image','url("'+localStorage.getItem('abj-pic1')+'")');
}