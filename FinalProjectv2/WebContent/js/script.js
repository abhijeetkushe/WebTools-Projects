
function addBookmark(title, url) {
    if ($.browser.mozilla) {
        window.sidebar.addPanel(title, url,"");
    } else if( $.browser.msie ) {
        external.AddToFavoritesBar( url, title);
    } else {
        alert("Sorry, your browser doesn't support this");
    }
}

/*$(function(){
    $('ul li:last').addClass('last');
    
    // FAQ
    $('#block-views-faq-block_1 .views-field-body').hide();
    $('#block-views-faq-block_1 .views-field-title a').click(function(){
        $('.views-field-body',$(this).parent().parent().parent()).toggle('slow');
        return false;
    });
    
    $('a.add_to_bookmarks').click(function(){
        if ($.browser.mozilla) {
            window.sidebar.addPanel($(this).attr('title'), $(this).attr('href'),"");
        } else if( $.browser.msie ) {
            window.external.AddFavorite( $(this).attr('href'), $(this).attr('title'));
        } else {
            alert("Sorry, your browser doesn't support this");
        }
        return false;
    })
    
});*/
