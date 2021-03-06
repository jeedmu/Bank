package dk.eamv.bank.ejb.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.2.5-jbossorg-1
 * 2019-03-18T15:22:25.142+01:00
 * Generated source version: 3.2.5-jbossorg-1
 *
 */
@WebService(targetNamespace = "http://ejb.bank.eamv.dk/", name = "ForeignEntryNetsBean")
@XmlSeeAlso({ObjectFactory.class})
public interface ForeignEntryNetsBean {

    @WebMethod(operationName = "CreateNetsRequest")
    @RequestWrapper(localName = "CreateNetsRequest", targetNamespace = "http://ejb.bank.eamv.dk/", className = "dk.eamv.bank.ejb.ws.CreateNetsRequest")
    @ResponseWrapper(localName = "CreateNetsRequestResponse", targetNamespace = "http://ejb.bank.eamv.dk/", className = "dk.eamv.bank.ejb.ws.CreateNetsRequestResponse")
    @WebResult(name = "return", targetNamespace = "")
    public boolean createNetsRequest(
        @WebParam(name = "arg0", targetNamespace = "")
        dk.eamv.bank.ejb.ws.Entry arg0
    );
}
