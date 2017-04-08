/**
 * Created by duanzhengmou on 4/8/17.
 */
init();
var goodData;
function init() {
    initData();
    initEvent();
}

function initData() {
    let key = location.search.split('=')[1];
    let url = '/search?key='+key;
    $.ajax({
        url: url,
        success: function (data) {
            goodData = data;
            for (let x of data){
                addCard(x);
            }
            $('.detail').on('click', function () {
                let id = $(this).attr('data-id');
                for (let x of goodData){
                    if (x.id == id){
                        localStorage.setItem('abj-description', x.description);
                        localStorage.setItem('abj-id', x.id);
                        localStorage.setItem('abj-pic1', x.pic1);
                        localStorage.setItem('abj-price', x.price);
                        localStorage.setItem('abj-sourceName', x.sourceName);
                        localStorage.setItem('abj-sourceURL', x.sourceURL);
                        localStorage.setItem('abj-title', x.title);
                        break;
                    }
                }
                location.href = '/html/goodsDetail.html';
            });
        },
        error: function (data) {
            console.error("ERROR");
        }
    });
}

function initEvent() {

}

function addCard(data) {
    console.log("add");
    let thumbnail_url = data.pic1=='' ? '/img/smile.png' : data.pic1;
    $('#search-result').append(
        '<div class="abj-card">'+
        '<div class="abj-thumbnail" style="background-image: url('+thumbnail_url+')"></div>'+
        '<div class="abj-description ajb-some">'+
        data.description+
        '</div>'+
        '<div class="abj-handle-bar">'+
        '<a class="detail" href="#" data-id='+data.id+'>详情</a>'+
        '<a href="#">购买</a>'+
        '</div>'+
        '</div>');

}