package com.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.dao.PersonDao;
import com.web.pojo.Person;
import com.web.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private PersonDao personDao;
	
	@Override
	public Person getPersonById(int id) {
		Person person = personDao.selectByPrimaryKey(id);
		return person;
	}

}
