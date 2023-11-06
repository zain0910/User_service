package com.example.demo.converter;

import java.util.Optional;
import org.springframework.stereotype.Component;
import com.example.demo.dto.UserDto;
import com.example.demo.model.User;

@Component
public class UserConverter {

	public User dtotoentity(UserDto userdto) {
		User user = new User();
		user.setId(userdto.getId());
		user.setUserName(userdto.getUesrName());

		return user;
	}

	public UserDto entitytodto(Optional<User> user) {
		UserDto userdto = new UserDto();
		userdto.setId(user.get().getId());
		userdto.setUesrName(user.get().getUserName());

		return userdto;
	}

}
