import java.util.Scanner;
import java.util.Arrays;
import java.util.*;

public class Reto53 {
    
    static int promt;
    
    public static void level(double num){
        if(num >= 0 && num <= 5){System.out.println("SIN RIESGO"); return;}
        if(num > 5 && num <= 14){System.out.println("BAJO"); return;}
        if(num > 14 && num <= 35){System.out.println("MEDIO"); return;}
        if(num > 35 && num <= 80){System.out.println("ALTO"); return;}
        if(num > 80 && num <= 100){System.out.println("INVIABLE SANITARIAMENTE"); return;}
        }
        
    public static void porcentaje(double num){
        if(num >= 0 && num <= 5){promt = 1; return;}
        if(num > 5 && num <= 14){promt = 2; return;}
        if(num > 14 && num <= 35){promt = 3; return;}
        if(num > 35 && num <= 80){promt = 4; return;}
        if(num > 80 && num <= 100){promt = 5; return;}
        }
    
    public static void main(String args[]) {
        
        double sum = 0;
        double prom;
        int tipop;
        double cont = 0;
        double porc;
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        double data[] = new double[n];
        
        for(int i = 0; i< n; i++){
            data[i] = sc.nextDouble();
            sum += data[i];
        }
        
        prom = sum/n;
        
        Arrays.sort(data);
        
        level(prom);
        porcentaje(prom);
        tipop = promt;
        for(int i = 0; i< n; i++){
            porcentaje(data[i]);
            if(promt == tipop){
                cont++;
            }
        }
        
        porc = cont/n*100;
        System.out.println(String.format("%.2f", porc));
        level(data[0]);
    }
}