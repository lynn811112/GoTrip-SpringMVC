<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- <%@page import="model.Employee"%> --%>
<%-- <%@page import="model.Hotel"%> --%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!doctype html>
<html class="no-js" lang="">

<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>評論列表</title>
	<%-- style sheet (以下三個style sheet請記得link進來) --%>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">
	<link rel="stylesheet" href="<c:url value='/css/style.css'/>">
	<link rel="stylesheet" href="<c:url value='/css/stars.css'/>">
	<link href="https://cdn.jsdelivr.net/npm/@sweetalert2/theme-bootstrap-4/bootstrap-4.css" rel="stylesheet">
	<style>
	.image{
    position:relative;
    overflow:hidden;
    padding-bottom:100%;
	}
	.image img{
	    position:absolute;
	}
	</style>
</head>

<body>
    <%-- side Bar (side bar請記得include進來) --%>
	<%@include file="./partials/sidebar.jspf"%>

    <%-- main--%>
    
	<main id="right-panel" class="right-panel">
		<div class="breadcrumbs">
			<div class="breadcrumbs-inner">
				<div class="page-header float-left">
					<div class="page-title">
						<h1>評論管理 / 新增評論</h1>
					</div>
				</div>
			</div>
		</div>

        <div class="content">
            <div class="row justify-content-center">
                <div class="col-lg-6 ">
                    <div class="card">
                        <div class="card-body card-block">

                            <form:form action="new/save" method="POST" modelAttribute="comment" id="insertForm" cssClass="form-horizontal needs-validation"  enctype="multipart/form-data">
                                
                                <div class="mb-4 row">
                                    <form:label path="itemTb" for="itemTb" cssClass="col-sm-3 col-form-label">項目類別</form:label>
                                    <div class="col-sm-9">
                                        <form:select path="itemTb" cssClass="form-select" name="itemTb" id="itemTb">
											<%-- <form:option value="" disabled selected hidden>請選擇類別</form:option> --%>
                                        	<form:option value="">請選擇類別</form:option>
                                            <form:option value="ticket">行程</form:option>
                                            <form:option value="restaurant">餐廳</form:option>
                                            <form:option value="hotel">住宿</form:option>
                                            <form:option value="carRental">租車</form:option>
                                        </form:select>
									    <div class="invalid-feedback">請選擇商品項目類別</div>
                                    </div>

                                </div>
                                
                                <!-- 輸入商品編號 -->
                  				<div class="mb-4 row">
                                    <form:label path="itemId" cssClass="col-sm-3 col-form-label">商品編號</form:label>
                                    <div class="col-sm-9">
                                    	<form:input path="itemId" cssClass="form-control" type="text"/>
                                    	<div class="invalid-feedback">請輸入商品編號</div>
                                    </div>
                                </div>
		
                                <!-- 會員ID -->
                                <div class="mb-4 row">
                                    <form:label path="userId" for="userId" cssClass="col-sm-3 col-form-label">會員帳號</form:label>
                                    <div class="col-sm-9">
                                      	<form:input path="userId" type="text" cssClass="form-control" name="userId" id="userId"/>
                                    	<div class="invalid-feedback">請輸入會員帳號</div>
                                    </div>
                                </div>

                                <!-- 給予評分 -->
                               <div class="mb-4 row">
                                    <form:label path="rating" cssClass="col-sm-3 col-form-label">給予評分</form:label>
                                    <div class="col-sm-9">
				                        <fieldset class="starability-basic">
				                            <form:radiobutton path="rating" value="0" id="no-rate"/>
				                            <form:radiobutton path="rating" value="1" id="first-rate1"/>
				                            <form:label path="rating" for="first-rate1">1 star</form:label>
				                            <form:radiobutton path="rating" value="2" id="first-rate2"/>
				                            <form:label path="rating" for="first-rate2">2 stars</form:label>
				                            <form:radiobutton path="rating" value="3" id="first-rate3"/>
				                            <form:label path="rating" for="first-rate3">3 stars</form:label>
				                            <form:radiobutton path="rating" value="4" id="first-rate4"/>
				                            <form:label path="rating" for="first-rate4">4 stars</form:label>
				                            <form:radiobutton path="rating" value="5" id="first-rate5"/>
				                            <form:label path="rating" for="first-rate5">5 stars</form:label>
				                        </fieldset>
                    				</div>
                                </div>

                                <!-- 體驗分享 -->
                                <div class="mb-4 row">
                                	<div class="col-sm-3">
                                    	<form:label path="content" for="content" cssClass="col-form-label">評論內容</form:label>
                                    	<div id="content-length" class="text-black-50 small">(0/200)</div>
                                	</div>
                                    <div class="col-sm-9">
                                        <form:textarea path="content" cssClass="form-control" name="content" id="content" cols="30" rows="5" style="resize:none"></form:textarea>
                                        <div class="invalid-feedback">評論內容上限200字</div>
                                     </div>
                                </div>
                                
                                <div class="row justify-content-end">
                                	<div class="col-sm-3">
									  	<label for="images" class="col-form-label">上傳照片</label>
									  	<div id="images-length" class="text-black-50 small">(0/3)</div>
                                	</div>
								  	<div class="col-sm-9">
								  		<input class="form-control" type="file" name="images" id="images" multiple onchange="previewMultiple(event)" accept="image/*">
										<div class="invalid-feedback">最多選取3張圖片</div>
									</div>
								</div>
								<div class="row justify-content-end">
									<div class="col-sm-9">
										<div class="row" id="formFile">
										</div>
									</div>
								</div>
                                <!-- 送出 -->
                                <!-- action=insert對應到controller的doGet -->

                                <div class="row">
	                                <div class="d-grid gap-2 col-6">
	                                	<a class="btn btn-outline-warning rounded-pill mt-5 mb-4" href="<c:url value='/comments/' />">取消新增</a>

	                            	</div>
	                                <div class="d-grid gap-2 col-6">
	                                	<form:button type="submit" name="action" value="save" class="btn btn-warning rounded-pill mt-5 mb-4" id="btn-insert">送出</form:button>
	                            	</div>
								</div>
                            </form:form>
                            
                        </div>
                    </div>
                </div>
                
                <div class="col-lg-6 ">
                    <div class="card">
                        <div class="card-body">
                        	<div class="d-flex justify-content-center">
	                        	<button type="submit" name="select" id="btn-ticket" value="ticket" class="btn btn-outline-dark mb-3 mx-1">行程列表</button>
	                        	<button type="submit" name="select" id="btn-resaturant" value="resaturant" class="btn btn-outline-dark mb-3 mx-1">餐廳列表</button>
	                        	<button type="submit" name="select" id="btn-hotel" value="hotel" class="btn btn-outline-dark mb-3 mx-1">住宿列表</button>
	                        	<button type="submit" name="select" id="btn-carRental" value="carRental" class="btn btn-outline-dark mb-3 mx-1">租車列表</button>
							</div>
                        	<table id="table_id" class="display table table-hover">
								<thead>
									<tr class="text-center">
										<th>項目</th>
										<th>編號</th>
										<th>名稱</th>
										<th>內容</th>
									</tr>
								</thead>
								<tbody id="rows">
									<tr>
										<td style="text-align: center;" colspan="4">點選上方選項以載入項目列表</td>
									</tr>
								</tbody>
							</table>
                        </div>
                    </div>
                </div>
            </div>
        </div>


    </main>

	<%-- Scripts --%>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
	<script src="<c:url value='/js/jquery-3.6.0.js'/>"></script>
	<script src="<c:url value='/js/plugins.js'/>"></script>
	<script src="<c:url value='/js/main.js'/>"></script>
	<script src="<c:url value='/js/data.js'/>"></script>
	<script>
		// 以帳號(Email)去掉@後文字作為預設留言者Id
<%-- 		<% --%>
// 		Employee employee = (Employee) session.getAttribute("login");
<%-- 		%> --%>
<%-- 		let userEmail = "<%=employee.getEmail()%>"; --%>
// 		userId = userEmail.substring(0, userEmail.indexOf('@'))
// 		document.getElementById("userId").value = userId;
		
	
		// 立即顯示所選照片
		function previewMultiple(event) {
		    var images = document.getElementById("images");
		    var number = images.files.length;
		    document.getElementById("formFile").innerHTML = ""
		    for (i = 0; i < number; i++) {
		        var urls = URL.createObjectURL(event.target.files[i]);
		        document.getElementById("formFile").innerHTML += 
		        	'<div class="col-4"> <img src="' + urls + '" class="rounded"/> </div>';
		    }
		}
		
// 		function saveComment(e) {
// 		Swal.fire({
// 			  icon: 'success',
// 			  title: 'Your work has been saved',
// 			  showConfirmButton: false,
// 			  timer: 1500
// 			})
// 		}
		
		jQuery(document).ready(function($){
	        $(function() {
	        	let contentMax = 200;
	        	let imagesMax = 3;

				// 確認表單內容
				$('#btn-insert').click(function (e) {
					let isItemTbValid = $('#itemTb').val() !== null;
					let isItemIdVaild = $('#itemId').val() !== '';
					let isUserIdVaild = $('#userId').val() !== '';
					let isContentVaild = $("#content").val().length <= contentMax;
					let isImagesVaild = $("#images")[0].files.length <= imagesMax;
					
					if (!isItemTbValid || !isItemIdVaild || !isUserIdVaild || !isContentVaild || !isImagesVaild ) {
						e.preventDefault();					
						isItemTbValid ? hideInvalidText($('#itemTb')) : showInvalidText($('#itemTb'));
						isItemIdVaild ? hideInvalidText($('#itemId')) : showInvalidText($('#itemId'));
						isUserIdVaild ? hideInvalidText($('#userId')) : showInvalidText($('#userId'));
						isContentVaild ? hideInvalidText($('#content')) : showInvalidText($('#content'));
						isImagesVaild ? hideInvalidText($('#images')) : showInvalidText($('#images'));
						$("form").addClass('validated');
					} else {
						e.preventDefault();		
				 		Swal.fire({
			 			  icon: 'success',
			 			  title: '儲存成功',
			 			  showConfirmButton: false,
			 			  timer: 1500
			 			});
				 		
				 		setInterval(function() {
				 			$('#insertForm').submit()
				 		}, 1500);
					}
				});
				
				function showInvalidText(selector) {
					selector.removeClass('is-valid').addClass('is-invalid');
					selector.siblings('.invalid-feedback').css('display', 'block')
				}
				
				function hideInvalidText(selector) {
					selector.removeClass('is-invalid').addClass('is-valid');
					selector.siblings('.invalid-feedback').css('display', 'none')
				}
				
				$('#itemTb').on('change', function () {
					if ($("form").hasClass('validated')) 
						$('#itemTb').val() == null ? showInvalidText($('#itemTb')) : hideInvalidText($('#itemTb'))
				})
				
				$('#itemId').keyup(function () {
					if ($("form").hasClass('validated')) 
						$('#itemId').val() == '' ? showInvalidText($('#itemId')) : hideInvalidText($('#itemId'))
				})

				$('#userId').keyup(function () {
					if ($("form").hasClass('validated')) 
						$('#userId').val() == '' ? showInvalidText($('#userId')) : hideInvalidText($('#userId'))
				})
				
				// 顯示評論字數
				$("#content").keyup(function(){
					let contentLength = $("#content").val().length;
				    $("#content-length").text('('+contentLength+'/'+contentMax+')');
				    if (contentLength > contentMax) {
				    	$('#content-length').removeClass('text-black-50').addClass('text-danger')
				    } else {
					    $('#content-length').removeClass('text-danger').addClass('text-black-50')
				    }
				    if ($("form").hasClass('validated')) {
				    	contentLength > contentMax ? showInvalidText($('#content')) : hideInvalidText($('#content'))				    	
				    }
				});
				
				// 顯示上傳照片數量
				$("#images").on("change", function() {
					let imagesLength = $("#images")[0].files.length;
					$('#images-length').text('('+imagesLength+'/'+ imagesMax +')')
				    if (imagesLength > imagesMax) {
				        $('#images-length').removeClass('text-black-50').addClass('text-danger')
				    } else {
				        $('#images-length').removeClass('text-danger').addClass('text-black-50')
				    }
					if ($("form").hasClass('validated')) {
						imagesLength > imagesMax ? showInvalidText($('#images')) : hideInvalidText($('#images'))				    	
				    } 
				});

				
				// 顯示"行程"資訊
				$('#btn-ticket').on('click', function() {
					$.ajax({
	                    type: 'GET',
	                    url: 'findItem',
	                    dataType: 'json',
	                    data: {
	                    	"select": "tickets"
	                    },
	                    success: function (data) {
	                    	// 清空tbody內容
	                    	$("tbody").html('');
	                    	// ajax回傳資料放到tbody
	                    	$.each(data, function (i) {
	                    		let str = "<tr><td style='text-align: center'>行程</td>"+
	                    				  "<td style='text-align: center'>"+data[i].prod_no+"</td>"+
	                    			  	  "<td>"+data[i].prod_name+"</td>"+
		                    			  "<td class='info' style='text-align:center'><i class='bi bi-info-square'></i></td></tr>";
	                    		$("tbody").append(str)
	                    	})
	                    	// td on click 自動填入
	        	        	$("td").on('click', function() {
	        		        	let id = $(this).closest("tr").find('td').eq(1).html();
	        		            $("#itemId").val(id);
	        		            $("#itemTb").val("ticket")
	        		            // form validation 設定更改
	            		        if ($("form").hasClass('validated')) {
	            		        	$('#itemTb').val() !== null ? hideInvalidText($('#itemTb')) : showInvalidText($('#itemTb'));
	            		        	$('#itemId').val() !== '' ? hideInvalidText($('#itemId')) : showInvalidText($('#itemId'));
	            		        }
	        		        });
	                    	// info on click 找該商品資訊
        		            $('.info').on('click', function() {
	        		        	let row = $(this).closest("tr");        
	        		        	let item = $(row).find('td').eq(0).html();
	        		        	let id = $(row).find('td').eq(1).html();
        		            	popUpInfo(item, id);
        		            });
	                    	
	                    },
	                    error: function () {
	                        console.log('error')
	                    }
	                })
				})
				
				
				// 顯示"住宿"資訊
				$('#btn-hotel').on('click', function() {
					$.ajax({
	                    type: 'GET',
	                    url: 'findItem',
	                    dataType: 'json',
	                    data: {
	                    	"select": "hotels"
	                    },
	                    success: function (data) {
	                    	$("tbody").html('');
	                    	let str = "";
	                    	$.each(data, function (i) {
	                    		str += "<tr><td style='text-align:center'>住宿</td>"+
	                    				  "<td style='text-align:center'>"+data[i].id+"</td>"+
	                    			  	  "<td >"+data[i].hotel_name+"</td>"+
		                    			  "<td class='info' style='text-align:center'><i class='bi bi-info-square'></i></td></tr>";
	                    	})
                    		$("tbody").html(str);
	        	        	$("td").on('click', function() {
	        	        		let id = $(this).closest("tr").find('td').eq(1).html();
	        		            $("#itemId").val(id);
	        		            $("#itemTb").val("hotel")
	        		            // form validation 設定更改
	            		        if ($("form").hasClass('validated')) {
	            		        	$('#itemTb').val() !== null ? hideInvalidText($('#itemTb')) : showInvalidText($('#itemTb'));
	            		        	$('#itemId').val() !== '' ? hideInvalidText($('#itemId')) : showInvalidText($('#itemId'));
	            		        }
	        		        });
        		            $('.info').on('click', function() {
	        		        	let row = $(this).closest("tr");        
	        		        	let item = $(row).find('td').eq(0).html();
	        		        	let id = $(row).find('td').eq(1).html();
        		            	popUpInfo(item, id);
        		            });
	                    },
	                    
	                    error: function () {
	                        console.log('error')
	                    }
	                })
				})
	        	
		
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
		})
		
	</script>
</body>

</html>