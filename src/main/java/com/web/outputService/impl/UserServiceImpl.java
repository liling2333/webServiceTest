package com.web.outputService.impl;

import javax.annotation.Resource;
import javax.jws.WebService;

import com.web.dao.PersonDao;
import com.web.outputService.UserService;
import com.web.pojo.Person;

@WebService(targetNamespace="http://outputService.web.com/")
public class UserServiceImpl implements UserService{

	@Resource
	private PersonDao personDao;
	
	@Override
	public Person getPersonById(int id) {

		Person person = personDao.selectByPrimaryKey(id);
		return person;
	}

}
