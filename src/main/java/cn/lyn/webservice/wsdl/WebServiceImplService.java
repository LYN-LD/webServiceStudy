
package cn.lyn.webservice.wsdl;

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
@WebServiceClient(name = "WebServiceImplService", targetNamespace = "http://impl.serviceone.webservice.lyn.cn/", wsdlLocation = "http://127.0.0.1:8080/webservice/sayhello?wsdl")
public class WebServiceImplService
    extends Service
{

    private final static URL WEBSERVICEIMPLSERVICE_WSDL_LOCATION;
    private final static WebServiceException WEBSERVICEIMPLSERVICE_EXCEPTION;
    private final static QName WEBSERVICEIMPLSERVICE_QNAME = new QName("http://impl.serviceone.webservice.lyn.cn/", "WebServiceImplService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://127.0.0.1:8080/webservice/sayhello?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        WEBSERVICEIMPLSERVICE_WSDL_LOCATION = url;
        WEBSERVICEIMPLSERVICE_EXCEPTION = e;
    }

    public WebServiceImplService() {
        super(__getWsdlLocation(), WEBSERVICEIMPLSERVICE_QNAME);
    }

    public WebServiceImplService(WebServiceFeature... features) {
        super(__getWsdlLocation(), WEBSERVICEIMPLSERVICE_QNAME, features);
    }

    public WebServiceImplService(URL wsdlLocation) {
        super(wsdlLocation, WEBSERVICEIMPLSERVICE_QNAME);
    }

    public WebServiceImplService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, WEBSERVICEIMPLSERVICE_QNAME, features);
    }

    public WebServiceImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public WebServiceImplService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns WebServiceImpl
     */
    @WebEndpoint(name = "WebServiceImplPort")
    public WebServiceImpl getWebServiceImplPort() {
        return super.getPort(new QName("http://impl.serviceone.webservice.lyn.cn/", "WebServiceImplPort"), WebServiceImpl.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns WebServiceImpl
     */
    @WebEndpoint(name = "WebServiceImplPort")
    public WebServiceImpl getWebServiceImplPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://impl.serviceone.webservice.lyn.cn/", "WebServiceImplPort"), WebServiceImpl.class, features);
    }

    private static URL __getWsdlLocation() {
        if (WEBSERVICEIMPLSERVICE_EXCEPTION!= null) {
            throw WEBSERVICEIMPLSERVICE_EXCEPTION;
        }
        return WEBSERVICEIMPLSERVICE_WSDL_LOCATION;
    }

}
