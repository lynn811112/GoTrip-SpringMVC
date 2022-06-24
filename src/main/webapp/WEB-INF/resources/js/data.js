jQuery(document).ready(function($){

	function popUpInfo(item, id) {
	    $.ajax({
	        type: 'POST',
	        url: 'findItem',
	        dataType: 'json',
	        data: {
	            "itemTb": item,
	            "itemId": id
	        },
	        success: function (response) {
	            let str = JSON.stringify(response)
	            let parsed = JSON.parse(str);
	            let itemInfo = "商品資訊"
	            if (String(parsed.tableName) == "住宿") {
	                itemInfo = "商品項目：" + parsed.tableName +
	                    "<br>商品編號：" + parsed.itemId +
	                    "<br>商品名稱：" + parsed.itemName +
	                    "<br>商品價格：NT$" + parsed.price +
	                    "<br>賣家：　　" + parsed.owner +
	                    "<br>電話：　　" + parsed.phone;
	            } else if (String(parsed.tableName) == "行程") {
	                itemInfo = "商品項目：" + parsed.tableName +
	                    "<br>商品編號：" + parsed.itemId +
	                    "<br>商品名稱：" + parsed.itemName +
	                    "<br>商品價格：NT$" + parsed.price +
	                    "<br>電話：　　" + parsed.phone +
	                    "<br>地址：　　" + parsed.city + parsed.district + parsed.address +
	                    "<br>商品介紹：<br>" + parsed.info;
	            }
	            Swal.fire({
	                html: '<div class="text-dark text-start small">' + itemInfo + '</div>',
	                confirmButtonColor: '#FF8D29',
	            })
	        },
	        error: function () {
	            console.log('error')
	        }
	    })
	}




})






