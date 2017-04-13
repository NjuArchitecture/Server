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
    let image_url = localStorage.getItem('abj-pic1');
    image_url = image_url==''?'/img/abj-no-image.jpg':image_url;
    console.log(image_url);
    $('.good-image').css('background-image','url("'+image_url+'")');
    initData();

}

function initData() {
    let goodId = "AVtb1YR-bRMnjcvlwyoh";
    $.ajax({
        url:'/getComment',
        type:'get',
        data:{goodId: goodId},
        success: function(data){
            $('#comment_count').text(data.length+1);
            for (let x of data){
                addComment(x);
            }
        },
        error: function(data){
            // alert("ERROR");
        }

    });
}

function addComment(data) {
    let avatar_index = Math.round(Math.random()*4)+1;
    $('.comment-container').append(
        '<hr>' +
        '<div class="media">'+
        '<div class="media-left">'+
        '<a href="#">'+
        '<img class="media-object" src="../img/abj-avatar-'+avatar_index+'.png" alt="...">'+
        '</a>'+
        '<div class="comment-date" >'+data.time+'</div>'+
        '</div>'+
        '<div class="media-body">'+
        '<h4 class="media-heading">'+data.userName+'</h4>'+
        data.content+
        '</div>'+
        '</div>')
}