import java.util.Scanner;
// ¿Cuál es el desempeño promedio de todo el grupo?
// ¿Que porcentaje de los exámenes fueron Excelente?
// ¿Cuál genero tiene un mejor desempeño promedio?
// ¿Cuál es el estudiante con el mejor desempeño para la materia quimica?

public class Reto13 {

	static double[][] gradingScale0 = {
	    {0,1},
	    {1,2.5},
	    {2.5,3,5},
	    {3.5,4.5},
	    {4.5,5}
	};
	static double[][] gradingScale1 = {
	    {0,3},
	    {3,6},
	    {6,8},
	    {8,9},
	    {9,10}
	};
	static double[][] gradingScale2 = {
	    {0,30},
	    {30,60},
	    {60,80},
	    {80,90},
	    {90,100}
	};
    static String[] subjects = {"quimica", "idiomas", "historia"};
	static double[][] gradingScale = gradingScale0;
    static String[] students = { "armando", "nicolas", "daniel", "maria", "marcela", "alexandra"};
    static String[] genders = {"m", "f"};
    public static void main(String[] args) throws Exception {
        double[][] data = readData();
        print(getAverageAllGrades(data));
        print(geExamsPercentajeExcellent(data));
        print(genders[getGenderWithBestPerformance(data)]);
        print(students[getStudentBestGradeBySubject(data)[0] -1]);
    }
    public static void print(Object a){
        if(a instanceof Double){
            System.out.printf("%.2f\n",a);
        }else{
            System.out.println(a);
        }
        
    }     

    public static double[][] readData(){

        Scanner scanLine = new Scanner(System.in);
        int n = scanLine.nextInt();
        scanLine.nextLine();
        double[][] data = new double[n][4];
        String[] lines = new String[n];
        for(int i = 0; i < n; i++){
            lines[i] = scanLine.nextLine();
        }
        for(int i = 0; i < lines.length; i++){
            String[] line = lines[i].split(" ");
            for(int j = 0; j < line.length; j++)
                data[i][j] = Double.parseDouble(line[j]);
        }
        scanLine.close();
        return data;
    }

    // '¿Cuál es el desempeño promedio de todo el grupo?'
    public static double getAverageAllGrades(double[][] data){
        double sum = 0;
        for(int i = 0; i < data.length; i++){
            sum += data[i][3];
        }
        return (sum / data.length);
    }


    public static boolean isAprobbed(double grade){
        return gradingScale[2][0] < grade;
    }




    public static int getExamsExcellent(double[][] data){
        int count = 0;
        for(int i = 0; i < data.length; i++){
            if(gradingScale[4][0] < data[i][3] && gradingScale[4][1] >= data[i][3])
                count++;
        }
        return count;
    }
    public static double geExamsPercentajeExcellent(double[][] data){
        return (double)(getExamsExcellent(data)) / data.length;
    }

    public static int getGenderWithBestPerformance(double[][] data){
        double[] gendersSum = {0,0};
        int[] gendersCount = {0,0};
        for(int i = 0; i < data.length; i++){
            gendersSum[(int)(data[i][1])] +=  data[i][3];
            gendersCount[(int)(data[i][1])] = gendersCount[(int)(data[i][1])] + 1;
        }
        double auxMax = 0;
        int auxIndex = -1;
        for(int i = 0; i < gendersSum.length; i++){
            if(gendersCount[i] != 0 && auxMax < gendersSum[i]/gendersCount[i]){
                auxMax = gendersSum[i]/gendersCount[i];
                auxIndex = i;
            }
        }
        return auxIndex;
    }

    public static int[] getStudentBestGradeBySubject(double[][] data){
        double[] subjectsMax = {0,0,0};
        int[] subjectsStudentIndex = {0,0,0};
        for(int i = 0; i < data.length; i++){
            if(subjectsMax[(int)(data[i][2] -1 ) ] < data[i][3]){
                subjectsMax[(int)(data[i][2] -1 ) ] = data[i][3];
                subjectsStudentIndex[(int)(data[i][2] -1 )] = (int)data[i][0];
            }
        }
        return subjectsStudentIndex;
    }

}