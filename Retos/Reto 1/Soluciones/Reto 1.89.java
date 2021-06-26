import java.util.Arrays;
import java.util.Scanner;

public class Reto89 {

    public static float[] getRangeAndMedian(float[] arr) {
        float[] result = new float[2];
        Arrays.sort(arr);
        float min = arr[0];
        float max = arr[arr.length - 1];
        float range = max - min;
        result[0] = range;
        float median = 0;
        if (arr.length % 2 == 0)
            median = (arr[arr.length/2] + arr[arr.length/2 - 1])/2;
        else
            median = arr[arr.length/2];
        result[1] = median;
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
        float[] rangeAndMedian = new float[2];
        rangeAndMedian = getRangeAndMedian(noduleSizes);
        float rangeNoduleSize = rangeAndMedian[0];
        float medianNoduleSize = rangeAndMedian[1];
        System.out.println(rangeNoduleSize);
        System.out.println(medianNoduleSize);
    }
}