<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="util.Util" %>

<!DOCTYPE html>
<html lang="ja">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>ユーザ更新画面</title>
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
            <a class="navbar-brand" href="userList.html">ユーザ情報更新</a>
      		</div>

          <ul class="nav navbar-nav navbar-right">
  						<li class="navbar-text"> ${loginUser.name} さん </li>
  						<li class="dropdown">
  							<a class="btn btn-danger" href="Logout">ログアウト</a>
              </li>
  				</ul>
      	</div>
      </nav>
    </header>
    <!-- /header -->

    <!-- body -->

<%
String check = (String)request.getAttribute("check");
if(check!=null&&check.equals("NG")){
%>
  <div class="alert alert-danger" role="alert">入力された内容は正しくありません</div>
<% } %>
    <div class="container">
      <div class="panel panel-default">
        <div class="panel-body">
          <div class="panel-body">
            <form method="post" action="UserUpdate" class="form-horizontal">
              <div class="form-group">
                <label for="user-id" class="control-label col-sm-2">ログインID</label>
                <div  class="form-control-static col-sm-6">
                   ${updateUser.login_id}
                   <input type="hidden" name="updateId" value="${updateUser.login_id}" >
                </div>
              </div>
              <div class="form-group">
                <label for="password" class="control-label col-sm-2">パスワード</label>
                <div class="col-sm-6">
                  <input type="password" name="password" id="password" class="form-control" />
                </div>
              </div>
              <div class="form-group form-margin">
                <label for="password-confirm" class="control-label col-sm-2">パスワード(確認)</label>
                <div class="col-sm-6">
                  <input type="password" name="passwordConfirm" id="password-confirm" class="form-control" />
                </div>
              </div>
              <div class="form-group form-margin">
                <label for="user-name" class="control-label col-sm-2">ユーザ名</label>
                <div class="col-sm-6">
                  <input type="text" name="userName" id="use-name" class="form-control" value= ${ updateUser.name } />
                </div>
              </div>
              <div class="form-group form-margin">
                <label for="continent" class="control-label col-sm-2">生年月日</label>
                <div class="row">
                  <div class="col-sm-5">

                    <input  type="date" name="birthDate" id="date-start" class="form-control" size="30"
                                               value= "${ updateUser.birth_date }"  />
                  </div>
              </div>
              </div>

              <div>
                <button type="submit" value="検索" class="btn btn-primary center-block form-submit">更新</button>
              </div>

            </form>
          </div>
        </div>
      </div>

      <div class="col-xs-4">
        <a href="UserList">戻る</a>
      </div>


    </div>
  </body>
</html>
