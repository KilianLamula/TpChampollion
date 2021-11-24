package champollion;

import static java.lang.Math.round;
import java.util.ArrayList;
import java.util.List;

public class Enseignant extends Personne {

    List<ServicePrevu> servicesPrevus = new ArrayList<>();
    List<Intervention> lesInterventions = new ArrayList<>();

    public Enseignant(String nom, String email) {
        super(nom, email);
    }

    /**
     * Calcule le nombre total d'heures prévues pour cet enseignant en "heures
     * équivalent TD" Pour le calcul : 1 heure de cours magistral vaut 1,5 h
     * "équivalent TD" 1 heure de TD vaut 1h "équivalent TD" 1 heure de TP vaut
     * 0,75h "équivalent TD"
     *
     * @return le nombre total d'heures "équivalent TD" prévues pour cet
     * enseignant, arrondi à l'entier le plus proche
     *
     */
    public int heuresPrevues() {
        int equivTD = 0;

        for (ServicePrevu s : servicesPrevus) {
            //On convertit :
            equivTD += (1.5 * s.getVolumeCM()) + s.getVolumeTD() + (0.75 * s.getVolumeTP());
        }
        
        //On arrondit :
        round(equivTD);
        
        return equivTD;
    }

    public boolean enSousService() {
        boolean res = false;
        //Selon le TP UML un enseignant est en sous service pour un total d'heures < 192h
        if (this.heuresPrevues() < 192) {
            res = true;
        }
        return res;
    }

    /**
     * Calcule le nombre total d'heures prévues pour cet enseignant dans l'UE
     * spécifiée en "heures équivalent TD" Pour le calcul : 1 heure de cours
     * magistral vaut 1,5 h "équivalent TD" 1 heure de TD vaut 1h "équivalent
     * TD" 1 heure de TP vaut 0,75h "équivalent TD"
     *
     * @param ue l'UE concernée
     * @return le nombre total d'heures "équivalent TD" prévues pour cet
     * enseignant, arrondi à l'entier le plus proche
     *
     */
    public int heuresPrevuesPourUE(UE ue) {
        int equivTD = 0;

        for (ServicePrevu s : servicesPrevus) {
            //On vérifie que l'UE est bien celui de l'enseignant :
            if (s.getUe() == ue) {
                //On convertit :
                equivTD += (s.getVolumeCM()*1.5) + s.getVolumeTD() + (s.getVolumeTP()*0.75);
            }
        }
        
        //On arrondit :
        round(equivTD);
        
        return equivTD;
    }

    /**
     * Ajoute un enseignement au service prévu pour cet enseignant
     *
     * @param ue l'UE concernée
     * @param volumeCM le volume d'heures de cours magitral
     * @param volumeTD le volume d'heures de TD
     * @param volumeTP le volume d'heures de TP
     */
    
    public void ajouteEnseignement(UE ue, int volumeCM, int volumeTD, int volumeTP) {
        boolean existe=false;
        for(ServicePrevu s : servicesPrevus){
                if(s.getUe()==ue){
                    s.setVolumeCM(volumeCM + s.getVolumeCM());
                    s.setVolumeTD(volumeTD + s.getVolumeTD());
                    s.setVolumeTP(volumeTP+ s.getVolumeTP());
                    existe=true;
                }
        }
        if(existe==false){
            ServicePrevu serv=new ServicePrevu(volumeCM, volumeTD, volumeTP,ue,this);
            servicesPrevus.add(serv);
        }
    }

    public void ajouteIntervention(Intervention inter) {
        lesInterventions.add(inter);
    }
        
    public int resteAPlanifier(UE ue, TypeIntervention type) {
        int resteAPlanif = 0;
        int planifiees = 0;
        int prevues = 0;
        
        //On récupère les heures prévues :
        for(Intervention i : lesInterventions){
            if(i.getType()==type && i.getUe()==ue){
                planifiees+=i.getDuree();
            }
        }
        
        //On récupère les heures planifiées :
        for(ServicePrevu s : servicesPrevus){
            if(s.getUe()==ue){
                if(type==TypeIntervention.CM) prevues+=s.getVolumeCM();
                if(type==TypeIntervention.TD) prevues+=s.getVolumeTD();
                if(type==TypeIntervention.TP) prevues+=s.getVolumeTP();
            }
        }
        
        //On détermine à partir des résultats précédents ce qu'il reste à planifier :
        resteAPlanif = prevues - planifiees;
        
        return round(resteAPlanif);
    } 
}
