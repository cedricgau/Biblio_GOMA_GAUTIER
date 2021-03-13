package Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Iterator;

import DAO.ExemplairesDAO;
import DAO.UtilisateurDao;
import Exceptions.BiblioException;
import Schemas.Adherent;
import Schemas.Employe;
import Schemas.EmpruntArchive;
import Schemas.EmpruntEnCours;
import Schemas.EnumCategorieEmploye;
import Schemas.EnumStatusExemplaire;
import Schemas.Exemplaire;
import Schemas.Utilisateur;
import DAO.ExemplairesDAO;
import DAO.UtilisateurDao;

public class Test_DAO {
	

	public static void main(String[] args) throws Exception {
		
		// TestDeBase 1
		System.out.println("\t\t Test de Base 1.1");
		System.out.println("********************************************************\n");
		System.out.println("Demande de deux exemplaires par leur id aux Dao :\n");
		System.out.println(Arrays.toString(ExemplairesDAO.findByKey(1,2)));
		
		// TestDeBase /3
		
		UtilisateurDao udao = new UtilisateurDao();
		 
		Iterator <Utilisateur> it;
		 
		System.out.println("********************************************************\n");
		System.out.println();
		System.out.println("Voici tous les Utilisateurs");
		System.out.println();
		it = udao.findAll().iterator();
		while( it.hasNext() ) 
		{
			System.out.println("\t" + it.next());
		}
		System.out.println();
		System.out.println("Demandes d'un adhérent par son id aux Dao : \n");
		System.out.println("\"1\" trouvé:\n\t" + udao.findByKey(1) );
		System.out.println("********************************************************\n");
		
		System.out.println();
		System.out.println("Demandes d'un employe par son id aux Dao : \n");
		System.out.println("\"1\" trouvé:\n\t" + udao.findByKey(3) );
		System.out.println("********************************************************\n");
		
		
		// TestDeBase 4/5
		System.out.println();
		System.out.println("\t\tCREATION D'UN EMPRUNT");
		ExemplairesDAO edao = new ExemplairesDAO();
		
		Adherent Bob = new Adherent("MO", "Bob", "01/03/2021", "Homme", 5,"azerrt", "Bob01", "056871369");
		Adherent Mia = new Adherent("MO", "Mia", "01/03/2021", "Femme", 8,"azert", "Mia01", "056871599");
		System.out.println("\nCréation d'un nouvel Adhérent : "+Mia);
		Employe paul = new Employe("Miral", "Paul", "20/01/1999", "Homme", 3,"emc2","Enstein555", "BU_Paris13_01 1", EnumCategorieEmploye.BIBLIOTHECAIRE);
		System.out.println("\nCréation d'un nouvel Employé : "+paul+"\n");
		
		Exemplaire a = new Exemplaire("agr",1,"09/03/2021",EnumStatusExemplaire.DISPONIBLE);
		Exemplaire b = new Exemplaire("apo",2,"01/03/2021",EnumStatusExemplaire.DISPONIBLE);
		Exemplaire c = new Exemplaire("bcr",3,"09/03/2021",EnumStatusExemplaire.DISPONIBLE);
		Exemplaire d = new Exemplaire("deo",4,"01/03/2021",EnumStatusExemplaire.DISPONIBLE);
		Exemplaire e = new Exemplaire("fgr",5,"09/01/2021",EnumStatusExemplaire.DISPONIBLE);
		Exemplaire f = new Exemplaire("hio",6,"01/01/2021",EnumStatusExemplaire.DISPONIBLE);
		Exemplaire g = new Exemplaire("fgsr",7,"09/03/2021",EnumStatusExemplaire.DISPONIBLE);
		Exemplaire h = new Exemplaire("aeg",8,"01/03/2021",EnumStatusExemplaire.DISPONIBLE);
		Exemplaire i = new Exemplaire("bgy",9,"09/03/2021",EnumStatusExemplaire.DISPONIBLE);
		Exemplaire j = new Exemplaire("dff",10,"01/03/2021",EnumStatusExemplaire.DISPONIBLE);
		Exemplaire k = new Exemplaire("faa",11,"09/01/2021",EnumStatusExemplaire.DISPONIBLE);
		Exemplaire l = new Exemplaire("hge",12,"01/01/2021",EnumStatusExemplaire.DISPONIBLE);
		
		System.out.println("\t\t Test adherent en retard 1.2");
		System.out.println("********************************************************\n");
	
		System.out.println("On ajoute un emprunt a l'adhérent Bob ");
		Bob.addEmpruntEnCours(new EmpruntEnCours(Bob, a, "05/03/2021"));
		System.out.println("emprunt en cours : "+Bob.getNbEmpruntsEnCours());
		System.out.println();
		//System.out.println(a.getStatus());
		System.out.println("maintenant on fait l'ajout d'un emprunt en retard");
		Bob.addEmpruntEnCours(new EmpruntEnCours(Bob, b, "08/02/2021"));
		System.out.println("emprunt en cours : "+Bob.getNbEmpruntsEnCours());
		System.out.println();
		
		System.out.println("Essaie d'un emprunt apres un emprunt en retard");
		Bob.addEmpruntEnCours(new EmpruntEnCours(Bob, c, "01/03/2021"));
		System.out.println("emprunt en cours : "+Bob.getNbEmpruntsEnCours());
		System.out.println(Bob.getEmpruntenCours());
		System.out.println();
		
		
		System.out.println("\t\t Test employe en retard 1.3");
		System.out.println("********************************************************\n");
		
		System.out.println("On fait paul l'employe emprunter deux exemplaire en retard");
		paul.addEmpruntEnCours(new EmpruntEnCours(paul, h, "12/02/2021"));
		paul.addEmpruntEnCours(new EmpruntEnCours(paul, i, "13/02/2021"));	
		System.out.println("emprunt en cours : "+paul.getNbEmpruntsEnCours());
		
		
		System.out.println("\t\t Test 3 emprunt adherent 1.4");
		System.out.println("********************************************************\n");
		System.out.println("***On fait mia une adherente faire 3 autre emprunt ***");
		Mia.addEmpruntEnCours(new EmpruntEnCours(Mia, d, "06/03/2021"));
		System.out.println("emprunt en cours : "+Mia.getNbEmpruntsEnCours());
		System.out.println();
		
		Mia.addEmpruntEnCours(new EmpruntEnCours(Mia, e, "06/03/2021"));
		System.out.println("emprunt en cours : "+Mia.getNbEmpruntsEnCours());
		System.out.println();
		
		Mia.addEmpruntEnCours(new EmpruntEnCours(Mia, f, "06/03/2021"));
		System.out.println("emprunt en cours : "+Mia.getNbEmpruntsEnCours());
		System.out.println();
		
		System.out.println("Ajout d'un 4 eme exemplaire");
		Mia.addEmpruntEnCours(new EmpruntEnCours(Mia, g, "06/03/2021"));
		System.out.println("emprunt en cours : "+Mia.getNbEmpruntsEnCours());
		System.out.println();
		
		System.out.println("\t\t Test employe 3 emprunt 1.5");
		System.out.println("********************************************************\n");
		System.out.println("On fait paul emprunter 2 exemplaires supplementaires");
		paul.addEmpruntEnCours(new EmpruntEnCours(paul, j, "08/02/2021"));
		paul.addEmpruntEnCours(new EmpruntEnCours(paul, k, "08/02/2021"));
		System.out.println("emprunt en cours : "+paul.getNbEmpruntsEnCours());
		
		//test de base 6
		System.out.println("\n\t\t Test retour 1.6");
		System.out.println("********************************************************\n");
		System.out.println("Bob fait un retour de son exemplaire ayant pour id 1");
		
		System.out.println(" pour le moment Bob a emprunt en cours : "+Bob.getNbEmpruntsEnCours());
		System.out.println(" voici le status de l'exemplaire A ayant pour Id 1 : \n"+ a.getStatus());
		Bob.removeEmprunt(1);
		System.out.println("voici le status de l'exemplaire A ayant pour Id "+a.getIdExemplaire()+" apres retour  : \n"+a.getStatus());
		System.out.println("l'exemplaire ayant pour Id n'apparait plus dans les emprunt en cours : \n"+Bob.getEmpruntenCours());
		System.out.println();
		System.out.println("emprunt en cours  de bob : "+Bob.getNbEmpruntsEnCours());
		
	}
}
