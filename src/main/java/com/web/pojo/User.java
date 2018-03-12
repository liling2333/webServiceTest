package com.web.pojo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

//一定要使用XmlRootElement注解进行标注
@XmlRootElement(name = "User")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	private String id;
	private String name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
