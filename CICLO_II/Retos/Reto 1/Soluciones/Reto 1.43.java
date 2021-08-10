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
public class Reto43 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int n;
        String datos[][] = new String[100][6];

        Scanner leer = new Scanner(System.in);

        System.out.println("Digite el número de pacientes: ");
        n = leer.nextInt();

        double edad = 0;

        for (int i = 0; i < n; i++) {
            System.out.println("Digite el nombre del paciente " + (i + 1));
            datos[i][0] = leer.next();
            System.out.println("Digite la cedula del paciente " + (i + 1));
            datos[i][1] = leer.next();
            System.out.println("Digite la edad del paciente ");
            datos[i][2] = leer.next();
            System.out.println("Digite el ciudad del paciente " + (i + 1));
            datos[i][3] = leer.next();
            System.out.println("Digite la eps del paciente " + (i + 1));
            datos[i][4] = leer.next();
            System.out.println("Digite la enfermedad del paciente ");
            datos[i][5] = leer.next();

            edad = edad + Double.parseDouble(datos[i][2]);

        }

        double ep = (edad / n);
        System.out.println("La edad promedio es: " + ep);

        for (int i = 0; i < n; i++) {
            if (Double.parseDouble(datos[i][2]) > ep) {
                System.out.println(datos[i][0] + " " + datos[i][1]);
            }

        }

    }

}
