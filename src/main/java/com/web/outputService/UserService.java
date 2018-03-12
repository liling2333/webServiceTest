package com.web.outputService;

import javax.jws.WebService;

import com.web.pojo.Person;

/**
 * soap webservice服务类
 * @author liling
 *
 */
@WebService
public interface UserService {

	/**
	 * 根据id查询用户信息
	 * @param id
	 * @return
	 */
	public Person getPersonById(int id);
}
