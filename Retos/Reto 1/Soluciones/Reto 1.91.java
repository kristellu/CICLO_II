import java.util.Scanner;

public class Reto91 {

    public static void printArray(String[] arr) { 
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void printFormattedArray(float[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(String.format("%.2f", arr[i]));
        }
    }

    public static float[] getNormalizedArray(float[] arr) {
        float[] result = new float[arr.length];
        float max = -1;
        for (float elem : arr) {;
            if (max < elem) max = elem;
        }
        System.out.println("Max: " + max);
        for (int i = 0; i < arr.length; i++) {
            result[i] = (float) arr[i]/max;
        }
        return result;
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

    public static String[] computeResults(int score, float noduleSize){
        String[] arr = new String[2];
        if ((score >= 0) && (score <= 1)) {
            arr[0] = "benigno";
            arr[1] = "no aaf";
        } else if (score == 2) {
            arr[0] = "no sospechoso";
            arr[1] = "no aaf";
        } else if (score == 3) {
            arr[0]  = "levemente sospechoso";
            if (noduleSize >= 2.5) {
                arr[1] = "aaf";
            } else {
                arr[1] = "seguimiento";
            }
        } else if ((score >= 4) && (score <= 6)) {
            arr[0] = "moderadamente sospechoso";
            if (noduleSize >= 1.5) {
                arr[1] = "aaf";
            } else {
                arr[1] = "seguimiento";
            }
        } else if (score >= 7) {
            arr[0] = "altamente sospechoso";
            if (noduleSize >= 1) {
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
        float[] noduleSizes = new float[numOfPatients];
        for (int i = 0; i < numOfPatients; i++) {
            noduleSizes[i] = Float.parseFloat(patientsMat[i][8]);
        }
        float[] normalizedArray = new float[numOfPatients];
        normalizedArray = getNormalizedArray(noduleSizes);
        printArray(alertArray);
        printArray(treatmentArray);
        printFormattedArray(normalizedArray);
    }
}