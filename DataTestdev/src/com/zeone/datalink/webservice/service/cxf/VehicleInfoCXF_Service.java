
package com.zeone.datalink.webservice.service.cxf;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "VehicleInfoCXF", targetNamespace = "http://cxf.service.webservice.dataLink.zeone.com/", wsdlLocation = "http://112.27.198.15:9009/bridge/services/VehicleInfoCXF?wsdl")
public class VehicleInfoCXF_Service
    extends Service
{

    private final static URL VEHICLEINFOCXF_WSDL_LOCATION;
    private final static WebServiceException VEHICLEINFOCXF_EXCEPTION;
    private final static QName VEHICLEINFOCXF_QNAME = new QName("http://cxf.service.webservice.dataLink.zeone.com/", "VehicleInfoCXF");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://10.5.4.5:1087/bridge/services/VehicleInfoCXF?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        VEHICLEINFOCXF_WSDL_LOCATION = url;
        VEHICLEINFOCXF_EXCEPTION = e;
    }

    public VehicleInfoCXF_Service() {
        super(__getWsdlLocation(), VEHICLEINFOCXF_QNAME);
    }

    public VehicleInfoCXF_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), VEHICLEINFOCXF_QNAME, features);
    }

    public VehicleInfoCXF_Service(URL wsdlLocation) {
        super(wsdlLocation, VEHICLEINFOCXF_QNAME);
    }

    public VehicleInfoCXF_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, VEHICLEINFOCXF_QNAME, features);
    }

    public VehicleInfoCXF_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public VehicleInfoCXF_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns VehicleInfoCXF
     */
    @WebEndpoint(name = "VehicleInfoCXFImplPort")
    public VehicleInfoCXF getVehicleInfoCXFImplPort() {
        return super.getPort(new QName("http://cxf.service.webservice.dataLink.zeone.com/", "VehicleInfoCXFImplPort"), VehicleInfoCXF.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns VehicleInfoCXF
     */
    @WebEndpoint(name = "VehicleInfoCXFImplPort")
    public VehicleInfoCXF getVehicleInfoCXFImplPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://cxf.service.webservice.dataLink.zeone.com/", "VehicleInfoCXFImplPort"), VehicleInfoCXF.class, features);
    }

    private static URL __getWsdlLocation() {
        if (VEHICLEINFOCXF_EXCEPTION!= null) {
            throw VEHICLEINFOCXF_EXCEPTION;
        }
        return VEHICLEINFOCXF_WSDL_LOCATION;
    }

}
