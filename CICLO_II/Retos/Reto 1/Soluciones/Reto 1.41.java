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
public class Reto41 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Scanner leer = new Scanner(System.in);
        String datos[][] = new String[100][8];
        String diag[] = new String[100];
        String cla[] = new String[100];
        System.out.println("Numero de pacientes: ");

        int n = leer.nextInt();
        int pacSD = 0;

        for (int i = 0; i < n; i++) {
            int swD = 0;
            System.out.println("Nombre: ");
            datos[i][0] = leer.next();
            System.out.println("Cedula: ");
            datos[i][1] = leer.next();

            for (int j = 2; j < 7; j++) {
                System.out.println("Sintoma " + (j - 1));
                datos[i][j] = leer.next();
            }

             //Staphylococcus aureus
            if (datos[i][2].equalsIgnoreCase("si") && datos[i][3].equalsIgnoreCase("si") && datos[i][4].equalsIgnoreCase("si")
                    && datos[i][5].equalsIgnoreCase("si") && datos[i][6].equalsIgnoreCase("si")) {               
                    diag[i] = "Staphylococcus aureus";
                    cla[i] = "Bacteriano";
                    swD = 1;

            }
            
           //Bacillus cereus
            if (datos[i][2].equalsIgnoreCase("si") && datos[i][3].equalsIgnoreCase("si")) {
                if (datos[i][4].equalsIgnoreCase("no") && datos[i][5].equalsIgnoreCase("no") && datos[i][6].equalsIgnoreCase("no")){
                    diag[i] = "Bacillus cereus";
                    cla[i] = "Bacteriano";
                    swD = 1;

                }

            }
            //Taenia saginata
            if (datos[i][4].equalsIgnoreCase("si") && datos[i][5].equalsIgnoreCase("si")) {
                if (datos[i][2].equalsIgnoreCase("no") && datos[i][3].equalsIgnoreCase("no") && datos[i][6].equalsIgnoreCase("no")) {
                    diag[i] = "Taenia saginata";
                    cla[i] = "Parasitaria";
                    swD = 1;

                }

            }

            //Norovirus 2 3 6 9
            if (datos[i][2].equalsIgnoreCase("si") && datos[i][3].equalsIgnoreCase("si") && datos[i][5].equalsIgnoreCase("si") && datos[i][6].equalsIgnoreCase("si")) {
                if (datos[i][4].equalsIgnoreCase("no")) {
                    diag[i] = "Norovirus";
                    cla[i] = "Viral";
                    swD = 1;

                }

            }

            //Rotavirus 3 9 6
            if (datos[i][3].equalsIgnoreCase("si") && datos[i][6].equalsIgnoreCase("si")) {
                if (datos[i][2].equalsIgnoreCase("no") && datos[i][4].equalsIgnoreCase("no") && datos[i][5].equalsIgnoreCase("no")) {
                    diag[i] = "Rotavirus";
                    cla[i] = "Viral";
                    swD = 1;

                }

            }


            if (swD == 0) {
                pacSD++;
            }

        }

        int repSint[] = new int[5];
        for (int i = 0; i < 5; i++) {
            repSint[i] = 0;
        }

        System.out.println("Diagnosticos: ");

        for (int i = 0; i < n; i++) {
            System.out.println(datos[i][1] + " " + diag[i]);

            for (int j = 2; j < 7; j++) {
                if (datos[i][j].equalsIgnoreCase("si")) {
                    repSint[j - 2] += 1;
                }
            }
        }

        int may = -1, numM = -1, men = 1000000000, numMe = -1;
        for (int i = 0; i < 5; i++) {
            if (repSint[i] > may) {
                may = repSint[i];
                numM = i;
            }
            if (repSint[i] < men) {
                men = repSint[i];
                numMe = i;
            }
        }

        System.out.println("Sintoma más presentado: ");
        switch (numM) {
            case 0:
                System.out.println("Nauseas");
                break;
            case 1:
                System.out.println("Vomitos");
                break;
            case 2:
                System.out.println("dolor abdominal");
                break;
            case 3:
                System.out.println("diarrea");
                break;
            case 4:
                System.out.println("fiebre");
                break;
        }

        System.out.println("Sintoma menos presentado: ");
        switch (numMe) {
           case 0:
                System.out.println("Nauseas");
                break;
            case 1:
                System.out.println("Vomitos");
                break;
            case 2:
                System.out.println("dolor abdominal");
                break;
            case 3:
                System.out.println("diarrea");
                break;
            case 4:
                System.out.println("fiebre");
                break;
        }

        System.out.println("Diagnosticos con exito: " + (n - pacSD));

    }

}
