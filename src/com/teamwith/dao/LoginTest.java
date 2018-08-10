package com.teamwith.dao;

public class LoginTest {
	public static void main(String[] args) {
		LoginServiceDao ld = LoginServiceDao.getInstance();
		System.out.println(ld.existMember("joran1", "k123456!"));
		System.out.println(ld.existMember("joran1", "123456!"));
		System.out.println(ld.login("joran1", "k123456!"));
	}
	
	   
	   
}
