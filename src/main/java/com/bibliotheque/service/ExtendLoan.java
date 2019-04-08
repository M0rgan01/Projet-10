
package com.bibliotheque.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour extendLoan complex type.
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="extendLoan">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Loan_ID" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
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
@XmlType(name = "extendLoan", propOrder = {
    "loanID",
    "userId"
})
public class ExtendLoan {

    @XmlElement(name = "Loan_ID")
    protected Long loanID;
    @XmlElement(name = "user_id")
    protected Long userId;

    /**
     * Obtient la valeur de la propri�t� loanID.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getLoanID() {
        return loanID;
    }

    /**
     * D�finit la valeur de la propri�t� loanID.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setLoanID(Long value) {
        this.loanID = value;
    }

    /**
     * Obtient la valeur de la propri�t� userId.
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
     * D�finit la valeur de la propri�t� userId.
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
