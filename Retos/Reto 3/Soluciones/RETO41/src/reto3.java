import java.util.Scanner;

public class reto3 {
    public static void main(String[] args) throws Exception {
        Scanner leer = new Scanner(System.in);
        int cantPx = Integer.parseInt(leer.nextLine());
        Paciente[] datos = new Paciente[cantPx];
        int cantNoDiag = 0;
        int[] cantSint = new int[5];

        // Inicializar contadores en 0
        for (int i = 0; i < 5; i++) cantSint[i] = 0;

        for (int i = 0; i < cantPx; i++) {
            String[] paciente = leer.nextLine().split("-");
            Paciente px = new Paciente(paciente[0], paciente[1], paciente[2], paciente[3], paciente[4], paciente[5], paciente[6]);

            if (px.getNauseas().equalsIgnoreCase("si")) {
                cantSint[0] += 1;
            }
            if (px.getVomitos().equalsIgnoreCase("si")) {
                cantSint[1] += 1;
            }
            if (px.getDolor().equalsIgnoreCase("si")) {
                cantSint[2] += 1;
            }
            if (px.getDiarrea().equalsIgnoreCase("si")) {
                cantSint[3] += 1;
            }
            if (px.getFiebre().equalsIgnoreCase("si")) {
                cantSint[4] += 1;
            }

            datos[i] = px;

        }

        leer.close();

        for (Paciente px : datos) {
            String[] sintomas = {px.getNauseas(), px.getVomitos(), px.getDolor(), px.getDiarrea(), px.getFiebre()};
            String diagnostico = px.diagnosticar(sintomas);
            if (diagnostico.equals("Sin diagnostico")) cantNoDiag += 1;
            System.out.println(px.getCedula() + " " + diagnostico);
        }

        String[] vecSint = {"nauseas", "vomitos", "dolor abdominal", "diarrea", "fiebre"};
        int max, min;
        max = -1; min = 10000;

        for (int i = 0; i < 5; i++) {
            if (max < cantSint[i]) {
                max = cantSint[i];
            }
            if (min > cantSint[i]) {
                min = cantSint[i];
            }
        }
        for (int i = 0; i < 5; i++){
            if (cantSint[i] == max) {
                System.out.println(vecSint[i]);
                break;
            }
        }
        for (int i = 0; i < 5; i++){
            if (cantSint[i] == min) {
                System.out.println(vecSint[i]);
                break;
            }
        }
        System.out.println(cantPx - cantNoDiag);
    }
}
