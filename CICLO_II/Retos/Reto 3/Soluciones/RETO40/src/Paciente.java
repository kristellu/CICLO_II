public class Paciente extends Persona {
    private String nauseas;
    private String vomitos;
    private String dolor;
    private String diarrea;
    private String fiebre;


    public Paciente(String nombre, String cedula, String nauseas, String vomitos, String dolor, String diarrea, String fiebre) {
        super(nombre, cedula);
        this.nauseas = nauseas;
        this.vomitos = vomitos;
        this.dolor = dolor;
        this.diarrea = diarrea;
        this.fiebre = fiebre;
    }

    public String getDiarrea() {
        return diarrea;
    }public String getDolor() {
        return dolor;
    }
    public String getFiebre() {
        return fiebre;
    }
    public String getNauseas() {
        return nauseas;
    }
    public String getVomitos() {
        return vomitos;
    }
    public void setDiarrea(String diarrea) {
        this.diarrea = diarrea;
    }
    public void setDolor(String dolor) {
        this.dolor = dolor;
    }
    public void setFiebre(String fiebre) {
        this.fiebre = fiebre;
    }
    public void setNauseas(String nauseas) {
        this.nauseas = nauseas;
    }
    public void setVomitos(String vomitos) {
        this.vomitos = vomitos;
    }
    public String diagnosticar(){
        String enf="Sin diagnostico";

        //Staphylococcus aureus
        if (nauseas.equalsIgnoreCase("si") && vomitos.equalsIgnoreCase("si") && dolor.equalsIgnoreCase("si")
        && diarrea.equalsIgnoreCase("si") && fiebre.equalsIgnoreCase("si")) {
            enf = "Staphylococcus aureus";
        }
        //Bacillus cereus
        if (nauseas.equalsIgnoreCase("si") && vomitos.equalsIgnoreCase("si")) {
            if (dolor.equalsIgnoreCase("no") && diarrea.equalsIgnoreCase("no") && fiebre.equalsIgnoreCase("no")){
                enf = "Bacillus cereus";
            }
        }

        //Taenia saginata
        if (dolor.equalsIgnoreCase("si") && fiebre.equalsIgnoreCase("si")) {
            if (nauseas.equalsIgnoreCase("no") && vomitos.equalsIgnoreCase("no") && diarrea.equalsIgnoreCase("no")) {
                enf = "Taenia saginata";
            }

        }

        //Norovirus 2 3 6 9
        if (nauseas.equalsIgnoreCase("si") && vomitos.equalsIgnoreCase("si") && diarrea.equalsIgnoreCase("si") &&
        fiebre.equalsIgnoreCase("si")) {
            if (dolor.equalsIgnoreCase("no")) {
                enf = "Norovirus";
            }
        }

        //Rotavirus 3 9 6
        if (vomitos.equalsIgnoreCase("si") && diarrea.equalsIgnoreCase("si")) {
            if (nauseas.equalsIgnoreCase("no") && dolor.equalsIgnoreCase("no") && fiebre.equalsIgnoreCase("no")) {
                enf = "Rotavirus";
                //enf = "Viral";
            }

        }
        return enf;
    }



}
