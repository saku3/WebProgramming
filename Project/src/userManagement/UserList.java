package userManagement;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import model.User;

/**
 * Servlet implementation class UserList
 */
@WebServlet("/UserList")
public class UserList extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();

		request.setCharacterEncoding("UTF-8");
		UserDao userDao = new UserDao();
        List<User> users = userDao.findAll();


       	//setする
        request.setAttribute("users", users);

        ///test
	    //System.out.println(search);

	    //loginUserのセッションが残っているか
	    Object loginUser = session.getAttribute("loginUser");
	    if(loginUser!=null) {

	       RequestDispatcher dispatcher = request.getRequestDispatcher(
				      "/WEB-INF/jsp/userList.jsp");
           dispatcher.forward(request,response);
           return;

	    }

	    response.sendRedirect("UserLogin");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();

		request.setCharacterEncoding("UTF-8");
		UserDao userDao = new UserDao();
        List<User> users = userDao.findAll();


        //検索するとき
        String search = (String)request.getParameter("search");
        String searchLogin_id = (String)request.getParameter("searchLogin_id");
        String searchUserName =(String)request.getParameter("searchUserName");
        String startDate =(String)request.getParameter("startDate");
        String endDate =(String)request.getParameter("endDate");

       	if(search!=null&&search.equals("search")) {
       	   users = userDao.searchUser(searchLogin_id,searchUserName,startDate,endDate);

       	}

        //setする
        request.setAttribute("users", users);


        //loginUserのセッションが残っているか
	    Object loginUser = session.getAttribute("loginUser");
	    if(loginUser!=null) {

	       RequestDispatcher dispatcher = request.getRequestDispatcher(
				      "/WEB-INF/jsp/userList.jsp");
           dispatcher.forward(request,response);
           return;

	    }
	}

}
