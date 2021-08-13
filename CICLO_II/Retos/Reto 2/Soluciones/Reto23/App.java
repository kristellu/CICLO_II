public class App{
    public static void main(String[] args){
        SchoolGradingSystem gradingSystem = new SchoolGradingSystem();
        gradingSystem.readData();
        print(gradingSystem.question1());
        print(gradingSystem.question2());
        print(gradingSystem.question3());
        print(gradingSystem.question4());

    }

    public static void print(Object a){
        if(a instanceof Double){
            System.out.printf("%.2f\n",a);
        }else{
            System.out.println(a);
        }
    }
}