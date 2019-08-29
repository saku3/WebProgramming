<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ja">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>ログイン画面</title>
    <!-- BootstrapのCSS読み込み -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- オリジナルCSS読み込み -->
    <link href="css/original/common2.css" rel="stylesheet">
    <!-- Jqeryの読み込み -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js">
    <!-- BootstrapのJS読み込み -->
    <script src="js/bootstrap.min.js"></script>
    <!-- レイアウトカスタマイズ用個別CSS -->

  </head>



  <body>
<%
String check = (String)request.getAttribute("check");
if(check.equals("loginError")){
%>
  <div class="alert alert-danger" role="alert">IDまたはパスワードが異なります。</div>
<% }else if(check.equals("logout")){
%>
<div class="alert alert-success" role="alert">ログアウトしました</div>
<% }%>
    <div class="container">
        	<div class="row">
    			<div class="col-md-6 col-md-offset-3">
    				<div class="panel panel-login">
    					<div class="panel-heading">
                <form class="form-signin" action="UserLogin" method="post">
                <h1>Login<h1>


    					</div>
    					<div class="panel-body">
    						<div class="row">
    							<div class="col-lg-12">
    									<div class="form-group">
    										<input type="text" name="login_Id" id="login_id" tabindex="1" class="form-control" placeholder="Login_Id" required>
    									</div>
    									<div class="form-group">
    										<input type="password" name="pass" id="password" tabindex="2" class="form-control" placeholder="Password" required>
    									</div>
                      <button  class="btn btn-lg btn-primary btn-block btn-signin"  type="submit">Login</button>

                          </form><!-- /form -->
  </body>
</html>