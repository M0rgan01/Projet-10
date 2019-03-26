
package com.bibliotheque.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java pour utilisateur complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
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
 *         &lt;element name="passWordConfirm" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pseudo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
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
    "passWordConfirm",
    "pseudo"
})
public class Utilisateur {

    protected boolean active;
    protected int essaisConnection;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar expirationConnection;
    protected Long id;
    protected String passWord;
    protected String passWordConfirm;
    protected String pseudo;

    /**
     * Obtient la valeur de la propriété active.
     * 
     */
    public boolean isActive() {
        return active;
    }

    /**
     * Définit la valeur de la propriété active.
     * 
     */
    public void setActive(boolean value) {
        this.active = value;
    }

    /**
     * Obtient la valeur de la propriété essaisConnection.
     * 
     */
    public int getEssaisConnection() {
        return essaisConnection;
    }

    /**
     * Définit la valeur de la propriété essaisConnection.
     * 
     */
    public void setEssaisConnection(int value) {
        this.essaisConnection = value;
    }

    /**
     * Obtient la valeur de la propriété expirationConnection.
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
     * Définit la valeur de la propriété expirationConnection.
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
     * Obtient la valeur de la propriété passWord.
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
     * Définit la valeur de la propriété passWord.
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
     * Obtient la valeur de la propriété passWordConfirm.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPassWordConfirm() {
        return passWordConfirm;
    }

    /**
     * Définit la valeur de la propriété passWordConfirm.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPassWordConfirm(String value) {
        this.passWordConfirm = value;
    }

    /**
     * Obtient la valeur de la propriété pseudo.
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
     * Définit la valeur de la propriété pseudo.
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
