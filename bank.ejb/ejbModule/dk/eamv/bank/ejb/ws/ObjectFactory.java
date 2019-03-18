
package dk.eamv.bank.ejb.ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the dk.eamv.bank.ejb.ws package. 
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

    private final static QName _CreateNetsRequest_QNAME = new QName("http://ejb.bank.eamv.dk/", "CreateNetsRequest");
    private final static QName _CreateNetsRequestResponse_QNAME = new QName("http://ejb.bank.eamv.dk/", "CreateNetsRequestResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: dk.eamv.bank.ejb.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CreateNetsRequest }
     * 
     */
    public CreateNetsRequest createCreateNetsRequest() {
        return new CreateNetsRequest();
    }

    /**
     * Create an instance of {@link CreateNetsRequestResponse }
     * 
     */
    public CreateNetsRequestResponse createCreateNetsRequestResponse() {
        return new CreateNetsRequestResponse();
    }

    /**
     * Create an instance of {@link Entry }
     * 
     */
    public Entry createEntry() {
        return new Entry();
    }

    /**
     * Create an instance of {@link LocalDateTime }
     * 
     */
    public LocalDateTime createLocalDateTime() {
        return new LocalDateTime();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateNetsRequest }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CreateNetsRequest }{@code >}
     */
    @XmlElementDecl(namespace = "http://ejb.bank.eamv.dk/", name = "CreateNetsRequest")
    public JAXBElement<CreateNetsRequest> createCreateNetsRequest(CreateNetsRequest value) {
        return new JAXBElement<CreateNetsRequest>(_CreateNetsRequest_QNAME, CreateNetsRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateNetsRequestResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CreateNetsRequestResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://ejb.bank.eamv.dk/", name = "CreateNetsRequestResponse")
    public JAXBElement<CreateNetsRequestResponse> createCreateNetsRequestResponse(CreateNetsRequestResponse value) {
        return new JAXBElement<CreateNetsRequestResponse>(_CreateNetsRequestResponse_QNAME, CreateNetsRequestResponse.class, null, value);
    }

}
