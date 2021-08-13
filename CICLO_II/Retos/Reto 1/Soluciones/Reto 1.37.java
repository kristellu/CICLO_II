/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RetosCiclo2;

import java.util.Scanner;

/**
 *
 * @author Asus
 */
public class Reto37 {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        // TODO code application logic here
        int n;
        String datos[][] = new String[100][6];
        int puntaje[] = new int[100];

        Scanner leer = new Scanner(System.in);

        //System.out.println("Digite el número de pacientes: ");
        n = leer.nextInt();

        for (int i = 0; i < n; i++) {
            //System.out.println("Digite el nombre del paciente " + (i + 1));
            datos[i][0] = leer.next();
            //System.out.println("Digite la cedula del paciente " + (i + 1));
            datos[i][1] = leer.next();
            //System.out.println("Digite el género del paciente, M para masculino y F para femenino");
            datos[i][2] = leer.next();
            for (int j = 3; j < 6; j++) {
                //System.out.println("Digite la muestra " + (j - 2) + " para el paciente " + (i + 1));
                datos[i][j] = leer.next();
            }
        }
        
        String nomM="";
        double creM=-1000;

        for (int i = 0; i < n; i++) {
            System.out.println("Para el paciente " + (i+1));
            int ptpp = 0, numMPD=0; 
            String numM="";
            

            double m1 = Double.parseDouble(datos[i][3]);
            if (datos[i][2].equals("M")) {
                //Masculino
                if (m1 < 0.74 || m1 > 1.35) {
                    ptpp += 5;
                }
                if(m1 < 0.74){
                    numMPD++;
                    numM+="1";
                }
            } else {
                //Femenino
                if (m1 < 0.59 || m1 > 1.04) {
                    ptpp += 5;
                }
                if(m1 < 0.59){
                    numMPD++;
                    numM+="1";
                }
            }

            double m2 = Double.parseDouble(datos[i][4]);
            if (datos[i][2].equals("M")) {
                //Masculino
                if (m2 < 0.74 || m2 > 1.35) {
                    ptpp += 5;
                }
                
                if(m2 < 0.74){
                    numMPD++;
                    numM+=" 2";
                }
            } else {
                //Femenino
                if (m2 < 0.59 || m2 > 1.04) {
                    ptpp += 5;
                }
                
                if(m2 < 0.59){
                    numMPD++;
                    numM+=" 2";
                }
            }

            double m3 = Double.parseDouble(datos[i][5]);
            if (datos[i][2].equals("M")) {
                //Masculino
                if (m3 < 14 || m3 > 26) {
                    ptpp += 5;
                }
                
                if(m3 < 14){
                    numMPD++;
                    numM+=" 3";
                }
            } else {
                //Femenino
                if (m3 < 11 || m3 > 20) {
                    ptpp += 5;
                }
                
                if(m3 < 11){
                    numMPD++;
                    numM+=" 3";
                }
            }
            
            if(m3 > creM){
                creM = m3;
                nomM = datos[i][0];
            }
            
            System.out.println("Puntaje obtenido: " + ptpp);
            puntaje[i] = ptpp;
            
            switch (ptpp) {
                case 0:
                    System.out.println("Categorización riesgo: Sin Riesgo");
                    break;
                case 5:
                    System.out.println("Categorización riesgo: Bajo");
                    break;
                case 10:
                    System.out.println("Categorización riesgo: Medio");
                    break;
                case 15:
                    System.out.println("Categorización riesgo: Alto");
                    break;
            }
            
            puntaje[i] = ptpp;
            System.out.println("Número de las muestras por debajo de los niveles normales: " + numMPD);
            System.out.println("Número de las muestras que se encuentran por debajo de los niveles normales: " + numM);
            
        }
        System.out.println("Mayor: " + nomM);
            

        for (int i = 0; i < n; i++) {
            System.out.println("");
            for (int j = 0; j < 6; j++) {
                System.out.print(datos[i][j] + " ");
            }
        }
    }

}
