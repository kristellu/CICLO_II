import java.util.ArrayList;

public class Medico extends Persona {
    private ArrayList<String> pacientesList = new ArrayList<String>();

    public Medico(String nombre, String cedula) {
        super(nombre, cedula);
    }

    public void addPaciente(String cc) {
        this.pacientesList.add(cc);
    }

    public ArrayList<String> getPacientes() {
        return this.pacientesList;
    }

    public void pacientes() {
        for (String px : this.pacientesList) {
            System.out.println(px);
        }
    }

}
