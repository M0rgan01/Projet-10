
package com.bibliotheque.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour getLibrary complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="getLibrary">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="library_id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getLibrary", propOrder = {
    "libraryId"
})
public class GetLibrary {

    @XmlElement(name = "library_id")
    protected Long libraryId;

    /**
     * Obtient la valeur de la propriété libraryId.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getLibraryId() {
        return libraryId;
    }

    /**
     * Définit la valeur de la propriété libraryId.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setLibraryId(Long value) {
        this.libraryId = value;
    }

}
