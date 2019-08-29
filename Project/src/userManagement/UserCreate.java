package userManagement;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CreateUser;

/**
 * Servlet implementation class UserCreate
 */
@WebServlet("/UserCreate")
public class UserCreate extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserCreate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");

		request.setAttribute("check","");

	    //loginUserのセッションが残っているか
	    Object loginUser = session.getAttribute("loginUser");
	    if(loginUser!=null) {

	       RequestDispatcher dispatcher = request.getRequestDispatcher(
				      "/WEB-INF/jsp/userCreate.jsp");
           dispatcher.forward(request,response);
           return;
	    }

	    response.sendRedirect("UserLogin");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

	    //新規登録
        String loginId = (String)request.getParameter("loginId");
        String pass =(String)request.getParameter("pass");
        String passConfirm =(String)request.getParameter("passConfirm");
        String userName =(String)request.getParameter("userName");
        String birthDate =(String)request.getParameter("birthDate");
        //パスワード以外の入力内容を残す
        //test
        //System.out.println(loginId+pass+userName+passConfirm+birthDate);

        boolean check = CreateUser.userInsert(loginId,pass,passConfirm,userName,birthDate);


        if(check) {
           request.setAttribute("check","OK");
	       RequestDispatcher dispatcher = request.getRequestDispatcher("UserList");
				      //"/WEB-INF/jsp/userCreate.jsp");
           dispatcher.forward(request,response);
           return;
        }else {
        	   request.setAttribute("check","NG");
        	   RequestDispatcher dispatcher = request.getRequestDispatcher(
		       "/WEB-INF/jsp/userCreate.jsp");
           dispatcher.forward(request,response);
           return;
        }
	}

}
