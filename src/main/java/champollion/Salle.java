/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package champollion;

/**
 *
 * @author lamul
 */
public class Salle {
    
    private String intitule;
    private int capacite;

    public Salle(String intitule, int capacite) {
        this.intitule = intitule;
        this.capacite = capacite;
    }

    public String getIntitule() {
        return intitule;
    }

    public int getCapacite() {
        return capacite;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }
}
