<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   

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
<link rel="stylesheet"
	href="http://jqueryui.com/resources/demos/style.css">

<style>

.font-family{
	font-family: DFKai-sb;
}

.English-font{
	font-family: Times New Roman;
}

</style>

</head>
<body>
	<%-- side Bar (side bar請記得include進來) --%>
	<%@include file="./partials/sidebar.jspf"%>
	<%-- main--%>
	<main id="right-panel" class="right-panel">
		<div class="breadcrumbs font-family">
			<div class="breadcrumbs-inner">
				<div class="row m-0">
					<div class="page-header float-left">
						<div class="page-title">
							<h1>景點管理</h1>
						</div>
					</div>
				</div>
			</div>
		</div>
	<c:if test="${UPDATE == 1}">
		<form action="Ticket.Update" method="post" style="width:50%"  name="update">
			<input type="hidden" name="ticketNo" value="<c:out value='${TicketBean.ticketNo}' />" />
	</c:if>

	<c:if test="${UPDATE != 1}">
		<form action="Ticket.Insert" method="post" enctype="multipart/form-data">
	</c:if>
<%-- 		<form:form method="post" action="save"> --%>
			<div class="content font-family">
				<div class="row">
					<div class="col-md-12">
						<div class="card">
							<div class="card-header">
								<!-- <form name="form" action="view.controller" method="POST"> -->
								<form action="<c:url value='/Ticket.Insert' />" method="GET" name="insert">
								<table class="table table-hover table table-sm">
									<thead class="thead-dark">

										<!-- 商品名稱 -->
										<div class="mb-4 row">
											<label class="col-sm-3 col-form-label">商品名稱</label>
											
											<div class="col-sm-9">
												<input type="text" name="ticketName" class="form-control"
													required="required"
													value="<c:out value='${TicketBean.ticketName}' />" />
												<%--                                     <input type="text" name="ticketName" class="col-sm-3 col-form-label" value="<c:out value='${view_pro.ticketName}' />" /> --%>
											</div>
										</div>

										<!--商品簡介 -->
										<div class="mb-4 row">
											<label class="col-sm-3 col-form-label" placeholder="限制500字以內">商品簡介</label>
											<div class="col-sm-9">
												<textarea name="ticketIntro" class="form-control" cols="30"
													rows="10" style="white-space: normal"><c:out
														value='${TicketBean.ticketIntro}' /></textarea>
												<%-- 								<input type="text" name="ticketIntro" "<c:out value='${view_pro.ticketIntro}' />" /> --%>
											</div>
										</div>

										<!-- 營業日期 -->
										<div class="mb-4 row">
											<label class="col-sm-3 col-form-label">營業日期</label>
											<div class="col-sm-9">
												<input type="checkbox" name="week1"
													<c:if test="${fn:containsIgnoreCase(TicketBean.ticketOpenWeek, '1')}"> checked</c:if> />
												<span>星期一</span> <input type="checkbox" name="week2"
													<c:if test="${fn:containsIgnoreCase(TicketBean.ticketOpenWeek, '2')}"> checked</c:if> />
												<span>星期二</span> <input type="checkbox" name="week3"
													<c:if test="${fn:containsIgnoreCase(TicketBean.ticketOpenWeek, '3')}"> checked</c:if> />
												<span>星期三</span> <input type="checkbox" name="week4"
													<c:if test="${fn:containsIgnoreCase(TicketBean.ticketOpenWeek, '4')}"> checked</c:if> />
												<span>星期四</span> <input type="checkbox" name="week5"
													<c:if test="${fn:containsIgnoreCase(TicketBean.ticketOpenWeek, '5')}"> checked</c:if> />
												<span>星期五</span> <input type="checkbox" name="week6"
													<c:if test="${fn:containsIgnoreCase(TicketBean.ticketOpenWeek, '6')}"> checked</c:if> />
												<span>星期六</span> <input type="checkbox" name="week7"
													<c:if test="${fn:containsIgnoreCase(TicketBean.ticketOpenWeek, '7')}"> checked</c:if> />
												<span>星期日</span>
											</div>
										</div>

										<!--營業起始時間 -->
										<div class="mb-4 row">
											<label class="col-sm-3 col-form-label">營業起始時間</label>
											<div class="col-sm-9">
												<input type="time" name="ticketOpenTime"
													value="<c:out value='${TicketBean.ticketOpenTime}' />">
											</div>
										</div>
										<!--營業結束時間 -->
										<div class="mb-4 row">
											<label class="col-sm-3 col-form-label">營業結束時間</label>
											<div class="col-sm-9">
												<input type="time" name="ticketEndTime"
													value="<c:out value='${TicketBean.ticketEndTime}'/>">
											</div>
										</div>
										<!-- 電話 -->
										<div class="mb-4 row">
											<label class="col-sm-3 col-form-label">電話</label>
											<div class="col-sm-9">
												<input type='text' name="phone" required="required"
													maxlength="10" data-minlength="10" placeholder="請輸入電話號碼"
													value="<c:out value='${TicketBean.phone}' />">
												<!--  pattern="09\d{2}\d{6}"/ -->
											</div>
										</div>
										<!-- 國家 -->
										<div class="mb-4 row">
											<label class="col-sm-3 col-form-label">國家</label>
											<div class="col-sm-9">
												<select class="form-select" name="country"><option
														value="台灣">台灣</option></select>
											</div>
										</div>

										<!--城市 -->
										<div class="mb-4 row">
											<label class="col-sm-3 col-form-label">城市</label>
											<div class="col-sm-9">
												<select id="city" name="city" placeholder="請選擇縣市"
													class="form-select" /></select>
											</div>
										</div>

										<!-- 地區 -->
										<div class="mb-4 row">
											<label class="col-sm-3 col-form-label">地區</label>
											<div class="col-sm-9">
												<select id="dist" name="location" placeholder="請選擇鄉鎮區"
													class="form-select" /></select>
											</div>
										</div>

										<!--地址 -->
										<div class="mb-4 row">
											<label class="col-sm-3 col-form-label">地址</label>
											<div class="col-sm-9">
												<input type="text" name="address" class="form-control"
													value="<c:out value='${TicketBean.address}' />" />
											</div>
										</div>

										<!--價格 -->
										<div class="mb-4 row">
											<label class="col-sm-3 col-form-label">價格</label>
											<div class="col-sm-9">
												<input type="text" name="price" class="form-control"
													value="<c:out value='${TicketBean.price}' />" />
											</div>
										</div>
								</table>
								<div style="float: right">
								
									<input type="submit" value="保存商品資訊" name="Insert"
										class=" btn btn-outline-warning btn-sm btn " /><br>
										<a href="ticket" class="pull-right btn btn-outline-warning btn-sm">查看商品列表</a>
								
								</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</form>
	</main>
	<%-- scripts --%>
	<script src="js/vendor/jquery-2.1.4.min.js"></script>
	<script src="js/plugins.js"></script>
	<script src="js/main.js"></script>
	<!-- 城市及地區判斷 -->
	<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
	<script type='text/javascript' src="https://demeter.5fpro.com/tw/zipcode-selector.js"></script>
	<script type='text/javascript' class="js-demeter-tw-zipcode-selector" data-city="#city" data-dist="#dist" /></script>
	<script type="text/javascript">
	//判斷城市資料後再自動代入地區
		window.addEventListener('load', function () {
			console.log("load complete");
			setTimeout(function(){
			    console.log("I am the third log after 2 seconds");
				document.getElementById("city").value = "<c:out value='${TicketBean.city}'/>";
				document.getElementById("city").dispatchEvent(new Event('change'));
				setTimeout(function(){
					document.getElementById("dist").value = "<c:out value='${TicketBean.location}'/>";
				},1000);
			},1000);
		})
	</script>
</body>

</html>