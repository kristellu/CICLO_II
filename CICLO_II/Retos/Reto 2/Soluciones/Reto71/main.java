/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.reto71;

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

        //nivel de riesgo e id de cada cuerpo de agua        
        String nivel_id;
        for (int i = 0; i < num; i++) {
            nivel_id = datos[i].nivel()+" "+datos[i].getId();
            System.out.println(nivel_id);
        }

        //Numero de cuerpos de agua que no requieren la accion de la ALCALDIA
        double cont = 0;
        for (int i = 0; i < num; i++) {
            if (datos[i].getIrca() > 35) {
                cont++;
            }

        }
        System.out.println(String.format("%.2f", cont));

         //irca de los cuerpos que tienen nivel de riesgo MEDIO
        double contm = 0;
        for (int i = 0; i < num; i++) {
            if (datos[i].getIrca() > 14 && datos[i].getIrca() <= 35) {
                System.out.println(String.format("%.2f", datos[i].getIrca())+ " ");
                contm++;
            }
        }
        if (contm == 0) {
            System.out.print("NA"+"\n");
        }
        
        //irca mas bajo
        double min = 101;
        for (int i = 0; i < num; i++) {
            if (datos[i].getIrca() < min) {
                min = datos[i].getIrca();
            }
        }
        System.out.println(String.format("%.2f", min));


    }

}
