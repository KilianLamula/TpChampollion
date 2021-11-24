package champollion;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class ChampollionJUnitTest {
	Enseignant untel;
	UE uml, java;
		
	@BeforeEach
	public void setUp() {
		untel = new Enseignant("untel", "untel@gmail.com");
		uml = new UE("UML");
		java = new UE("Programmation en java");		
	}
	

	@Test
	public void testNouvelEnseignantSansService() {
		assertEquals(0, untel.heuresPrevues(),
                        "Un nouvel enseignant doit avoir 0 heures prévues");
	}
	
	@Test
	public void testAjouteHeures() {
                // 10h TD pour UML
		untel.ajouteEnseignement(uml, 0, 10, 0);

		assertEquals(10, untel.heuresPrevuesPourUE(uml),
                        "L'enseignant doit maintenant avoir 10 heures prévues pour l'UE 'uml'");

                // 20h TD pour UML
                untel.ajouteEnseignement(uml, 0, 20, 0);
                
		assertEquals(10 + 20, untel.heuresPrevuesPourUE(uml),
                         "L'enseignant doit maintenant avoir 30 heures prévues pour l'UE 'uml'");		
		
	}
        
        @Test
        public void testHeuresPrevues(){
            //On crée un enseignement avec 10h pour chaque type
            untel.ajouteEnseignement(uml, 10, 10, 10);
            
            //Heures = (1.5*10) + 10 + (0.75*10) = 15 + 10 + 7.5 = 32 (arrondi inférieur)
            assertEquals(32, untel.heuresPrevues(),
                        "Les heures prévues sont mal déterminées");
        }
	
        @Test
        public void testEnSousServiceTrue(){
            //On ajoute les mêmes heures à l'enseignant car on sait qu'il est en sous service (32<192)
            untel.ajouteEnseignement(uml, 10, 10, 10);
            //Doit retourner true :
            assertEquals(true, untel.enSousService(),
                        "La méthode doit retourner true, l'enseignant est en sous service");
        }
        
        @Test
        public void testEnSousServiceFalse(){
            //On ajoute des heures à l'enseignant pour qu'il ne soit pas en sous service (195>192)
            untel.ajouteEnseignement(uml, 60, 60, 60);
            //Doit retourner false :
            assertEquals(false, untel.enSousService(),
                        "La méthode doit retourner false, l'enseignant n'est pas en sous service");
        }
        
        @Test
        public void testAjouteIntervention(){
            //On crée une intervetion et donc une salle :
            Salle s =  new  Salle("Salle 1" , 30);
            Intervention e =  new  Intervention(untel, new Date(), 2, false, 2, uml, s, TypeIntervention.CM);
            
            //On ajoute l'intervention :
            untel.ajouteIntervention(e);
            
            assertEquals(e, untel.lesInterventions.get(0),"L'intervention n'a pas correctement été ajoutée");            
        }
        
        @Test
        public void testResteAPlanifier(){
            //On crée une intervention de type CM de 2h et on l'ajoute
            Salle s =  new  Salle("Salle 1" , 30);
            Intervention e =  new  Intervention(untel, new Date(), 2, false, 2, uml, s, TypeIntervention.CM);
            untel.ajouteIntervention(e);
            
            //On ajoute des heures prévues à l'enseignant (on ajoute 2h de plus en prévues qu'en planifiées)
            untel.ajouteEnseignement(uml, 4, 0, 0);
            
            //On vérifie que le calcul des heures restantes à planifier est juste :
            assertEquals(2, untel.resteAPlanifier(uml, TypeIntervention.CM),"Le nombre d'heures restantes à planifier n'est pas correcte");
        }
}
