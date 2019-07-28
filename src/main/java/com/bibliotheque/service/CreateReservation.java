
package com.bibliotheque.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour createReservation complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="createReservation">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="reservation" type="{http://service.bibliotheque.com/}reservation" minOccurs="0"/>
 *         &lt;element name="ouvrage_id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
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
@XmlType(name = "createReservation", propOrder = {
    "reservation",
    "ouvrageId",
    "utilisateurId"
})
public class CreateReservation {

    protected Reservation reservation;
    @XmlElement(name = "ouvrage_id")
    protected Long ouvrageId;
    @XmlElement(name = "utilisateur_id")
    protected Long utilisateurId;

    /**
     * Obtient la valeur de la propriété reservation.
     * 
     * @return
     *     possible object is
     *     {@link Reservation }
     *     
     */
    public Reservation getReservation() {
        return reservation;
    }

    /**
     * Définit la valeur de la propriété reservation.
     * 
     * @param value
     *     allowed object is
     *     {@link Reservation }
     *     
     */
    public void setReservation(Reservation value) {
        this.reservation = value;
    }

    /**
     * Obtient la valeur de la propriété ouvrageId.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getOuvrageId() {
        return ouvrageId;
    }

    /**
     * Définit la valeur de la propriété ouvrageId.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setOuvrageId(Long value) {
        this.ouvrageId = value;
    }

    /**
     * Obtient la valeur de la propriété utilisateurId.
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
     * Définit la valeur de la propriété utilisateurId.
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
