<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE>
<%
	//セッション変数の取得
	String logName = (String) session.getAttribute("logName");
	String logUrl = (String) session.getAttribute("logUrl");

	if (logName == null || logName.isEmpty()) {
		logName = "ログイン";
	}
	if (logUrl == null || logUrl.isEmpty()) {
		logUrl = "login.jsp";
	}
%>
<html lang="ja">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>index</title>
<meta name="viewport" content="width=device-width">

<link
	href="http://netdna.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.css"
	rel="stylesheet">
<link rel="stylesheet" href="css/RaiseForIt.css">
<link rel="stylesheet" href="css/cssreset-min.css">
<script type="text/javascript" src="js/window_change.js"></script>
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
						<li><a href=<%= request.getContextPath() + "/index.jsp" %>><FONT color="#00ffff">トップ</FONT></a></li>
						<li><a href=<%= request.getContextPath() + "/ListServlet" %>>プロジェクト一覧</a></li>
						<li><a href="<%= request.getContextPath() + "/raise.jsp" %>">Raise</a></li>
						<li><a href="<%= logUrl %>"><%= logName %></a></li>
						<li><a href="<%= request.getContextPath() + "/shinki_touroku.jsp" %>">新規登録</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<div class="contents">
		<div class="main-visual">
			<img src="" width="100%" height="500px" alt="メインビジュアル">
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