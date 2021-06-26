import java.util.Scanner;
import java.util.Arrays;
import java.util.*;

public class Reto66{
    
        static double cs = 0;
        static double cb = 0;
        static double cm = 0;
        static double ca = 0;
        static double ci = 0;
    
    public static void level(double num){
        if(num >= 0 && num <= 5){System.out.println("Continuar el control y la vigilancia"); return;}
        if(num > 5 && num <= 14){System.out.println("BAJO"); return;}
        if(num > 14 && num <= 35){System.out.println("MEDIO"); return;}
        if(num > 35 && num <= 80){System.out.println("ALTO"); return;}
        if(num > 80 && num <= 100){System.out.println("INVIABLE SANITARIAMENTE"); return;}
        }
        
    public static void levelsort(double[] data){
        for(int i = 0; i<= 5; i++){
            if(data[i] >= 0 && data[i] <= 5){cs++;}
            if(data[i] > 5 && data[i] <= 14){cb++;}
            if(data[i] > 14 && data[i] <= 35){cm++;}
            if(data[i] > 35 && data[i] <= 80){ca++;}
            if(data[i] > 80 && data[i] <= 100){ci++;}
        }
         return;
        }
        
     public static void comun(){
        if(cs >= cb && cs >= cm && cs >= ca && cs >= ci){System.out.println("CONTINUAR VIGILANCIA"); return;}
        if(cb >= cs && cb >= cm && cb >= ca && cb >= ci){System.out.println("PERSONA PRESTADORA"); return;}
        if(cm >= cs && cm >= cb && cm >= ca && cm >= ci){System.out.println("PERSONA PRESTADORA"); return;}
        if(ca >= cs && ca >= cb && ca >= cm && ca >= ci){System.out.println("ALCALDIA"); return;}
        if(ci >= cs && ci >= cb && ci >= cm && ci >= ca){System.out.println("GOBERNACION"); return;}
        }
        
    
    public static void main(String args[]) {
        
        double data[] = new double[6];
        double sum = 0;
        double prom;
        double cont = 0;
        
        Scanner sc = new Scanner(System.in);
        
        for(int i = 0; i<= 5; i++){
            data[i] = sc.nextDouble();
            sum += data[i];
        }
        
        prom = sum/6;
        
        Arrays.sort(data);
        
        level(prom);
        levelsort(data);
        System.out.println(String.format("%.2f", cb+cm));
        System.out.println(String.format("%.2f", data[0]));
        

    }
}