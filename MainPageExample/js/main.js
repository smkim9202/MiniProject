$(document).ready(function(){
    $('.nv1 div .main1,.sub').mouseover(function(){ 
        $('.sub').css('display','block');
    });
    
    $('.nv1 div .main1,.sub').mouseout(function(){
        $('.sub').css('display','');
    });
    
    $('.a1,.sub1').mouseover(function(){ 
        $('.sub1').css('display','block');
    });
    
    $('.a1,.sub1').mouseout(function(){
        $('.sub1').css('display','');
    });
});