
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	//セッションの受け取り
	String member = (String) session.getAttribute("member");
	String logUrl = "";
	String logName = "";

	//会員でなければlogin.jspへ飛ばす
	if (member == null || member.isEmpty()) {
		request.getRequestDispatcher("login.jsp").forward(request, response);
	} else {
		logUrl = "logoutServlet.jsp";
		logName = "ログアウト";
	}
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>raise</title>
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
						<li><a href="<%=request.getContextPath() + "/raise.jsp"%>"><FONT
								color="#00ffff">Raise</FONT></a></li>
						<li><a href="<%=logUrl%>"><%=logName%></a></li>
						<li><a
							href="<%=request.getContextPath() + "/shinki_touroku.jsp"%>">新規登録</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<div class="contents">
		<div class="raise-main-visual">
			<div class="raise-button">
				<a href="<%=request.getContextPath() + "/raise_form.jsp"%>"><img
					src="" width="" height="" alt="raiseボタン"></a>
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