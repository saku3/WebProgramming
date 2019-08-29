package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import util.Util;


public class UpdateUser {
	public static boolean userUpdate(String updateId,String password,String passwordConfirm, String userName,String birthDate) {
		Connection conn = null;
	try {
		conn = DBManager.getConnection();

		//未入力チェック
		
	    if(userName==""||birthDate.length()!=10) {
		    return false;
		}

		if(!(password.equals(passwordConfirm))) {
			return false;
		}

		birthDate = Util.formatDate(birthDate);
		password = Util.toCode(password);

		//現在時刻の取得
		Date date = new Date();
		SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String fdate = d.format(date);

		String sql = "UPDATE UserInfo SET ";
		String where = " WHERE login_id ='"+updateId+"'";

		if(!(password==""||passwordConfirm=="")){
		   sql +=" password='"+password+"',";
		}
		sql +=" name='"+userName+"',";
		sql +=" birth_date='"+birthDate+"',";
		sql +=" update_date='"+fdate+"'";
		sql +=where;


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
