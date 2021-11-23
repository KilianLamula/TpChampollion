/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package champollion;

import java.util.Date;

/**
 *
 * @author lamul
 */
public class Intervention {
    
    private Enseignant enseignant;
    private Date debut;
    private int duree;
    private boolean annulee;
    private int heureDebut;
    private UE ue;
    private Salle salle;
    private TypeIntervention type;

    public Intervention(Enseignant enseignant, Date debut, int duree, boolean annulee, int heureDebut, UE ue, Salle salle, TypeIntervention type) {
        this.enseignant = enseignant;
        this.debut = debut;
        this.duree = duree;
        this.annulee = annulee;
        this.heureDebut = heureDebut;
        this.ue = ue;
        this.salle = salle;
        this.type = type;
    }
    
    //Getters :

    public Enseignant getEnseignant() {
        return enseignant;
    }

    public Date getDebut() {
        return debut;
    }

    public int getDuree() {
        return duree;
    }

    public boolean isAnnulee() {
        return annulee;
    }

    public int getHeureDebut() {
        return heureDebut;
    }

    public UE getUe() {
        return ue;
    }

    public Salle getSalle() {
        return salle;
    }

    public TypeIntervention getType() {
        return type;
    }
    
    //Setters :

    public void setEnseignant(Enseignant enseignant) {
        this.enseignant = enseignant;
    }

    public void setDebut(Date debut) {
        this.debut = debut;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public void setAnnulee(boolean annulee) {
        this.annulee = annulee;
    }

    public void setHeureDebut(int heureDebut) {
        this.heureDebut = heureDebut;
    }

    public void setUe(UE ue) {
        this.ue = ue;
    }

    public void setSalle(Salle salle) {
        this.salle = salle;
    }

    public void setType(TypeIntervention type) {
        this.type = type;
    }
}
