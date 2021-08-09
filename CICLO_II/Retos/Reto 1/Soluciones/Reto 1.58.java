import java.util.Scanner;
import java.util.Arrays;
import java.util.*;

public class Reto58{
    
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
        double cont1 = 0;
        double cont2 = 0;
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        double data[] = new double[n];
        
        for(int i = 0; i< n; i++){
            data[i] = sc.nextDouble();
            sum += data[i];
             if(data[i] > 35 && data[i] <= 80){
                cont1++;
            }
            if(data[i] > 80 && data[i] <= 100){
                cont1++;
            }
            if(data[i] >= 0 && data[i] <= 5){
                cont2++;
            }
        }
        
        prom = sum/n;
        
        Arrays.sort(data);
        
        level(prom);
        System.out.println(String.format("%.2f", cont1/n*100));
        if(cont2>= 1){
            System.out.println("SI");
        }else{System.out.println("NO");}
    }
}