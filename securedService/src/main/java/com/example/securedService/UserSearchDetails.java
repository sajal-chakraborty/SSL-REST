package com.example.securedService;

public class UserSearchDetails {
	String userid;

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	@Override
	public String toString() {
		return "UserSearchDetails [userid=" + userid + "]";
	}

}
