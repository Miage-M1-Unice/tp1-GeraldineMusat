/**
 * @version 1.00 23 Mars 2001
 * @author Michel Buffa
 * Inspiré par la classe Reflectiontest.java de
 * Cay S. Horstmann & Gary Cornell, publiée dans le livre Core Java, Sun Press
 */

import java.lang.reflect.*;
import java.io.*;

public class AnalyseurDeClasse {

  public static void analyseClasse(String nomClasse) throws ClassNotFoundException {
    // Récupération d'un objet de type Class correspondant au nom passé en paramètres
    Class cl = getClasse(nomClasse);

    afficheEnTeteClasse(cl);

    System.out.println("Affichage attributs");
    afficheAttributs(cl);

    System.out.println("Affichage constructeur");
    afficheConstructeurs(cl);

    System.out.println("Affichage methode");
    afficheMethodes(cl);

    // L'accolade fermante de fin de classe !
    //System.out.println("}");
  }


  /** Retourne la classe dont le nom est passé en paramètre */
  public static Class getClasse(String nomClasse) throws ClassNotFoundException {
	return Class.forName(nomClasse);
  }

  /** Cette méthode affiche par ex "public class Toto extends Tata implements Titi, Tutu {" */
  public static void afficheEnTeteClasse(Class cl) {
    //  Affichage du modifier et du nom de la classe
    // CODE A ECRIRE
	  int modifier = cl.getModifiers();
	  System.out.print(Modifier.toString(modifier) + " " + cl.getSimpleName()+ " ");

   // Récupération de la superclasse si elle existe (null si cl est le type Object)
   Class supercl = cl.getSuperclass();
   if (supercl.getSimpleName() == "Object" || supercl == null) {
	   
   } else {
	 System.out.print("extends " + supercl.getSimpleName());  
   }

    // Affichage des interfaces que la classe implemente
    Class[] interfaces = cl.getInterfaces();
    if (interfaces.length > 0) {
    	System.out.print(" implemente " );
    	for(Class c : interfaces) {
    		System.out.print(c.getSimpleName() + " ");
    	}
    }

    // Enfin, l'accolade ouvrante !
    System.out.print(" \n");
  }

  public static void afficheAttributs(Class cl) {
    Field[] field = cl.getDeclaredFields();
    if(field.length > 0) {
    	for(Field f : field) {
        	System.out.println("\t" + Modifier.toString(f.getModifiers()) + " " + f.getGenericType() + " " + f.getName());
    		
    	}
    }
  }

  public static void afficheConstructeurs(Class cl) {
	  Constructor[] cs = cl.getConstructors();
	  if(cs.length > 0) {
		  for(Constructor c : cs) {
			 System.out.println("\t" + c); 
		  }
	  }
  }

  public static void afficheMethodes(Class cl) {
	  Method[] ms = cl.getMethods();
	  if(ms.length > 0) {
		  for (Method m : ms) {
			  if(m.getDeclaringClass().getName() == cl.getName()) {
				  System.out.println("\t" + m);
			  }
		  }
	  }
  }

  public static String litChaineAuClavier() throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      return br.readLine();
  }

  public static void main(String[] args) {
    boolean ok = false;

    while(!ok) {
      try {
        //System.out.print("Entrez le nom d'une classe (ex : java.util.Date): ");
        //String nomClasse = litChaineAuClavier();
        String nomClasse = "java.awt.Point";
        System.out.println("Classe : " + nomClasse);
        analyseClasse(nomClasse);

        ok = true;
      } catch(ClassNotFoundException e) {
        System.out.println("Classe non trouvée.");
      }/*catch(IOException e) {
        System.out.println("Erreur d'E/S!");
      }*/
    }
  }
}