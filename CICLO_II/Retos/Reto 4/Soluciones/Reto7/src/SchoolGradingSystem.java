import java.util.Formatter;
import java.util.Scanner;

public class SchoolGradingSystem extends GradingSystem{
    
    private double data[][];

    public SchoolGradingSystem(){}

    public double[][] getData(){
        return data;
    }

    public void loadData(){
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

    public void loadDataGUI(String inputText, int n){
        String[] lines = inputText.split("\n");
        data = new double[n][4];
        for(int i = 0; i<n; i++){
            String[] numbers = lines[i].split(" ");
            for(int j=0; j< 4; j++){
                data[i][j] = Double.parseDouble(numbers[j]);
            }
        }
    }

    public String formatOutput(Object o){
        if(o instanceof Double){
            Formatter fmt = new Formatter();
            String aux = fmt.format("%.2f", o).toString();
            fmt.close();
            return aux;
        }
        return o.toString();
    }

    public String getAnswers(){
        String aux = formatOutput(stat1(data));
        aux += "\n" + formatOutput(stat2(data));
        aux += "\n" + stat3(data);
        aux += "\n" + stat4(data);
        return aux;
    }

    public double getIndexOf(Object[] a, Object b){
        for(int i= 0; i < a.length; i++){
            if(a[i].equals(b))
                return i;
        }
        return -1;
    }
}