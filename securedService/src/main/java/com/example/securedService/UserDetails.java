package com.example.securedService;

public class UserDetails {
	UserSearchDetails userSearchDetails;
	String name;
	String address;

	public UserSearchDetails getUserSearchDetails() {
		return userSearchDetails;
	}

	public void setUserSearchDetails(UserSearchDetails userSearchDetails) {
		this.userSearchDetails = userSearchDetails;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "UserDetails [userSearchDetails=" + userSearchDetails + ", name=" + name + ", address=" + address + "]";
	}

}
