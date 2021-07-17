/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.reto64;

import java.util.Scanner;

/**
 *
 * @author acer nitro5
 */
public class main {

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
                    lines[2], Double.parseDouble(lines[3]));
        }

        //nombre e identificador de cada cuerpo de agua        
        String nombre_id;
        for (int i = 0; i < num; i++) {
            nombre_id = datos[i].getNombre()+" "+String.format("%.2f", datos[i].getId());
            System.out.println(nombre_id);
        }

        //Numero de cuerpos de agua con irca mayor a 0
        double cont = 0;
        for (int i = 0; i < num; i++) {
            if (datos[i].getIrca() > 0) {
                cont++;
            }

        }
        System.out.println(String.format("%.2f", cont));

         //Nombre de cuerpos de agua con nivel de riesgo entre BAJO y ALTO
        double contm = 0;
        for (int i = 0; i < num; i++) {
            if (datos[i].getIrca() > 5 && datos[i].getIrca() <= 80) {
                System.out.print(datos[i].getNombre() + " ");
                contm++;
            }
        }
        if (contm == 0) {
            System.out.print("NA");
        }
        
        // irca mas alto y mas bajo
        double max = -1;
        double min = 101;
        for (int i = 0; i < num; i++) {
            if (datos[i].getIrca() > max) {
                max = datos[i].getIrca();
            }
            if (datos[i].getIrca() < min) {
                min = datos[i].getIrca();
            }
        }
        System.out.println("\n"+String.format("%.2f", max)+" "+String.format("%.2f", min));

		


    }

}
