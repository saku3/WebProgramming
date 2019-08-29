<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="util.Util" %>
<%@ page import="model.User" %>
<!DOCTYPE html>
<html lang="ja">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>ユーザ詳細参照画面</title>
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
            <div class="navbar-brand" >ユーザ詳細</div>
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


          <div class="panel-body">
            <form method="post" action="#" class="form-horizontal">
              <div class="form-group">
                <label for="user-id" class="control-label col-sm-2">ログインID</label>
                <div class="form-control-static static-padding">
                  ${detailUser.login_id}
                </div>
              </div>
              <div class="form-group form-margin">
                <label for="user-name" class="control-label col-sm-2">ユーザ名</label>
                <p class="form-control-static static-padding">
                  ${detailUser.name}
                </p>
              </div>
              <div class="form-group form-margin">
                <label for="continent" class="control-label col-sm-2">生年月日</label>
                <p class="form-control-static static-padding">
                   ${detailUser.format_birth_date}
                </p>
              </div>
              <div class="form-group form-margin">
                <label for="continent" class="control-label col-sm-2">作成日時</label>
                  <p class="form-control-static static-padding">
                    ${detailUser.format_create_date}

                  </p>
                </div>
              <div class="form-group form-margin">
                <label for="continent" class="control-label col-sm-2">更新日時</label>
                <p class="form-control-static static-padding">
                  ${detailUser.format_update_date}
                </p>
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
