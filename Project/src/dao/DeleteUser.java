package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


public class DeleteUser {
	public static boolean userDelete(String deleteId) {
		Connection conn = null;
	try {
		conn = DBManager.getConnection();



		String sql = "DELETE FROM userInfo WHERE login_id ='"+deleteId+"'";


		//test
		//System.out.println(sql);

		Statement stmt = conn.createStatement();
		int rs = stmt.executeUpdate(sql);

		return true;

	}catch(SQLException e) {
		e.printStackTrace();
		return false;
	}finally {
		//データベース切断
		if(conn!=null) {
			try {
				conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
				return false;
			}
		}
    }
  }
}