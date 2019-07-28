
package com.bibliotheque.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour BibliothequeException complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="BibliothequeException">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="info" type="{http://service.bibliotheque.com/}bibliothequeFault" minOccurs="0"/>
 *         &lt;element name="message" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BibliothequeException", propOrder = {
    "info",
    "message"
})
public class BibliothequeException {

    protected BibliothequeFault info;
    protected String message;

    /**
     * Obtient la valeur de la propriété info.
     * 
     * @return
     *     possible object is
     *     {@link BibliothequeFault }
     *     
     */
    public BibliothequeFault getInfo() {
        return info;
    }

    /**
     * Définit la valeur de la propriété info.
     * 
     * @param value
     *     allowed object is
     *     {@link BibliothequeFault }
     *     
     */
    public void setInfo(BibliothequeFault value) {
        this.info = value;
    }

    /**
     * Obtient la valeur de la propriété message.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessage() {
        return message;
    }

    /**
     * Définit la valeur de la propriété message.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessage(String value) {
        this.message = value;
    }

}
