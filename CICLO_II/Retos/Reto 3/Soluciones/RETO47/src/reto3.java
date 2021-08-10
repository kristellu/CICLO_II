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
public class App {

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
        //Nivel de riesgo de cada cuerpo de agua
        String nivel;
        for (int i = 0; i < num; i++) {
            nivel = datos[i].nivel();
            System.out.println(nivel);
        }

        //Numero de cuerpos de agua con nivel de riesgo MEDIO o inferior
        double cont = 0;
        for (int i = 0; i < num; i++) {
            if (datos[i].getIrca() <= 35) {
                cont++;
            }

        }
        System.out.println(String.format("%.2f", cont));

        //Nombre de cuerpos de agua con nivel de riesgo MEDIO
        double contm = 0;
        for (int i = 0; i < num; i++) {
            if (datos[i].getIrca() > 14 && datos[i].getIrca() <= 35) {
                System.out.print(datos[i].getNombre() + " ");
                contm++;
            }
        }
        if (contm == 0) {
            System.out.print("NA");
        }

        //Nombre del cuerpo con irca mas bajo e id
        double min = 101;
        String nombre_bajo = "";
        for (int i = 0; i < num; i++) {
            if (datos[i].getIrca() < min) {
                min = datos[i].getIrca();
                nombre_bajo = datos[i].getNombre() + " " + String.format("%.2f", datos[i].getId());
            }
        }
        System.out.println("\n" + nombre_bajo);

    }

}
