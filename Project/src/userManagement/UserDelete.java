package userManagement;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DeleteUser;

/**
 * Servlet implementation class UserDelete
 */
@WebServlet("/UserDelete")
public class UserDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserDelete() {
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

		String deleteId = (String)request.getParameter("deleteId");

	    //loginUserのセッションが残っているか
	    Object loginUser = session.getAttribute("loginUser");
	    if(loginUser!=null&&deleteId!=null) {

	       RequestDispatcher dispatcher = request.getRequestDispatcher(
				      "/WEB-INF/jsp/userDelete.jsp");
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

		String deleteId = (String)request.getParameter("deleteId");

		boolean check = DeleteUser.userDelete(deleteId);
		if(check) {
			request.setAttribute("check","Delete");
			RequestDispatcher dispatcher = request.getRequestDispatcher("UserList");
	        dispatcher.forward(request,response);

	        return;
		}


	}

}
