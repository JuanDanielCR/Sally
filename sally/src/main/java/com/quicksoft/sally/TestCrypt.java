package com.quicksoft.sally;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class TestCrypt {

	public static void main(String[] args) {
		BCryptPasswordEncoder be=new BCryptPasswordEncoder();
		System.out.println("pe: "+be.encode("admin123"));

	}

}