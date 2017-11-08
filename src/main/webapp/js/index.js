
$(function () {
	$('#nav li a').hover(function(){
		$(this).find('.nav1').stop().animate({'top':"-48px"},400);
		$(this).find('.nav2').stop().animate({'top':0},400);
	},function(){
		$(this).find('.nav1').stop().animate({'top':0},400);
		$(this).find('.nav2').stop().animate({'top':"48px"},400);
	})

    $('.banner_c_text .text_p1').fadeIn(1200);
	$('.banner_c_text .text_p2').fadeIn(2400);
	$('.banner_c_text .text_p3').fadeIn(3600);
	$('.banner_c_text .text_p4').fadeIn(4800);






})



























