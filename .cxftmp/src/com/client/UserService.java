package com.client;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.1.11
 * 2018-02-01T17:05:18.983+08:00
 * Generated source version: 3.1.11
 * 
 */
@WebService(targetNamespace = "http://outputService.web.com/", name = "UserService")
@XmlSeeAlso({ObjectFactory.class})
public interface UserService {

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "getPersonById", targetNamespace = "http://outputService.web.com/", className = "com.client.GetPersonById")
    @WebMethod
    @ResponseWrapper(localName = "getPersonByIdResponse", targetNamespace = "http://outputService.web.com/", className = "com.client.GetPersonByIdResponse")
    public com.client.Person getPersonById(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0
    );
}
