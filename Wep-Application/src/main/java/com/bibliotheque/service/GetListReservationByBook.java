
package com.bibliotheque.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour getListReservationByBook complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="getListReservationByBook">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Book_ID" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getListReservationByBook", propOrder = {
    "bookID"
})
public class GetListReservationByBook {

    @XmlElement(name = "Book_ID")
    protected Long bookID;

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

}
