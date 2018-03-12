package com.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.web.pojo.Person;
import com.web.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;

	@ResponseBody
	@RequestMapping("/user/{id}")
	public Person getUserById(@PathVariable int id){
		return userService.getPersonById(id);
	}
}
