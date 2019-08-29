package model;

import java.io.Serializable;

import util.Util;

public class User implements Serializable {
	int userId;
	String login_id;
	String name;
	String birth_date;
	String pass;
	String create_date;
	String update_date;
	String format_birth_date;
	String format_create_date;
	String format_update_date;


	public User(int Id,String login_id, String name,String birth_date,String pass,String create_date,String update_date) {
		this.userId = Id;
		this.login_id = login_id;
		this.name= name;
		this.birth_date = birth_date;
		this.pass = pass;
		this.create_date = create_date;
		this.update_date = update_date;
		this.format_birth_date = Util.formatBirth_date(this.birth_date);
		this.format_create_date = Util.formatUserDate(this.create_date);
		this.format_update_date = Util.formatUserDate(this.update_date);

	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getLogin_id() {
		return login_id;
	}


	public void setLogin_id(String login_id) {
		this.login_id = login_id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getBirth_date() {
		return birth_date;
	}


	public void setBirth_date(String birth_date) {
		this.birth_date = birth_date;
	}


	public String getPass() {
		return pass;
	}


	public void setPass(String pass) {
		this.pass = pass;
	}


	public String getCreate_date() {
		return create_date;
	}


	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}


	public String getUpdate_date() {
		return update_date;
	}


	public void setUpdate_date(String update_date) {
		this.update_date = update_date;
	}


	public String getFormat_birth_date() {
		return format_birth_date;
	}


	public void setFormat_birth_date(String format_birth_date) {
		this.format_birth_date = format_birth_date;
	}


	public String getFormat_create_date() {
		return format_create_date;
	}


	public void setFormat_create_date(String format_create_date) {
		this.format_create_date = format_create_date;
	}


	public String getFormat_update_date() {
		return format_update_date;
	}


	public void setFormat_update_date(String format_update_date) {
		this.format_update_date = format_update_date;
	}



}
