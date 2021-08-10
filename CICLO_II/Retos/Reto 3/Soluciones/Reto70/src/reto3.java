/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;

/**
 *
 * @author acer nitro5
 */
public class reto3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int num;
        CuerpoDeAgua[] datos = new CuerpoDeAgua[100];
        Scanner sc = new Scanner(System.in);
        num = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < num; i++) {
            String[] lines = sc.nextLine().split(" ");
            datos[i] = new CuerpoDeAgua(lines[0], Double.parseDouble(lines[1]),
                    lines[2], lines[3], lines[4],Double.parseDouble(lines[5]));
        }
        sc.close();

        //nivel de riesgo y nombre de cada cuerpo de agua        
        String nivel_nombre;
        for (int i = 0; i < num; i++) {
            nivel_nombre = datos[i].nivel()+" "+datos[i].getNombre();
            System.out.println(nivel_nombre);
        }

        //Numero de cuerpos de agua que no requieren la accion de la ALCALDIA
        double cont = 0;
        for (int i = 0; i < num; i++) {
            if (datos[i].getIrca() <= 35 || datos[i].getIrca() > 80) {
                cont++;
            }

        }
        System.out.println(String.format("%.2f", cont));

         //irca de los cuerpos que tienen nivel de riesgo SIN RIESGO
        double contm = 0;
        for (int i = 0; i < num; i++) {
            if (datos[i].getIrca() <= 5) {
                System.out.println(String.format("%.2f", datos[i].getIrca())+ " ");
                contm++;
            }
        }
        if (contm == 0) {
            System.out.print("NA"+"\n");
        }
        
        //irca promedio
        double promedio;
        double suma = 0;
        for (int i = 0; i < num; i++) {
            suma+= datos[i].getIrca();            
        }
        promedio = suma/num;
        System.out.println(String.format("%.2f", promedio));

 



    }

}