import java.util.Scanner;

/**
 *
 * @author Asus
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);
        int cantPx = Integer.parseInt(leer.nextLine());
        Paciente[] datos = new Paciente[cantPx];
        int[] bac = {0, 0};
        int[] vir = {0, 0};

        for (int i = 0; i < cantPx; i++) {
            String[] paciente = leer.nextLine().split("-");
            Paciente px = new Paciente(paciente[0], paciente[1], paciente[2], paciente[3], paciente[4], paciente[5], paciente[6]);

            datos[i] = px;
        }

        leer.close();

        for (Paciente px : datos) {
            String[] sintomas = {px.getNauseas(), px.getVomitos(), px.getDolor(), px.getDiarrea(), px.getFiebre()};
            String diagnostico = px.diagnosticar(sintomas);
            if (diagnostico.equals("Staphylococcus aureus")) {
                bac[0] += 1;
            } else if (diagnostico.equals("Bacillus cereus")) {
                bac[1] += 1;
            } else if (diagnostico.equals("Norovirus")) {
                vir[0] += 1;
            } else if (diagnostico.equals("Rotavirus")) {
                vir[1] += 1;
            }
            System.out.println(px.getCedula() + " " + diagnostico);
        }

        if (bac[0] == 0 && bac[1] == 0) {
            System.out.println("NA");
        } else if (bac[0] > bac[1]) {
            System.out.println("Staphylococcus aureus");
        } else {
            System.out.println("Bacillus cereus");
        }

        if (vir[0] == 0 && vir[1] == 0) {
            System.out.println("NA");
        } else if (vir[0] > vir[1]) {
            System.out.println("Norovirus");
        } else {
            System.out.println("Rotavirus");
        }

    }

}
