<%@page import="com.ispan.model.*"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html class="no-js" lang="">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.0.0/jquery.min.js"></script>
<script src="https://demeter.5fpro.com/tw/zipcode-selector.js"></script>
<script src="http://lib.sinaapp.com/js/jquery/1.12.4/jquery-1.12.4.min.js"></script>
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>會員資料</title>
<meta name="description" content="dashboard">
<meta name="viewport" content="width=device-width, initial-scale=1">
<%-- style sheet (以下三個style sheet請記得link進來) --%>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
<style>
		h1{
		text-align: center;
		font-weight: bolder;
		}
</style>

</head>

<body>

	<%-- side Bar --%>
	<%@include file="./partials/sidebar.jspf"%>

	<%-- main--%>
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
				<div class="col-lg-6 ">
					<div class="card">
						<div class="card-header py-3">
							<strong class="card-title">新增會員</strong>
						</div>
					<div class="card-body">
							<form method="POST" action="<c:url value='/SaveMem'/>" enctype='multipart/form-data'>
								

								<p class="sty">
									<label for="1" class="t1">中文名：</label>
									<input type="text" name="ch_name" placeholder="中文名" autofocus size="10" id="1" required="required">
								</p>

								<p class="sty">
									<label for="2" class="t1">英文名：</label>
									<input type="text" name="en_name" placeholder="Name" size="10" id="2">
								</p>

								<p class="sty">
									<label class="t1" for="3">E-mail：</label> <input type="email" name="email" id="3" size="25">
								</p>


								<p class="sty">
									<label class="t1">性別：</label> 
									<label> <input type="radio" name="gender" value="男">男</label> 
									<label> <input type="radio" name="gender" value="女">女</label>
								</p>

								<p class="sty">
									<label class="t1">生日：</label> 
									<input type="date" name="birthday">
								</p>

								<p class="sty">
									<label for="4" class="t1">密碼：</label>
									<input type="password" name="password" id="password" placeholder="請輸入8-20位英數混合密碼" maxlength="20" size="30" required="required" pattern="^(?=.*[a-zA-Z])(?=.*[0-9]).{8,20}$">       
									
    								<a>
        							<label class="checkbox">
        							<input type="checkbox" id="myCheck" onclick="myFunction()"><i></i>顯示密碼</label>
    								</a>
    								
								</p>
								
								<p class="sty">
									<label for="3" class="t1">電話：</label>
									<input type="text" name="phone" maxlength="10" id="3">
								</p>

								<p>
								<label class="t1">地址：</label> 
									<input type="text" class="js-demeter-tw-zipcode-selector" data-city="#city" data-dist="#location" placeholder="郵遞區號" size="6" readonly/> 
									<select id="city" name="city" placeholder="請選擇縣市" onchange="addressChange()"></select> 
									<select id="location" name="location" placeholder="請選擇鄉鎮區" onchange="addressChange()"></select>
								</p>
								
								<p class="sty">
								<input type="text" name="address" id="address" size="40" >
								</p>
								<div class="row">
									<div class="d-grid gap-2 col-4">
										<input type="submit" class="btn btn-warning rounded-pill my-5" style="width:160px" onclick="javascript:return chk()" value="確定新增">
									</div>
									<div class="d-grid gap-2 col-4">
										<label><a href="<c:url value='/member'/>" class="btn btn-outline-warning rounded-pill my-5" style="width:160px">取消</a></label>
									</div>
								</div>
<%-- 								<center><button type="submit" name="action" value="invert" class="btn btn-warning rounded-pill my-5" style="width:200px" onclick="javascript:return chk()">確定新增</button></center> --%>
								
							</form>

						</div>
					</div>
				</div>
			</div>
		</div>


	</main>

	<%-- Scripts --%>
	<script src="js/vendor/jquery-2.1.4.min.js"></script>
	<script src="js/plugins.js"></script>
	<script src="js/main.js"></script>

	<script>
		function previewMultiple(event) {
			var images = document.getElementById("formFileMultiple");
			var number = images.files.length;
			for (i = 0; i < number; i++) {
				var urls = URL.createObjectURL(event.target.files[i]);
				document.getElementById("formFile").innerHTML += '<div class="col-4"> <img src="' + urls + '" class="rounded"/> </div>';
			}
		}
	</script>
    
    <%-- 顯示密碼 --%>
	<script>
	function myFunction() {
		  // Get the checkbox
		  var checkBox = document.getElementById("myCheck");

		  // If the checkbox is checked, translate type 'password' to 'text'
		  if (checkBox.checked == true){
			  $("#password").prop("type", 'text');
		  } else {
			  $("#password").prop("type", 'password');
		  }
		}
	</script>
	
	<%-- 立即顯示縣市鄉鎮 --%>
	<script type="text/javascript">
	function addressChange() {
        var city = document.getElementById('city').value;
        var location = document.getElementById('location').value;
        document.getElementById('address').value = city + location;
    }
	</script>
	
	<script type="text/javascript">
 	 function chk(){
     var password=document.getElementById("password").value; 
	 if (password.indexOf(" ")>=0) {
	    alert("密碼不可含有空格！");
	    return false;
	 }
  	}
	</script>
	
</body>

</html>