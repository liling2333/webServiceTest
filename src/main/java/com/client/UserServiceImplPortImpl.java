
/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

package com.client;

import java.util.logging.Logger;

/**
 * This class was generated by Apache CXF 3.1.11
 * 2018-02-01T17:05:18.973+08:00
 * Generated source version: 3.1.11
 * 
 */

@javax.jws.WebService(
                      serviceName = "UserServiceImplService",
                      portName = "UserServiceImplPort",
                      targetNamespace = "http://outputService.web.com/",
                      wsdlLocation = "http://localhost:8080/webServiceTest/webservice/getPersonById?wsdl",
                      endpointInterface = "com.client.UserService")
                      
public class UserServiceImplPortImpl implements UserService {

    private static final Logger LOG = Logger.getLogger(UserServiceImplPortImpl.class.getName());

    /* (non-Javadoc)
     * @see com.client.UserService#getPersonById(int arg0)*
     */
    public com.client.Person getPersonById(int arg0) { 
        LOG.info("Executing operation getPersonById");
        System.out.println(arg0);
        try {
            com.client.Person _return = new com.client.Person();
            _return.setAge(Integer.valueOf(-1878653657));
            _return.setId(Integer.valueOf(74555088));
            _return.setName("Name1980850537");
            _return.setSex("Sex-818590633");
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

}