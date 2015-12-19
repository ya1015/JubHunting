<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>regist_comp</title>
<meta name="viewport" content="width=device-width">
<link href="http://netdna.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.css" rel="stylesheet">
<link rel="stylesheet" href="css/RaiseForIt.css">
<link rel="stylesheet" href="css/cssreset-min.css">
<script src="http://code.$.com/$-1.11.1.min.js"></script>
<script>
$(function(){

	$("#menubtn").click(function(){
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
                    <h1><a href="#"><img src="img/index_logo.png" alt="RaiseForIt" width="250" height="33"></a></h1>
                </div>
            </div>
            <div class="box2">
                <button type="button" id="menubtn">
                    <i class="fa fa-bars"></i><span>MENU</span>
                </button>
                <div class="menu" id="menu">
                    <ul>
                        <li><a href="<%= request.getContextPath() + "/index.jsp" %>">トップ</a></li>
                        <li><a href="<%= request.getContextPath() + "/ListServlet" %>">プロジェクト一覧</a></li>
                        <li><a href="<%= request.getContextPath() + "/raise.jsp" %>">Raise</a></li>
                        <li><a href="<%= request.getContextPath() + "/login.jsp" %>">ログイン</a></li>
                        <li><a href="<%= request.getContextPath() + "/shinki_touroku.jsp" %>"><FONT color="#00ffff">新規登録</FONT></a></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <div class="contents">
        <div class="regist_comp_message">
    		<p>ご登録ありがとうございました</p>
    	</div>
    	<div class="regist_comp_message2">
    		<p>ご登録されたメールアドレスに登録完了メールを送信しました。</p>
    		<p>ご確認ください。このまま『LunchDrop』を続ける場合は下の「TOPに戻る」ボタンでトップページへ戻ってください。</p>
    		<p>自動的にログインされます。</p>
    	</div>
		<div class="login_link">
			<p><a href="index.jsp">トップに戻る</a></p>
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