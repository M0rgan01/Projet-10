
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
    private final static QName _SaveGenre_QNAME = new QName("http://service.bibliotheque.com/", "saveGenre");
    private final static QName _SaveMail_QNAME = new QName("http://service.bibliotheque.com/", "saveMail");
    private final static QName _DeleteMail_QNAME = new QName("http://service.bibliotheque.com/", "deleteMail");
    private final static QName _DeleteUtilisateurResponse_QNAME = new QName("http://service.bibliotheque.com/", "deleteUtilisateurResponse");
    private final static QName _BibliothequeException_QNAME = new QName("http://service.bibliotheque.com/", "BibliothequeException");
    private final static QName _SaveUtilisateurResponse_QNAME = new QName("http://service.bibliotheque.com/", "saveUtilisateurResponse");
    private final static QName _DoConnection_QNAME = new QName("http://service.bibliotheque.com/", "doConnection");
    private final static QName _GetRerservationResponse_QNAME = new QName("http://service.bibliotheque.com/", "getRerservationResponse");
    private final static QName _GetListRolesResponse_QNAME = new QName("http://service.bibliotheque.com/", "getListRolesResponse");
    private final static QName _GetMail_QNAME = new QName("http://service.bibliotheque.com/", "getMail");
    private final static QName _DeleteOuvrageResponse_QNAME = new QName("http://service.bibliotheque.com/", "deleteOuvrageResponse");
    private final static QName _DeleteUtilisateur_QNAME = new QName("http://service.bibliotheque.com/", "deleteUtilisateur");
    private final static QName _GetGenre_QNAME = new QName("http://service.bibliotheque.com/", "getGenre");
    private final static QName _CreateOuvrageResponse_QNAME = new QName("http://service.bibliotheque.com/", "createOuvrageResponse");
    private final static QName _GetListRoles_QNAME = new QName("http://service.bibliotheque.com/", "getListRoles");
    private final static QName _ListOuvrageResponse_QNAME = new QName("http://service.bibliotheque.com/", "listOuvrageResponse");
    private final static QName _DeleteReservationResponse_QNAME = new QName("http://service.bibliotheque.com/", "deleteReservationResponse");
    private final static QName _GetMailResponse_QNAME = new QName("http://service.bibliotheque.com/", "getMailResponse");
    private final static QName _DoConnectionResponse_QNAME = new QName("http://service.bibliotheque.com/", "doConnectionResponse");
    private final static QName _DeleteOuvrage_QNAME = new QName("http://service.bibliotheque.com/", "deleteOuvrage");
    private final static QName _GetListGenreResponse_QNAME = new QName("http://service.bibliotheque.com/", "getListGenreResponse");
    private final static QName _SaveGenreResponse_QNAME = new QName("http://service.bibliotheque.com/", "saveGenreResponse");
    private final static QName _SaveMailResponse_QNAME = new QName("http://service.bibliotheque.com/", "saveMailResponse");
    private final static QName _CreateUtilisateurResponse_QNAME = new QName("http://service.bibliotheque.com/", "createUtilisateurResponse");
    private final static QName _DeleteReservation_QNAME = new QName("http://service.bibliotheque.com/", "deleteReservation");
    private final static QName _SaveReservationResponse_QNAME = new QName("http://service.bibliotheque.com/", "saveReservationResponse");
    private final static QName _UpdateOuvrage_QNAME = new QName("http://service.bibliotheque.com/", "updateOuvrage");
    private final static QName _DeleteMailResponse_QNAME = new QName("http://service.bibliotheque.com/", "deleteMailResponse");
    private final static QName _GetListGenre_QNAME = new QName("http://service.bibliotheque.com/", "getListGenre");
    private final static QName _CreateUtilisateur_QNAME = new QName("http://service.bibliotheque.com/", "createUtilisateur");
    private final static QName _SaveUtilisateur_QNAME = new QName("http://service.bibliotheque.com/", "saveUtilisateur");
    private final static QName _CreateOuvrage_QNAME = new QName("http://service.bibliotheque.com/", "createOuvrage");
    private final static QName _GetGenreResponse_QNAME = new QName("http://service.bibliotheque.com/", "getGenreResponse");
    private final static QName _GetRerservation_QNAME = new QName("http://service.bibliotheque.com/", "getRerservation");
    private final static QName _ListOuvrage_QNAME = new QName("http://service.bibliotheque.com/", "listOuvrage");
    private final static QName _GetOuvrage_QNAME = new QName("http://service.bibliotheque.com/", "getOuvrage");
    private final static QName _SaveReservation_QNAME = new QName("http://service.bibliotheque.com/", "saveReservation");
    private final static QName _UpdateOuvrageResponse_QNAME = new QName("http://service.bibliotheque.com/", "updateOuvrageResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.bibliotheque.service
     * 
     */
    public ObjectFactory() {
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
     * Create an instance of {@link SaveGenreResponse }
     * 
     */
    public SaveGenreResponse createSaveGenreResponse() {
        return new SaveGenreResponse();
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
     * Create an instance of {@link DeleteReservation }
     * 
     */
    public DeleteReservation createDeleteReservation() {
        return new DeleteReservation();
    }

    /**
     * Create an instance of {@link SaveReservationResponse }
     * 
     */
    public SaveReservationResponse createSaveReservationResponse() {
        return new SaveReservationResponse();
    }

    /**
     * Create an instance of {@link UpdateOuvrage }
     * 
     */
    public UpdateOuvrage createUpdateOuvrage() {
        return new UpdateOuvrage();
    }

    /**
     * Create an instance of {@link DeleteMailResponse }
     * 
     */
    public DeleteMailResponse createDeleteMailResponse() {
        return new DeleteMailResponse();
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
     * Create an instance of {@link GetGenreResponse }
     * 
     */
    public GetGenreResponse createGetGenreResponse() {
        return new GetGenreResponse();
    }

    /**
     * Create an instance of {@link GetRerservation }
     * 
     */
    public GetRerservation createGetRerservation() {
        return new GetRerservation();
    }

    /**
     * Create an instance of {@link ListOuvrage }
     * 
     */
    public ListOuvrage createListOuvrage() {
        return new ListOuvrage();
    }

    /**
     * Create an instance of {@link GetOuvrage }
     * 
     */
    public GetOuvrage createGetOuvrage() {
        return new GetOuvrage();
    }

    /**
     * Create an instance of {@link SaveReservation }
     * 
     */
    public SaveReservation createSaveReservation() {
        return new SaveReservation();
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
     * Create an instance of {@link SaveGenre }
     * 
     */
    public SaveGenre createSaveGenre() {
        return new SaveGenre();
    }

    /**
     * Create an instance of {@link SaveMail }
     * 
     */
    public SaveMail createSaveMail() {
        return new SaveMail();
    }

    /**
     * Create an instance of {@link DeleteMail }
     * 
     */
    public DeleteMail createDeleteMail() {
        return new DeleteMail();
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
     * Create an instance of {@link GetRerservationResponse }
     * 
     */
    public GetRerservationResponse createGetRerservationResponse() {
        return new GetRerservationResponse();
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
     * Create an instance of {@link GetGenre }
     * 
     */
    public GetGenre createGetGenre() {
        return new GetGenre();
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
     * Create an instance of {@link Mail }
     * 
     */
    public Mail createMail() {
        return new Mail();
    }

    /**
     * Create an instance of {@link Roles }
     * 
     */
    public Roles createRoles() {
        return new Roles();
    }

    /**
     * Create an instance of {@link Utilisateur }
     * 
     */
    public Utilisateur createUtilisateur() {
        return new Utilisateur();
    }

    /**
     * Create an instance of {@link Genre }
     * 
     */
    public Genre createGenre() {
        return new Genre();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link GetOuvrageResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bibliotheque.com/", name = "getOuvrageResponse")
    public JAXBElement<GetOuvrageResponse> createGetOuvrageResponse(GetOuvrageResponse value) {
        return new JAXBElement<GetOuvrageResponse>(_GetOuvrageResponse_QNAME, GetOuvrageResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveGenre }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bibliotheque.com/", name = "saveGenre")
    public JAXBElement<SaveGenre> createSaveGenre(SaveGenre value) {
        return new JAXBElement<SaveGenre>(_SaveGenre_QNAME, SaveGenre.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteMail }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bibliotheque.com/", name = "deleteMail")
    public JAXBElement<DeleteMail> createDeleteMail(DeleteMail value) {
        return new JAXBElement<DeleteMail>(_DeleteMail_QNAME, DeleteMail.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link GetRerservationResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bibliotheque.com/", name = "getRerservationResponse")
    public JAXBElement<GetRerservationResponse> createGetRerservationResponse(GetRerservationResponse value) {
        return new JAXBElement<GetRerservationResponse>(_GetRerservationResponse_QNAME, GetRerservationResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link GetGenre }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bibliotheque.com/", name = "getGenre")
    public JAXBElement<GetGenre> createGetGenre(GetGenre value) {
        return new JAXBElement<GetGenre>(_GetGenre_QNAME, GetGenre.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveGenreResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bibliotheque.com/", name = "saveGenreResponse")
    public JAXBElement<SaveGenreResponse> createSaveGenreResponse(SaveGenreResponse value) {
        return new JAXBElement<SaveGenreResponse>(_SaveGenreResponse_QNAME, SaveGenreResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteReservation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bibliotheque.com/", name = "deleteReservation")
    public JAXBElement<DeleteReservation> createDeleteReservation(DeleteReservation value) {
        return new JAXBElement<DeleteReservation>(_DeleteReservation_QNAME, DeleteReservation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveReservationResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bibliotheque.com/", name = "saveReservationResponse")
    public JAXBElement<SaveReservationResponse> createSaveReservationResponse(SaveReservationResponse value) {
        return new JAXBElement<SaveReservationResponse>(_SaveReservationResponse_QNAME, SaveReservationResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteMailResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bibliotheque.com/", name = "deleteMailResponse")
    public JAXBElement<DeleteMailResponse> createDeleteMailResponse(DeleteMailResponse value) {
        return new JAXBElement<DeleteMailResponse>(_DeleteMailResponse_QNAME, DeleteMailResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link GetGenreResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bibliotheque.com/", name = "getGenreResponse")
    public JAXBElement<GetGenreResponse> createGetGenreResponse(GetGenreResponse value) {
        return new JAXBElement<GetGenreResponse>(_GetGenreResponse_QNAME, GetGenreResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetRerservation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bibliotheque.com/", name = "getRerservation")
    public JAXBElement<GetRerservation> createGetRerservation(GetRerservation value) {
        return new JAXBElement<GetRerservation>(_GetRerservation_QNAME, GetRerservation.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link GetOuvrage }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bibliotheque.com/", name = "getOuvrage")
    public JAXBElement<GetOuvrage> createGetOuvrage(GetOuvrage value) {
        return new JAXBElement<GetOuvrage>(_GetOuvrage_QNAME, GetOuvrage.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveReservation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bibliotheque.com/", name = "saveReservation")
    public JAXBElement<SaveReservation> createSaveReservation(SaveReservation value) {
        return new JAXBElement<SaveReservation>(_SaveReservation_QNAME, SaveReservation.class, null, value);
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
