<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE>
<%
	HttpSession sessionCount = request.getSession(true);

	String fcount = request.getParameter("fcount");

	String counter = (String) sessionCount.getAttribute("counter");

	String submit = "";
	//検索文字
	String pattern1 = "a";
	String pattern2 = "b";
	String pattern3 = "c";

	if (counter.indexOf(pattern1) != -1 && counter.indexOf(pattern2) != -1) {
		submit = "完了";
	} else if (counter.indexOf(pattern2) != -1 && counter.indexOf(pattern3) != -1) {
		submit = "完了";
	} else if (counter.indexOf(pattern1) != -1 && counter.indexOf(pattern3) != -1) {
		submit = "完了";
	} else {
		submit = "保存する";
	}
%>
<html lang="ja">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>raise_edit_image</title>
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
						<li><a href="<%=request.getContextPath() + "/index.jsp"%>">トップ</a></li>
						<li><a href="<%=request.getContextPath() + "/ListServlet"%>">プロジェクト一覧</a></li>
						<li><a href="<%=request.getContextPath() + "/raise.jsp"%>"><FONT
								color="#00ffff">Raise</FONT></a></li>
						<li><a
							href="<%=request.getContextPath() + "/LogoutServlet"%>">ログアウト</a></li>
						<li><a
							href="<%=request.getContextPath() + "/shinki_touroku.jsp"%>">新規登録</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<div class="contents">
		<div class="contents-inner">
			<h1>編集</h1>
			<div id="">
				<ul>
					<li><a
						href="<%=request.getContextPath() + "/raise_edit_title.jsp"%>">タイトル</a></li>
					<li><a
						href="<%=request.getContextPath() + "/raise_edit_text.jsp"%>">本文</a></li>
					<li><a
						href="<%=request.getContextPath() + "/raise_edit_image.jsp"%>"><FONT
							color="#00ffff">動画・画像</FONT></a></li>
					<li><a href="#">プロフィール</a></li>
				</ul>
			</div>
			<form action="RaiseEditImageServlet" method="POST">
				<table id="">
					<tr>
						<th>紹介用画像(メイン)</th>
						<td><textarea name="introduction_visual_path"></textarea></td>
					</tr>
					<tr>
						<th>動画</th>
						<td><input type="text" name="movie_path"
							placeholder="https://www.youtube.com/watch?v=xxxxxxxxxx or vimeo"></td>
					</tr>
				</table>
				<div id="">
					<input type="hidden" name="type" value="0"> <input
						type="hidden" name="project_no" value="${ project_no }"> <input
						type="hidden" name="fcount" value="c"> <input
						type="submit" value="<%=submit%>">
				</div>
			</form>
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