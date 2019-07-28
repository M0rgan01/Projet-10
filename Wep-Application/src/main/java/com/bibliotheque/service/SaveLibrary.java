
package com.bibliotheque.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour saveLibrary complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="saveLibrary">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="library" type="{http://service.bibliotheque.com/}library" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "saveLibrary", propOrder = {
    "library"
})
public class SaveLibrary {

    protected Library library;

    /**
     * Obtient la valeur de la propriété library.
     * 
     * @return
     *     possible object is
     *     {@link Library }
     *     
     */
    public Library getLibrary() {
        return library;
    }

    /**
     * Définit la valeur de la propriété library.
     * 
     * @param value
     *     allowed object is
     *     {@link Library }
     *     
     */
    public void setLibrary(Library value) {
        this.library = value;
    }

}
