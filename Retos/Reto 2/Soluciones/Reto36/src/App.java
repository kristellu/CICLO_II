import java.util.Scanner;
// ¿Cuantos de los examenes fueron reprobados?
// ¿Cuántos examenes tienen una calificación Excelente?
// ¿Cuál es la materia con el mayor numero de examenes aprobados?
// ¿Cuál es el estudiante con el peor desempeño para la materia historia?

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
    static String[] subjects = {"historia", "literatura", "biologia"};
	static double[][] gradingScale = gradingScale2;
    static String[] students = { "armando", "nicolas", "daniel", "maria", "marcela", "alexandra"};
    static String[] genders = {"m", "f"};
    static Persona[] data = new Persona[6];
    public static void main(String[] args) throws Exception {
        readData();
        print(getTestsFailed(data));
        print(getExamsExcellent(data));
        print(subjects[getSubjectMostApprobedExams(data)]);
        print(students[getStudentWorstGradeBySubject(data) -1]);
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
            data[i] = new Persona(id, gen, notaQ, notaI, notaH);
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

    public static int getTestsFailed(Persona[] data){
        int count = 0;
        for(int i = 0; i < data.length; i++){
            count+=data[0].contarReprobados();       
        }
        return count;
    }

    public static int getExamsExcellent(Persona[] data){
        int count = 0;
        for(int i = 0; i < data.length; i++){
            if(gradingScale[4][0] < data[i].getNotaBiologia() && gradingScale[4][1] >= data[i].getNotaBiologia())
                count++;
            if(gradingScale[4][0] < data[i].getNotaHistoria() && gradingScale[4][1] >= data[i].getNotaHistoria())
                count++;
            if(gradingScale[4][0] < data[i].getNotaLiteratura() && gradingScale[4][1] >= data[i].getNotaLiteratura())
                count++;
        }
        return count;
    }

    public static int getSubjectMostApprobedExams(Persona[] data){
        int[] subjectsCount = {0,0,0,0,0,0,0,0,0};
        
        for(int i = 0; i < data.length; i++){
            if(isAprobbed(data[i].getNotaHistoria())){
                subjectsCount[0] = subjectsCount[0] + 1;
            }
            if(isAprobbed(data[i].getNotaLiteratura())){
                subjectsCount[1] = subjectsCount[1] + 1;
            }
            if(isAprobbed(data[i].getNotaBiologia())){
                subjectsCount[2] = subjectsCount[2] + 1;
            }
        }
        double auxMax = 0;
        int auxIndex = -1;
        for(int i = 0; i < subjectsCount.length; i++){
            if(subjectsCount[i] != 0 && auxMax < subjectsCount[i]){
                auxIndex = i;
            }
        }
        return auxIndex;

    }

    public static int getStudentWorstGradeBySubject(Persona[] data){
        double min = data[0].getNotaHistoria();
        int indMin = (int)data[0].getId();
        for(int i = 0; i < data.length; i++){
            if(data[i].getNotaHistoria() < min){
                min = data[i].getNotaHistoria();
                indMin = (int)data[i].getId();
            }
        }
        return indMin;
    }

}