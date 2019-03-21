
package com.bibliotheque.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java pour utilisateur complex type.
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="utilisateur">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="active" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="essaisConnection" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="expirationConnection" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="passWord" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pseudo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "utilisateur", propOrder = {
    "active",
    "essaisConnection",
    "expirationConnection",
    "id",
    "passWord",
    "pseudo"
})
public class Utilisateur {

    protected boolean active;
    protected int essaisConnection;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar expirationConnection;
    protected Long id;
    protected String passWord;
    protected String pseudo;

    /**
     * Obtient la valeur de la propri�t� active.
     * 
     */
    public boolean isActive() {
        return active;
    }

    /**
     * D�finit la valeur de la propri�t� active.
     * 
     */
    public void setActive(boolean value) {
        this.active = value;
    }

    /**
     * Obtient la valeur de la propri�t� essaisConnection.
     * 
     */
    public int getEssaisConnection() {
        return essaisConnection;
    }

    /**
     * D�finit la valeur de la propri�t� essaisConnection.
     * 
     */
    public void setEssaisConnection(int value) {
        this.essaisConnection = value;
    }

    /**
     * Obtient la valeur de la propri�t� expirationConnection.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getExpirationConnection() {
        return expirationConnection;
    }

    /**
     * D�finit la valeur de la propri�t� expirationConnection.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setExpirationConnection(XMLGregorianCalendar value) {
        this.expirationConnection = value;
    }

    /**
     * Obtient la valeur de la propri�t� id.
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
     * D�finit la valeur de la propri�t� id.
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
     * Obtient la valeur de la propri�t� passWord.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPassWord() {
        return passWord;
    }

    /**
     * D�finit la valeur de la propri�t� passWord.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPassWord(String value) {
        this.passWord = value;
    }

    /**
     * Obtient la valeur de la propri�t� pseudo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPseudo() {
        return pseudo;
    }

    /**
     * D�finit la valeur de la propri�t� pseudo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPseudo(String value) {
        this.pseudo = value;
    }

}
