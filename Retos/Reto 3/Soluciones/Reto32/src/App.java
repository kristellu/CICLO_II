import java.util.Scanner;
// ¿Cuantos de los examenes tienen una calificación mayor a la del promedio del grupo?
// ¿Cuántos examenes tienen una calificación Deficiente?
// ¿Cuál es la materia con el mejor desempeño promedio para todo el grupo?
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
	static double[][] gradingScale = gradingScale1;
    static String[] students = { "armando", "nicolas", "daniel", "maria", "marcela", "alexandra"};
    static String[] genders = {"m", "f"};
    static Estudiante[] data = new Estudiante[6];
    public static void main(String[] args) throws Exception {
        readData();
        print(getTestsPerformanceOverAvg(data));
        print(getExamsDeficient(data));
        print(subjects[getBetterPerformingSubjectGroup(data)]);
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
            double notaH = Double.parseDouble(line1[3]);
            double notaL = Double.parseDouble(line2[3]);
            double notaB = Double.parseDouble(line3[3]);
            data[i] = new Estudiante(id, gen, notaH, notaL, notaB);
        }
        scanLine.close();
    }

    // '¿Cuál es el desempeño promedio de todo el grupo?'
    public static double getAverageAllGrades(Estudiante[] data){
        double sum = 0;
        for(int i = 0; i < data.length; i++){
            sum += data[i].getNotaHistoria() + data[i].getNotaBiologia() + data[i].getNotaLiteratura() ;
        }
        return (sum / (data.length*3));
    }


    public static boolean isAprobbed(double grade){
        return gradingScale[2][0] < grade;
    }

    public static int getTestsPerformanceOverAvg(Estudiante[] data){
        int count = 0;
        double avg = getAverageAllGrades(data);
        for(int i = 0; i < data.length; i++){
            if(data[i].getNotaHistoria() > avg)
                count++;
            if(data[i].getNotaBiologia() > avg)
                count++;
            if(data[i].getNotaLiteratura() > avg)
                count++;
        }
        return count;
    }

    public static int getExamsDeficient(Estudiante[] data){
        int count = 0;
        for(int i = 0; i < data.length; i++){
            count += data[i].contarDeficientes();
        }
        return count;
    }

    public static int getBetterPerformingSubjectGroup(Estudiante[] data){
        double[] subjectsSum = {0,0,0};
        int[] subjectsCount = {0,0,0};

        for(int j = 0; j < data.length; j++){
            subjectsSum[0] = subjectsSum[0] + data[j].getNotaHistoria();
            subjectsSum[1] = subjectsSum[1] + data[j].getNotaLiteratura();
            subjectsSum[2] = subjectsSum[2] + data[j].getNotaBiologia();
            subjectsCount[0] = subjectsCount[0] + 1;
            subjectsCount[1] = subjectsCount[1] + 1;
            subjectsCount[2] = subjectsCount[2] + 1;
        }
        
        double auxMax = 0;
        int auxIndex = -1;
        for(int i = 0; i < subjectsSum.length; i++){
            if(subjectsCount[i] != 0 && auxMax < subjectsSum[i]/subjectsCount[i]){
                auxMax = subjectsSum[i]/subjectsCount[i];
                auxIndex = i;
            }
                
        }
        return auxIndex;
        
    }

    public static int getStudentWorstGradeBySubject(Estudiante[] data){
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