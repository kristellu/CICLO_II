import java.util.Scanner;
// ¿Cuantos de los examenes tienen una calificación mayor a la del promedio del grupo?
// ¿Cuántos examenes tienen una calificación Regular?
// ¿Cuál es la materia con el mayor numero de examenes reprobados
// ¿Cuál es el estudiante con el mejor desempeño para la materia quimica?

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
    static String[] subjects = {"quimica", "idiomas", "historia"};
	static double[][] gradingScale = gradingScale0;
    static String[] students = { "armando", "nicolas", "daniel", "maria", "marcela", "alexandra"};
    static String[] genders = {"m", "f"};
    static Estudiante[] data = new Estudiante[6];
    public static void main(String[] args) throws Exception {
        readData();
        print(getTestsPerformanceOverAvg(data));
        print(getExamsRegular(data));
        print(subjects[getSubjectMostFailedExams(data)]);
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
    public static double getAverageAllGrades(Estudiante[] data){
        double sum = 0;
        for(int i = 0; i < data.length; i++){
            sum += data[i].getNotaHistoria() + data[i].getNotaIdioma() + data[i].getNotaQuimica() ;
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
            if(data[i].getNotaIdioma() > avg)
                count++;
            if(data[i].getNotaQuimica() > avg)
                count++;
        }
        return count;
    }


    public static int getExamsRegular(Estudiante[] data){
        int count = 0;
        for(int i = 0; i < data.length; i++){
            count += data[i].contarRegulares();
        }
        return count;
    }

public static int getSubjectMostFailedExams(Estudiante[] data){
    int[] subjectsCount = {0,0,0};
        for(int i = 0; i < data.length; i++){
            if(!isAprobbed(data[i].getNotaQuimica())){
                subjectsCount[0]++;
            }
            if(!isAprobbed(data[i].getNotaIdioma())){
                subjectsCount[1]++;
            }
            if(!isAprobbed(data[i].getNotaHistoria())){
                subjectsCount[2]++;
            }
        }
        double auxMax = 0;
        int auxIndex = -1;
        for(int i = 0; i < subjectsCount.length; i++){
            if(subjectsCount[i] != 0 && auxMax < subjectsCount[i]){
                auxMax = subjectsCount[i];
                auxIndex = i;
            }
        }
        return auxIndex;
}

    public static int getStudentBestGradeBySubject(Estudiante[] data){
        double max = data[0].getNotaQuimica();
        int indMax = (int)data[0].getId();
        for(int i = 0; i < data.length; i++){
            if(data[i].getNotaQuimica() > max){
                max = data[i].getNotaQuimica();
                indMax = (int)data[i].getId();
            }
        }
        return indMax;
    }

}