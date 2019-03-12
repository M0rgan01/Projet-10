package com.bibliotheque.pager;

public class PagerModel {
	
		// bouton total (hormis les << >> et fleche)
		private int buttonsToShow = 6;
	    private int startPage;
	    private int endPage;
	    
	    
	    public PagerModel(int totalPages, int currentPage, int buttonsToShow) {
	    	
	        setButtonsToShow(buttonsToShow);
	        
	        //moitier des bouton
	        int halfPagesToShow = getButtonsToShow() / 2;
	        
	        
	        // si le nombre de page est inferieur ou egal au nombre de bouton, on assigne
	        if (totalPages <= getButtonsToShow()) {
	            setStartPage(1);
	            setEndPage(totalPages);
	            
	       // si la page courante moin le nombre de bouton a afficher est inferieur ou egal a 0     
	        } else if (currentPage - halfPagesToShow <= 0) {
	            setStartPage(1);
	            setEndPage(getButtonsToShow());
	            
	        // si la page courante plus le nombre de bouton a afficher est egal au total de page  
	        } else if (currentPage + halfPagesToShow == totalPages) {
	            setStartPage(currentPage - halfPagesToShow);
	            setEndPage(totalPages);
	            
	            
	        } else if (currentPage + halfPagesToShow > totalPages) {
	            setStartPage(totalPages - getButtonsToShow() + 1);
	            setEndPage(totalPages);
	            
	            
	        } else {	        		        	
	            setStartPage(currentPage - halfPagesToShow);
	            setEndPage(currentPage + halfPagesToShow);
	        }
	    }
	    
	    
	    public int getButtonsToShow() {
	        return buttonsToShow;
	    }
	    
	    
	    public void setButtonsToShow(int buttonsToShow) {
	        if (buttonsToShow % 2 != 0) {
	            this.buttonsToShow = buttonsToShow;
	        } else {
	            throw new IllegalArgumentException("Must be an odd value!");
	        }
	    }
	    
	    public int getStartPage() {
	        return startPage;
	    }
	    public void setStartPage(int startPage) {
	        this.startPage = startPage;
	    }
	    public int getEndPage() {
	        return endPage;
	    }
	    public void setEndPage(int endPage) {
	        this.endPage = endPage;
	    }
	   
}
