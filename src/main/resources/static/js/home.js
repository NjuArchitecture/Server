/**
 * Created by duanzhengmou on 4/8/17.
 */
init();
function init() {
    initEvent();
}

function initEvent() {
    $('#search-input').on('keydown', function (event) {
        if (event.keyCode == 13){
            let queryStr = $('#search-input').val();
            location.href = '/html/searchResult.html?goodsName='+queryStr;
        }
    })
}