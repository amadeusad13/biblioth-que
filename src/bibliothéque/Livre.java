package bibliothéque;

public class Livre {
	String titre;
	String auteur;
	String ISBN;
	int Ann_pub;
	String genre;	

	  public String getTitre() {
		    return titre;
		  }
	  public String getAuteur() {
		    return auteur;
		  }
	  public String getISBN() {
		    return ISBN;
		  }
	  public int getAnn_pub() {
		    return Ann_pub;
		  }
	  public String getGenre() {
		    return genre;
		  }	  
	    
	  
	  public String toString()
	{
		return("le livre intituler: "+ titre + ", par l'écrivaint: " + auteur+", posséde l'ISBN suivant: "+ISBN+", publier en "+ Ann_pub+" et du genre: " +genre);
	}
	
	
	
	public void setTitre(String titre) {
	    this.titre = titre;
	  }
	public void setAuteur(String auteur) {
	    this.auteur = auteur;
	  }
	public void setISBN(String ISBN) {
	    this.ISBN = ISBN;
	  }
	public void setAnn_pub(int Ann_pub) {
	    this.Ann_pub = Ann_pub;
	  }
	public void setGenre(String genre) {
	    this.genre = genre;
	  }

}
