package champollion;

public class ServicePrevu {
    
    private int volumeCM;
    private int volumeTD;
    private int volumeTP;
    private UE ue;
    private Enseignant enseignant;

    public ServicePrevu(int volumeCM, int volumeTD, int volumeTP, UE ue, Enseignant enseignant) {
        this.volumeCM = volumeCM;
        this.volumeTD = volumeTD;
        this.volumeTP = volumeTP;
        this.ue = ue;
        this.enseignant = enseignant;
    }

    public int getVolumeCM() {
        return volumeCM;
    }

    public int getVolumeTD() {
        return volumeTD;
    }

    public int getVolumeTP() {
        return volumeTP;
    }

    public void setVolumeCM(int volumeCM) {
        this.volumeCM = volumeCM;
    }

    public void setVolumeTD(int volumeTD) {
        this.volumeTD = volumeTD;
    }

    public void setVolumeTP(int volumeTP) {
        this.volumeTP = volumeTP;
    }

    public UE getUe() {
        return ue;
    }

    public Enseignant getEnseignant() {
        return enseignant;
    }

    public void setUe(UE ue) {
        this.ue = ue;
    }

    public void setEnseignant(Enseignant enseignant) {
        this.enseignant = enseignant;
    }

}
