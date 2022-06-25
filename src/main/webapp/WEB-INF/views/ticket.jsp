
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.ispan.model.*"%>
<%@page import="java.util.*"%>

<!DOCTYPE html>
<html class="no-js" lang="">
<%@page import="com.ispan.model.*"%>
<%@page import="java.util.*"%>

<head>

<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>景點列表</title>
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
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.6-rc.0/css/select2.min.css"
	rel="stylesheet" />
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.6-rc.0/js/select2.min.js"></script>
<!-- Select2 i18 中文翻譯 -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.6-rc.0/js/i18n/zh-TW.js"></script>

<style>
.font-family {
	font-family: DFKai-sb;
}

.English-font {
	font-family: Times New Roman;
}

.tableStyle {
	display: block;
	white-space: nowrap;
	word-wrap: break-word;
}

.table td, .table th {
	min-width: 100px;
}

.
thead th, .table-bordered thead td {
	border-bottom-width: 1px;
	width: 100%;
	height: 50px;
}

.textarea {
	border: none;
	background-color: transparent;
	resize: none;
	outline: none;
}
</style>
</head>
<body>
	<%-- side Bar (side bar請記得include進來) --%>
	<%@include file="./partials/sidebar.jspf"%>

	<%-- main--%>
	<main id="right-panel" class="right-panel font-family">
		<div class="breadcrumbs">
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

		<c:if test="${ticketBean != null}">
			<form action="View_pro" method="post" style="width:50%">
				<input type="hidden" name="ticketNo" value="<c:out value='${ticketBean.ticketNo}' />" />
			</form>
		</c:if>
		<c:if test="${ticketBean == null}">
			<form action="View_pro" method="post" style="width:50%"> </form>
		</c:if>

		<div class="content">
			<div class="row">
				<div class="col-md-12">
					<div class="card">
						<div class="card-header">
							<form action="<c:url value='ShowNewForm' />" name="new" method="GET">
								<input type="hidden" value="new" name="showNewForm"> 
								<input type="submit" class="English-font" value="new">
							</form>

							<!-- 							<form action="View_pro" method="POST"> -->
							<!-- 								<input type="hidden" name="list" value="list"> <input -->
							<!-- 									type="submit" class="btn btn-success" value="list"> -->
							<!-- 							</form> -->
							<!-- 							<input type="hidden" name="action" value="new"> -->
							<!-- 							//new按鈕無法使用 <input type="submit" action="insert" name="action" -->
							<!-- 								value="new" method="POST" class="English-font"> -->
							<table
								class="table table-hover table-sm tableStyle table-bordered">
								<thead class="thead-dark">
									<tr>
										<th>商品編號</th>
										<th>商品名稱</th>
										<th>商品簡介</th>
										<th>營業日期</th>
										<th>營業起始時間</th>
										<th>營業結束時間</th>
										<th>電話</th>
										<th>國家</th>
										<th>城市</th>
										<th>地區</th>
										<th>地址</th>
										<th>票價</th>
										<!-- <th scope="col">圖片檔案</th> -->
										<!-- <th scope="col">圖片簡介</th> -->
									</tr>
								</thead>
								<tbody>
									<c:forEach var="ticketBean" items="${list}">
										<tr>
											<td><c:out value="${ticketBean.ticketNo}" /></td>
											<td><c:out value="${ticketBean.ticketName}" /></td>
											<td class="ellipsis"><textarea readonly rows="5"
													cols="30" class="textarea" style="white-space: normal">
													<c:out value="${ticketBean.ticketIntro}" />
												</textarea></td>
											<td><c:out value="${ticketBean.ticketOpenWeek}"
													escapeXml="false" /></td>
											<td><c:out value="${ticketBean.ticketOpenTime}" /></td>
											<td><c:out value="${ticketBean.ticketEndTime}" /></td>
											<td><c:out value="${ticketBean.phone}" /></td>
											<td><c:out value="${ticketBean.country}" /></td>
											<td><c:out value="${ticketBean.city}" /></td>
											<td><c:out value="${ticketBean.location}" /></td>
											<td class="ellipsis"><c:out
													value="${ticketBean.address}" /></td>
											<td><c:out value="${ticketBean.price}" /></td>
											<%-- <td><a href="Delete_view_pro?id=<c:out value='${view_pro.prod_no}'class="btn btn-outline-warning btn-sm" />">Delete</a></td> --%>
											<td><div style="float: left">
<!-- 													<a -->
<%-- 														href="Edit_view_pro?ticketNo=<c:out value='${ticketBean.ticketNo}'/>"> --%>
<!-- 														<i class="bi bi-pencil-square"></i>編輯 -->
<!-- 													</a> <br> -->
													<form action="showEditForm" method="POST" name="edit">
<!-- 														<input type="hidden" name="showEditForm" value="edit"> -->
														<input type="hidden" name="UpdateId" value="<c:out value='${ticketBean.ticketNo}' />"> 
														<input type="submit" class="bi bi-pencil-square" value="編輯">
													</form>
													<form action="<c:url value='Ticket.Delete'/>" method="POST" name="delete">
														<input type="hidden" name="Delete"
															value="<c:out value='${ticketBean.ticketNo}' />">
														<input type="submit" class="bi bi-trash3" value="刪除">
													</form>
													<%-- <a href="delete/<c:out value='${ticketBean.ticketNo}'/>"> --%>
													<%--type="submit" name="action" value="Delete_view_pro" class="btn btn-outline-warning btn-sm"  --%>
													<!-- 													<i class="bi bi-trash3 "></i>刪除 </a> -->
												</div></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</main>
	<%-- scripts --%>
	<script src="<%=request.getContextPath()%>/js/jquery-3.6.0.js"></script>
	<script src="<%=request.getContextPath()%>/js/plugins.js"></script>
	<script src="<%=request.getContextPath()%>/js/main.js"></script>
	<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
	<script src="https://demeter.5fpro.com/tw/zipcode-selector.js"></script>

</body>