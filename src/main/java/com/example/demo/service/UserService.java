package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.example.demo.dto.UserDto;
import com.example.demo.exception.UserNotFound;
import com.example.demo.model.User;


public interface UserService {

	public String addUser(UserDto userdto);

	public String updateUser(Integer id, String userName);

	public UserDto getById(Integer id) throws UserNotFound;

	public UserDto getByuserName(String userName) throws UserNotFound;

	public List<User> findAllUsers();

	public String deleteUser(Integer id);

}
