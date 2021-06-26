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
public class Reto45 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        int n;
        String datos[][] = new String[100][6];
        int enf[] = new int[6];
        String eps[] = new String[100];
        int enfRep[] = new int[100];
        Scanner leer = new Scanner(System.in);

        System.out.println("Digite el número de pacientes: ");
        int nEPS = leer.nextInt();
        
        for (int i = 0; i < nEPS; i++) {
            eps[i] = leer.next();
        }
        
        System.out.println("Digite el número de pacientes: ");
        n = leer.nextInt();

        for (int i = 0; i < 6; i++) {
            enf[i] = 0;
        }

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

            if (datos[i][5].equalsIgnoreCase("cancer")) {
                enf[0]++;
            }
            if (datos[i][5].equalsIgnoreCase("cardiovasculares")) {
                enf[1]++;
            }
            if (datos[i][5].equalsIgnoreCase("respiratorias")) {
                enf[2]++;
            }
            if (datos[i][5].equalsIgnoreCase("cerebrovasculares")) {
                enf[3]++;
            }
            if (datos[i][5].equalsIgnoreCase("hipertension")) {
                enf[4]++;
            }
            if (datos[i][5].equalsIgnoreCase("diabetes")) {
                enf[5]++;
            }
        }

        int may = -1, iMay = -1;
        int men = 10000, iMen = -1;
        for (int i = 0; i < 6; i++) {
            if (enf[i] > may ) {
                may = enf[i];
                iMay = i;
            }
            
            if (enf[i] < men) {
                men = enf[i];
                iMen = i;
            }
        }

        switch (iMay) {
            case 0:
                System.out.println("cancer");
                break;
            case 1:
                System.out.println("cardiovasculares");
                break;
            case 2:
                System.out.println("respiratorias");
                break;
            case 3:
                System.out.println("cerebrovasculares");
                break;
            case 4:
                System.out.println("hipertension");
                break;
            case 5:
                System.out.println("diabetes");
        }
        
        switch (iMen) {
            case 0:
                System.out.println("cancer");
                break;
            case 1:
                System.out.println("cardiovasculares");
                break;
            case 2:
                System.out.println("respiratorias");
                break;
            case 3:
                System.out.println("cerebrovasculares");
                break;
            case 4:
                System.out.println("hipertension");
                break;
            case 5:
                System.out.println("diabetes");
        }

    }

}
