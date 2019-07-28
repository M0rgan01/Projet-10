
package com.bibliotheque.service;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour pagination complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="pagination">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="numberT" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="page" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="t" type="{http://www.w3.org/2001/XMLSchema}anyType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="totalsPage" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="totalsT" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "pagination", propOrder = {
    "numberT",
    "page",
    "t",
    "totalsPage",
    "totalsT"
})
public class Pagination {

    protected int numberT;
    protected int page;
    @XmlElement(nillable = true)
    protected List<Object> t;
    protected int totalsPage;
    protected int totalsT;

    /**
     * Obtient la valeur de la propriété numberT.
     * 
     */
    public int getNumberT() {
        return numberT;
    }

    /**
     * Définit la valeur de la propriété numberT.
     * 
     */
    public void setNumberT(int value) {
        this.numberT = value;
    }

    /**
     * Obtient la valeur de la propriété page.
     * 
     */
    public int getPage() {
        return page;
    }

    /**
     * Définit la valeur de la propriété page.
     * 
     */
    public void setPage(int value) {
        this.page = value;
    }

    /**
     * Gets the value of the t property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the t property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getT().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     * 
     * 
     */
    public List<Object> getT() {
        if (t == null) {
            t = new ArrayList<Object>();
        }
        return this.t;
    }

    /**
     * Obtient la valeur de la propriété totalsPage.
     * 
     */
    public int getTotalsPage() {
        return totalsPage;
    }

    /**
     * Définit la valeur de la propriété totalsPage.
     * 
     */
    public void setTotalsPage(int value) {
        this.totalsPage = value;
    }

    /**
     * Obtient la valeur de la propriété totalsT.
     * 
     */
    public int getTotalsT() {
        return totalsT;
    }

    /**
     * Définit la valeur de la propriété totalsT.
     * 
     */
    public void setTotalsT(int value) {
        this.totalsT = value;
    }

}
