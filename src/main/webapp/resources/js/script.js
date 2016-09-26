/**
 * Created by ezequ on 6/25/2016.
 */
$(document).ready(function () {
    $('#home').click(function () {
        $(location).attr('href', 'index.jsp');
    });
    $('#back').click(function () {
        $(location).attr('href', 'ServletRead');
    });

    $('#consult').click(function () {
        $(location).attr('href', 'ServletRead');
    });
    $('.message a').click(function(){
        $('form').animate({height: "toggle", opacity: "toggle"}, "slow");
    });
});