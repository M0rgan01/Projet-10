
package com.bibliotheque.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour getListReservationRetardedByUtilisateurID complex type.
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="getListReservationRetardedByUtilisateurID">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="utilisateur_id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getListReservationRetardedByUtilisateurID", propOrder = {
    "utilisateurId"
})
public class GetListReservationRetardedByUtilisateurID {

    @XmlElement(name = "utilisateur_id")
    protected Long utilisateurId;

    /**
     * Obtient la valeur de la propri�t� utilisateurId.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getUtilisateurId() {
        return utilisateurId;
    }

    /**
     * D�finit la valeur de la propri�t� utilisateurId.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setUtilisateurId(Long value) {
        this.utilisateurId = value;
    }

}
