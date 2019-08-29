package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.User;
import util.Util;


public class UserDao {
	public List<User> findAll(){
	Connection conn = null;
	List<User> userList = new ArrayList<User>();

	try {
		//データベースへ接続
		conn = DBManager.getConnection();

		//SELECT 文を準備
		String sql = "SELECT * FROM UserInfo";

		//SELECTを実行し、結果表を取得
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);

		//結果表に格納されたレコードの内容を
		//Userインスタンスに設定し、ArrayListインスタンスに追加
		while(rs.next()) {

			if(rs.getString("login_id").equals("admin")){continue;}

			int id = rs.getInt("id");
			String login_id = rs.getString("login_id");
			String name = rs.getString("name");
			String birth_date = rs.getString("birth_date");
			String pass= rs.getString("password");
			String create_date = rs.getString("create_date");
			String update_date = rs.getString("update_date");

			User user = new User(id,login_id, name, birth_date, pass, create_date, update_date);
			userList.add(user);

		}
	}catch(SQLException e) {
		e.printStackTrace();
		return null;
	}finally {
		//データベース切断
		if(conn!=null) {
			try {
				conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
				return null;
			}
		}
	}
    return userList;
	}

	public User findById(String targetId) {
		Connection conn = null;

	try {
		conn = DBManager.getConnection();

		String sql = "SELECT id,login_id,name,birth_date,password,"
				+ "create_date,update_date FROM UserInfo WHERE login_id ='"+targetId+"'" ;

		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);

		if(!rs.next()) {
			return null;
		}

		int id = rs.getInt("id");
		String login_id = rs.getString("login_id");
		String name = rs.getString("name");
		String birth_date = rs.getString("birth_date");
		String pass= rs.getString("password");
		String create_date = rs.getString("create_date");
		String update_date = rs.getString("update_date");

		return new User(id,login_id,name,birth_date,pass,create_date,update_date);

	}catch(SQLException e) {
		e.printStackTrace();
		return null;
	}finally {
		//データベース切断
		if(conn!=null) {
			try {
				conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
				return null;
			}
		}
    }
}

	/*
	 * *ユーザー検索機能
	 */
	public List<User> searchUser(String targetId,String targetName,String startDate,String endDate) {
		Connection conn = null;
		List<User> userList = new ArrayList<User>();
	try {
		conn = DBManager.getConnection();

		String sql = "SELECT id,login_id,name,birth_date,password,"
				+ "create_date,update_date FROM UserInfo ";

		//前の項目に入力があるか判断し、なければwhereで、あればandで繋げていく
		String where ="WHERE";
		String and ="AND";
		boolean flag = false;

		if(targetId!=""){
		    String str = "WHERE login_id ='"+targetId+"'" ;
			sql+=str;
			flag=true;
		}

		if(targetName!="") {
			String str = " name LIKE '%"+targetName+"%'";

			if(flag==true) {
				str = and+str;
			}
			else {
				str = where+str;
				flag = true;
			}
			sql+=str;
		}

		if(startDate!="") {
			String str = " DATEDIFF(birth_date,'"+Util.formatDate(startDate)+"') >=0 ";
			if(flag==true) {
				str = and+str;
			}else {
				str = where+str;
				flag = true;
			}
			sql+=str;
		}

		if(endDate!="") {
			String str = " DATEDIFF(birth_date,' "+Util.formatDate(endDate)+" ') <= 0 ";
			if(flag==true) {
				str = and+str;
			}else {
				str = where+str;
			}
			sql+=str;
		}

		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);

		//結果表に格納されたレコードの内容を
		//Userインスタンスに設定し、ArrayListインスタンスに追加
		while(rs.next()) {

		if(rs.getString("login_id").equals("admin")){continue;}

		int id = rs.getInt("id");
		String login_id = rs.getString("login_id");
		String name = rs.getString("name");
		String birth_date = rs.getString("birth_date");
		String pass= rs.getString("password");
		String create_date = rs.getString("create_date");
		String update_date = rs.getString("update_date");

		User user = new User(id,login_id, name, birth_date, pass, create_date, update_date);
		userList.add(user);

		}

		return userList;

	}catch(SQLException e) {
		e.printStackTrace();
		return null;
	}finally {
		//データベース切断
		if(conn!=null) {
			try {
				conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
				return null;
			}
		}
    }
}


}
