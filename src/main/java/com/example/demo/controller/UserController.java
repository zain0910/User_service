package com.example.demo.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.dto.UserDto;
import com.example.demo.exception.UserNotFound;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
//import com.example.demo.service.UserService;
import com.example.demo.service.UserServiceImpl;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserRepository userRepository;
	@Autowired
	UserService userService;

	@GetMapping("/users")
	public List<User> findAllUsers() {
		return userService.findAllUsers();
	}

	@GetMapping("/{id}")
	public Optional<UserDto> getById(@PathVariable Integer id) throws UserNotFound {
		UserDto userDto = userService.getById(id);
		return Optional.ofNullable(userDto);
	}

	@GetMapping("/getbyusername/{userName}")
	public Optional<UserDto> getByuserName(@PathVariable String userName) throws UserNotFound {
		UserDto userDto = userService.getByuserName(userName);
		return Optional.ofNullable(userDto);
	}

	@PostMapping("/add/user")
	public ResponseEntity<String> addUser(@RequestBody UserDto userdto) {
		String msg = userService.addUser(userdto);
		return new ResponseEntity<String>(msg, HttpStatus.CREATED);
	}

	@PutMapping("/update/{id}/{userName}")
	public ResponseEntity<String> updateUser(@PathVariable Integer id, @PathVariable String userName) {
		String msg = userService.updateUser(id, userName);
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable Integer id) {
		String msg = userService.deleteUser(id);
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}

}
