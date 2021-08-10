import java.util.Scanner;

public class Reto88 {

    public static void printAlertsMode(int[] counts) {
        String[] alerts = {"benigno", "no sospechoso", "levemente sospechoso",
                           "moderadamente sospechoso", "altamente sospechoso"};
        int min = 1000;
        String mode = "";
        for (int elem : counts) {
            if ((min > elem) && (elem != 0)) min = elem;
        }
        for (int i = 0; i < 5; i++) {
            if (counts[i] == min) mode = mode.concat(alerts[i] + ";");
        }
        String[] modeArr = mode.split(";");
        if (modeArr.length == 5) System.out.println("todos los datos tienen la misma frecuencia");
        else {
            for (String s : modeArr) System.out.println(s);
        }
    }

    public static void printTreatmentsMode(int[] counts) {
        String[] treatments = {"no aaf", "seguimiento", "aaf"};
        int min = 1000;
        String mode = "";
        for (int elem : counts) {
            if ((min > elem) && (elem != 0)) min = elem;
        }
        for (int i = 0; i < 3; i++) {
            if (counts[i] == min) mode = mode.concat(treatments[i] + ";");
        }
        String[] modeArr = mode.split(";");
        if (modeArr.length == 3) System.out.println("todos los datos tienen la misma frecuencia");
        else {
            for (String s : modeArr) System.out.println(s);
        }
    }

    public static void countAlertsElements(String[] arr, int[] counts){
        for (String elem : arr) {
            switch (elem) { 
                case "benigno": 
                    counts[0] += 1;
                    break;
                case "no sospechoso": 
                    counts[1] += 1;
                    break;   
                case "levemente sospechoso":
                    counts[2] += 1;
                    break;
                case "moderadamente sospechoso":
                    counts[3] += 1;
                    break;
                case "altamente sospechoso":
                    counts[4] += 1;
                    break;
                default: break;
            }
        }
    }
 
    public static void countTreatmentsElements(String[] arr, int[] counts) {
        for (String elem : arr) {
            switch (elem) {
                case "no aaf":
                    counts[0] += 1;
                    break;
                case "seguimiento":
                    counts[1] += 1;
                    break;
                case "aaf":
                    counts[2] += 1;
                    break;
                default: break;
            }
        }
    }

    public static void printAlertsCount(int[] counts) {
        String[] alerts = {"benigno", "no sospechoso", "levemente sospechoso",
                            "moderadamente sospechoso", "altamente sospechoso"};
        for (int i = 0; i < 5; i++) {
            if (counts[i] != 0) {
                System.out.println(alerts[i] + " " + counts[i]);
            }
        }
    }

    public static void printTreatmentsCount(int[] counts) {
        String[] treatments = {"no aaf", "seguimiento", "aaf"};
        for (int i = 0; i < 3; i++) {
            if (counts[i] != 0) {
                System.out.println(treatments[i] + " " + counts[i]);
            }
        }
    }

    public static int computeComposition(String code) {
        int score = 0;
        if (code.equals("C3")) {
            score += 1;
        }else if (code.equals("C4")) {
            score += 2;
        }
        return score;
    }

    public static int computeEchogenicity(String code) {
        int score = 0;
        if (code.equals("E2")) {
            score += 1;
        }else if (code.equals("E3")) {
            score += 2;
        }else if (code.equals("E4")) {
            score += 3;
        }
        return score;
    }

    public static int computeForm(String code) {
        return code.equals("F1") ? 0 : 3;
    }

    public static int computeMargin(String code) {
        int score = 0;
        if (code.equals("M3")) {
            score += 2;
        }else if (code.equals("M4")) {
            score += 3;
        }
        return score;
    }

    public static int computeEchogenicFoci(String[] codes) {
        int score = 0;
        if (codes[0].equals("1")) {
            score += 0;
        }
        if (codes[1].equals("1")) {
            score += 1;
        }
        if (codes[2].equals("1")) {
            score += 2;
        }
        if (codes[3].equals("1")) {
            score += 3;
        }
        return score;
    }

    public static String[] computeResults(int score, float nodule_size){
        String[] arr = new String[2];
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
        } else if ((score >= 4) && (score <= 6)) {
            arr[0] = "moderadamente sospechoso";
            if (nodule_size >= 1.5) {
                arr[1] = "aaf";
            } else {
                arr[1] = "seguimiento";
            }
        } else if (score >= 7) {
            arr[0] = "altamente sospechoso";
            if (nodule_size >= 1) {
                arr[1] = "aaf";
            } else {
                arr[1] = "seguimiento";
            }
        }
        return arr;
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int numOfPatients = scanner.nextInt();
        String[][] patientsMat = new String[numOfPatients][9];
        for (int i = 0; i < numOfPatients; i++) {
            patientsMat[i][0] = scanner.next();
            patientsMat[i][1] = scanner.next();
            patientsMat[i][2] = scanner.next();
            patientsMat[i][3] = scanner.next();
            patientsMat[i][4] = scanner.next();
            patientsMat[i][5] = scanner.next();
            patientsMat[i][6] = scanner.next();
            patientsMat[i][7] = scanner.next();
            patientsMat[i][8] = scanner.next();
        }
        scanner.close();
        String[] alertArray = new String[numOfPatients];
        String[] treatmentArray = new String[numOfPatients];

        for (int i = 0; i < numOfPatients; i++) {
            int patientScore = 0;
            patientScore += computeComposition(patientsMat[i][0]);
            patientScore += computeEchogenicity(patientsMat[i][1]);
            patientScore += computeForm(patientsMat[i][2]);
            patientScore += computeMargin(patientsMat[i][3]);
            String[] echogenicFoci = new String [4];
            for (int j = 4; j < 8; j++) {
                echogenicFoci[j-4] = patientsMat[i][j];
            }
            patientScore += computeEchogenicFoci(echogenicFoci);
            String[] temp = new String[2];
            temp = computeResults(patientScore, Float.parseFloat(patientsMat[i][8]));
            alertArray[i] = temp[0];
            treatmentArray[i] = temp[1];
        }
        int[] countAlerts = new int[5];
        int[] countTreatments = new int[3];
        countAlertsElements(alertArray, countAlerts);
        countTreatmentsElements(treatmentArray, countTreatments);
        printAlertsMode(countAlerts);
        printTreatmentsMode(countTreatments);
    }
}