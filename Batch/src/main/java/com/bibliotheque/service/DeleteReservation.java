
package com.bibliotheque.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour deleteReservation complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="deleteReservation">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Book_ID" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="user_id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "deleteReservation", propOrder = {
    "bookID",
    "userId"
})
public class DeleteReservation {

    @XmlElement(name = "Book_ID")
    protected Long bookID;
    @XmlElement(name = "user_id")
    protected Long userId;

    /**
     * Obtient la valeur de la propriété bookID.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getBookID() {
        return bookID;
    }

    /**
     * Définit la valeur de la propriété bookID.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setBookID(Long value) {
        this.bookID = value;
    }

    /**
     * Obtient la valeur de la propriété userId.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * Définit la valeur de la propriété userId.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setUserId(Long value) {
        this.userId = value;
    }

}
