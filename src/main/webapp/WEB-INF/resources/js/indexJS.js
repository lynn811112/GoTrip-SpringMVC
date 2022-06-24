jQuery(document).ready(function($) {


	$(".coupon").each(function() {
		console.log(this);
		if ($(this).text() == "1") {
			$(this).text("滿千送百");
		} else if ($(this).text() == "2") {
			$(this).text("打八折");
		}

	});

	$(".status").each(function() {
		console.log(this);
		if ($(this).text() == "1") {
			$(this).text("成功");
		} else if ($(this).text() == "2") {
			$(this).text("不成立");
		}

	});

	$(".paystatus").each(function() {
		console.log(this);
		if ($(this).text() == "1") {
			$(this).text("尚未付款");
		} else if ($(this).text() == "2") {
			$(this).text("已付款");
		}
	});


});/**
 * 
 */