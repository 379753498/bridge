
package com.zeone.datalink.webservice.service.cxf;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.zeone.datalink.webservice.service.cxf package. 
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

    private final static QName _SendVehicleWeightResponse_QNAME = new QName("http://cxf.service.webservice.dataLink.zeone.com/", "sendVehicleWeightResponse");
    private final static QName _SendVehicleWeight_QNAME = new QName("http://cxf.service.webservice.dataLink.zeone.com/", "sendVehicleWeight");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.zeone.datalink.webservice.service.cxf
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SendVehicleWeightResponse }
     * 
     */
    public SendVehicleWeightResponse createSendVehicleWeightResponse() {
        return new SendVehicleWeightResponse();
    }

    /**
     * Create an instance of {@link SendVehicleWeight }
     * 
     */
    public SendVehicleWeight createSendVehicleWeight() {
        return new SendVehicleWeight();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SendVehicleWeightResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cxf.service.webservice.dataLink.zeone.com/", name = "sendVehicleWeightResponse")
    public JAXBElement<SendVehicleWeightResponse> createSendVehicleWeightResponse(SendVehicleWeightResponse value) {
        return new JAXBElement<SendVehicleWeightResponse>(_SendVehicleWeightResponse_QNAME, SendVehicleWeightResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SendVehicleWeight }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cxf.service.webservice.dataLink.zeone.com/", name = "sendVehicleWeight")
    public JAXBElement<SendVehicleWeight> createSendVehicleWeight(SendVehicleWeight value) {
        return new JAXBElement<SendVehicleWeight>(_SendVehicleWeight_QNAME, SendVehicleWeight.class, null, value);
    }

}
