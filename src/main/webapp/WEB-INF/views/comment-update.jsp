<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.lynn.model.*"%>
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!doctype html>
<html class="no-js" lang="">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>評論列表</title>
<%-- style sheet (以下三個style sheet請記得link進來) --%>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">
<link rel="stylesheet" href="<c:url value='/css/style.css'/>">
<link rel="stylesheet" href="<c:url value='/css/stars.css'/>">
<!-- 	<link href="https://cdn.jsdelivr.net/npm/@sweetalert2/theme-bootstrap-4/bootstrap-4.css" rel="stylesheet"> -->
<style>
img {
	object-fit: cover;
	width: 100%;
	height: 100%;
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
						<h1>評論管理 / 修改評論</h1>
					</div>
				</div>
			</div>
		</div>

		<div class="content">
			<div class="row justify-content-center">
				<div class="col-sm-6 ">
					<div class="card">
						<div class="card-body card-block">
							<form:form action="update/save" method="POST" modelAttribute="comment" cssClass="form-horizontal" enctype="multipart/form-data">
								<div class="mb-4 row">
									<form:label path="id" cssClass="col-sm-3 col-form-label">評論編號</form:label>
									<div class="col-sm-9">
										<form:input path="id" cssClass="form-control" type="text" readonly="true" />
									</div>
								</div>
								<!-- 選擇類別 -->
								<div class="mb-4 row">
									<label for="itemTb" class="col-sm-3 col-form-label">項目類別</label>
<%-- 									<form:label path="itemTb" cssClass="col-sm-3 col-form-label">項目類別</form:label> --%>
									<div class="col-sm-9">
										<input name="itemTb" class="form-control" type="text" id="itemTb"  readonly/>
<%-- 										<form:input path="itemTb" cssClass="form-control" type="text" id="itemTb" readonly="true" /> --%>
									</div>
								</div>

								<!-- 輸入商品編號 -->
								<div class="mb-4 row">
									<form:label path="itemId" cssClass="col-sm-3 col-form-label">商品編號</form:label>
									<div class="col-sm-9">
										<form:input path="itemId" cssClass="form-control" type="text" readonly="true" />
										<div class="invalid-feedback">請輸入商品編號</div>
									</div>
								</div>

								<!-- 會員ID -->
								<div class="mb-4 row">
									<form:label path="itemId" cssClass="col-sm-3 col-form-label">會員帳號</form:label>
									<div class="col-sm-9">
										<form:input path="userId" cssClass="form-control" type="text" readonly="true" />
										<div class="invalid-feedback">請輸入會員帳號</div>
									</div>
								</div>

								<!-- 日期 -->
								<div class="mb-4 row">
									<form:label path="itemId" cssClass="col-sm-3 col-form-label">評論日期</form:label>
									<div class="col-sm-9">
										<form:input path="date" cssClass="form-control" type="text"	readonly="true" />
									</div>
								</div>

								<!-- 給予評分 -->
								<div class="mb-4 row">
									<form:label path="rating" cssClass="col-sm-3 col-form-label">給予評分</form:label>
									<div class="col-sm-9">
										<fieldset class="starability-basic">
											<form:radiobutton path="rating" value="0" id="no-rate" />
											<form:radiobutton path="rating" value="1" id="first-rate1" />
											<form:label path="rating" for="first-rate1">1 star</form:label>
											<form:radiobutton path="rating" value="2" id="first-rate2" />
											<form:label path="rating" for="first-rate2">2 stars</form:label>
											<form:radiobutton path="rating" value="3" id="first-rate3" />
											<form:label path="rating" for="first-rate3">3 stars</form:label>
											<form:radiobutton path="rating" value="4" id="first-rate4" />
											<form:label path="rating" for="first-rate4">4 stars</form:label>
											<form:radiobutton path="rating" value="5" id="first-rate5" />
											<form:label path="rating" for="first-rate5">5 stars</form:label>
										</fieldset>
									</div>
								</div>

								<!-- 體驗分享 -->
								<div class="mb-5 row">
									<div class="col-sm-3">
										<form:label path="content" cssClass="col-form-label">評論內容</form:label>
										<div id="content-length" class="text-black-50 small">(0/200)</div>
									</div>
									<div class="col-sm-9">
										<form:textarea path="content" cssClass="form-control" id="content" cols="30" rows="5" cssStyle="resize:none"></form:textarea>
										<div class="invalid-feedback">評論內容上限200字</div>
									</div>
								</div>
								<div class="mb-4 row">
									<div class="col-sm-3">
										<label for="images" class="col-form-label">上傳照片</label>
										<div id="images-length" class="text-black-50 small">(0/3)</div>
									</div>
									<div class="col-sm-9">
										<input class="form-control" type="file" name="images" id="images" multiple onchange="previewMultiple(event)" accept="image/*">
										<div class="invalid-feedback">最多選取3張圖片</div>
									</div>
									<div class="row justify-content-end">
										<div class="col-sm-9">
											<div class="row">
												<label for="imagesFromDB"></label> 
<%-- 												<c:set var="sum" value="0" /> --%>
												<c:if test="${not empty comment.getImage1()}">
													<div class="col-4">
														<input type="checkbox" name="deleteImages" value="${comment.getImage1()}" id="">刪除 
														<img src="../<c:url value='${comment.getImage1()}'/>" class="rounded" />
													</div>
													<input type="hidden" name="existedImages" value="${comment.getImage1()}"> 
<%-- 													<c:set var="sum" value="${sum+= 1}" /> --%>
												</c:if>
												<c:if test="${not empty comment.getImage2()}">
													<div class="col-4">
														<input type="checkbox" name="deleteImages" value="${comment.getImage2()}" id="">刪除 
														<img src="../<c:url value='${comment.getImage2()}'/>" class="rounded" />
													</div>
													<input type="hidden" name="existedImages" value="${comment.getImage2()}"> 
<%-- 													<c:set var="sum" value="${sum+= 1}" /> --%>
												</c:if>
												<c:if test="${not empty comment.getImage3()}">
													<div class="col-4">
														<input type="checkbox" name="deleteImages" value="${comment.getImage3()}" id="">刪除 
														<img src="../<c:url value='${comment.getImage3()}'/>" class="rounded" />
													</div>
													<input type="hidden" name="existedImages" value="${comment.getImage3()}">
<%-- 													<c:set var="sum" value="${sum+= 1}" /> --%>
												</c:if>
											</div>
										</div>
									</div>
								</div>
									<div class="row justify-content-end">
										<div class="col-sm-9">
											<div class="row" id="formFile"></div>
										</div>
									</div>
								


								<!-- 送出 -->
								<!-- action=update對應到controller的doGet -->
								<div class="row">
									<div class="d-grid gap-2 col-6">
										<a class="btn btn-outline-warning rounded-pill mt-5 mb-4" href="<c:url value='/comments/' />">取消修改</a>
									</div>
									<div class="d-grid gap-2 col-6">
										<form:button type="submit" class="btn btn-warning rounded-pill mt-5 mb-4" id="btn-insert">送出</form:button>
									</div>
								</div>
							</form:form>
						</div>
					</div>
				</div>

				<div class="col-lg-6">
					<div class="card">
						<div class="card-body">
							<h4 class="card-title">商品資訊</h4>
							<div id="info"></div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</main>

	<%-- Scripts --%>
	<script src="<c:url value='/js/jquery-3.6.0.js'/>"></script>
	<script src="<c:url value='/js/plugins.js'/>"></script>
	<script src="<c:url value='/js/main.js'/>"></script>
	<script>
		let sum = 0;
		if ("${comment.getImage1()}" != "") {
			sum += 1;
		}
		if ("${comment.getImage2()}" != "") {
			sum += 1;
		}
		if ("${comment.getImage3()}" != "") {
			sum += 1;
		}
		let itemTbValue = "${comment.getItemTb()}";
		let itemIdValue = ${comment.getItemId()};
		console.log(sum);
		const itemTb = document.getElementById("itemTb");
		switch ("${comment.getItemTb()}") {
			case 'ticket':
				itemTb.value = '行程'
				break
			case 'restaurant':
				itemTb.value = '餐廳'
				break
			case 'hotel':
				itemTb.value = '住宿'
				break
			case 'carRental':
				itemTb.value = '租車'
				break
			default:
				itemTb.value = '此項目已被移除';
		};
		
		// 立即顯示所選照片
		function previewMultiple(event) {
		    var images = document.getElementById("images");
		    var number = images.files.length;
		    document.getElementById("formFile").innerHTML = ''
		    for (i = 0; i < number; i++) {
		        var urls = URL.createObjectURL(event.target.files[i]);
		        document.getElementById("formFile").innerHTML += 
		        	'<div class="col-4 mt-5"> <img src="' + urls + '" class="rounded"/> </div>';
		    }
		}
		
		
		jQuery(document).ready(function($){
	        $(function() {

	        	loadInfo();
	        	
	        	let contentMax = 200;
	        	let imagesMax = 3;

	        	let contentLength = $("#content").val().length;
	        	console.log(contentLength);
			    $("#content-length").text('('+contentLength+'/'+contentMax+')');
				
				let imagesLength = sum;
				$('#images-length').text('('+imagesLength+'/'+ imagesMax +')')

				
				// 確認表單內容
				$('#btn-update').click(function (e) {
					let isUserIdVaild = $('#userId').val() !== '';
					let isContentVaild = $("#content").val().length <= contentMax;
					let isImagesVaild = imagesLength <= imagesMax;
					
					if ( !isUserIdVaild || !isContentVaild || !isImagesVaild ) {
						e.preventDefault();					
						isUserIdVaild ? hideInvalidText($('#userId')) : showInvalidText($('#userId'));
						isContentVaild ? hideInvalidText($('#content')) : showInvalidText($('#content'));
						isImagesVaild ? hideInvalidText($('#images')) : showInvalidText($('#images'));
						$("form").addClass('validated');
					} else {
						$('#btn-update').submit();
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
				
				$('input[name="deleteImages"]').on('change', function() {
					imagesLength = sum - $('input[name="deleteImages"]:checked').length + $("#images")[0].files.length;
					console.log($('input[name="deleteImages"]:checked').length)
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
				
				// 顯示上傳照片數量
				$("#images").on("change", function() {
					imagesLength = sum - $('input[name="deleteImages"]:checked').length;
					imagesLength += $("#images")[0].files.length;
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
				
				
	        	
	        	function loadInfo() {
					$.ajax({
	                    type: 'GET',
	                    url: 'findItem',
	                    dataType: 'json',
	                    data: {
	                    	"select": "tickets"
	                    },
	                    success: function (data) {
	                    	popUpInfo(itemTbValue, itemIdValue)
	                    },
	                    error: function () {
	                        console.log('error')
	                    }
	                })
				}
				
				
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
				            $('#info').html('<div class="text-dark text-start">' + itemInfo + '</div>')
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