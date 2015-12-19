<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%--JSTLタグ仕様準備 --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>list</title>
<meta name="viewport" content="width=device-width">

<link
	href="http://netdna.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.css"
	rel="stylesheet">

<link rel="stylesheet" href="css/RaiseForIt.css">
<link rel="stylesheet" href="css/cssreset-min.css">


<script src="http://code.$.com/$-1.11.1.min.js"></script>
<script>
	$(function() {

		$("#menubtn").click(function() {
			$("#menu").slideToggle();
		});

	});
</script>
</head>

<body>
	<div class="header">
		<div class="header-inner">
			<div class="box1">
				<div class="site">
					<h1>
						<a href="#"><img src="img/index_logo.png" alt="RaiseForIt"
							width="250" height="33"></a>
					</h1>
				</div>
			</div>
			<div class="box2">
				<button type="button" id="menubtn">
					<i class="fa fa-bars"></i><span>MENU</span>
				</button>
				<div class="menu" id="menu">
					<ul>
						<li><a href="<%=request.getContextPath() + "/index.jsp"%>">トップ</a></li>
						<li><a href="<%=request.getContextPath() + "/ListServlet"%>"><FONT
								color="#00ffff">プロジェクト一覧</FONT></a></li>
						<li><a href="<%=request.getContextPath() + "/raise.jsp"%>">raise</a></li>
						<li><a href="<%=request.getContextPath() + "/login.jsp"%>">ログイン</a></li>
						<li><a
							href="<%=request.getContextPath() + "/shinki_touroku.jsp"%>">新規登録</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<div class="contents">
		<div class="contents-inner">
			<c:forEach var="p" items="${ list }">
				<div class="project-box">
					<form action="DetailServlet" method="POST"
						name="image${ p.project_no }">
						<input type="hidden" value="${ p.project_no }" name="project_no">
						<a href="#"
							onClick="javascript:document.image${ p.project_no }.submit()">
							<img src="" class="ichiran-img" alt="写真">
						</a>
					</form>
					<form action="DetailServlet" method="POST"
						name="project${ p.project_no }">
						<input type="hidden" value="${ p.project_no }" name="project_no">
						<a href="#"
							onClick="javascript:document.project${ p.project_no }.submit()">${ p.project_name }</a>
					</form>
					<p>${ p.caption }</p>
					<p>募金額${ p.support_amount }</p>
					<p>募金人数${ p.support_numbers }</p>
				</div>
			</c:forEach>
		</div>
	</div>
	<div class="footer">
		<div class="footer-inner">
			<div class="copyright">
				<p>Copyright &copy; RaiseForIt</p>
			</div>
		</div>
	</div>
</body>
</html>