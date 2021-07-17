import java.util.Scanner;
// ¿Cuantos de los examenes tienen una calificación mayor a la del promedio del grupo?
// ¿Cuántos examenes tienen una calificación Regular?
// ¿Cuál es la materia con el mayor numero de examenes reprobados
// ¿Cuál es el estudiante con el mejor desempeño para la materia quimica?

public class SchoolGradingSystem {
    private double[][] data;
	private final double[][] gradingScale = {
	    {0,1},
	    {1,2.5},
	    {2.5,3,5},
	    {3.5,4.5},
	    {4.5,5}
	};
    private final String[] subjects = {"quimica", "idiomas", "historia"};
    private final String[] students = { "armando", "nicolas", "daniel", "maria", "marcela", "alexandra"};
    private final String[] genders = {"m", "f"};


    public SchoolGradingSystem(){}

    public void readData(){
        Scanner scanLine = new Scanner(System.in);
        int n = scanLine.nextInt();
        scanLine.nextLine();
        data = new double[n][4];
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
    }

    // '¿Cuál es el desempeño promedio de todo el grupo?'
    private double getAverageAllGrades(){
        double sum = 0;
        for(int i = 0; i < data.length; i++){
            sum += data[i][3];
        }
        return (sum / data.length);
    }


    private boolean isAprobbed(double grade){
        return gradingScale[2][0] < grade;
    }

    public int question1(){
        int count = 0;
        double avg = getAverageAllGrades();
        for(int i = 0; i < data.length; i++){
            if(data[i][3] > avg)
                count++;
        }
        return count;
    }

    public int question2(){
        int count = 0;
        for(int i = 0; i < data.length; i++){
            if(gradingScale[2][0] < data[i][3] && gradingScale[2][1] >= data[i][3])
                count++;
        }
        return count;
    }

public String question3(){
    int[] subjectsCount = {0,0,0};
    for(int i = 0; i < data.length; i++){
        if(!isAprobbed(data[i][3])){
            subjectsCount[(int)(data[i][2] - 1)] = subjectsCount[(int)(data[i][2] - 1)] + 1;
        }
    }
    double auxMax = 0;
    int auxIndex = -1;
    for(int i = 0; i < subjectsCount.length; i++){
        if(subjectsCount[i] != 0 && auxMax < subjectsCount[i]){
            auxIndex = i;
        }
    }
    return subjects[auxIndex];
}

    public String question4(){
        double[] subjectsMax = {0,0,0};
        int[] subjectsStudentIndex = {0,0,0};
        for(int i = 0; i < data.length; i++){
            if(subjectsMax[(int)(data[i][2] -1 ) ] < data[i][3]){
                subjectsMax[(int)(data[i][2] -1 ) ] = data[i][3];
                subjectsStudentIndex[(int)(data[i][2] -1 )] = (int)data[i][0];
            }
        }
        return students[subjectsStudentIndex[0] - 1];
    }



}