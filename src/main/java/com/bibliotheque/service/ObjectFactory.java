
package com.bibliotheque.service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.bibliotheque.service package. 
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

    private final static QName _GetOuvrageResponse_QNAME = new QName("http://service.bibliotheque.com/", "getOuvrageResponse");
    private final static QName _GetUtilisateur_QNAME = new QName("http://service.bibliotheque.com/", "getUtilisateur");
    private final static QName _CreateReservationResponse_QNAME = new QName("http://service.bibliotheque.com/", "createReservationResponse");
    private final static QName _SaveMail_QNAME = new QName("http://service.bibliotheque.com/", "saveMail");
    private final static QName _DeleteUtilisateurResponse_QNAME = new QName("http://service.bibliotheque.com/", "deleteUtilisateurResponse");
    private final static QName _BibliothequeException_QNAME = new QName("http://service.bibliotheque.com/", "BibliothequeException");
    private final static QName _SaveUtilisateurResponse_QNAME = new QName("http://service.bibliotheque.com/", "saveUtilisateurResponse");
    private final static QName _DoConnection_QNAME = new QName("http://service.bibliotheque.com/", "doConnection");
    private final static QName _GetListRolesResponse_QNAME = new QName("http://service.bibliotheque.com/", "getListRolesResponse");
    private final static QName _GetMail_QNAME = new QName("http://service.bibliotheque.com/", "getMail");
    private final static QName _ProlongerReservation_QNAME = new QName("http://service.bibliotheque.com/", "prolongerReservation");
    private final static QName _DeleteOuvrageResponse_QNAME = new QName("http://service.bibliotheque.com/", "deleteOuvrageResponse");
    private final static QName _DeleteUtilisateur_QNAME = new QName("http://service.bibliotheque.com/", "deleteUtilisateur");
    private final static QName _CreateOuvrageResponse_QNAME = new QName("http://service.bibliotheque.com/", "createOuvrageResponse");
    private final static QName _GetListRoles_QNAME = new QName("http://service.bibliotheque.com/", "getListRoles");
    private final static QName _ListOuvrageResponse_QNAME = new QName("http://service.bibliotheque.com/", "listOuvrageResponse");
    private final static QName _GetDaysProlongationResponse_QNAME = new QName("http://service.bibliotheque.com/", "getDaysProlongationResponse");
    private final static QName _GetListReservationRetardedByUtilisateurIDResponse_QNAME = new QName("http://service.bibliotheque.com/", "getListReservationRetardedByUtilisateurIDResponse");
    private final static QName _ProlongerReservationResponse_QNAME = new QName("http://service.bibliotheque.com/", "prolongerReservationResponse");
    private final static QName _GetReservation_QNAME = new QName("http://service.bibliotheque.com/", "getReservation");
    private final static QName _GetDaysProlongation_QNAME = new QName("http://service.bibliotheque.com/", "getDaysProlongation");
    private final static QName _GetListReservationRetardedByUtilisateurID_QNAME = new QName("http://service.bibliotheque.com/", "getListReservationRetardedByUtilisateurID");
    private final static QName _DeleteReservationResponse_QNAME = new QName("http://service.bibliotheque.com/", "deleteReservationResponse");
    private final static QName _GetMailResponse_QNAME = new QName("http://service.bibliotheque.com/", "getMailResponse");
    private final static QName _CreateReservation_QNAME = new QName("http://service.bibliotheque.com/", "createReservation");
    private final static QName _DoConnectionResponse_QNAME = new QName("http://service.bibliotheque.com/", "doConnectionResponse");
    private final static QName _DeleteOuvrage_QNAME = new QName("http://service.bibliotheque.com/", "deleteOuvrage");
    private final static QName _GetListGenreResponse_QNAME = new QName("http://service.bibliotheque.com/", "getListGenreResponse");
    private final static QName _SaveMailResponse_QNAME = new QName("http://service.bibliotheque.com/", "saveMailResponse");
    private final static QName _CreateUtilisateurResponse_QNAME = new QName("http://service.bibliotheque.com/", "createUtilisateurResponse");
    private final static QName _GetListReservationByUtilisateurID_QNAME = new QName("http://service.bibliotheque.com/", "getListReservationByUtilisateurID");
    private final static QName _DeleteReservation_QNAME = new QName("http://service.bibliotheque.com/", "deleteReservation");
    private final static QName _UpdateOuvrage_QNAME = new QName("http://service.bibliotheque.com/", "updateOuvrage");
    private final static QName _GetListGenre_QNAME = new QName("http://service.bibliotheque.com/", "getListGenre");
    private final static QName _CreateUtilisateur_QNAME = new QName("http://service.bibliotheque.com/", "createUtilisateur");
    private final static QName _SaveUtilisateur_QNAME = new QName("http://service.bibliotheque.com/", "saveUtilisateur");
    private final static QName _CreateOuvrage_QNAME = new QName("http://service.bibliotheque.com/", "createOuvrage");
    private final static QName _GetUtilisateurResponse_QNAME = new QName("http://service.bibliotheque.com/", "getUtilisateurResponse");
    private final static QName _ListOuvrage_QNAME = new QName("http://service.bibliotheque.com/", "listOuvrage");
    private final static QName _GetListReservationByUtilisateurIDResponse_QNAME = new QName("http://service.bibliotheque.com/", "getListReservationByUtilisateurIDResponse");
    private final static QName _GetOuvrage_QNAME = new QName("http://service.bibliotheque.com/", "getOuvrage");
    private final static QName _GetReservationResponse_QNAME = new QName("http://service.bibliotheque.com/", "getReservationResponse");
    private final static QName _UpdateOuvrageResponse_QNAME = new QName("http://service.bibliotheque.com/", "updateOuvrageResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.bibliotheque.service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetDaysProlongation }
     * 
     */
    public GetDaysProlongation createGetDaysProlongation() {
        return new GetDaysProlongation();
    }

    /**
     * Create an instance of {@link GetListReservationRetardedByUtilisateurID }
     * 
     */
    public GetListReservationRetardedByUtilisateurID createGetListReservationRetardedByUtilisateurID() {
        return new GetListReservationRetardedByUtilisateurID();
    }

    /**
     * Create an instance of {@link DeleteReservationResponse }
     * 
     */
    public DeleteReservationResponse createDeleteReservationResponse() {
        return new DeleteReservationResponse();
    }

    /**
     * Create an instance of {@link GetMailResponse }
     * 
     */
    public GetMailResponse createGetMailResponse() {
        return new GetMailResponse();
    }

    /**
     * Create an instance of {@link CreateReservation }
     * 
     */
    public CreateReservation createCreateReservation() {
        return new CreateReservation();
    }

    /**
     * Create an instance of {@link DoConnectionResponse }
     * 
     */
    public DoConnectionResponse createDoConnectionResponse() {
        return new DoConnectionResponse();
    }

    /**
     * Create an instance of {@link DeleteOuvrage }
     * 
     */
    public DeleteOuvrage createDeleteOuvrage() {
        return new DeleteOuvrage();
    }

    /**
     * Create an instance of {@link GetListGenreResponse }
     * 
     */
    public GetListGenreResponse createGetListGenreResponse() {
        return new GetListGenreResponse();
    }

    /**
     * Create an instance of {@link SaveMailResponse }
     * 
     */
    public SaveMailResponse createSaveMailResponse() {
        return new SaveMailResponse();
    }

    /**
     * Create an instance of {@link CreateUtilisateurResponse }
     * 
     */
    public CreateUtilisateurResponse createCreateUtilisateurResponse() {
        return new CreateUtilisateurResponse();
    }

    /**
     * Create an instance of {@link GetListReservationByUtilisateurID }
     * 
     */
    public GetListReservationByUtilisateurID createGetListReservationByUtilisateurID() {
        return new GetListReservationByUtilisateurID();
    }

    /**
     * Create an instance of {@link DeleteReservation }
     * 
     */
    public DeleteReservation createDeleteReservation() {
        return new DeleteReservation();
    }

    /**
     * Create an instance of {@link UpdateOuvrage }
     * 
     */
    public UpdateOuvrage createUpdateOuvrage() {
        return new UpdateOuvrage();
    }

    /**
     * Create an instance of {@link GetListGenre }
     * 
     */
    public GetListGenre createGetListGenre() {
        return new GetListGenre();
    }

    /**
     * Create an instance of {@link CreateUtilisateur }
     * 
     */
    public CreateUtilisateur createCreateUtilisateur() {
        return new CreateUtilisateur();
    }

    /**
     * Create an instance of {@link SaveUtilisateur }
     * 
     */
    public SaveUtilisateur createSaveUtilisateur() {
        return new SaveUtilisateur();
    }

    /**
     * Create an instance of {@link CreateOuvrage }
     * 
     */
    public CreateOuvrage createCreateOuvrage() {
        return new CreateOuvrage();
    }

    /**
     * Create an instance of {@link GetUtilisateurResponse }
     * 
     */
    public GetUtilisateurResponse createGetUtilisateurResponse() {
        return new GetUtilisateurResponse();
    }

    /**
     * Create an instance of {@link ListOuvrage }
     * 
     */
    public ListOuvrage createListOuvrage() {
        return new ListOuvrage();
    }

    /**
     * Create an instance of {@link GetListReservationByUtilisateurIDResponse }
     * 
     */
    public GetListReservationByUtilisateurIDResponse createGetListReservationByUtilisateurIDResponse() {
        return new GetListReservationByUtilisateurIDResponse();
    }

    /**
     * Create an instance of {@link GetOuvrage }
     * 
     */
    public GetOuvrage createGetOuvrage() {
        return new GetOuvrage();
    }

    /**
     * Create an instance of {@link GetReservationResponse }
     * 
     */
    public GetReservationResponse createGetReservationResponse() {
        return new GetReservationResponse();
    }

    /**
     * Create an instance of {@link UpdateOuvrageResponse }
     * 
     */
    public UpdateOuvrageResponse createUpdateOuvrageResponse() {
        return new UpdateOuvrageResponse();
    }

    /**
     * Create an instance of {@link GetOuvrageResponse }
     * 
     */
    public GetOuvrageResponse createGetOuvrageResponse() {
        return new GetOuvrageResponse();
    }

    /**
     * Create an instance of {@link GetUtilisateur }
     * 
     */
    public GetUtilisateur createGetUtilisateur() {
        return new GetUtilisateur();
    }

    /**
     * Create an instance of {@link CreateReservationResponse }
     * 
     */
    public CreateReservationResponse createCreateReservationResponse() {
        return new CreateReservationResponse();
    }

    /**
     * Create an instance of {@link SaveMail }
     * 
     */
    public SaveMail createSaveMail() {
        return new SaveMail();
    }

    /**
     * Create an instance of {@link DeleteUtilisateurResponse }
     * 
     */
    public DeleteUtilisateurResponse createDeleteUtilisateurResponse() {
        return new DeleteUtilisateurResponse();
    }

    /**
     * Create an instance of {@link BibliothequeException }
     * 
     */
    public BibliothequeException createBibliothequeException() {
        return new BibliothequeException();
    }

    /**
     * Create an instance of {@link SaveUtilisateurResponse }
     * 
     */
    public SaveUtilisateurResponse createSaveUtilisateurResponse() {
        return new SaveUtilisateurResponse();
    }

    /**
     * Create an instance of {@link DoConnection }
     * 
     */
    public DoConnection createDoConnection() {
        return new DoConnection();
    }

    /**
     * Create an instance of {@link GetListRolesResponse }
     * 
     */
    public GetListRolesResponse createGetListRolesResponse() {
        return new GetListRolesResponse();
    }

    /**
     * Create an instance of {@link GetMail }
     * 
     */
    public GetMail createGetMail() {
        return new GetMail();
    }

    /**
     * Create an instance of {@link ProlongerReservation }
     * 
     */
    public ProlongerReservation createProlongerReservation() {
        return new ProlongerReservation();
    }

    /**
     * Create an instance of {@link DeleteOuvrageResponse }
     * 
     */
    public DeleteOuvrageResponse createDeleteOuvrageResponse() {
        return new DeleteOuvrageResponse();
    }

    /**
     * Create an instance of {@link DeleteUtilisateur }
     * 
     */
    public DeleteUtilisateur createDeleteUtilisateur() {
        return new DeleteUtilisateur();
    }

    /**
     * Create an instance of {@link CreateOuvrageResponse }
     * 
     */
    public CreateOuvrageResponse createCreateOuvrageResponse() {
        return new CreateOuvrageResponse();
    }

    /**
     * Create an instance of {@link GetListRoles }
     * 
     */
    public GetListRoles createGetListRoles() {
        return new GetListRoles();
    }

    /**
     * Create an instance of {@link ListOuvrageResponse }
     * 
     */
    public ListOuvrageResponse createListOuvrageResponse() {
        return new ListOuvrageResponse();
    }

    /**
     * Create an instance of {@link GetDaysProlongationResponse }
     * 
     */
    public GetDaysProlongationResponse createGetDaysProlongationResponse() {
        return new GetDaysProlongationResponse();
    }

    /**
     * Create an instance of {@link GetListReservationRetardedByUtilisateurIDResponse }
     * 
     */
    public GetListReservationRetardedByUtilisateurIDResponse createGetListReservationRetardedByUtilisateurIDResponse() {
        return new GetListReservationRetardedByUtilisateurIDResponse();
    }

    /**
     * Create an instance of {@link ProlongerReservationResponse }
     * 
     */
    public ProlongerReservationResponse createProlongerReservationResponse() {
        return new ProlongerReservationResponse();
    }

    /**
     * Create an instance of {@link GetReservation }
     * 
     */
    public GetReservation createGetReservation() {
        return new GetReservation();
    }

    /**
     * Create an instance of {@link Mail }
     * 
     */
    public Mail createMail() {
        return new Mail();
    }

    /**
     * Create an instance of {@link Utilisateur }
     * 
     */
    public Utilisateur createUtilisateur() {
        return new Utilisateur();
    }

    /**
     * Create an instance of {@link Reservation }
     * 
     */
    public Reservation createReservation() {
        return new Reservation();
    }

    /**
     * Create an instance of {@link BibliothequeFault }
     * 
     */
    public BibliothequeFault createBibliothequeFault() {
        return new BibliothequeFault();
    }

    /**
     * Create an instance of {@link PageOuvrage }
     * 
     */
    public PageOuvrage createPageOuvrage() {
        return new PageOuvrage();
    }

    /**
     * Create an instance of {@link Ouvrage }
     * 
     */
    public Ouvrage createOuvrage() {
        return new Ouvrage();
    }

    /**
     * Create an instance of {@link Roles }
     * 
     */
    public Roles createRoles() {
        return new Roles();
    }

    /**
     * Create an instance of {@link Genre }
     * 
     */
    public Genre createGenre() {
        return new Genre();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetOuvrageResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bibliotheque.com/", name = "getOuvrageResponse")
    public JAXBElement<GetOuvrageResponse> createGetOuvrageResponse(GetOuvrageResponse value) {
        return new JAXBElement<GetOuvrageResponse>(_GetOuvrageResponse_QNAME, GetOuvrageResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUtilisateur }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bibliotheque.com/", name = "getUtilisateur")
    public JAXBElement<GetUtilisateur> createGetUtilisateur(GetUtilisateur value) {
        return new JAXBElement<GetUtilisateur>(_GetUtilisateur_QNAME, GetUtilisateur.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateReservationResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bibliotheque.com/", name = "createReservationResponse")
    public JAXBElement<CreateReservationResponse> createCreateReservationResponse(CreateReservationResponse value) {
        return new JAXBElement<CreateReservationResponse>(_CreateReservationResponse_QNAME, CreateReservationResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveMail }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bibliotheque.com/", name = "saveMail")
    public JAXBElement<SaveMail> createSaveMail(SaveMail value) {
        return new JAXBElement<SaveMail>(_SaveMail_QNAME, SaveMail.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteUtilisateurResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bibliotheque.com/", name = "deleteUtilisateurResponse")
    public JAXBElement<DeleteUtilisateurResponse> createDeleteUtilisateurResponse(DeleteUtilisateurResponse value) {
        return new JAXBElement<DeleteUtilisateurResponse>(_DeleteUtilisateurResponse_QNAME, DeleteUtilisateurResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BibliothequeException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bibliotheque.com/", name = "BibliothequeException")
    public JAXBElement<BibliothequeException> createBibliothequeException(BibliothequeException value) {
        return new JAXBElement<BibliothequeException>(_BibliothequeException_QNAME, BibliothequeException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveUtilisateurResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bibliotheque.com/", name = "saveUtilisateurResponse")
    public JAXBElement<SaveUtilisateurResponse> createSaveUtilisateurResponse(SaveUtilisateurResponse value) {
        return new JAXBElement<SaveUtilisateurResponse>(_SaveUtilisateurResponse_QNAME, SaveUtilisateurResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DoConnection }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bibliotheque.com/", name = "doConnection")
    public JAXBElement<DoConnection> createDoConnection(DoConnection value) {
        return new JAXBElement<DoConnection>(_DoConnection_QNAME, DoConnection.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetListRolesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bibliotheque.com/", name = "getListRolesResponse")
    public JAXBElement<GetListRolesResponse> createGetListRolesResponse(GetListRolesResponse value) {
        return new JAXBElement<GetListRolesResponse>(_GetListRolesResponse_QNAME, GetListRolesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMail }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bibliotheque.com/", name = "getMail")
    public JAXBElement<GetMail> createGetMail(GetMail value) {
        return new JAXBElement<GetMail>(_GetMail_QNAME, GetMail.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProlongerReservation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bibliotheque.com/", name = "prolongerReservation")
    public JAXBElement<ProlongerReservation> createProlongerReservation(ProlongerReservation value) {
        return new JAXBElement<ProlongerReservation>(_ProlongerReservation_QNAME, ProlongerReservation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteOuvrageResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bibliotheque.com/", name = "deleteOuvrageResponse")
    public JAXBElement<DeleteOuvrageResponse> createDeleteOuvrageResponse(DeleteOuvrageResponse value) {
        return new JAXBElement<DeleteOuvrageResponse>(_DeleteOuvrageResponse_QNAME, DeleteOuvrageResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteUtilisateur }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bibliotheque.com/", name = "deleteUtilisateur")
    public JAXBElement<DeleteUtilisateur> createDeleteUtilisateur(DeleteUtilisateur value) {
        return new JAXBElement<DeleteUtilisateur>(_DeleteUtilisateur_QNAME, DeleteUtilisateur.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateOuvrageResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bibliotheque.com/", name = "createOuvrageResponse")
    public JAXBElement<CreateOuvrageResponse> createCreateOuvrageResponse(CreateOuvrageResponse value) {
        return new JAXBElement<CreateOuvrageResponse>(_CreateOuvrageResponse_QNAME, CreateOuvrageResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetListRoles }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bibliotheque.com/", name = "getListRoles")
    public JAXBElement<GetListRoles> createGetListRoles(GetListRoles value) {
        return new JAXBElement<GetListRoles>(_GetListRoles_QNAME, GetListRoles.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListOuvrageResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bibliotheque.com/", name = "listOuvrageResponse")
    public JAXBElement<ListOuvrageResponse> createListOuvrageResponse(ListOuvrageResponse value) {
        return new JAXBElement<ListOuvrageResponse>(_ListOuvrageResponse_QNAME, ListOuvrageResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDaysProlongationResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bibliotheque.com/", name = "getDaysProlongationResponse")
    public JAXBElement<GetDaysProlongationResponse> createGetDaysProlongationResponse(GetDaysProlongationResponse value) {
        return new JAXBElement<GetDaysProlongationResponse>(_GetDaysProlongationResponse_QNAME, GetDaysProlongationResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetListReservationRetardedByUtilisateurIDResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bibliotheque.com/", name = "getListReservationRetardedByUtilisateurIDResponse")
    public JAXBElement<GetListReservationRetardedByUtilisateurIDResponse> createGetListReservationRetardedByUtilisateurIDResponse(GetListReservationRetardedByUtilisateurIDResponse value) {
        return new JAXBElement<GetListReservationRetardedByUtilisateurIDResponse>(_GetListReservationRetardedByUtilisateurIDResponse_QNAME, GetListReservationRetardedByUtilisateurIDResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProlongerReservationResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bibliotheque.com/", name = "prolongerReservationResponse")
    public JAXBElement<ProlongerReservationResponse> createProlongerReservationResponse(ProlongerReservationResponse value) {
        return new JAXBElement<ProlongerReservationResponse>(_ProlongerReservationResponse_QNAME, ProlongerReservationResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetReservation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bibliotheque.com/", name = "getReservation")
    public JAXBElement<GetReservation> createGetReservation(GetReservation value) {
        return new JAXBElement<GetReservation>(_GetReservation_QNAME, GetReservation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDaysProlongation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bibliotheque.com/", name = "getDaysProlongation")
    public JAXBElement<GetDaysProlongation> createGetDaysProlongation(GetDaysProlongation value) {
        return new JAXBElement<GetDaysProlongation>(_GetDaysProlongation_QNAME, GetDaysProlongation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetListReservationRetardedByUtilisateurID }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bibliotheque.com/", name = "getListReservationRetardedByUtilisateurID")
    public JAXBElement<GetListReservationRetardedByUtilisateurID> createGetListReservationRetardedByUtilisateurID(GetListReservationRetardedByUtilisateurID value) {
        return new JAXBElement<GetListReservationRetardedByUtilisateurID>(_GetListReservationRetardedByUtilisateurID_QNAME, GetListReservationRetardedByUtilisateurID.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteReservationResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bibliotheque.com/", name = "deleteReservationResponse")
    public JAXBElement<DeleteReservationResponse> createDeleteReservationResponse(DeleteReservationResponse value) {
        return new JAXBElement<DeleteReservationResponse>(_DeleteReservationResponse_QNAME, DeleteReservationResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMailResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bibliotheque.com/", name = "getMailResponse")
    public JAXBElement<GetMailResponse> createGetMailResponse(GetMailResponse value) {
        return new JAXBElement<GetMailResponse>(_GetMailResponse_QNAME, GetMailResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateReservation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bibliotheque.com/", name = "createReservation")
    public JAXBElement<CreateReservation> createCreateReservation(CreateReservation value) {
        return new JAXBElement<CreateReservation>(_CreateReservation_QNAME, CreateReservation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DoConnectionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bibliotheque.com/", name = "doConnectionResponse")
    public JAXBElement<DoConnectionResponse> createDoConnectionResponse(DoConnectionResponse value) {
        return new JAXBElement<DoConnectionResponse>(_DoConnectionResponse_QNAME, DoConnectionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteOuvrage }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bibliotheque.com/", name = "deleteOuvrage")
    public JAXBElement<DeleteOuvrage> createDeleteOuvrage(DeleteOuvrage value) {
        return new JAXBElement<DeleteOuvrage>(_DeleteOuvrage_QNAME, DeleteOuvrage.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetListGenreResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bibliotheque.com/", name = "getListGenreResponse")
    public JAXBElement<GetListGenreResponse> createGetListGenreResponse(GetListGenreResponse value) {
        return new JAXBElement<GetListGenreResponse>(_GetListGenreResponse_QNAME, GetListGenreResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveMailResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bibliotheque.com/", name = "saveMailResponse")
    public JAXBElement<SaveMailResponse> createSaveMailResponse(SaveMailResponse value) {
        return new JAXBElement<SaveMailResponse>(_SaveMailResponse_QNAME, SaveMailResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateUtilisateurResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bibliotheque.com/", name = "createUtilisateurResponse")
    public JAXBElement<CreateUtilisateurResponse> createCreateUtilisateurResponse(CreateUtilisateurResponse value) {
        return new JAXBElement<CreateUtilisateurResponse>(_CreateUtilisateurResponse_QNAME, CreateUtilisateurResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetListReservationByUtilisateurID }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bibliotheque.com/", name = "getListReservationByUtilisateurID")
    public JAXBElement<GetListReservationByUtilisateurID> createGetListReservationByUtilisateurID(GetListReservationByUtilisateurID value) {
        return new JAXBElement<GetListReservationByUtilisateurID>(_GetListReservationByUtilisateurID_QNAME, GetListReservationByUtilisateurID.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteReservation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bibliotheque.com/", name = "deleteReservation")
    public JAXBElement<DeleteReservation> createDeleteReservation(DeleteReservation value) {
        return new JAXBElement<DeleteReservation>(_DeleteReservation_QNAME, DeleteReservation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateOuvrage }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bibliotheque.com/", name = "updateOuvrage")
    public JAXBElement<UpdateOuvrage> createUpdateOuvrage(UpdateOuvrage value) {
        return new JAXBElement<UpdateOuvrage>(_UpdateOuvrage_QNAME, UpdateOuvrage.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetListGenre }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bibliotheque.com/", name = "getListGenre")
    public JAXBElement<GetListGenre> createGetListGenre(GetListGenre value) {
        return new JAXBElement<GetListGenre>(_GetListGenre_QNAME, GetListGenre.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateUtilisateur }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bibliotheque.com/", name = "createUtilisateur")
    public JAXBElement<CreateUtilisateur> createCreateUtilisateur(CreateUtilisateur value) {
        return new JAXBElement<CreateUtilisateur>(_CreateUtilisateur_QNAME, CreateUtilisateur.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveUtilisateur }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bibliotheque.com/", name = "saveUtilisateur")
    public JAXBElement<SaveUtilisateur> createSaveUtilisateur(SaveUtilisateur value) {
        return new JAXBElement<SaveUtilisateur>(_SaveUtilisateur_QNAME, SaveUtilisateur.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateOuvrage }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bibliotheque.com/", name = "createOuvrage")
    public JAXBElement<CreateOuvrage> createCreateOuvrage(CreateOuvrage value) {
        return new JAXBElement<CreateOuvrage>(_CreateOuvrage_QNAME, CreateOuvrage.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUtilisateurResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bibliotheque.com/", name = "getUtilisateurResponse")
    public JAXBElement<GetUtilisateurResponse> createGetUtilisateurResponse(GetUtilisateurResponse value) {
        return new JAXBElement<GetUtilisateurResponse>(_GetUtilisateurResponse_QNAME, GetUtilisateurResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListOuvrage }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bibliotheque.com/", name = "listOuvrage")
    public JAXBElement<ListOuvrage> createListOuvrage(ListOuvrage value) {
        return new JAXBElement<ListOuvrage>(_ListOuvrage_QNAME, ListOuvrage.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetListReservationByUtilisateurIDResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bibliotheque.com/", name = "getListReservationByUtilisateurIDResponse")
    public JAXBElement<GetListReservationByUtilisateurIDResponse> createGetListReservationByUtilisateurIDResponse(GetListReservationByUtilisateurIDResponse value) {
        return new JAXBElement<GetListReservationByUtilisateurIDResponse>(_GetListReservationByUtilisateurIDResponse_QNAME, GetListReservationByUtilisateurIDResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetOuvrage }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bibliotheque.com/", name = "getOuvrage")
    public JAXBElement<GetOuvrage> createGetOuvrage(GetOuvrage value) {
        return new JAXBElement<GetOuvrage>(_GetOuvrage_QNAME, GetOuvrage.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetReservationResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bibliotheque.com/", name = "getReservationResponse")
    public JAXBElement<GetReservationResponse> createGetReservationResponse(GetReservationResponse value) {
        return new JAXBElement<GetReservationResponse>(_GetReservationResponse_QNAME, GetReservationResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateOuvrageResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bibliotheque.com/", name = "updateOuvrageResponse")
    public JAXBElement<UpdateOuvrageResponse> createUpdateOuvrageResponse(UpdateOuvrageResponse value) {
        return new JAXBElement<UpdateOuvrageResponse>(_UpdateOuvrageResponse_QNAME, UpdateOuvrageResponse.class, null, value);
    }

}
