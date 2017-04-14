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
    let key = decodeURIComponent(location.search.split('=')[1]);
    console.log('key:'+key);
    $('#search_input').val(key);
    let url = '/search?key='+key;
    $.ajax({
        url: url,
        success: function (data) {
            if (data.length != 0){
                $('#not-found-div').hide();

            }else {
                $('#not-found-div').show();

            }
            goodData = data;
            for (let x of data){
                addCard(x);
            }
            $('.detail').on('click', function () {
                let id = $(this).attr('data-source_url');
                for (let x of data){
                    if (x.sourceURL == id){
                        console.log("set localstorage");
                        localStorage.setItem('abj-description', x.description);
                        localStorage.setItem('abj-id', x.id);
                        localStorage.setItem('abj-pic1', x.pic1);
                        localStorage.setItem('abj-price', x.price);
                        localStorage.setItem('abj-sourceName', x.sourceName);
                        localStorage.setItem('abj-sourceURL', x.sourceURL==''? '/img/abj-no-image.jpg':x.sourceURL);
                        localStorage.setItem('abj-title', x.title);
                        break;
                    }
                    console.log("ID NOT FOUND");
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
    $('#search_input').on('keydown', function (e) {
        if(e.keyCode==13)
            location.href = '/html/searchResult.html?goodsName='+$(this).val();
    });
}

function addCard(data) {
    
    let thumbnail_url = data.pic1=='' ? '/img/abj-no-image.jpg' : data.pic1;
    $('#search-result').append(
        '<div class="abj-card">'+
        '<div class="abj-thumbnail" style="background-image: url('+thumbnail_url+')"></div>'+
        '<hr>'+
        '<div class="abj-description ajb-some">' +
        data.description+
        '</div>'+
        '<div class="abj-handle-bar">'+
        '<a class="detail" href="#" data-source_url='+data.sourceURL+'>详情</a>'+
        '<a href="#">购买</a>'+
        '</div>'+
        '</div>');

}