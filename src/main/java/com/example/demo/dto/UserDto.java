package com.example.demo.dto;

import org.springframework.stereotype.Component;

public class UserDto {
	
	private Integer id;
	private String userName;
	
	public UserDto(Integer id, String userName) {
		super();
		this.id = id;
		this.userName = userName;
	}

	public UserDto() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUesrName() {
		return userName;
	}

	public void setUesrName(String userName) {
		this.userName = userName;
	}
	
	

}
