package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import util.Util;


public class CreateUser {
	public static boolean userInsert(String loginId,String pass,String passConfirm,
			               String name,String birthDate) {
		Connection conn = null;
	try {
		conn = DBManager.getConnection();

		//未入力チェック
		if(loginId==""||pass==""||passConfirm==""||name==""||birthDate=="") {
			return false;
		}

		//入力が正しいかのチェック
		if(!(pass.equals(passConfirm))||!(birthDate.length()==10)) {
			return false;
		}

		birthDate = Util.formatDate(birthDate);
		pass = Util.toCode(pass);
		//System.out.println(pass);

		//現在時刻の取得
		Date date = new Date();
		SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String fdate = d.format(date);

		String sql = "INSERT INTO userInfo(login_id,name,birth_date,password,create_date,update_date)"
		             + "VALUES ('"+loginId+"','"+name+"','"+birthDate+"','"+pass+"',"
				     +"'"+fdate+"','"+fdate+"')";

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
