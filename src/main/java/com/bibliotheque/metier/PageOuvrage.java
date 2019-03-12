package com.bibliotheque.metier;

import java.io.Serializable;
import java.util.List;

import com.bibliotheque.entities.Ouvrage;

public class PageOuvrage implements Serializable{

	private List<Ouvrage> ouvrages;
	private int page;
	private int totalPage;
	private int nombreOuvrages;
	private int totalOuvrages;
	
	public List<Ouvrage> getOuvrages() {
		return ouvrages;
	}
	public void setOuvrages(List<Ouvrage> ouvrages) {
		this.ouvrages = ouvrages;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getNombreOuvrages() {
		return nombreOuvrages;
	}
	public void setNombreOuvrages(int nombreOuvrages) {
		this.nombreOuvrages = nombreOuvrages;
	}
	public int getTotalOuvrages() {
		return totalOuvrages;
	}
	public void setTotalOuvrages(int totalOuvrages) {
		this.totalOuvrages = totalOuvrages;
	}
	
	
}
