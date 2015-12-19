<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE>
<html lang="ja">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>raise_form</title>
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
						<li><a href="<%=request.getContextPath() + "/ListServlet"%>">プロジェクト一覧</a></li>
						<li><a href="<%=request.getContextPath() + "/raise.jsp"%>"><FONT
								color="#00ffff">Raise</FONT></a></li>
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
			<h1 class="title">
				<span style="font-weight: bold">プロジェクトをつくる</span>
			</h1>
			<div class="shinki-form">
				<form action="RaiseServlet" method="POST">
					<table>
						<tr>
							<td>カテゴリー</td>
							<td><select name="category_name">
									<option value="アート" size="2">アート</option>
									<option value="プロダクト" size="2">プロダクト</option>
									<option value="ゲーム" size="2">ゲーム</option>
									<option value="コミュニティ" size="2">コミュニティ</option>
									<option value="ファッション" size="2">ファッション</option>
									<option value="ビジネス" size="2">ビジネス</option>
									<option value="社会貢献" size="2">社会貢献</option>
									<option value="その他" size="2">その他</option>
							</select></td>
							<td>タイトル</td>
							<td><input type="text" name="project_name"></td>
						</tr>
						<tr>
							<td class="button"><input type="submit" value="つくる！">
							</td>
						</tr>
					</table>
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