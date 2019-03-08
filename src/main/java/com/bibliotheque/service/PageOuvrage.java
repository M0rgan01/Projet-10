
package com.bibliotheque.service;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour pageOuvrage complex type.
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="pageOuvrage">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="nombreOuvrages" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ouvrages" type="{http://service.bibliotheque.com/}ouvrage" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="page" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="totalOuvrages" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="totalPage" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "pageOuvrage", propOrder = {
    "nombreOuvrages",
    "ouvrages",
    "page",
    "totalOuvrages",
    "totalPage"
})
public class PageOuvrage {

    protected int nombreOuvrages;
    @XmlElement(nillable = true)
    protected List<Ouvrage> ouvrages;
    protected int page;
    protected int totalOuvrages;
    protected int totalPage;

    /**
     * Obtient la valeur de la propri�t� nombreOuvrages.
     * 
     */
    public int getNombreOuvrages() {
        return nombreOuvrages;
    }

    /**
     * D�finit la valeur de la propri�t� nombreOuvrages.
     * 
     */
    public void setNombreOuvrages(int value) {
        this.nombreOuvrages = value;
    }

    /**
     * Gets the value of the ouvrages property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ouvrages property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOuvrages().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Ouvrage }
     * 
     * 
     */
    public List<Ouvrage> getOuvrages() {
        if (ouvrages == null) {
            ouvrages = new ArrayList<Ouvrage>();
        }
        return this.ouvrages;
    }

    /**
     * Obtient la valeur de la propri�t� page.
     * 
     */
    public int getPage() {
        return page;
    }

    /**
     * D�finit la valeur de la propri�t� page.
     * 
     */
    public void setPage(int value) {
        this.page = value;
    }

    /**
     * Obtient la valeur de la propri�t� totalOuvrages.
     * 
     */
    public int getTotalOuvrages() {
        return totalOuvrages;
    }

    /**
     * D�finit la valeur de la propri�t� totalOuvrages.
     * 
     */
    public void setTotalOuvrages(int value) {
        this.totalOuvrages = value;
    }

    /**
     * Obtient la valeur de la propri�t� totalPage.
     * 
     */
    public int getTotalPage() {
        return totalPage;
    }

    /**
     * D�finit la valeur de la propri�t� totalPage.
     * 
     */
    public void setTotalPage(int value) {
        this.totalPage = value;
    }

}
