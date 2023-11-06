package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.converter.UserConverter;
import com.example.demo.dto.UserDto;
import com.example.demo.exception.UserNotFound;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepository;
	@Autowired
	UserConverter userConverter;

	public String addUser(UserDto userdto) {
		userRepository.save(userConverter.dtotoentity(userdto));
		return "User added successfully";
	}

	public String updateUser(Integer id, String userName) {
		Optional<User> userOptional = Optional.of(new User());
		userOptional = userRepository.findById(id);
		if (userOptional.isPresent()) {
			User user = userOptional.get();
			user.setUserName(userName);
			userRepository.save(user);
			return "User updated successfully";
		} else {
			return "User not found";
		}
	}

	public UserDto getById(Integer id) throws UserNotFound {
		try {
			Optional<User> userOptional = Optional.of(new User());
			userOptional = userRepository.findById(id);
			UserDto userDto = userConverter.entitytodto(userOptional);
			return userDto;
		} catch (Exception e) {
			throw new UserNotFound("User with id " + id + " not found");
		}
	}

	public UserDto getByuserName(String userName) throws UserNotFound {
		try {
			Optional<User> userOptional = Optional.of(new User());
			userOptional = userRepository.findByuserName(userName);
			UserDto userDto = userConverter.entitytodto(userOptional);
			return userDto;
		} catch (Exception e) {
			throw new UserNotFound("User with username " + userName + " not found");
		}
	}

	public List<User> findAllUsers() {
		List<User> users = new ArrayList<>();
		userRepository.findAll().forEach(users::add);
		return users;
	}

	public String deleteUser(Integer id) {
		Optional<User> user = Optional.of(new User());
		user = userRepository.findById(id);
		if (user.isPresent()) {
			userRepository.deleteById(id);
			return "User deleted successfully";
		} else {
			return "User not found";
		}
	}

}
