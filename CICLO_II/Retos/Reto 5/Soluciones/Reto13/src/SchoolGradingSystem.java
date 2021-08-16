import java.util.Formatter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class SchoolGradingSystem extends GradingSystem{
    
    private HashMap<String,Student> studentsList;

    public SchoolGradingSystem(){
        this.studentsList = new HashMap<String, Student>();
    }


    public void loadDataGUI(String inputText, int n){
        String[] lines = inputText.split("\n");
        Set<String> usedNames = new HashSet<String>();
        for(int i = 0; i<n; i++){
            String[] row = lines[i].split(" ");
            String name = this.students[(int)Double.parseDouble(row[0]) - 1];
            String gender = this.genders[(int)Double.parseDouble(row[1])];
            String subject = this.subjects[(int)Double.parseDouble(row[2]) - 1 ];
            double grade = Double.parseDouble(row[3]);

            if(usedNames.add(name)){
                studentsList.put(name, new Student(name, gender, subject, grade));
            }else{
                studentsList.get(name).addGrade(subject, grade);
            }
        }

    }

    public double[][] getData(){
        int numberRecords = 0;
        for(Student st : studentsList.values()){
            numberRecords += st.formatOutputArray().length;
        }

        double[][] data = new double[numberRecords][4];
        int i = 0;
        for(Student st : studentsList.values()){
            for(int j=0; j < st.formatOutputArray().length; j++){
                Object[][] aux = st.formatOutputArray();
                data[i][0] = this.getIndexOf(aux[j][0], this.students) + 1;
                data[i][1] = this.getIndexOf(aux[j][1], this.genders);
                data[i][2] = this.getIndexOf(aux[j][2], this.subjects) + 1;
                data[i][3] = (double)aux[j][3];
                i++;
            }
        }
        return data;
    }

    private int getIndexOf(Object e, Object[] l){
        for(int i = 0; i < l.length; i++){
            if(l[i].equals(e))
                return i;
            
        }
        return -1;
    }

    private String formatOutput(Object o){
        if(o instanceof Double){
            Formatter fmt = new Formatter();
            String aux = fmt.format("%.2f", o).toString();
            fmt.close();
            return aux;
        }
        return o.toString();
    }

    public String getAnswers(double[][] data){
        String aux = formatOutput(stat1(data));
        aux += "\n" + formatOutput(stat2(data));
        aux += "\n" + stat3(data);
        aux += "\n" + stat4(data);
        return aux;
    }

}