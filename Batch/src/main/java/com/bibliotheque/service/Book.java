
package com.bibliotheque.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java pour book complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="book">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="author" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="available" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="availableReservation" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="copyAvailable" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="copyTotals" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="disable" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="kind" type="{http://service.bibliotheque.com/}kind" minOccurs="0"/>
 *         &lt;element name="loanBack" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="numberReservation" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="title" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "book", propOrder = {
    "author",
    "available",
    "availableReservation",
    "copyAvailable",
    "copyTotals",
    "description",
    "disable",
    "id",
    "kind",
    "loanBack",
    "numberReservation",
    "title"
})
public class Book {

    protected String author;
    protected boolean available;
    protected boolean availableReservation;
    protected int copyAvailable;
    protected int copyTotals;
    protected String description;
    protected boolean disable;
    protected Long id;
    protected Kind kind;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar loanBack;
    protected int numberReservation;
    protected String title;

    /**
     * Obtient la valeur de la propriété author.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Définit la valeur de la propriété author.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuthor(String value) {
        this.author = value;
    }

    /**
     * Obtient la valeur de la propriété available.
     * 
     */
    public boolean isAvailable() {
        return available;
    }

    /**
     * Définit la valeur de la propriété available.
     * 
     */
    public void setAvailable(boolean value) {
        this.available = value;
    }

    /**
     * Obtient la valeur de la propriété availableReservation.
     * 
     */
    public boolean isAvailableReservation() {
        return availableReservation;
    }

    /**
     * Définit la valeur de la propriété availableReservation.
     * 
     */
    public void setAvailableReservation(boolean value) {
        this.availableReservation = value;
    }

    /**
     * Obtient la valeur de la propriété copyAvailable.
     * 
     */
    public int getCopyAvailable() {
        return copyAvailable;
    }

    /**
     * Définit la valeur de la propriété copyAvailable.
     * 
     */
    public void setCopyAvailable(int value) {
        this.copyAvailable = value;
    }

    /**
     * Obtient la valeur de la propriété copyTotals.
     * 
     */
    public int getCopyTotals() {
        return copyTotals;
    }

    /**
     * Définit la valeur de la propriété copyTotals.
     * 
     */
    public void setCopyTotals(int value) {
        this.copyTotals = value;
    }

    /**
     * Obtient la valeur de la propriété description.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Définit la valeur de la propriété description.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Obtient la valeur de la propriété disable.
     * 
     */
    public boolean isDisable() {
        return disable;
    }

    /**
     * Définit la valeur de la propriété disable.
     * 
     */
    public void setDisable(boolean value) {
        this.disable = value;
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
     * Obtient la valeur de la propriété kind.
     * 
     * @return
     *     possible object is
     *     {@link Kind }
     *     
     */
    public Kind getKind() {
        return kind;
    }

    /**
     * Définit la valeur de la propriété kind.
     * 
     * @param value
     *     allowed object is
     *     {@link Kind }
     *     
     */
    public void setKind(Kind value) {
        this.kind = value;
    }

    /**
     * Obtient la valeur de la propriété loanBack.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getLoanBack() {
        return loanBack;
    }

    /**
     * Définit la valeur de la propriété loanBack.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setLoanBack(XMLGregorianCalendar value) {
        this.loanBack = value;
    }

    /**
     * Obtient la valeur de la propriété numberReservation.
     * 
     */
    public int getNumberReservation() {
        return numberReservation;
    }

    /**
     * Définit la valeur de la propriété numberReservation.
     * 
     */
    public void setNumberReservation(int value) {
        this.numberReservation = value;
    }

    /**
     * Obtient la valeur de la propriété title.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitle() {
        return title;
    }

    /**
     * Définit la valeur de la propriété title.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitle(String value) {
        this.title = value;
    }

}
