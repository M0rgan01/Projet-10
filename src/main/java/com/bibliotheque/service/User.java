
package com.bibliotheque.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java pour user complex type.
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="user">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="active" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="expiryConnection" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="oldPassWord" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="passWord" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="passWordConfirm" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pseudo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tryConnection" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "user", propOrder = {
    "active",
    "expiryConnection",
    "id",
    "oldPassWord",
    "passWord",
    "passWordConfirm",
    "pseudo",
    "tryConnection"
})
public class User {

    protected boolean active;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar expiryConnection;
    protected Long id;
    protected String oldPassWord;
    protected String passWord;
    protected String passWordConfirm;
    protected String pseudo;
    protected int tryConnection;

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
     * Obtient la valeur de la propri�t� expiryConnection.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getExpiryConnection() {
        return expiryConnection;
    }

    /**
     * D�finit la valeur de la propri�t� expiryConnection.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setExpiryConnection(XMLGregorianCalendar value) {
        this.expiryConnection = value;
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
     * Obtient la valeur de la propri�t� oldPassWord.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOldPassWord() {
        return oldPassWord;
    }

    /**
     * D�finit la valeur de la propri�t� oldPassWord.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOldPassWord(String value) {
        this.oldPassWord = value;
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
     * Obtient la valeur de la propri�t� passWordConfirm.
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
     * D�finit la valeur de la propri�t� passWordConfirm.
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

    /**
     * Obtient la valeur de la propri�t� tryConnection.
     * 
     */
    public int getTryConnection() {
        return tryConnection;
    }

    /**
     * D�finit la valeur de la propri�t� tryConnection.
     * 
     */
    public void setTryConnection(int value) {
        this.tryConnection = value;
    }

}
