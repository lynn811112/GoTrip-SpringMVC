<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html class="no-js" lang="">

<head>

<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>後台管理</title>
<meta name="description" content="dashboard">
<meta name="viewport" content="width=device-width, initial-scale=1">
<%-- style sheet (以下三個style sheet請記得link進來) --%>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/style.css">
<style>
h2 {
	margin-bottom: 20px;
}
</style>
</head>
<body>
	<%-- side Bar (side bar請記得include進來) --%>
	<%@include file="./partials/sidebar.jspf"%>

	<%-- main--%>
	<main id="right-panel" class="right-panel">



		<%-- 網站內容請放main裡面--%>

		<div class="container col-md-10 mt-5">
			<div class="card">
				<div class="card-body">
				
						<form:form action="insert" method="post" modelAttribute="orderBean">

					<caption>
						<h2>
                               新增訂單
						</h2>
					</caption>

			

					<div class="mb-4 row">
						<fieldset class="form-group col-md-4">
							<form:label path="orderCategory">訂單類別:</form:label><form:select class="form-select"
								path="orderCategory">
								<form:option value="訂房">訂房</form:option>
								<form:option value="訂票">訂票</form:option>
							</form:select>
						</fieldset>
						<fieldset class="form-group col-md-4">
							<form:label path="userNo">會員編號:</form:label> <form:input type="text"
								 class="form-control"
								path="userNo" id="userno"/>
						</fieldset>
					</div>
					<div class="mb-4 row">
						<fieldset class="form-group col-md-4">
							<form:label path="orderTotal">總價:</form:label> <form:input type="text"
								
								class="form-control" path="orderTotal" id="total"/>
						</fieldset>
						<fieldset class="form-group col-md-4">
							<form:label path="orderDiscount">折扣金額:</form:label> <form:input type="text"
								
								class="form-control" path="orderDiscount" readOnly="true"
								id="discount"/>
						</fieldset>
						<fieldset class="form-group col-md-4">
							<form:label path="couponId">折扣類別:</form:label><form:select class="form-select"
							 path="couponId" id="couponId">
								<form:option value="1">滿千送百</form:option>
								<form:option value="2">打八折</form:option>
							</form:select>
						</fieldset>
					</div>
					<div class="mb-2 row">

						<fieldset class="form-group col-md-4">
							<form:label path="orderStatus">訂單狀態:</form:label><form:select class="form-select"
								path="orderStatus">
								<form:option value="1">成功</form:option>
								<form:option value="2">不成立</form:option>
							</form:select>
						</fieldset>

						<fieldset class="form-group col-md-4">
							<form:label path="orderPayStatus">付款狀態:</form:label><form:select class="form-select"
								path="orderPayStatus">
								<form:option value="1">尚未付款</form:option>
								<form:option value="2">已付款</form:option>
							</form:select>
						</fieldset>

					</div>
					<div class="row" style="text-align: center">
						<fieldset class="form-group mt-4">
							<a href="<c:url value='/allquery' />" onclick="history.back()"
								class="btn btn-secondary">上一頁 </a>
							<form:button type="submit" class="btn btn-primary">送出</form:button>
						</fieldset>
					</div>
					<%-- 	<input type="button" value="回上一頁"
								class="btn btn-secondary" /> --%>

					</form:form>
					
				</div>
			</div>
		</div>
	</main>

	<%-- scripts --%>
	<script src="${pageContext.request.contextPath}/js/jquery-3.6.0.js"></script>
	<script src="${pageContext.request.contextPath}/js/plugins.js"></script>
	<script src="${pageContext.request.contextPath}/js/main.js"></script>
	<script>
	jQuery(document).ready(function($){
			
		var  coupon = $('#couponId').val() ;
		console.log(coupon);
		
		$('#total').on("blur",function(){
			var division;
			var	twenty
			if($('#couponId').val() == 1){
				 division  = parseInt($(this).val()/1000);
				$('#discount').val(division*100);
				
			}else if($('#couponId').val() == 2){
				twenty	= Math.round($(this).val()*0.2);
				$('#discount').val(twenty);
			}
			
		})

		$('#couponId').on("change",function(){
			
				
				if($('#couponId').val() == 1){
					division  = parseInt($("input[name=orderTotal]").val()/1000);
					$('#discount').val(division*100);
					
				}else if($('#couponId').val() == 2){
				 twenty = Math.round($("input[name=orderTotal]").val()*0.2);
					$('#discount').val(twenty);
				}
				
			
			})
			var total_input = document.getElementById("total");

			total_input.addEventListener("keydown", function(e){			
			
				 if( (e.which >= 48 && e.which <= 57) || e.which == 8 ){ // 8 是刪除鍵
					  
				  }else{
				     e.preventDefault(); // 停止預設行為(在欄位上出現所打的文字)
				  }
				  
				 
				});
				
			var userno_input = document.getElementById("userno");

			userno_input.addEventListener("keydown", function(e){			
			
				 if( (e.which >= 48 && e.which <= 57) || e.which == 8 ){ // 8 是刪除鍵
					  
				  }else{
				     e.preventDefault(); // 停止預設行為(在欄位上出現所打的文字)
				  }
				  
				 
				});
	
	});
	</script>

	<%--
	if($('#couponId').val()== "1"){
			if($('#'))
			$('#Total')
		}
	 --%>

</body>

</html>