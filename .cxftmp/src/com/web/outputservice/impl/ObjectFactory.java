
package com.web.outputservice.impl;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.web.outputservice.impl package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetPersonById_QNAME = new QName("http://impl.outputService.web.com/", "getPersonById");
    private final static QName _GetPersonByIdResponse_QNAME = new QName("http://impl.outputService.web.com/", "getPersonByIdResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.web.outputservice.impl
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetPersonById }
     * 
     */
    public GetPersonById createGetPersonById() {
        return new GetPersonById();
    }

    /**
     * Create an instance of {@link GetPersonByIdResponse }
     * 
     */
    public GetPersonByIdResponse createGetPersonByIdResponse() {
        return new GetPersonByIdResponse();
    }

    /**
     * Create an instance of {@link Person }
     * 
     */
    public Person createPerson() {
        return new Person();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPersonById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://impl.outputService.web.com/", name = "getPersonById")
    public JAXBElement<GetPersonById> createGetPersonById(GetPersonById value) {
        return new JAXBElement<GetPersonById>(_GetPersonById_QNAME, GetPersonById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPersonByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://impl.outputService.web.com/", name = "getPersonByIdResponse")
    public JAXBElement<GetPersonByIdResponse> createGetPersonByIdResponse(GetPersonByIdResponse value) {
        return new JAXBElement<GetPersonByIdResponse>(_GetPersonByIdResponse_QNAME, GetPersonByIdResponse.class, null, value);
    }

}
