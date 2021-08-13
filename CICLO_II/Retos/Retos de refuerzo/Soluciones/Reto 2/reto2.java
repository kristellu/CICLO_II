import java.util.Scanner;

public class reto2 {
    public static void main(String[] args) throws Exception {
        // Instanciamos el scanner para leer por pantalla
        Scanner scanner = new Scanner(System.in);
        // Leemos la cantidad de nodulos que recibirá el programa
        int numberOfPatients = Integer.parseInt(scanner.nextLine());

        // Iniciamos un vector de nodulos
        Nodule[] noduleArr = new Nodule[numberOfPatients];
        for (int i = 0; i < numberOfPatients; i++) {
            // Leemos las caracteristicas del nodo
            String[] noduleAttributes = scanner.nextLine().split(" ");
            // Vector temporal para almacenar los focos ecogenicos
            String[] tempEchgenicFoci = new String[4];
            // Almacenamos los focos ecogenicos en el vector temporal
            for (int j = 4; j < 8; j++) {
                tempEchgenicFoci[j-4] = noduleAttributes[j];
            }
            // Instanciamos un objeto de la clase Nodule
            Nodule patientNodule = new Nodule(noduleAttributes[0], noduleAttributes[1], noduleAttributes[2], noduleAttributes[3], tempEchgenicFoci, noduleAttributes[8]);
            // Lo agregamos al vector de nodulos
            noduleArr[i] = patientNodule;
        }
        scanner.close();

        // Imprimimos las alertas del vector de nodulos
        for (int i = 0; i < numberOfPatients; i++) {
            System.out.println(noduleArr[i].computeAlert());
        }

        // Imprimimos los tratamientos del vector de nodulos
        for (int i = 0; i < numberOfPatients; i++) {
            System.out.println(noduleArr[i].computeTreatment());
        }
    }
}
