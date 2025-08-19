package bibliothéque;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class main {

	

	public static void main(String[] args) throws IOException {
	
		Scanner sc= new Scanner(System.in);
		Scanner sc1= new Scanner(System.in);
		Scanner sc2= new Scanner(System.in);
		Scanner sc3= new Scanner(System.in);		
		
		GestionnaireLivre gl = new GestionnaireLivre();
		
		int NbI=0;
		
		
		try {
			BufferedReader rd = new  BufferedReader(new FileReader("test.txt"));
			String line;
			while ((line=rd.readLine()) != null) 
			{
				Livre lv1 = new Livre ();
             int debutTitre = line.indexOf("le livre intituler: ") + "le livre intituler: ".length();
             int finTitre = line.indexOf(", par l'écrivaint:" );
             String Title = line.substring(debutTitre, finTitre).trim();             
			 System.out.println("***************"+Title+"**************");
			 lv1.setTitre(Title);
			 int debutAuteur = line.indexOf(", par l'écrivaint: ") + ", par l'écrivaint: ".length();
             int finAuteur = line.indexOf(", posséde l'ISBN suivant: " );
             String Autor = line.substring(debutAuteur, finAuteur).trim();
             lv1.setAuteur(Autor);
             int debutISBN = line.indexOf(", posséde l'ISBN suivant: ") + ", posséde l'ISBN suivant: ".length();
             int finISBN = line.indexOf(", publier en " );
             String ISBN = line.substring(debutISBN, finISBN).trim();
             lv1.setISBN(ISBN);
             int debutY_pub = line.indexOf(", publier en ") + ", publier en ".length();
             int finY_pub = line.indexOf(" et du genre: " );
             String Y_pub = line.substring(debutY_pub, finY_pub).trim();
             int Y_pub2 = Integer.parseInt(Y_pub);
             lv1.setAnn_pub(Y_pub2);
             int debutGenra = line.indexOf(" et du genre: ") + " et du genre: ".length();
             String Genra = line.substring(debutGenra).trim();
             lv1.setGenre(Genra);
             gl.ajouterLivre(lv1);
			NbI++;			
			}
			rd.close();			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("le nombre de livre dans cett liste est de : " + NbI);

		System.out.println("combien de livre voulez-vous introduire:");
		int nb_livre_int= sc1.nextInt();
		
		
		for (int i=0;i<nb_livre_int;i++)
		{
			Livre lv = new Livre (/*"TLOTR","Tolkien","9788845292613",1954,"aventure et fantaisie"*/);
			System.out.println("rentrer le nom du livre:");
			lv.setTitre(sc.nextLine());
			System.out.println("rentrer le nom de l'auteur:");
			lv.setAuteur(sc.nextLine());
			System.out.println("rentrer l'ISBN:");
			lv.setISBN(sc.nextLine());
			System.out.println("rentrer le genre du livre:");
			lv.setGenre(sc.nextLine());
			System.out.println("rentrer l'année de publication:");
			lv.setAnn_pub(sc.nextInt());
			gl.ajouterLivre(lv);
			sc.nextLine();
		}		
		gl.afficherlivre();
		int N= gl.getnbr();

		/*try 
		{
			BufferedWriter wr = new BufferedWriter(new FileWriter("test.txt"));
			for (int i=0; i<=N; i++) 
			{int I=i+1;
			wr.write(I+"\n"+ gl.livres[i]+"\n");
			}
			wr.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}*/
		
		int F=1;
		while (F==1) 
		{
		System.out.println("que voulez-vous faire: \n1:modifier. \n2:supprimer. \n3:ajouter. \n4:recherche \n5:rien");
		int Cond=sc.nextInt();
		
		///////////////////////////////MODIF///////////////////////////
		if (Cond==1)
		{
			System.out.println("rentrer le numéro du livre: ");
			int num_livre2=sc.nextInt();
			int num_livre=num_livre2-1;
			System.out.println("rentrer le nouveau titre du livre: ");
			String nv_titre=sc.nextLine();
			gl.modifierTitreParIndex(num_livre, nv_titre);
			System.out.println("rentrer le nouvelle auteur du livre: ");
			String nv_auteur=sc.nextLine();
			gl.modifierauteurParIndex(num_livre, nv_auteur);
			System.out.println("rentrer le nouvelle ISBN du livre: ");
			String nv_isbn=sc.nextLine();
			gl.modifierISBNParIndex(num_livre, nv_isbn);
			System.out.println("rentrer le nouvelle date de publication du livre: ");
			int nv_Ann=sc.nextInt();
			gl.modifierAnn_pubParIndex(num_livre, nv_Ann);
			System.out.println("rentrer le nouveau genre du livre: ");
			String nv_genre=sc.nextLine();
			gl.modifierGenreParIndex(num_livre, nv_genre);
		}
		////////////////////////////////DELET//////////////////////////
		else if (Cond==2)
		{
			System.out.println("quelle livre vous voulez suprimmer ");
			int num_livre=sc.nextInt();
			gl.supprimerParIndex(num_livre-1);
			
		}
		///////////////////////////////////ADD//////////////////////////
		else if (Cond==3)
		{
			System.out.println("quelle livre vous voulez ajouter ");
			Livre lv2 = new Livre ();
			
			lv2.setTitre("nouveau livre");
			lv2.setAuteur("nouvelle auteur");
			lv2.setISBN("nouveau ISBN");
			lv2.setAnn_pub(1999);
			lv2.setGenre("nouveau genre");
			gl.ajouterLivre(lv2);
			//gl.setnbr(nb_livre_int++);
			System.out.println(gl.getnbr());

		}
		//////////////////////////////////SEARCH////////////////////////
		else if (Cond==4)
		{
			System.out.println("rentrer le titre du livre que vous rechercher:");
			String srch; 
			srch=sc.nextLine();
			gl.rechercheLivreParTitre(srch,gl.getnbr());
			

		}
///////////////////////////R1///////////////////////////////////////		
		else if (Cond==5)
		{}
		else
		{
			System.out.println("erreur!");	
		
		}
		
		
		System.out.println("souhaiter vous continuer: \n1:oui.\n2:non");
		F= sc.nextInt();
		}
		
		
		gl.afficherlivre();
						
		
		try 
		{
			BufferedWriter wr = new BufferedWriter(new FileWriter("test.txt"));
			for (int i=0; i<=gl.getnbr()-1; i++) 
			{
				//int I=NbI+i+1;
			wr.write( "- " + gl.livres[i]+"\n");
			}
			wr.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}		
	}
}
