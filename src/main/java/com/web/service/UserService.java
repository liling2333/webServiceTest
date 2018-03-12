package com.web.service;

import org.springframework.stereotype.Service;

import com.web.pojo.Person;

@Service
public interface UserService {

	/**
	 * 根据id查询用户信息
	 * @param id
	 * @return
	 */
	public Person getPersonById(int id);
}
