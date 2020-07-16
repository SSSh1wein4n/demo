package com.personal.demo.dubbo.demo.rpc.api.impl;

import org.apache.dubbo.config.annotation.Service;

import com.personal.demo.dubbo.demo.rpc.api.User;
import com.personal.demo.dubbo.demo.rpc.api.UserService;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * In-Memory {@link UserService} implementation.
 * @author oop
 */
@Service(protocol = "dubbo")
public class InMemoryUserServiceImpl implements UserService {

	private Map<Long, User> usersRepository = new HashMap<>();

	@Override
	public boolean save(User user) {
		return usersRepository.put(user.getId(), user) == null;
	}

	@Override
	public boolean remove(Long userId) {
		return usersRepository.remove(userId) != null;
	}

	@Override
	public Collection<User> findAll() {
		return usersRepository.values();
	}

}
