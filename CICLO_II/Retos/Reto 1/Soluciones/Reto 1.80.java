import java.util.Scanner;
import java.util.Arrays;
import java.util.*;

public class Reto80{
    
    public static void level(double num){
        if(num >= 0 && num <= 5){System.out.println("Continuar el control y la vigilancia"); return;}
        if(num > 5 && num <= 14){System.out.println("BAJO"); return;}
        if(num > 14 && num <= 35){System.out.println("MEDIO"); return;}
        if(num > 35 && num <= 80){System.out.println("ALTO"); return;}
        if(num > 80 && num <= 100){System.out.println("INVIABLE SANITARIAMENTE"); return;}
        }
    
    public static void main(String args[]) {
        
        double data[] = new double[6];
        double sum = 0;
        double prom;
        double min = 101;
        double max = -1;
        double suma = 0;
        
        Scanner sc = new Scanner(System.in);
        
        for(int i = 0; i<= 5; i++){
            data[i] = sc.nextDouble();
            sum += data[i];
            if(data[i]<min && data[i]>35 && data[i]<=80){
                min = data[i];
            }
            if(data[i]>max && data[i]<=80 && data[i]>35){
                max = data[i];
            }
        }
        
        prom = sum/6;
        
        Arrays.sort(data);
        
        level(prom);
        
        suma = min + max;
        
        if(max > -1){
            System.out.println(String.format("%.2f", suma));
        }else{System.out.println("NA");}
         System.out.println(String.format("%.2f", data[0]));
    }
}