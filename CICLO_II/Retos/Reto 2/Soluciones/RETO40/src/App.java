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
        Paciente datos[] = new Paciente[100];
        String diag[] = new String[100];
        String cla[] = new String[100];
        int repDiag[] = new int[5];

        int pacSD = 0;

        //System.out.println("Digite el número de pacientes: ");
        int n = Integer.parseInt(leer.nextLine());

        for (int i = 0; i < n; i++) {
            //System.out.println("Digite los datos del paciente separados por -");
            String linea = leer.nextLine();
            String[] vL = linea.split("-");
            Paciente pac = new Paciente(vL[0], vL[1], vL[2], vL[3], vL[4], vL[5], vL[6]);
            datos[i] = pac;
        }

        leer.close();

        //Iniciar en 0 conteo de diagnosticos
        for (int j = 0; j < 5; j++) {
            repDiag[j] = 0;
        }

        for (int i = 0; i < n; i++) {
            int swD = 0;
            Paciente pac = datos[i];

            //Staphylococcus aureus
            if (pac.getNauseas().equalsIgnoreCase("si") && pac.getVomitos().equalsIgnoreCase("si") && pac.getDolor().equalsIgnoreCase("si")
                    && pac.getDiarrea().equalsIgnoreCase("si") && pac.getFiebre().equalsIgnoreCase("si")) {
                    diag[i] = "Staphylococcus aureus";
                    cla[i] = "Bacteriano";
                    repDiag[0] += 1;
                    swD = 1;
            }
            //Bacillus cereus
            if (pac.getNauseas().equalsIgnoreCase("si") && pac.getVomitos().equalsIgnoreCase("si")) {
                if (pac.getDolor().equalsIgnoreCase("no") && pac.getDiarrea().equalsIgnoreCase("no") && pac.getFiebre().equalsIgnoreCase("no")){
                    diag[i] = "Bacillus cereus";
                    cla[i] = "Bacteriano";
                    swD = 1;
                    repDiag[1] += 1;

                }

            }

            //Taenia saginata
            if (pac.getDolor().equalsIgnoreCase("si") && pac.getFiebre().equalsIgnoreCase("si")) {
                if (pac.getNauseas().equalsIgnoreCase("no") && pac.getVomitos().equalsIgnoreCase("no") && pac.getDiarrea().equalsIgnoreCase("no")) {
                    diag[i] = "Taenia saginata";
                    cla[i] = "Parasitaria";
                    swD = 1;
                    repDiag[2] += 1;

                }

            }

            //Norovirus 2 3 6 9
            if (pac.getNauseas().equalsIgnoreCase("si") && pac.getVomitos().equalsIgnoreCase("si") && pac.getDiarrea().equalsIgnoreCase("si") && pac.getFiebre().equalsIgnoreCase("si")) {
                if (pac.getDolor().equalsIgnoreCase("no")) {
                    diag[i] = "Norovirus";
                    cla[i] = "Viral";
                    swD = 1;
                    repDiag[3] += 1;
                }
            }

            //Rotavirus 3 9 6
            if (pac.getVomitos().equalsIgnoreCase("si") && pac.getDiarrea().equalsIgnoreCase("si")) {
                if (pac.getNauseas().equalsIgnoreCase("no") && pac.getDolor().equalsIgnoreCase("no") && pac.getFiebre().equalsIgnoreCase("no")) {
                    diag[i] = "Rotavirus";
                    cla[i] = "Viral";
                    swD = 1;
                    repDiag[4] += 1;
                }

            }

            if (swD == 0) {
                pacSD++;
                diag[i] = "Sin diagnostico";
                cla[i] = "Sin clasificacion";
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.println(datos[i].getCedula() + " " + diag[i]);
        }

        int may = -1, numM = 0;
        for (int j = 0; j < 5; j++) {
            if (repDiag[j] > may) {
                may = j;
                numM = j;
            }
        }

        switch (numM) {
            case 0:
                System.out.println("Staphylococcus aureus");
                break;
            case 1:
                System.out.println("Bacillus cereus");
                break;
            case 2:
                System.out.println("Taenia saginata");
                break;
            case 3:
                System.out.println("Norovirus");
                break;
            case 4:
                System.out.println("Rotavirus");
                break;
        }

        System.out.println((pacSD));
    }

}



