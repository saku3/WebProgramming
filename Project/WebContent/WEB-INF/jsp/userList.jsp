<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.UserDao" %>
<%@ page import="java.util.List" %>
<%@ page import="util.Util" %>
<%@ page import="model.User" %>



<!DOCTYPE html>
<html lang="ja">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>ユーザ一覧画面</title>
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


          <ul class="nav navbar-nav navbar-right">
  						<li class="navbar-text">${loginUser.name} さん</li>
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




      <div class="text-right">
        <a href="UserCreate">新規登録</a>
      </div>


<%
String check = (String)request.getAttribute("check");
if(check!=null&&check.equals("OK")){
%>
  <div class="alert alert-success" role="alert">ユーザ情報の登録に成功しました</div>
<% }else if(check!=null&&check.equals("Delete") ){%>
  <div class="alert alert-success" role="alert">ユーザ情報の削除に成功しました</div>
<% } else if(check!=null&&check.equals("update")){%>
  <div class="alert alert-success" role="alert">ユーザ情報の更新に成功しました</div>
<%} %>
      <h1 align="center">ユーザー一覧</h1>


      <div class="panel-body">
        <div class="panel panel-primary">
            <div class="panel-heading">
                <div class="panel-title">検索条件</div>
            </div>
            <div class="panel-body">
              <form method="post" action="UserList" class="form-horizontal">
                <div class="form-group">
                  <label for="code" class="control-label col-sm-2">ログインID</label>
                  <div class="col-sm-6">
                    <input type="text" name="searchLogin_id" id="login-id"
                                        value="<%=Util.nullCheck((String)request.getParameter("searchLogin_id")) %>" class="form-control"/>
                    <input type="hidden" name="search" value="search" class="form-control"/>
                  </div>
                </div>
                <div class="form-group">
                  <label for="name" class="control-label col-sm-2">ユーザ名</label>
                  <div class="col-sm-6">
                    <input type="text" name="searchUserName" id="user-name" class="form-control"
                                             value="<%=Util.nullCheck((String)request.getParameter("searchUserName")) %>"/>
                  </div>
                </div>

                <div class="form-group">
                  <label for="continent" class="control-label col-sm-2">生年月日</label>
                  <div class="row">
                    <div class="col-sm-2">
                      <input type="date" name="startDate" id="date-start"
                                        value="<%=Util.nullCheck((String)request.getParameter("startDate")) %>"class="form-control"  size="30"/>
                    </div>
                    <div class="col-xs-1 text-center">
                      ~
                    </div>
                    <div class="col-sm-2">
                      <input type="date" name="endDate"
                                   value="<%=Util.nullCheck((String)request.getParameter("endDate")) %>" id="date-end" class="form-control"/>
                    </div>
                </div>
                </div>
                <div class="text-right">
                  <button type="submit" value="検索" class="btn btn-primary form-submit">検索</button>
                </div>
              </form>
          </div>
        </div>


          <div class="table-responsive">
             <table class="table table-striped table-bordered" class="table table-bordered">
               <thead>
                 <tr>
                   <th>ログインID</th>
                   <th>ユーザ名</th>
                   <th>生年月日</th>
                   <th></th>
                 </tr>
               </thead>
                <tbody>
               <%
                List<User> users =(List<User>)request.getAttribute("users");
		        for (User user:users) {
		        	%>
                 <tr>
                   <td><%= user.getLogin_id()%></td>
                   <td><%= user.getName()%></td>
                   <td><%= Util.formatBirth_date(user.getBirth_date())%></td>
                   <td>
                   <%
                    User loginUser = (User)session.getAttribute("loginUser");
                   %>

                     <form action="UserDetail" style=" display: inline; ">
                        <button class="btn btn-primary" >詳細</button>
                        <input type="hidden"  name="detailId" value=<%= user.getLogin_id()%>>
                     </form>

                      <% if((loginUser.getLogin_id()).equals("admin")||
                    		  (loginUser.getLogin_id()).equals(user.getLogin_id()) ) { %>
                     <form action="UserUpdate" style=" display: inline; ">
                       <button class="btn btn-success" type="submit">更新</button>
                       <input type="hidden"  name="updateId" value=<%= user.getLogin_id()%>>
                     </form>
                     <% }%>

                     <% if((loginUser.getLogin_id()).equals("admin") ) { %>
                     <form action="UserDelete" style=" display: inline; ">
                       <input type="hidden"  name="deleteId" value=<%= user.getLogin_id()%>>
                       <button class="btn btn-danger" type="submit" >削除</button>
                     </form>
                     <%
                     }
                     %>

                   </td>
                 </tr>
                 <%
                   }
                  %>
                  </tbody>
                </table>
              </div>
             </div>
            </div>

  </body>
</html>