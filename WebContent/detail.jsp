<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%--JSTLタグ仕様準備 --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>detail</title>
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
						<li><a href="<%=request.getContextPath() + "/raise.jsp"%>">Raise</a></li>
						<li><a href="<%=request.getContextPath() + "/login.jsp"%>">ログイン</a></li>
						<li><a
							href="<%=request.getContextPath() + "/shinki_touroku.jsp"%>">新規登録</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<div class="contents-up">
		<div class="contents">
			<c:forEach var="p" items="${list}">
				<div class="title">
					<h1 class="title">${ p.project_name }</h1>
					<p>${ p.category_name }</p>
				</div>
				<div class="clearfix">
					<!-- コンテンツにclass="clearfix"を追加したよ -->
					<div class="contents-detail">
						<div class="heading">
							<div class="thumbnail">
								<div class="thumbnail-in">
									<img src="${ p.introduction_visual_path }">
								</div>
							</div>
							<div class="caption">
								<h2>${ p.caption }</h2>
							</div>
						</div>
						<div class="status">
							<div class="total-inner">
								<h5>現在の募金額</h5>
								<div class="support-amount">${ p.support_amount }円</div>
								<div class="target">目標金額は${ p.goal_support_amount }円</div>
							</div>
							<div class="support-inner">
								<h5>募金人数</h5>
								<div class="support-numbers">${ p.support_numbers }人</div>
							</div>
							<div class="recruitment-end">
								<h5>募集終了まで</h5>
								<p>${ p.recruitment_end }日</p>
							</div>
							<div class="fund-offer">
							<!-- 次ページへ値を送る -->
								<form action="fund.jsp" method="POST" name="projectNo">
									<input type="hidden" value="${ p.project_no }" name="project_no">
									<input type="hidden" value="${ p.project_name }" name="project_name">
									<a href="#" onClick="javascript:document.projectNo.submit()"><img
										src="#">募金を申し込む</a>
								</form>
							</div>
						</div>
						<div id="main">
							<div class="projects-body">
								<div class="title-box">
									<h3>プロジェクト本文</h3>
								</div>
								<p class="text">${ p.text }</p>
							</div>
						</div>
					</div>
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