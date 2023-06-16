package com.decorizeLivspace.service;

import com.decorizeLivspace.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.decorizeLivspace.dto.UserRegistrationDto;

import java.util.List;

public interface UserService extends UserDetailsService{
	User save(UserRegistrationDto registrationDto);

	List<User> getAllUsers();

	User getUserById(Long id);

	void deleteUser(Long id);
}
