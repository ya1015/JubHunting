<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE>
<html lang="ja">
<%
	String fcount = request.getParameter("fcount");

	HttpSession sessionCount = request.getSession(true);

	String counter = (String) sessionCount.getAttribute("counter");

	String submit = "";

	//検索文字
	String pattern1 = "a";
	String pattern2 = "b";
	String pattern3 = "c";

	if (counter.indexOf(pattern1) != -1 && counter.indexOf(pattern2) != -1) {
		submit = "完了";
	}
	else if(counter.indexOf(pattern2) != -1 && counter.indexOf(pattern3) != -1){
		submit = "完了";
	}
	else if(counter.indexOf(pattern1) != -1 && counter.indexOf(pattern3) != -1){
		submit = "完了";
	}
	else {
		submit = "保存する";
	}
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>raise_edit_title</title>
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
						href="<%=request.getContextPath() + "/raise_edit_title.jsp"%>"><FONT
							color="#00ffff">タイトル</FONT></a></li>
					<li><a
						href="<%=request.getContextPath() + "/raise_edit_text.jsp"%>">本文</a></li>
					<li><a
						href="<%=request.getContextPath() + "/raise_edit_image.jsp"%>">動画・画像</a></li>
					<li><a href="#">プロフィール</a></li>
				</ul>
			</div>
			<form action="RaiseEditTitleServlet" method="POST">
				<table id="">
					<tr>
						<td>タイトル</td>
						<td><input type="text" value="${ sessionScope.project_name }"
							name="project_name"></td>
					</tr>
					<tr>
						<td>キャプション</td>
						<td><input type="text" name="caption"
							placeholder="プロジェクトの概要を簡単に書いてください"></td>
					</tr>
					<tr>
						<td>カテゴリー</td>
						<td><input type="text"
							value="${ sessionScope.category_name }" name="category_name"></td>
					</tr>
					<tr>
						<td>企画地</td>
						<td><select name="planning_area">
								<optgroup label="北海道">
									<option value="北海道">北海道</option>
								</optgroup>
								<optgroup label="東北">
									<option value="青森県">青森県</option>
									<option value="岩手県">岩手県</option>
									<option value="宮城県">宮城県</option>
									<option value="秋田県">秋田県</option>
									<option value="山形県">山形県</option>
									<option value="福島県">福島県</option>
								</optgroup>
								<optgroup label="関東">
									<option value="茨城県">茨城県</option>
									<option value="栃木県">栃木県</option>
									<option value="群馬県">群馬県</option>
									<option value="埼玉県">埼玉県</option>
									<option value="千葉県">千葉県</option>
									<option value="東京都">東京都</option>
									<option value="神奈川県">神奈川県</option>
								</optgroup>
								<optgroup label="中部">
									<option value="新潟県">新潟県</option>
									<option value="富山県">富山県</option>
									<option value="石川県">石川県</option>
									<option value="福井県">福井県</option>
									<option value="山梨県">山梨県</option>
									<option value="長野県">長野県</option>
									<option value="岐阜県">岐阜県</option>
									<option value="静岡県">静岡県</option>
									<option value="愛知県">愛知県</option>
								</optgroup>
								<optgroup label="近畿">
									<option value="三重県">三重県</option>
									<option value="滋賀県">滋賀県</option>
									<option value="京都府">京都府</option>
									<option value="大阪府">大阪府</option>
									<option value="兵庫県">兵庫県</option>
									<option value="奈良県">奈良県</option>
									<option value="和歌山県">和歌山県</option>
								</optgroup>
								<optgroup label="中国">
									<option value="鳥取県">鳥取県</option>
									<option value="島根県">島根県</option>
									<option value="岡山県">岡山県</option>
									<option value="広島県">広島県</option>
									<option value="山口県">山口県</option>
								</optgroup>
								<optgroup label="四国">
									<option value="徳島県">徳島県</option>
									<option value="香川県">香川県</option>
									<option value="愛知県">愛媛県</option>
									<option value="高知県">高知県</option>
								</optgroup>
								<optgroup label="九州">
									<option value="福岡県">福岡県</option>
									<option value="佐賀県">佐賀県</option>
									<option value="長崎県">長崎県</option>
									<option value="熊本県">熊本県</option>
									<option value="大分県">大分県</option>
									<option value="宮崎県">宮崎県</option>
									<option value="鹿児島県">鹿児島県</option>
								</optgroup>
								<optgroup label="沖縄">
									<option value="沖縄県">沖縄県</option>
								</optgroup>
						</select></td>
					</tr>
					<tr>
						<td>目標支援金額</td>
						<td><input type="text" name="goal_support_amount">円</td>
					</tr>
					<tr>
						<td>募集終了日</td>
						<td><input type="text" name="recruitment_end"></td>
					</tr>
				</table>
				<div id="">
					<input type="hidden" name="project_no" value="${ project_no }">
					<input type="hidden" name="fcount" value="a"> <input
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