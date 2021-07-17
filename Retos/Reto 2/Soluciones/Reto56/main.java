/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.reto56;

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

        //id de cada cuerpo de agua        
        double id;
        for (int i = 0; i < num; i++) {
            id = datos[i].getId();
            System.out.println(String.format("%.2f", id));
        }


        //Numero de cuerpos de agua con nivel de riesgo entre MEDIO y ALTO
        double cont = 0;
        for (int i = 0; i < num; i++) {
            if (datos[i].getIrca() > 14 && datos[i].getIrca() <= 80) {
                cont++;
            }

        }
        System.out.println(String.format("%.2f", cont));

        //Nombre de los municipios con cuerpos de agua con nivel de riesgo MEDIO
        double contm = 0;
        for (int i = 0; i < num; i++) {
            if (datos[i].getIrca() > 14 && datos[i].getIrca() <= 35) {
                System.out.print(datos[i].getMunicipio()+ " ");
                contm++;
            }
        }
        if (contm == 0) {
            System.out.print("NA");
        }

        //irca promedio
        double promedio;
        double suma = 0;
        for (int i = 0; i < num; i++) {
            suma+= datos[i].getIrca();            
        }
        promedio = suma/num;
        System.out.println("\n"+String.format("%.2f", promedio));


    }

}
