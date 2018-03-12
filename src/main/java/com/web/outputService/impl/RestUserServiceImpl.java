package com.web.outputService.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.ws.rs.core.Response;

import com.web.outputService.RestUserService;
import com.web.pojo.User;

public class RestUserServiceImpl implements RestUserService {

	private HashMap<String, User> users = new HashMap<String, User>();

	public RestUserServiceImpl() {
		init();
	}

	@Override
	public Response addUser(User user) {
		users.put(user.getId(), user);
		System.out.println("添加用户成功");
		System.out.println(users.size());
		System.out.println(users.get("2").getName());
		return Response.ok().build();
	}

	@Override
	public Response delUser(String id) {
		users.remove(id);
		System.out.println(users.size());
		return Response.ok().build();
	}

	@Override
	public Response updateUser(User user) {
		users.put(user.getId(), user);
		System.out.println(users.get("1").getName());
		return Response.ok().build();
	}

	@Override
	public User getUserById(String id) {
		return users.get(id);
	}

	@Override
	public List<User> findAllUsers() {
		List<User> userlist = new ArrayList<User>();
		userlist.add(users.get("1"));
		return userlist;
	}

	private void init() {
		User user = new User();
		user.setId("1");
		user.setName("温欢");
		users.put(user.getId(), user);
	}
}
