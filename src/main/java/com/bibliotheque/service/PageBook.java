
package com.bibliotheque.service;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour pageBook complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="pageBook">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="books" type="{http://service.bibliotheque.com/}book" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="numberBook" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="page" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="totalsBooks" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="totalsPage" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "pageBook", propOrder = {
    "books",
    "numberBook",
    "page",
    "totalsBooks",
    "totalsPage"
})
public class PageBook {

    @XmlElement(nillable = true)
    protected List<Book> books;
    protected int numberBook;
    protected int page;
    protected int totalsBooks;
    protected int totalsPage;

    /**
     * Gets the value of the books property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the books property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBooks().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Book }
     * 
     * 
     */
    public List<Book> getBooks() {
        if (books == null) {
            books = new ArrayList<Book>();
        }
        return this.books;
    }

    /**
     * Obtient la valeur de la propriété numberBook.
     * 
     */
    public int getNumberBook() {
        return numberBook;
    }

    /**
     * Définit la valeur de la propriété numberBook.
     * 
     */
    public void setNumberBook(int value) {
        this.numberBook = value;
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
     * Obtient la valeur de la propriété totalsBooks.
     * 
     */
    public int getTotalsBooks() {
        return totalsBooks;
    }

    /**
     * Définit la valeur de la propriété totalsBooks.
     * 
     */
    public void setTotalsBooks(int value) {
        this.totalsBooks = value;
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

}
