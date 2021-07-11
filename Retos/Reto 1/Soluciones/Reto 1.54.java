import java.util.Scanner;
import java.util.Arrays;
import java.util.*;

public class Reto54{
    
    public static void level(double num){
        if(num >= 0 && num <= 5){System.out.println("SIN RIESGO"); return;}
        if(num > 5 && num <= 14){System.out.println("BAJO"); return;}
        if(num > 14 && num <= 35){System.out.println("MEDIO"); return;}
        if(num > 35 && num <= 80){System.out.println("ALTO"); return;}
        if(num > 80 && num <= 100){System.out.println("INVIABLE SANITARIAMENTE"); return;}
        }
    
    public static void main(String args[]) {
        
        double sum = 0;
        double prom;
        double cont = 0;
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        double data[] = new double[n];
        
        for(int i = 0; i< n; i++){
            data[i] = sc.nextDouble();
            sum += data[i];
            if(data[i] > 80 && data[i] <= 100){
                cont++;
            }
        }
        
        prom = sum/n;
        
        Arrays.sort(data);
        
        level(prom);
        System.out.println(String.format("%.2f", cont/n*100));
        level(data[n-1]);
    }
}