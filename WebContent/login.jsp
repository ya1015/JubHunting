<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE>
<%
	//sessionスコープのデータを取得
	HttpSession session2 = request.getSession();
	String member = (String) session2.getAttribute("member");
%>
<html lang="ja">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login</title>
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
						<li><a href="<%=request.getContextPath() + "/ListServlet"%>">プロジェクト一覧</a></li>
						<li><a href="<%=request.getContextPath() + "/raise.jsp"%>">Raise</a></li>
						<li><a href="<%=request.getContextPath() + "/login.jsp"%>"><FONT
								color="#00ffff">ログイン</FONT></a></li>
						<li><a
							href="<%=request.getContextPath() + "/shinki_touroku.jsp"%>">新規登録</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<div class="contents">
		<div class="contents-inner">
			<h1 class="title">ログイン</h1>
			<p>
				<font size="2" color="#ff0000">${ nullErr }</font>
			</p>
			<p>
				<font size="2" color="#ff0000">${ zenErr }</font>
			</p>
			<form action="LoginServlet" method="POST">
				<p>
					<input type="text" name="id" placeholder="ユーザーIDを入力">
				</p>
				<p>
					<input type="text" name="pass" placeholder="パスワードを入力">
				</p>
				<p>
					<input type="submit" value="ログイン">
				</p>
			</form>
			<div class="login_link">
				<p>
					<a href="shinki_touroku.jsp">アカウントをまだお持ちでない方は新規登録へ</a>
				</p>
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