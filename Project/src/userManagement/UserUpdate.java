package userManagement;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UpdateUser;
import dao.UserDao;
import model.User;

/**
 * Servlet implementation class UserUpdate
 */
@WebServlet("/UserUpdate")
public class UserUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		request.setAttribute("check","");

		request.setCharacterEncoding("UTF-8");
	    String updateId = (String)request.getParameter("updateId");

	    //loginUserのセッションが残っているか
	    Object loginUser = session.getAttribute("loginUser");



    	    if(loginUser!=null&&updateId!=null) {

    	    	    //DBからユーザーの情報を取得
    			UserDao userDao = new UserDao();
    			User updateUser = userDao.findById(updateId);
    			request.setAttribute("updateUser", updateUser);

	        RequestDispatcher dispatcher = request.getRequestDispatcher(
				      "/WEB-INF/jsp/userUpdate.jsp");
            dispatcher.forward(request,response);

            return;

	    }


	    response.sendRedirect("UserList");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String updateId = (String)request.getParameter("updateId");
		String password = (String)request.getParameter("password");
		String passwordConfirm = (String)request.getParameter("passwordConfirm");
		String userName  = (String)request.getParameter("userName");
		String birthDate = (String)request.getParameter("birthDate");

		boolean check = UpdateUser.userUpdate(updateId, password, passwordConfirm, userName, birthDate);

		//成功したかcheck
		if(check) {
			request.setAttribute("check","update");

			//ユーザー一覧画面に移動する
		    RequestDispatcher dispatcher = request.getRequestDispatcher("UserList");
            dispatcher.forward(request,response);
            return;

		}else {
			UserDao userDao = new UserDao();
			User updateUser = userDao.findById(updateId);
			request.setAttribute("updateUser", updateUser);
			request.setAttribute("check","NG");

			//失敗したら更新ページに移動
     	    RequestDispatcher dispatcher = request.getRequestDispatcher(//"UserUpdate");
		      "/WEB-INF/jsp/userUpdate.jsp");
            dispatcher.forward(request,response);
            return;
		}
	}

}
