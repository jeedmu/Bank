package dk.eamv.bank.ejb.ws;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;

import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.2.5-jbossorg-1
 * 2019-03-18T15:22:25.171+01:00
 * Generated source version: 3.2.5-jbossorg-1
 *
 */
@WebServiceClient(name = "ForeignEntryNetsBeanService",
                  targetNamespace = "http://ejb.bank.eamv.dk/")
public class ForeignEntryNetsBeanService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://ejb.bank.eamv.dk/", "ForeignEntryNetsBeanService");
    public final static QName ForeignEntryNetsBeanPort = new QName("http://ejb.bank.eamv.dk/", "ForeignEntryNetsBeanPort");
    static {
    	/*
    	 * Maybe later change or add a "retrieve url from property"
    	 */
        WSDL_LOCATION = getWsdlURL();
    }
    
    private static URL getWsdlURL()
    {
    	URL url = null;
    	String urlAddress = "";
	    try {
	    	InetAddress addr = InetAddress.getLocalHost();
			String hostname = addr.getHostName();
			urlAddress = "http://"+hostname+":8080/bank.ejb/ForeignEntryNetsBean?wsdl";
		    url = new URL(urlAddress);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			java.util.logging.Logger.getLogger(ForeignEntryNetsBeanService.class.getName())
            .log(java.util.logging.Level.INFO,
                 "Can not initialize the default wsdl from {0}", urlAddress);
		}
	    
	    return url;
    }

    public ForeignEntryNetsBeanService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public ForeignEntryNetsBeanService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ForeignEntryNetsBeanService() {
        super(WSDL_LOCATION, SERVICE);
    }

    public ForeignEntryNetsBeanService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public ForeignEntryNetsBeanService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public ForeignEntryNetsBeanService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }




    /**
     *
     * @return
     *     returns ForeignEntryNetsBean
     */
    @WebEndpoint(name = "ForeignEntryNetsBeanPort")
    public ForeignEntryNetsBean getForeignEntryNetsBeanPort() {
        return super.getPort(ForeignEntryNetsBeanPort, ForeignEntryNetsBean.class);
    }

    /**
     *
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ForeignEntryNetsBean
     */
    @WebEndpoint(name = "ForeignEntryNetsBeanPort")
    public ForeignEntryNetsBean getForeignEntryNetsBeanPort(WebServiceFeature... features) {
        return super.getPort(ForeignEntryNetsBeanPort, ForeignEntryNetsBean.class, features);
    }

}
