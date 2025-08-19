package bibliothéque;

public class GestionnaireLivre {

	Livre[] livres;
	int nbr_livre;
	//int nbr_init;
	
	   public GestionnaireLivre() {
	        this.livres = new Livre[100];
	        this.nbr_livre = 0;
	        //this.nbr_init=0;
	    }
	   public void afficherlivre() {
	        System.out.println("=== Liste les livres ===");
	        for (int i = 0; i < nbr_livre; i++) {
	            System.out.println( "- " + livres[i].toString());
	        }
	    }
	   
	   public boolean ajouterLivre(Livre livre) {
	        if (nbr_livre < 100 && livre != null) 
	        {
	            livres[nbr_livre] = livre;
	            nbr_livre++;
	            return true;
	        }
	        return false;
	    }
	   public int getnbr() {
		    return nbr_livre;
		  }
	   
	   
	   /*public int getnbi() {
		    return nbr_init;
		  }*/
	   
	   public void setnbr(int nbr_livre)
	   {
		   this.nbr_livre=nbr_livre;
	   }
	   /*public void setnbi(int nbr_init)
	   {
		   this.nbr_init=nbr_init;
	   }	 */  
	   
	   public void AjouterTitre(String nouveauTitre, int i) {
		    
		   livres[i].setTitre(nouveauTitre);  
		}
	   
	   public void AjouterAuteur(String nouveauTitre, int i) 
	   {
		    
	        livres[i].setAuteur(nouveauTitre);  
	   }
	   public void AjouterISBN(String nouveauTitre,int i) {
		    
	        livres[i].setISBN(nouveauTitre);  
	}
	   public void AjouterAnn_pub(int nouveauTitre,int i) {
		    
	        livres[i].setAnn_pub(nouveauTitre);  
	}
	   public void AjouterGenre(String nouveauTitre,int i) {
		    
	        livres[i].setGenre(nouveauTitre);  
	}
	   

	   public boolean rechercheLivreParTitre(String Titrev,int N) 
	   {
		   for (int i=0 ; i<N;i++)
			   
		   {
			   if (livres[i].titre != null && livres[i].titre.equalsIgnoreCase(Titrev))
			   {
				   //int I=i+1;
				   System.out.println(livres[i].toString());
				   return true;
			   }
		   
		   }
		   return false;
		}
	   
	   
	   
	   public boolean modifierTitreParIndex(int index, String nouveauTitre) {
		    if (index >= 0 && index < nbr_livre) {
		        livres[index].setTitre(nouveauTitre);
		        return true;
		    }
		    return false;
		}
	   
	   public boolean modifierauteurParIndex(int index, String nouveauauteur) {
		    if (index >= 0 && index < nbr_livre) {
		        livres[index].setAuteur(nouveauauteur);
		        return true;
		    }
		    return false;
		}	   
	   
	   public boolean modifierISBNParIndex(int index, String nouveauISBN) {
		    if (index >= 0 && index < nbr_livre) {
		        livres[index].setISBN(nouveauISBN);
		        return true;
		    }
		    return false;
		}
	   public boolean modifierAnn_pubParIndex(int index, int nouvelleAnn_pub) {
		    if (index >= 0 && index < nbr_livre) {
		        livres[index].setAnn_pub(nouvelleAnn_pub);
		        return true;
		    }
		    return false;
		}
	   
	   public boolean modifierGenreParIndex(int index, String nouveauGenre) {
		    if (index >= 0 && index < nbr_livre) {
		        livres[index].setGenre(nouveauGenre);
		        return true;
		    }
		    return false;
		}
	   
	   public boolean supprimerParIndex(int index) {
		    if (index >= 0 && index < nbr_livre) {
		        for (int i = index; i < nbr_livre - 1; i++) {
		            livres[i] = livres[i + 1];
		        }
		        livres[nbr_livre - 1] = null;
		        nbr_livre--;
		        return true;
		    }
		    return false;
		}
	   
	   
	   
	   
	/*   public void setTitre(String titre) {
	
		  }*/
	   
	   /////
	   /*public Livre rechercherParNom(String nom) {
	        for (int i = 0; i < nbr_livre; i++) {
	            if (livres[i].getTitre() != null && 
	                livres[i].getTitre().equalsIgnoreCase(nom)) {
	                return livres[i];
	            }
	        }
	        return null;
	    }*/
}
