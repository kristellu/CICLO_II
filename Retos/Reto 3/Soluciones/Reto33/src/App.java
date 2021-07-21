import java.util.Scanner;
// ¿Cuantos de los examenes tienen una calificación mayor a la del promedio del grupo?
// ¿Que porcentaje de los exámenes fueron Excelente?
// ¿Cuál es la materia con el peor desempeño promedio para todo el grupo?
// ¿Cuál es el estudiante con el mejor desempeño para la materia matemáticas?

public class App {

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
    static String[] subjects = {"matemáticas", "informatica", "fisica"};
	static double[][] gradingScale = gradingScale2;
    static String[] students = { "armando", "nicolas", "daniel", "maria", "marcela", "alexandra"};
    static String[] genders = {"m", "f"};
    static Estudiante[] data = new Estudiante[6];
    public static void main(String[] args) throws Exception {
        readData();
        print(getTestsPerformanceOverAvg(data));
        print(geExamsPercentajeExcellent(data));
        print(subjects[getWorseSubjectGroup(data)]);
        print(students[getStudentBestGradeBySubject(data) -1]);
    }
    public static void print(Object a){
        if(a instanceof Double){
            System.out.printf("%.2f\n",a);
        }else{
            System.out.println(a);
        }
        
    }     

    public static void readData(){

        Scanner scanLine = new Scanner(System.in);
        int n = scanLine.nextInt();
        scanLine.nextLine();

        for(int i = 0; i < n/3; i++){
            String[] line1 = scanLine.nextLine().split(" ");
            String[] line2 = scanLine.nextLine().split(" ");
            String[] line3 = scanLine.nextLine().split(" ");
            double id = Double.parseDouble(line1[0]);
            double gen = Double.parseDouble(line1[1]);
            double notaQ = Double.parseDouble(line1[3]);
            double notaI = Double.parseDouble(line2[3]);
            double notaH = Double.parseDouble(line3[3]);
            data[i] = new Estudiante(id, gen, notaQ, notaI, notaH);
        }
        scanLine.close();
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

    public static double getTestsPerformanceOverAvg(Estudiante[] data){
        double sum = 0;
        for(int i = 0; i < data.length; i++){
            sum += data[i].getNotaFis() + data[i].getNotaInf() + data[i].getNotaMat() ;
        }
        return (sum / (data.length*3));
    }

    public static int getExamsExcellent(Estudiante[] data){
        int res = 0;
        for(int i = 0; i < data.length; i++){
            res+=data[i].contarExcelentes();
        }
        return res;
    }
    public static double geExamsPercentajeExcellent(Estudiante[] data){
        return (double)(getExamsExcellent(data)) / data.length;
    }

    public static int getWorseSubjectGroup(Estudiante[] data){
        double[] subjectsSum = {0,0,0};
        int[] subjectsCount = {0,0,0};
        
        for(int j = 0; j < data.length/3; j++){
            subjectsSum[0] = subjectsSum[0] + data[j].getNotaMat();
            subjectsSum[1] = subjectsSum[0] + data[j].getNotaInf();
            subjectsSum[2] = subjectsSum[0] + data[j].getNotaFis();
            subjectsCount[0] = subjectsCount[0] + 1;
            subjectsCount[1] = subjectsCount[1] + 1;
            subjectsCount[2] = subjectsCount[2] + 1;
        }
        
        double auxMin = 100000;
        int auxIndex = -1;
        for(int i = 0; i < subjectsSum.length; i++){
            if(subjectsCount[i] != 0 && auxMin > subjectsSum[i]/subjectsCount[i]){
                auxMin = subjectsSum[i]/subjectsCount[i];
                auxIndex = i;
            }
                
        }
        return auxIndex;
        
    }

    public static int getStudentBestGradeBySubject(Estudiante[] data){
        double max = data[0].getNotaMat();
        int indMax = (int)data[0].getId();
        for(int i = 0; i < data.length; i++){
            if(data[i].getNotaMat() > max){
                max = data[i].getNotaMat();
                indMax = (int)data[i].getId();
            }
        }
        return indMax;
    }

}