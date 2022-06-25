<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.ispan.model.*"%>
<%@page import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset="UTF-8">

<title>會員資料</title>
<meta name="description" content="dashboard">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css">

<style>
img {
	object-fit: cover;
	width: 70px;
	height: 70px;
}

h1 {
	text-align: center;
	font-weight: bolder;
}

/* 	.btn-round { */
/* 		border-radius: 50% */
/* 	} */
</style>

</head>
<body>
	<%-- <%List<MemberBean> memberDatas = (List<MemberBean>)request.getAttribute("memberDatas");%> --%>

	<%@include file="./partials/sidebar.jspf"%>

	<main id="right-panel" class="right-panel">
		<div class="breadcrumbs">
			<div class="breadcrumbs-inner">
				<div class="row m-0">
					<div class="col-sm-4">
						<div class="page-header float-left">
							<div class="page-title">
								<h1>會員資料管理</h1>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="content">
			<div class="row justify-content-center">
				<div class="col-sm-12">
					<div class="card">
						<div class="card-header py-3">
							<strong class="card-title">會員列表</strong>
						</div>
						<div class="card-body">
							<div class="float-end mb-3">

								<form name="form">

									<a href="addMem" class="btn btn-sm btn-warning rounded-pill">新增會員資料</a>


								</form>
							</div>
							<table class="table  table-hover">
								<thead>
									<tr>
										<th>會員編號</th>
										<th>E-mail</th>
										<th>中文姓名</th>
										<th>英文姓名</th>
										<th>密碼</th>
										<th>性別</th>
										<th>生日</th>
										<th>電話</th>
										<th>完整地址</th>
										<th>管理</th>
									</tr>
								</thead>
								<tbody>
									<form name="form">
										<c:forEach items='${MemberData}' var='MemberData'>
											<tr>
												<input type="hidden" name="user_no"
													value="${MemberData.user_no}">
												<td>${MemberData.user_no}</td>
												<td>${MemberData.email}</td>
												<td>${MemberData.ch_name}</td>
												<td>${MemberData.en_name}</td>
												<td>${MemberData.password}</td>
												<td>${MemberData.gender}</td>
												<td>${MemberData.birthday}</td>
												<td>${MemberData.phone}</td>
												<td>${MemberData.address}</td>
												<td><a href="mem/${MemberData.user_no}"
													class="btn btn-outline-warning btn-sm rounded-circle">
														<i class="bi bi-pencil-square"></i>
												</a> <%-- 												<a href="<c:url value='/memDel/${MemberData.user_no}'/>" class="btn btn-outline-info btn-sm rounded-circle"><i class="bi bi-trash3"></i> --%>
													<!-- 												</a> --> <%-- 												<form action="<c:url value='mem/${MemberData.user_no}'/>" method="GET" class="inline-block"> --%>
													<%-- <%-- 													<input type="hidden" name="id" value="${comment.id}"> --%>
													<!-- 													<button type="submit" class="edit btn btn-outline-warning btn-sm rounded-circle"> -->
													<!-- 														<i class="bi bi-pencil-square"></i> -->
													<!-- 													</button> --> <!-- 												</form> -->
													<!-- 													<button type="button" class="delete btn btn-outline-info btn-sm rounded-circle "> -->
													<!-- 														<i class="bi bi-trash3"></i> --> <!-- 													</button> -->
													<form
														action="<c:url value='/memDel/${MemberData.user_no}'/>"
														method="POST" class="inline-block">
														<input type="hidden" name="id" value="${comment.id}">
														<button type="submit" onclick="javascript:return del();"
															class="delete btn btn-outline-info btn-sm rounded-circle ">
															<i class="bi bi-trash3"></i>
														</button>
													</form></td>
											</tr>
										</c:forEach>
									</form>
								</tbody>
							</table>

						</div>
					</div>
				</div>
			</div>
		</div>

	</main>

	<%-- Scripts --%>

	<script src="<%=request.getContextPath()%>/js/jquery-3.6.0.js"></script>
	<script src="<%=request.getContextPath()%>/js/plugins.js"></script>
	<script src="<%=request.getContextPath()%>/js/main.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	<script>
		function sure(key){
		//這些代碼是javascript的代碼，需要包含在script標簽中
	
			if(confirm("確認刪除？"))
			{
			alert('已刪除');
			}
			else
			{
			alert('取消')
			}
			var oBtn = document.getElementById('btn');
			btn.style.backgroundColor="";
			oBtn.onclick = function(){
				this.style.backgroundColor = 'red';
			}
		}
	</script>
	<script>
	function del() {
		var msg = "確定要刪除這筆會員資料嗎？";
		if (confirm(msg)==true){
		return true;
		}else{
		return false;
		}
	}
	</script>
</body>
</html>