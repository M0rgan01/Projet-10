
package com.bibliotheque.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java pour loan complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="loan">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="book" type="{http://service.bibliotheque.com/}book" minOccurs="0"/>
 *         &lt;element name="end_loan" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="extension" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="late" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="made" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="start_loan" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="user" type="{http://service.bibliotheque.com/}user" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "loan", propOrder = {
    "book",
    "endLoan",
    "extension",
    "id",
    "late",
    "made",
    "startLoan",
    "user"
})
public class Loan {

    protected Book book;
    @XmlElement(name = "end_loan")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar endLoan;
    protected boolean extension;
    protected Long id;
    protected boolean late;
    protected boolean made;
    @XmlElement(name = "start_loan")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar startLoan;
    protected User user;

    /**
     * Obtient la valeur de la propriété book.
     * 
     * @return
     *     possible object is
     *     {@link Book }
     *     
     */
    public Book getBook() {
        return book;
    }

    /**
     * Définit la valeur de la propriété book.
     * 
     * @param value
     *     allowed object is
     *     {@link Book }
     *     
     */
    public void setBook(Book value) {
        this.book = value;
    }

    /**
     * Obtient la valeur de la propriété endLoan.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEndLoan() {
        return endLoan;
    }

    /**
     * Définit la valeur de la propriété endLoan.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEndLoan(XMLGregorianCalendar value) {
        this.endLoan = value;
    }

    /**
     * Obtient la valeur de la propriété extension.
     * 
     */
    public boolean isExtension() {
        return extension;
    }

    /**
     * Définit la valeur de la propriété extension.
     * 
     */
    public void setExtension(boolean value) {
        this.extension = value;
    }

    /**
     * Obtient la valeur de la propriété id.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getId() {
        return id;
    }

    /**
     * Définit la valeur de la propriété id.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setId(Long value) {
        this.id = value;
    }

    /**
     * Obtient la valeur de la propriété late.
     * 
     */
    public boolean isLate() {
        return late;
    }

    /**
     * Définit la valeur de la propriété late.
     * 
     */
    public void setLate(boolean value) {
        this.late = value;
    }

    /**
     * Obtient la valeur de la propriété made.
     * 
     */
    public boolean isMade() {
        return made;
    }

    /**
     * Définit la valeur de la propriété made.
     * 
     */
    public void setMade(boolean value) {
        this.made = value;
    }

    /**
     * Obtient la valeur de la propriété startLoan.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getStartLoan() {
        return startLoan;
    }

    /**
     * Définit la valeur de la propriété startLoan.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setStartLoan(XMLGregorianCalendar value) {
        this.startLoan = value;
    }

    /**
     * Obtient la valeur de la propriété user.
     * 
     * @return
     *     possible object is
     *     {@link User }
     *     
     */
    public User getUser() {
        return user;
    }

    /**
     * Définit la valeur de la propriété user.
     * 
     * @param value
     *     allowed object is
     *     {@link User }
     *     
     */
    public void setUser(User value) {
        this.user = value;
    }

}
