<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE>
<%
request.setCharacterEncoding("utf-8");

String project_no = request.getParameter("project_no");
String project_name = request.getParameter("project_name");

System.out.println(project_no);
System.out.println(project_name);
%>
<html lang="ja">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>fund</title>
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
						<li><a href=<%=request.getContextPath() + "/index.jsp"%>>トップ</a></li>
						<li><a href="<%=request.getContextPath() + "/ListServlet"%>"><FONT
								color="#00ffff">プロジェクト一覧</FONT></a></li>
						<li><a href="<%=request.getContextPath() + "/raise.jsp"%>">Raise</a></li>
						<li><a
							href="<%=request.getContextPath() + "/logoutServlet"%>">ログアウト</a></li>
						<li><a
							href="<%=request.getContextPath() + "/shinki_touroku.jsp"%>">新規登録</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<div class="contents">
		<div class="contents-inner">
		<div class="">
		<p></p>
		</div>
			<h1 class="title">
				<span style="font-weight: bold">募金を申し込む！</span>
			</h1>
			<div>
				<form action="fundServlet" method="POST">
					<input type="text"  name="support_amount" placeholder="募金額を入力してください">円募金する
					<input type="hidden"  name="project_no" value="<%=project_no%>">
					<input type="submit" value="完了">
				</form>
			</div>
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