import java.util.HashMap;

public class Student {
    private final String name;
    private final String gender;
    private final HashMap<String, Double> subjects_grades;
     
    public Student(String name, String gender, String[] subjects, double[] grades){
        this.gender = gender;
        this.name = name;
        this.subjects_grades = new HashMap<String, Double>();
        for(int i= 0; i < Math.min(subjects.length, grades.length); i++){
            subjects_grades.put(subjects[i], grades[i]);
        }
    }

    public Student(String name, String gender, HashMap<String, Double> subjects_grades){
        this.gender = gender;
        this.name = name;
        this.subjects_grades = subjects_grades;
    }

    public Student(String name, String gender, String subject, double grade){
        this.gender = gender;
        this.name = name;
        this.subjects_grades = new HashMap<String, Double>();
        this.subjects_grades.put(subject, grade);
    }

    public void addGrade(String subject, double grade){
        this.subjects_grades.put(subject, grade);
    }


    public double getGradeBySubcject(String subject){
        return subjects_grades.get(subject);
    }

    public double[] getGrades(){
        double[] grades = new double[subjects_grades.size()];
        Double[] auxGrades = subjects_grades.values().toArray(new Double[subjects_grades.size()]);
        for(int i = 0; i < subjects_grades.size(); i++)
            grades[i] = auxGrades[i].doubleValue();
        return grades;
    }

    public String[] getSubjects(){
        return subjects_grades.keySet().toArray(new String[subjects_grades.size()]);
    }
    
    public Object[][] formatOutputArray(){
        Object[][] info = new Object[subjects_grades.size()][4];
        int i = 0;
        for(String subject : subjects_grades.keySet()){
            info[i][0] = this.name;
            info[i][1] = this.gender;
            info[i][2] = subject;
            info[i][3] = subjects_grades.get(subject);
            i++;
        }

        return info;
    }
}
