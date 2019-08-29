<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="util.Util" %>
<!DOCTYPE html>
<html lang="ja">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>ユーザ削除画面</title>
    <!-- BootstrapのCSS読み込み -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- オリジナルCSS読み込み -->
    <link href="css/original/common.css" rel="stylesheet">
    <!-- Jqeryの読み込み -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js">
    <!-- BootstrapのJS読み込み -->
    <script src="js/bootstrap.min.js"></script>
    <!-- レイアウトカスタマイズ用個別CSS -->

  </head>
  <body>

    <!-- header -->
    <header>
      <nav class="navbar navbar-inverse">
      	<div class="container">
      		<div class="navbar-header">
            <a class="navbar-brand" href="userList.html">ユーザ削除確認</a>
      		</div>

          <ul class="nav navbar-nav navbar-right">
  						<li class="navbar-text">${loginUser.name} さん </li>
  						<li class="dropdown">
  							<a class="btn btn-danger" href="Logout">ログアウト</a>
              </li>
  				</ul>
      	</div>
      </nav>
    </header>
    <!-- /header -->


    <!-- body -->
    <div class="container">

      <div class="panel panel-default">
        <div class="panel-body">
        <% String deleteId = Util.nullCheck((String)request.getParameter("deleteId"));%>

          <p>ログインID: <%= deleteId %> を本当に削除してもよろしいでしょうか。</p>
           <!--  <p>を本当に削除してもよろしいでしょうか。</p> -->

          <div class="text-center">
            <a class="btn btn-default form-submit" href="UserList">Cancel</a>

            <form method="post" action="UserDelete" style=" display: inline; ">
            <button class="btn btn-primary" >OK</button>
            <input type="hidden" name="deleteId" value=<%=deleteId %>></form>

          </div>
        </div>
      </div>


      <div class="col-xs-4">
        <a href="UserList">戻る</a>
      </div>
    </div>
  </body>
</html>