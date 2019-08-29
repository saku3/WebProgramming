package userManagement;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import model.User;
import util.Util;

/**
 * Servlet implementation class UserLogin
 */
@WebServlet("/UserLogin")
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLogin() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//フォワード
		HttpSession session = request.getSession();




	    //loginUserのセッションが残っているか
	    Object loginUser = session.getAttribute("loginUser");
	    if(loginUser!=null) {

	       RequestDispatcher dispatcher = request.getRequestDispatcher("UserList");
  	    		    //"/WEB-INF/jsp/userList.jsp");
           dispatcher.forward(request,response);
           return;

	    }

			request.setAttribute("check","");

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/index.jsp");
			dispatcher.forward(request,response);
			return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//リクエストパラメーターの取得
		request.setCharacterEncoding("UTF-8");

		String login_Id  = request.getParameter("login_Id");
		String pass = request.getParameter("pass");



		//DBからユーザーの情報を取得
		UserDao userDao = new UserDao();
		User loginUser = userDao.findById(login_Id);

		//ログイン判定
		if(loginUser!=null&&(Util.toCode(pass)).equals(loginUser.getPass())) {

			HttpSession session = request.getSession();
           	session.setAttribute("loginUser",loginUser);

           	//リダイレクトする
           	response.sendRedirect("UserList");


		}else {
			//エラーメッセージ

			request.setAttribute("check","loginError");


			RequestDispatcher dispatcher = request.getRequestDispatcher(
					                               "/WEB-INF/jsp/index.jsp");
			dispatcher.forward(request,response);

			return;

		}

	}
}
