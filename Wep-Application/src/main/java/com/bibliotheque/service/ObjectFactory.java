
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

    private final static QName _GetBookResponse_QNAME = new QName("http://service.bibliotheque.com/", "getBookResponse");
    private final static QName _CreateReservationResponse_QNAME = new QName("http://service.bibliotheque.com/", "createReservationResponse");
    private final static QName _CreateUserResponse_QNAME = new QName("http://service.bibliotheque.com/", "createUserResponse");
    private final static QName _GetDaysLoanResponse_QNAME = new QName("http://service.bibliotheque.com/", "getDaysLoanResponse");
    private final static QName _GetLoan_QNAME = new QName("http://service.bibliotheque.com/", "getLoan");
    private final static QName _GetListReservationByBookResponse_QNAME = new QName("http://service.bibliotheque.com/", "getListReservationByBookResponse");
    private final static QName _SendTokenResponse_QNAME = new QName("http://service.bibliotheque.com/", "sendTokenResponse");
    private final static QName _GetListReservationByBook_QNAME = new QName("http://service.bibliotheque.com/", "getListReservationByBook");
    private final static QName _DoConnection_QNAME = new QName("http://service.bibliotheque.com/", "doConnection");
    private final static QName _ExtendLoan_QNAME = new QName("http://service.bibliotheque.com/", "extendLoan");
    private final static QName _GetListRolesResponse_QNAME = new QName("http://service.bibliotheque.com/", "getListRolesResponse");
    private final static QName _ReturnLoan_QNAME = new QName("http://service.bibliotheque.com/", "returnLoan");
    private final static QName _UpdateBookResponse_QNAME = new QName("http://service.bibliotheque.com/", "updateBookResponse");
    private final static QName _GetListReservationWithEndDate_QNAME = new QName("http://service.bibliotheque.com/", "getListReservationWithEndDate");
    private final static QName _CreateUser_QNAME = new QName("http://service.bibliotheque.com/", "createUser");
    private final static QName _ParseException_QNAME = new QName("http://service.bibliotheque.com/", "ParseException");
    private final static QName _GetListLoanLate_QNAME = new QName("http://service.bibliotheque.com/", "getListLoanLate");
    private final static QName _DeleteUserResponse_QNAME = new QName("http://service.bibliotheque.com/", "deleteUserResponse");
    private final static QName _ValidateTokenResponse_QNAME = new QName("http://service.bibliotheque.com/", "validateTokenResponse");
    private final static QName _GetListKind_QNAME = new QName("http://service.bibliotheque.com/", "getListKind");
    private final static QName _GetMailResponse_QNAME = new QName("http://service.bibliotheque.com/", "getMailResponse");
    private final static QName _CreateReservation_QNAME = new QName("http://service.bibliotheque.com/", "createReservation");
    private final static QName _CreateLoanResponse_QNAME = new QName("http://service.bibliotheque.com/", "createLoanResponse");
    private final static QName _EditPassWordByRecoveryResponse_QNAME = new QName("http://service.bibliotheque.com/", "editPassWordByRecoveryResponse");
    private final static QName _DeleteBookResponse_QNAME = new QName("http://service.bibliotheque.com/", "deleteBookResponse");
    private final static QName _GetListLoanByUserID_QNAME = new QName("http://service.bibliotheque.com/", "getListLoanByUserID");
    private final static QName _GetDaysExtendResponse_QNAME = new QName("http://service.bibliotheque.com/", "getDaysExtendResponse");
    private final static QName _ValidateToken_QNAME = new QName("http://service.bibliotheque.com/", "validateToken");
    private final static QName _GetListReservationWithEndDateResponse_QNAME = new QName("http://service.bibliotheque.com/", "getListReservationWithEndDateResponse");
    private final static QName _GetBook_QNAME = new QName("http://service.bibliotheque.com/", "getBook");
    private final static QName _GetDaysLoan_QNAME = new QName("http://service.bibliotheque.com/", "getDaysLoan");
    private final static QName _SaveMail_QNAME = new QName("http://service.bibliotheque.com/", "saveMail");
    private final static QName _BibliothequeException_QNAME = new QName("http://service.bibliotheque.com/", "BibliothequeException");
    private final static QName _SendToken_QNAME = new QName("http://service.bibliotheque.com/", "sendToken");
    private final static QName _GetMail_QNAME = new QName("http://service.bibliotheque.com/", "getMail");
    private final static QName _GetListLoanLateResponse_QNAME = new QName("http://service.bibliotheque.com/", "getListLoanLateResponse");
    private final static QName _GetListRoles_QNAME = new QName("http://service.bibliotheque.com/", "getListRoles");
    private final static QName _DeleteUser_QNAME = new QName("http://service.bibliotheque.com/", "deleteUser");
    private final static QName _GetListReservationByUserResponse_QNAME = new QName("http://service.bibliotheque.com/", "getListReservationByUserResponse");
    private final static QName _GetListKindResponse_QNAME = new QName("http://service.bibliotheque.com/", "getListKindResponse");
    private final static QName _ReturnLoanResponse_QNAME = new QName("http://service.bibliotheque.com/", "returnLoanResponse");
    private final static QName _GetListLoanLateByUserID_QNAME = new QName("http://service.bibliotheque.com/", "getListLoanLateByUserID");
    private final static QName _DeleteReservationResponse_QNAME = new QName("http://service.bibliotheque.com/", "deleteReservationResponse");
    private final static QName _DoConnectionResponse_QNAME = new QName("http://service.bibliotheque.com/", "doConnectionResponse");
    private final static QName _GetListReservationByUser_QNAME = new QName("http://service.bibliotheque.com/", "getListReservationByUser");
    private final static QName _UpdateBook_QNAME = new QName("http://service.bibliotheque.com/", "updateBook");
    private final static QName _SaveMailResponse_QNAME = new QName("http://service.bibliotheque.com/", "saveMailResponse");
    private final static QName _ListBookResponse_QNAME = new QName("http://service.bibliotheque.com/", "listBookResponse");
    private final static QName _ListBook_QNAME = new QName("http://service.bibliotheque.com/", "listBook");
    private final static QName _CreateBookResponse_QNAME = new QName("http://service.bibliotheque.com/", "createBookResponse");
    private final static QName _DeleteReservation_QNAME = new QName("http://service.bibliotheque.com/", "deleteReservation");
    private final static QName _ExtendLoanResponse_QNAME = new QName("http://service.bibliotheque.com/", "extendLoanResponse");
    private final static QName _GetDaysExtend_QNAME = new QName("http://service.bibliotheque.com/", "getDaysExtend");
    private final static QName _GetListLoanByUserIDResponse_QNAME = new QName("http://service.bibliotheque.com/", "getListLoanByUserIDResponse");
    private final static QName _CreateBook_QNAME = new QName("http://service.bibliotheque.com/", "createBook");
    private final static QName _DeleteBook_QNAME = new QName("http://service.bibliotheque.com/", "deleteBook");
    private final static QName _CreateLoan_QNAME = new QName("http://service.bibliotheque.com/", "createLoan");
    private final static QName _EditPassWordByRecovery_QNAME = new QName("http://service.bibliotheque.com/", "editPassWordByRecovery");
    private final static QName _GetListLoanLateByUserIDResponse_QNAME = new QName("http://service.bibliotheque.com/", "getListLoanLateByUserIDResponse");
    private final static QName _SaveUserResponse_QNAME = new QName("http://service.bibliotheque.com/", "saveUserResponse");
    private final static QName _GetLoanResponse_QNAME = new QName("http://service.bibliotheque.com/", "getLoanResponse");
    private final static QName _SaveUser_QNAME = new QName("http://service.bibliotheque.com/", "saveUser");

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
     * Create an instance of {@link DoConnectionResponse }
     * 
     */
    public DoConnectionResponse createDoConnectionResponse() {
        return new DoConnectionResponse();
    }

    /**
     * Create an instance of {@link GetListReservationByUser }
     * 
     */
    public GetListReservationByUser createGetListReservationByUser() {
        return new GetListReservationByUser();
    }

    /**
     * Create an instance of {@link UpdateBook }
     * 
     */
    public UpdateBook createUpdateBook() {
        return new UpdateBook();
    }

    /**
     * Create an instance of {@link SaveMailResponse }
     * 
     */
    public SaveMailResponse createSaveMailResponse() {
        return new SaveMailResponse();
    }

    /**
     * Create an instance of {@link ListBookResponse }
     * 
     */
    public ListBookResponse createListBookResponse() {
        return new ListBookResponse();
    }

    /**
     * Create an instance of {@link ListBook }
     * 
     */
    public ListBook createListBook() {
        return new ListBook();
    }

    /**
     * Create an instance of {@link CreateBookResponse }
     * 
     */
    public CreateBookResponse createCreateBookResponse() {
        return new CreateBookResponse();
    }

    /**
     * Create an instance of {@link DeleteReservation }
     * 
     */
    public DeleteReservation createDeleteReservation() {
        return new DeleteReservation();
    }

    /**
     * Create an instance of {@link ExtendLoanResponse }
     * 
     */
    public ExtendLoanResponse createExtendLoanResponse() {
        return new ExtendLoanResponse();
    }

    /**
     * Create an instance of {@link GetDaysExtend }
     * 
     */
    public GetDaysExtend createGetDaysExtend() {
        return new GetDaysExtend();
    }

    /**
     * Create an instance of {@link GetListLoanByUserIDResponse }
     * 
     */
    public GetListLoanByUserIDResponse createGetListLoanByUserIDResponse() {
        return new GetListLoanByUserIDResponse();
    }

    /**
     * Create an instance of {@link CreateBook }
     * 
     */
    public CreateBook createCreateBook() {
        return new CreateBook();
    }

    /**
     * Create an instance of {@link DeleteBook }
     * 
     */
    public DeleteBook createDeleteBook() {
        return new DeleteBook();
    }

    /**
     * Create an instance of {@link CreateLoan }
     * 
     */
    public CreateLoan createCreateLoan() {
        return new CreateLoan();
    }

    /**
     * Create an instance of {@link EditPassWordByRecovery }
     * 
     */
    public EditPassWordByRecovery createEditPassWordByRecovery() {
        return new EditPassWordByRecovery();
    }

    /**
     * Create an instance of {@link GetListLoanLateByUserIDResponse }
     * 
     */
    public GetListLoanLateByUserIDResponse createGetListLoanLateByUserIDResponse() {
        return new GetListLoanLateByUserIDResponse();
    }

    /**
     * Create an instance of {@link SaveUserResponse }
     * 
     */
    public SaveUserResponse createSaveUserResponse() {
        return new SaveUserResponse();
    }

    /**
     * Create an instance of {@link GetLoanResponse }
     * 
     */
    public GetLoanResponse createGetLoanResponse() {
        return new GetLoanResponse();
    }

    /**
     * Create an instance of {@link SaveUser }
     * 
     */
    public SaveUser createSaveUser() {
        return new SaveUser();
    }

    /**
     * Create an instance of {@link GetListReservationWithEndDateResponse }
     * 
     */
    public GetListReservationWithEndDateResponse createGetListReservationWithEndDateResponse() {
        return new GetListReservationWithEndDateResponse();
    }

    /**
     * Create an instance of {@link GetBook }
     * 
     */
    public GetBook createGetBook() {
        return new GetBook();
    }

    /**
     * Create an instance of {@link GetDaysLoan }
     * 
     */
    public GetDaysLoan createGetDaysLoan() {
        return new GetDaysLoan();
    }

    /**
     * Create an instance of {@link SaveMail }
     * 
     */
    public SaveMail createSaveMail() {
        return new SaveMail();
    }

    /**
     * Create an instance of {@link BibliothequeException }
     * 
     */
    public BibliothequeException createBibliothequeException() {
        return new BibliothequeException();
    }

    /**
     * Create an instance of {@link SendToken }
     * 
     */
    public SendToken createSendToken() {
        return new SendToken();
    }

    /**
     * Create an instance of {@link GetMail }
     * 
     */
    public GetMail createGetMail() {
        return new GetMail();
    }

    /**
     * Create an instance of {@link GetListLoanLateResponse }
     * 
     */
    public GetListLoanLateResponse createGetListLoanLateResponse() {
        return new GetListLoanLateResponse();
    }

    /**
     * Create an instance of {@link GetListRoles }
     * 
     */
    public GetListRoles createGetListRoles() {
        return new GetListRoles();
    }

    /**
     * Create an instance of {@link DeleteUser }
     * 
     */
    public DeleteUser createDeleteUser() {
        return new DeleteUser();
    }

    /**
     * Create an instance of {@link GetListReservationByUserResponse }
     * 
     */
    public GetListReservationByUserResponse createGetListReservationByUserResponse() {
        return new GetListReservationByUserResponse();
    }

    /**
     * Create an instance of {@link GetListKindResponse }
     * 
     */
    public GetListKindResponse createGetListKindResponse() {
        return new GetListKindResponse();
    }

    /**
     * Create an instance of {@link ReturnLoanResponse }
     * 
     */
    public ReturnLoanResponse createReturnLoanResponse() {
        return new ReturnLoanResponse();
    }

    /**
     * Create an instance of {@link GetListLoanLateByUserID }
     * 
     */
    public GetListLoanLateByUserID createGetListLoanLateByUserID() {
        return new GetListLoanLateByUserID();
    }

    /**
     * Create an instance of {@link ValidateTokenResponse }
     * 
     */
    public ValidateTokenResponse createValidateTokenResponse() {
        return new ValidateTokenResponse();
    }

    /**
     * Create an instance of {@link GetListKind }
     * 
     */
    public GetListKind createGetListKind() {
        return new GetListKind();
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
     * Create an instance of {@link CreateLoanResponse }
     * 
     */
    public CreateLoanResponse createCreateLoanResponse() {
        return new CreateLoanResponse();
    }

    /**
     * Create an instance of {@link EditPassWordByRecoveryResponse }
     * 
     */
    public EditPassWordByRecoveryResponse createEditPassWordByRecoveryResponse() {
        return new EditPassWordByRecoveryResponse();
    }

    /**
     * Create an instance of {@link DeleteBookResponse }
     * 
     */
    public DeleteBookResponse createDeleteBookResponse() {
        return new DeleteBookResponse();
    }

    /**
     * Create an instance of {@link GetListLoanByUserID }
     * 
     */
    public GetListLoanByUserID createGetListLoanByUserID() {
        return new GetListLoanByUserID();
    }

    /**
     * Create an instance of {@link GetDaysExtendResponse }
     * 
     */
    public GetDaysExtendResponse createGetDaysExtendResponse() {
        return new GetDaysExtendResponse();
    }

    /**
     * Create an instance of {@link ValidateToken }
     * 
     */
    public ValidateToken createValidateToken() {
        return new ValidateToken();
    }

    /**
     * Create an instance of {@link GetBookResponse }
     * 
     */
    public GetBookResponse createGetBookResponse() {
        return new GetBookResponse();
    }

    /**
     * Create an instance of {@link CreateReservationResponse }
     * 
     */
    public CreateReservationResponse createCreateReservationResponse() {
        return new CreateReservationResponse();
    }

    /**
     * Create an instance of {@link CreateUserResponse }
     * 
     */
    public CreateUserResponse createCreateUserResponse() {
        return new CreateUserResponse();
    }

    /**
     * Create an instance of {@link GetDaysLoanResponse }
     * 
     */
    public GetDaysLoanResponse createGetDaysLoanResponse() {
        return new GetDaysLoanResponse();
    }

    /**
     * Create an instance of {@link GetLoan }
     * 
     */
    public GetLoan createGetLoan() {
        return new GetLoan();
    }

    /**
     * Create an instance of {@link GetListReservationByBookResponse }
     * 
     */
    public GetListReservationByBookResponse createGetListReservationByBookResponse() {
        return new GetListReservationByBookResponse();
    }

    /**
     * Create an instance of {@link SendTokenResponse }
     * 
     */
    public SendTokenResponse createSendTokenResponse() {
        return new SendTokenResponse();
    }

    /**
     * Create an instance of {@link GetListReservationByBook }
     * 
     */
    public GetListReservationByBook createGetListReservationByBook() {
        return new GetListReservationByBook();
    }

    /**
     * Create an instance of {@link DoConnection }
     * 
     */
    public DoConnection createDoConnection() {
        return new DoConnection();
    }

    /**
     * Create an instance of {@link ExtendLoan }
     * 
     */
    public ExtendLoan createExtendLoan() {
        return new ExtendLoan();
    }

    /**
     * Create an instance of {@link GetListRolesResponse }
     * 
     */
    public GetListRolesResponse createGetListRolesResponse() {
        return new GetListRolesResponse();
    }

    /**
     * Create an instance of {@link ReturnLoan }
     * 
     */
    public ReturnLoan createReturnLoan() {
        return new ReturnLoan();
    }

    /**
     * Create an instance of {@link UpdateBookResponse }
     * 
     */
    public UpdateBookResponse createUpdateBookResponse() {
        return new UpdateBookResponse();
    }

    /**
     * Create an instance of {@link GetListReservationWithEndDate }
     * 
     */
    public GetListReservationWithEndDate createGetListReservationWithEndDate() {
        return new GetListReservationWithEndDate();
    }

    /**
     * Create an instance of {@link CreateUser }
     * 
     */
    public CreateUser createCreateUser() {
        return new CreateUser();
    }

    /**
     * Create an instance of {@link ParseException }
     * 
     */
    public ParseException createParseException() {
        return new ParseException();
    }

    /**
     * Create an instance of {@link GetListLoanLate }
     * 
     */
    public GetListLoanLate createGetListLoanLate() {
        return new GetListLoanLate();
    }

    /**
     * Create an instance of {@link DeleteUserResponse }
     * 
     */
    public DeleteUserResponse createDeleteUserResponse() {
        return new DeleteUserResponse();
    }

    /**
     * Create an instance of {@link Mail }
     * 
     */
    public Mail createMail() {
        return new Mail();
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
     * Create an instance of {@link Kind }
     * 
     */
    public Kind createKind() {
        return new Kind();
    }

    /**
     * Create an instance of {@link Loan }
     * 
     */
    public Loan createLoan() {
        return new Loan();
    }

    /**
     * Create an instance of {@link Pagination }
     * 
     */
    public Pagination createPagination() {
        return new Pagination();
    }

    /**
     * Create an instance of {@link Book }
     * 
     */
    public Book createBook() {
        return new Book();
    }

    /**
     * Create an instance of {@link Roles }
     * 
     */
    public Roles createRoles() {
        return new Roles();
    }

    /**
     * Create an instance of {@link User }
     * 
     */
    public User createUser() {
        return new User();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBookResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bibliotheque.com/", name = "getBookResponse")
    public JAXBElement<GetBookResponse> createGetBookResponse(GetBookResponse value) {
        return new JAXBElement<GetBookResponse>(_GetBookResponse_QNAME, GetBookResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bibliotheque.com/", name = "createUserResponse")
    public JAXBElement<CreateUserResponse> createCreateUserResponse(CreateUserResponse value) {
        return new JAXBElement<CreateUserResponse>(_CreateUserResponse_QNAME, CreateUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDaysLoanResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bibliotheque.com/", name = "getDaysLoanResponse")
    public JAXBElement<GetDaysLoanResponse> createGetDaysLoanResponse(GetDaysLoanResponse value) {
        return new JAXBElement<GetDaysLoanResponse>(_GetDaysLoanResponse_QNAME, GetDaysLoanResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLoan }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bibliotheque.com/", name = "getLoan")
    public JAXBElement<GetLoan> createGetLoan(GetLoan value) {
        return new JAXBElement<GetLoan>(_GetLoan_QNAME, GetLoan.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetListReservationByBookResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bibliotheque.com/", name = "getListReservationByBookResponse")
    public JAXBElement<GetListReservationByBookResponse> createGetListReservationByBookResponse(GetListReservationByBookResponse value) {
        return new JAXBElement<GetListReservationByBookResponse>(_GetListReservationByBookResponse_QNAME, GetListReservationByBookResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SendTokenResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bibliotheque.com/", name = "sendTokenResponse")
    public JAXBElement<SendTokenResponse> createSendTokenResponse(SendTokenResponse value) {
        return new JAXBElement<SendTokenResponse>(_SendTokenResponse_QNAME, SendTokenResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetListReservationByBook }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bibliotheque.com/", name = "getListReservationByBook")
    public JAXBElement<GetListReservationByBook> createGetListReservationByBook(GetListReservationByBook value) {
        return new JAXBElement<GetListReservationByBook>(_GetListReservationByBook_QNAME, GetListReservationByBook.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link ExtendLoan }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bibliotheque.com/", name = "extendLoan")
    public JAXBElement<ExtendLoan> createExtendLoan(ExtendLoan value) {
        return new JAXBElement<ExtendLoan>(_ExtendLoan_QNAME, ExtendLoan.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link ReturnLoan }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bibliotheque.com/", name = "returnLoan")
    public JAXBElement<ReturnLoan> createReturnLoan(ReturnLoan value) {
        return new JAXBElement<ReturnLoan>(_ReturnLoan_QNAME, ReturnLoan.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateBookResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bibliotheque.com/", name = "updateBookResponse")
    public JAXBElement<UpdateBookResponse> createUpdateBookResponse(UpdateBookResponse value) {
        return new JAXBElement<UpdateBookResponse>(_UpdateBookResponse_QNAME, UpdateBookResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetListReservationWithEndDate }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bibliotheque.com/", name = "getListReservationWithEndDate")
    public JAXBElement<GetListReservationWithEndDate> createGetListReservationWithEndDate(GetListReservationWithEndDate value) {
        return new JAXBElement<GetListReservationWithEndDate>(_GetListReservationWithEndDate_QNAME, GetListReservationWithEndDate.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bibliotheque.com/", name = "createUser")
    public JAXBElement<CreateUser> createCreateUser(CreateUser value) {
        return new JAXBElement<CreateUser>(_CreateUser_QNAME, CreateUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ParseException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bibliotheque.com/", name = "ParseException")
    public JAXBElement<ParseException> createParseException(ParseException value) {
        return new JAXBElement<ParseException>(_ParseException_QNAME, ParseException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetListLoanLate }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bibliotheque.com/", name = "getListLoanLate")
    public JAXBElement<GetListLoanLate> createGetListLoanLate(GetListLoanLate value) {
        return new JAXBElement<GetListLoanLate>(_GetListLoanLate_QNAME, GetListLoanLate.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bibliotheque.com/", name = "deleteUserResponse")
    public JAXBElement<DeleteUserResponse> createDeleteUserResponse(DeleteUserResponse value) {
        return new JAXBElement<DeleteUserResponse>(_DeleteUserResponse_QNAME, DeleteUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValidateTokenResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bibliotheque.com/", name = "validateTokenResponse")
    public JAXBElement<ValidateTokenResponse> createValidateTokenResponse(ValidateTokenResponse value) {
        return new JAXBElement<ValidateTokenResponse>(_ValidateTokenResponse_QNAME, ValidateTokenResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetListKind }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bibliotheque.com/", name = "getListKind")
    public JAXBElement<GetListKind> createGetListKind(GetListKind value) {
        return new JAXBElement<GetListKind>(_GetListKind_QNAME, GetListKind.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateLoanResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bibliotheque.com/", name = "createLoanResponse")
    public JAXBElement<CreateLoanResponse> createCreateLoanResponse(CreateLoanResponse value) {
        return new JAXBElement<CreateLoanResponse>(_CreateLoanResponse_QNAME, CreateLoanResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EditPassWordByRecoveryResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bibliotheque.com/", name = "editPassWordByRecoveryResponse")
    public JAXBElement<EditPassWordByRecoveryResponse> createEditPassWordByRecoveryResponse(EditPassWordByRecoveryResponse value) {
        return new JAXBElement<EditPassWordByRecoveryResponse>(_EditPassWordByRecoveryResponse_QNAME, EditPassWordByRecoveryResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteBookResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bibliotheque.com/", name = "deleteBookResponse")
    public JAXBElement<DeleteBookResponse> createDeleteBookResponse(DeleteBookResponse value) {
        return new JAXBElement<DeleteBookResponse>(_DeleteBookResponse_QNAME, DeleteBookResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetListLoanByUserID }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bibliotheque.com/", name = "getListLoanByUserID")
    public JAXBElement<GetListLoanByUserID> createGetListLoanByUserID(GetListLoanByUserID value) {
        return new JAXBElement<GetListLoanByUserID>(_GetListLoanByUserID_QNAME, GetListLoanByUserID.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDaysExtendResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bibliotheque.com/", name = "getDaysExtendResponse")
    public JAXBElement<GetDaysExtendResponse> createGetDaysExtendResponse(GetDaysExtendResponse value) {
        return new JAXBElement<GetDaysExtendResponse>(_GetDaysExtendResponse_QNAME, GetDaysExtendResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValidateToken }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bibliotheque.com/", name = "validateToken")
    public JAXBElement<ValidateToken> createValidateToken(ValidateToken value) {
        return new JAXBElement<ValidateToken>(_ValidateToken_QNAME, ValidateToken.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetListReservationWithEndDateResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bibliotheque.com/", name = "getListReservationWithEndDateResponse")
    public JAXBElement<GetListReservationWithEndDateResponse> createGetListReservationWithEndDateResponse(GetListReservationWithEndDateResponse value) {
        return new JAXBElement<GetListReservationWithEndDateResponse>(_GetListReservationWithEndDateResponse_QNAME, GetListReservationWithEndDateResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBook }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bibliotheque.com/", name = "getBook")
    public JAXBElement<GetBook> createGetBook(GetBook value) {
        return new JAXBElement<GetBook>(_GetBook_QNAME, GetBook.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDaysLoan }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bibliotheque.com/", name = "getDaysLoan")
    public JAXBElement<GetDaysLoan> createGetDaysLoan(GetDaysLoan value) {
        return new JAXBElement<GetDaysLoan>(_GetDaysLoan_QNAME, GetDaysLoan.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link BibliothequeException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bibliotheque.com/", name = "BibliothequeException")
    public JAXBElement<BibliothequeException> createBibliothequeException(BibliothequeException value) {
        return new JAXBElement<BibliothequeException>(_BibliothequeException_QNAME, BibliothequeException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SendToken }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bibliotheque.com/", name = "sendToken")
    public JAXBElement<SendToken> createSendToken(SendToken value) {
        return new JAXBElement<SendToken>(_SendToken_QNAME, SendToken.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link GetListLoanLateResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bibliotheque.com/", name = "getListLoanLateResponse")
    public JAXBElement<GetListLoanLateResponse> createGetListLoanLateResponse(GetListLoanLateResponse value) {
        return new JAXBElement<GetListLoanLateResponse>(_GetListLoanLateResponse_QNAME, GetListLoanLateResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bibliotheque.com/", name = "deleteUser")
    public JAXBElement<DeleteUser> createDeleteUser(DeleteUser value) {
        return new JAXBElement<DeleteUser>(_DeleteUser_QNAME, DeleteUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetListReservationByUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bibliotheque.com/", name = "getListReservationByUserResponse")
    public JAXBElement<GetListReservationByUserResponse> createGetListReservationByUserResponse(GetListReservationByUserResponse value) {
        return new JAXBElement<GetListReservationByUserResponse>(_GetListReservationByUserResponse_QNAME, GetListReservationByUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetListKindResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bibliotheque.com/", name = "getListKindResponse")
    public JAXBElement<GetListKindResponse> createGetListKindResponse(GetListKindResponse value) {
        return new JAXBElement<GetListKindResponse>(_GetListKindResponse_QNAME, GetListKindResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReturnLoanResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bibliotheque.com/", name = "returnLoanResponse")
    public JAXBElement<ReturnLoanResponse> createReturnLoanResponse(ReturnLoanResponse value) {
        return new JAXBElement<ReturnLoanResponse>(_ReturnLoanResponse_QNAME, ReturnLoanResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetListLoanLateByUserID }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bibliotheque.com/", name = "getListLoanLateByUserID")
    public JAXBElement<GetListLoanLateByUserID> createGetListLoanLateByUserID(GetListLoanLateByUserID value) {
        return new JAXBElement<GetListLoanLateByUserID>(_GetListLoanLateByUserID_QNAME, GetListLoanLateByUserID.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link DoConnectionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bibliotheque.com/", name = "doConnectionResponse")
    public JAXBElement<DoConnectionResponse> createDoConnectionResponse(DoConnectionResponse value) {
        return new JAXBElement<DoConnectionResponse>(_DoConnectionResponse_QNAME, DoConnectionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetListReservationByUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bibliotheque.com/", name = "getListReservationByUser")
    public JAXBElement<GetListReservationByUser> createGetListReservationByUser(GetListReservationByUser value) {
        return new JAXBElement<GetListReservationByUser>(_GetListReservationByUser_QNAME, GetListReservationByUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateBook }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bibliotheque.com/", name = "updateBook")
    public JAXBElement<UpdateBook> createUpdateBook(UpdateBook value) {
        return new JAXBElement<UpdateBook>(_UpdateBook_QNAME, UpdateBook.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link ListBookResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bibliotheque.com/", name = "listBookResponse")
    public JAXBElement<ListBookResponse> createListBookResponse(ListBookResponse value) {
        return new JAXBElement<ListBookResponse>(_ListBookResponse_QNAME, ListBookResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListBook }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bibliotheque.com/", name = "listBook")
    public JAXBElement<ListBook> createListBook(ListBook value) {
        return new JAXBElement<ListBook>(_ListBook_QNAME, ListBook.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateBookResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bibliotheque.com/", name = "createBookResponse")
    public JAXBElement<CreateBookResponse> createCreateBookResponse(CreateBookResponse value) {
        return new JAXBElement<CreateBookResponse>(_CreateBookResponse_QNAME, CreateBookResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link ExtendLoanResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bibliotheque.com/", name = "extendLoanResponse")
    public JAXBElement<ExtendLoanResponse> createExtendLoanResponse(ExtendLoanResponse value) {
        return new JAXBElement<ExtendLoanResponse>(_ExtendLoanResponse_QNAME, ExtendLoanResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDaysExtend }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bibliotheque.com/", name = "getDaysExtend")
    public JAXBElement<GetDaysExtend> createGetDaysExtend(GetDaysExtend value) {
        return new JAXBElement<GetDaysExtend>(_GetDaysExtend_QNAME, GetDaysExtend.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetListLoanByUserIDResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bibliotheque.com/", name = "getListLoanByUserIDResponse")
    public JAXBElement<GetListLoanByUserIDResponse> createGetListLoanByUserIDResponse(GetListLoanByUserIDResponse value) {
        return new JAXBElement<GetListLoanByUserIDResponse>(_GetListLoanByUserIDResponse_QNAME, GetListLoanByUserIDResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateBook }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bibliotheque.com/", name = "createBook")
    public JAXBElement<CreateBook> createCreateBook(CreateBook value) {
        return new JAXBElement<CreateBook>(_CreateBook_QNAME, CreateBook.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteBook }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bibliotheque.com/", name = "deleteBook")
    public JAXBElement<DeleteBook> createDeleteBook(DeleteBook value) {
        return new JAXBElement<DeleteBook>(_DeleteBook_QNAME, DeleteBook.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateLoan }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bibliotheque.com/", name = "createLoan")
    public JAXBElement<CreateLoan> createCreateLoan(CreateLoan value) {
        return new JAXBElement<CreateLoan>(_CreateLoan_QNAME, CreateLoan.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EditPassWordByRecovery }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bibliotheque.com/", name = "editPassWordByRecovery")
    public JAXBElement<EditPassWordByRecovery> createEditPassWordByRecovery(EditPassWordByRecovery value) {
        return new JAXBElement<EditPassWordByRecovery>(_EditPassWordByRecovery_QNAME, EditPassWordByRecovery.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetListLoanLateByUserIDResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bibliotheque.com/", name = "getListLoanLateByUserIDResponse")
    public JAXBElement<GetListLoanLateByUserIDResponse> createGetListLoanLateByUserIDResponse(GetListLoanLateByUserIDResponse value) {
        return new JAXBElement<GetListLoanLateByUserIDResponse>(_GetListLoanLateByUserIDResponse_QNAME, GetListLoanLateByUserIDResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bibliotheque.com/", name = "saveUserResponse")
    public JAXBElement<SaveUserResponse> createSaveUserResponse(SaveUserResponse value) {
        return new JAXBElement<SaveUserResponse>(_SaveUserResponse_QNAME, SaveUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLoanResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bibliotheque.com/", name = "getLoanResponse")
    public JAXBElement<GetLoanResponse> createGetLoanResponse(GetLoanResponse value) {
        return new JAXBElement<GetLoanResponse>(_GetLoanResponse_QNAME, GetLoanResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bibliotheque.com/", name = "saveUser")
    public JAXBElement<SaveUser> createSaveUser(SaveUser value) {
        return new JAXBElement<SaveUser>(_SaveUser_QNAME, SaveUser.class, null, value);
    }

}
