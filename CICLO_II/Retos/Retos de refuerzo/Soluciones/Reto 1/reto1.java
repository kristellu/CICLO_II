import java.util.Scanner;

public class reto1 {

    // Función para imprimir un arreglo
    public static void printArray(String[] arr) {
        for (int i = 0; i < arr.length /* Aqui va la longitud del arreglo */ ; i++) {
            System.out.println(arr[i]); // Aqui se imprime el dato que se encuentra en la posición i del arreglo
        }
    }

    // Se calcula el puntaje de la composición del nodulo del paciente
    public static int computeComposition(String code) {
        int score = 0; // Puntaje
        if (code.equals("C3")) {
            score += 1; // Aquí se suma 1 punto, correspondientes al valor de C3
        }else if (code.equals("C4")) {
            score += 2;
        }
        return score; // Aqui se retorna puntaje
    }

    // Se calcula el puntaje de la ecogenicidad del nodulo del paciente
    public static int computeEchogenicity(String code) {
        int score = 0;
        if (code.equals("E2")) { // Aqui se verifica que sea igual a E2
            score += 1;
        }else if (code.equals("E3")) {
            score += 2; // Aqui se suman 2 puntos, correspondientes al valor de E3
        }else if (code.equals("E4")) { // Aqui se verifica que sea igual a E4
            score += 3; // Aqui se suman 3 puntos, correspondientes al valor de E4
        }
        return score;
    }

    // Se calcula el puntaje de la forma del nodulo del paciente
    public static int computeForm(String code) {
        if (code.equals("F1")) {
            return 0;
        } else {
            return 3;
        }
    }

    // Se calcula el puntaje del margen del nodulo del paciente
    public static int computeMargin(String code) {
        int score = 0;
        if (code.equals("M3")) {
            score += 2;
        }else if (code.equals("M4")) {
            score += 3;
        }
        return score;
    }

    // Se calcula el puntaje de la composición del nodulo del paciente
    public static int computeEchogenicFoci(String[] codes) {
        // Recibe un vector de cuatro posiciones correspondiente a los distintos focos ecogenicos
        // 0 significa que no aplica el foco, 1 significa que aplica
        int score = 0;
        if (codes[0].equals("1")) {
            score += 0;
        }
        if (codes[1].equals("1")) { // Aqui se verifica que el segundo foco ecogenico aplique al nodulo del paciente
            score += 1;
        }
        if (codes[2].equals("1")) {// Aqui se verifica que el tercer foco ecogenico aplique al nodulo del paciente
            score += 2;
        }
        if (codes[3].equals("1")) { // Aqui se verifica que el cuarto foco ecogenico aplique al nodulo del paciente
            score += 3; // Aqui se le suman 3 puntos al puntaje acumulado
        }
        return score;
    }

    // Se calcula la alerta y tratamiento del paciente
    public static String[] computeResults(int score, float nodule_size){
        String[] arr = new String[2]; // Aqui instanciamos el arreglo con dos posiciones
        if ((score >= 0) && (score <= 1)) {
            arr[0] = "benigno";
            arr[1] = "no aaf";
        } else if (score == 2) {
            arr[0] = "no sospechoso";
            arr[1] = "no aaf";
        } else if (score == 3) {
            arr[0]  = "levemente sospechoso";
            if (nodule_size >= 2.5) {
                arr[1] = "aaf";
            } else {
                arr[1] = "seguimiento";
            }
        } else if ((score >= 4) && (score <= 6)) { // El puntaje es mayor igual a 4 y menor igual a 6
            arr[0] = "moderadamente sospechoso";
            if (nodule_size >= 1.5) {
                arr[1] = "aaf";
            } else {
                arr[1] = "seguimiento";
            }
        } else if (score >= 7) {
            arr[0] = "altamente sospechoso";
            if (nodule_size >= 1) { // El tamaño del nodulo es mayor o igual a 1
                arr[1] = "aaf";
            } else {
                arr[1] = "seguimiento";
            }
        }
        return arr; // Retornar el arreglo
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int numOfPatients = Integer.parseInt(scanner.nextLine());
        String[][] patientsMat = new String[numOfPatients][9];
        for (int i = 0; i < numOfPatients; i++) {
            patientsMat[i][0] = scanner.nextLine();
            patientsMat[i][1] = scanner.nextLine();
            patientsMat[i][2] = scanner.nextLine();
            patientsMat[i][3] = scanner.nextLine();
            patientsMat[i][4] = scanner.nextLine();
            patientsMat[i][5] = scanner.nextLine();
            patientsMat[i][6] = scanner.nextLine();
            patientsMat[i][7] = scanner.nextLine();
            patientsMat[i][8] = scanner.nextLine();
        }
        scanner.close();
        String[] alertArray = new String[numOfPatients]; // Aquí el tamaño del arreglo debe ser el mismo que el número de pacientes
        String[] treatmentArray = new String[numOfPatients];

        for (int i = 0; i < numOfPatients; i++) {
            int patientScore = 0;
            patientScore += computeComposition(patientsMat[i][0]);
            patientScore += computeEchogenicity(patientsMat[i][1]);
            patientScore += computeForm(patientsMat[i][2]); // Aqui debe ir la tercera columna de la matriz de pacientes
            patientScore += computeMargin(patientsMat[i][3]); // Aqui debe ir la cuarta columna de la matriz de pacientes
            String[] echogenicFoci = new String [4]; // Arreglo de los focos ecogenicos
            for (int j = 4; j < 8; j++) {
                echogenicFoci[j-4] = patientsMat[i][j]; // Extramos los focos ecogenicos del paciente
            }
            patientScore += computeEchogenicFoci(echogenicFoci); // Aqui debe ir arreglo de los focos ecogenicos
            String[] temp = new String[2];
            temp = computeResults(patientScore, Float.parseFloat(patientsMat[i][8]));
            alertArray[i] = temp[0]; // Aqui debe ir la primera posicion del arreglo temporal
            treatmentArray[i] = temp[1]; // Aqui debe ir la segunda posicion del arreglo temporal
        }
        printArray(alertArray);
        printArray(treatmentArray);
    }
}