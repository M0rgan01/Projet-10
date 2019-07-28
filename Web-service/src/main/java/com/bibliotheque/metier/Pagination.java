package com.bibliotheque.metier;

import java.io.Serializable;
import java.util.List;

/**
 * Object simplifiant la pagination d'une liste
 * 
 * @author pichat morgan
 *
 * @param <T>
 */
public class Pagination<T> implements Serializable{

	private List<T> t;
	private int page;
	private int totalsPage;
	private int numberT;
	private int totalsT;
	
	public List<T> getT() {
		return t;
	}
	public void setT(List<T> t) {
		this.t = t;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getTotalsPage() {
		return totalsPage;
	}
	public void setTotalsPage(int totalsPage) {
		this.totalsPage = totalsPage;
	}
	public int getNumberT() {
		return numberT;
	}
	public void setNumberT(int numberT) {
		this.numberT = numberT;
	}
	public int getTotalsT() {
		return totalsT;
	}
	public void setTotalsT(int totalsT) {
		this.totalsT = totalsT;
	}
		
}
