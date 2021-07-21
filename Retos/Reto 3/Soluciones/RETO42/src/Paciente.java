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
    public String diagnosticar(String[] sintomas){
        String enf="Sin diagnostico";

        //Staphylococcus aureus
        if (sintomas[0].equalsIgnoreCase("si") && sintomas[1].equalsIgnoreCase("si") && sintomas[2].equalsIgnoreCase("si")
        && sintomas[3].equalsIgnoreCase("si") && sintomas[4].equalsIgnoreCase("si")) {
            enf = "Staphylococcus aureus";
        }
        //Bacillus cereus
        if (sintomas[0].equalsIgnoreCase("si") && sintomas[1].equalsIgnoreCase("si")) {
            if (sintomas[2].equalsIgnoreCase("no") && sintomas[3].equalsIgnoreCase("no") && sintomas[4].equalsIgnoreCase("no")){
                enf = "Bacillus cereus";
            }
        }

        //Taenia saginata
        if (sintomas[2].equalsIgnoreCase("si") && sintomas[4].equalsIgnoreCase("si")) {
            if (sintomas[0].equalsIgnoreCase("no") && sintomas[1].equalsIgnoreCase("no") && sintomas[3].equalsIgnoreCase("no")) {
                enf = "Taenia saginata";
            }

        }

        //Norovirus 2 3 6 9
        if (sintomas[0].equalsIgnoreCase("si") && sintomas[1].equalsIgnoreCase("si") && sintomas[3].equalsIgnoreCase("si") && sintomas[4].equalsIgnoreCase("si")) {
            if (sintomas[2].equalsIgnoreCase("no")) {
                enf = "Norovirus";
            }
        }

        //Rotavirus 3 9 6
        if (sintomas[1].equalsIgnoreCase("si") && sintomas[3].equalsIgnoreCase("si")) {
            if (sintomas[0].equalsIgnoreCase("no") && sintomas[2].equalsIgnoreCase("no") && sintomas[4].equalsIgnoreCase("no")) {
                enf = "Rotavirus";
                //enf = "Viral";
            }

        }
        return enf;
    }



}
