<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <%--JSTLタグ仕様準備 --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>raise_confirmation</title>
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
    		    		<p>こちらの内容で投稿します</p>
    		</div>
    	<div class="regist_comp_message2">
    	<table width="600px">
    	<c:forEach var="p" items="${ list }">
    	<tr>
    	<td>タイトル</td>
    	<td>${ p.project_name }</td>
    		</tr>
    		<tr>
    		<td>募集終了日</td>
    		<td>${ p.recruitment_end }</td>
    		</tr>
    		<tr>
    		<td>目標支援金額</td>
    		<td>${ p.goal_support_amount }</td>
    		</tr>
    		<tr>
    		<td>キャプション</td>
    		<td>${ p.caption }</td>
    		</tr>
    		<tr>
    		<td>紹介用画像</td>
    		<td>${ p.introduction_visual_path }</td>
    		</tr>
    		<tr>
    		<td>紹介動画</td>
    		<td>${ p.movie_path }</td>
    		</tr>
    		<tr>
    		<td>本文</td>
    		<td>${ p.text }</td>
    		</tr>
    		<tr>
    		<td>企画地</td>
    		<td>${ p.planning_area }</td>
    		</tr>
    		</c:forEach>
    		<tr>
    		<td>カテゴリー</td>
    		<td>${ category_name }</td>
    		</tr>
    		</table>
    	</div>
		<div class="#">
			<p><a href="RaiseCompServlet">公開する</a></p>
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