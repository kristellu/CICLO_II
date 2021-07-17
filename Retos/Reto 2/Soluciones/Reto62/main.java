/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.reto62;

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

        //id y nivel de riesgo de cada cuerpo de agua        
        String id_riesgo;
        for (int i = 0; i < num; i++) {
            id_riesgo = String.format("%.2f", datos[i].getId())+" "+datos[i].nivel();
            System.out.println(id_riesgo);
        }

        //Numero de cuerpos de agua con irca menor o igual a 14
        double cont = 0;
        for (int i = 0; i < num; i++) {
            if (datos[i].getIrca() <= 14) {
                cont++;
            }

        }
        System.out.println(String.format("%.2f", cont));

        //Nombre de cuerpos de agua con nivel de riesgo BAJO
        double contm = 0;
        for (int i = 0; i < num; i++) {
            if (datos[i].getIrca() > 5 && datos[i].getIrca() <= 14) {
                System.out.print(datos[i].getNombre() + " ");
                contm++;
            }
        }
        if (contm == 0) {
            System.out.print("NA");
        }
        
        // irca mas alto
        double max = -1;
        for (int i = 0; i < num; i++) {
            if (datos[i].getIrca() > max) {
                max = datos[i].getIrca();
            }
        }
        System.out.println("\n"+String.format("%.2f", max));
		


    }

}
