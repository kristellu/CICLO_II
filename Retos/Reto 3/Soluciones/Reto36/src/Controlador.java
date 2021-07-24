import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controlador {

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
    static Estudiante[] data = new Estudiante[6];

    @FXML
    private Button ingresar;

    @FXML
    private TextField nombre;

    @FXML
    private TextField genero;

    @FXML
    private TextField materia;

    @FXML
    private TextField nota;

    @FXML
    private TextArea entrada;

    @FXML
    private Button procesar;

    @FXML
    private TextArea salida;

    @FXML
    void clicIngresar(ActionEvent event) {

        String s = String.join(" ", nombre.getText(),
        genero.getText(),
        materia.getText(),
        nota.getText());
        entrada.setText(entrada.getText() + s + "\n");

    }

    @FXML
    void clicProcesar(ActionEvent event) {
        readData(entrada.getText());
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
    
    public static void readData(String entrada){

        String[] datos = entrada.split("\n");
        int x = 0;
        for (int i = 0; i < datos.length; i=i+3) {
            String[] line1 = datos[i].split(" ");
            String[] line2 = datos[i+1].split(" ");
            String[] line3 = datos[i+2].split(" ");
            double id = Double.parseDouble(line1[0]);
            double gen = Double.parseDouble(line1[1]);
            double notaI = Double.parseDouble(line1[3]);
            double notaH = Double.parseDouble(line2[3]);
            double notaL = Double.parseDouble(line3[3]);
            data[x] = new Estudiante(id, gen, notaI, notaH, notaL);
            x++;
        }

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

public static int getTestsFailed(Estudiante[] data){
    int count = 0;
    for(int i = 0; i < data.length; i++){
        count+=data[0].contarReprobados();       
    }
    return count;
}

public static int getExamsExcellent(Estudiante[] data){
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

public static int getSubjectMostApprobedExams(Estudiante[] data){
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
