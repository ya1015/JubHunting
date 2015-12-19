<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE>
<%

%>
<html lang="ja">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>RaiseForIt_shinki_touroku</title>
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
						<li><a href="<%=request.getContextPath() + "/login.jsp"%>">ログイン</a></li>
						<li><a
							href="<%=request.getContextPath() + "/shinki_touroku.jsp"%>"><FONT
								color="#00ffff">新規登録</FONT></a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<div class="contents">
		<div class="contents-inner">
			<h1 class="title">新規会員登録</h1>
			${ nullErr } ${ passErr } ${ zenErr }
			<div class="shinki-form">
				<form action="shinki_tourokuServlet" method="POST">
					<table>
						<tr>
							<td>名前</td>
							<td><input type="text" name="member_name"></td>
						</tr>
						<tr>
							<td>ユーザーID</td>
							<td><input type="text" name="user_id"></td>
						</tr>
						<tr>
							<td>パスワード</td>
							<td><input type="text" name="pass"></td>
						</tr>
						<tr>
							<td>パスワード(確認用)</td>
							<td><input type="text" name="pass2"></td>
						</tr>
						<tr>
							<td>メールアドレス</td>
							<td><input type="text" name="mail_address"></td>
						</tr>
						<tr>
							<td>電話番号</td>
							<td><input type="text" name="tel_no"></td>
						</tr>
						<tr>
							<td>出身地</td>
							<td><select name="birthplace">
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
					</table>
					<input type="submit" value="送信">
				</form>
				<div class="login_link">
					<p>
						<a href="login.jsp">アカウントをすでにお持ちの方はこちら</a>
					</p>
				</div>
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