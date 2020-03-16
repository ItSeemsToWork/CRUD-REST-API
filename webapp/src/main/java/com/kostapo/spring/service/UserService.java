package com.kostapo.spring.service;

import java.util.List;

import com.kostapo.spring.model.User;

public interface UserService {
	
	int add(User user);

	User get(int id);

	List<User> list();

	void update(int id, User book);

	void delete(int id);
	
}
