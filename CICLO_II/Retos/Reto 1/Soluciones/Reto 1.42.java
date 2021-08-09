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
public class Reto42 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Scanner leer = new Scanner(System.in);
        String datos[][] = new String[100][8];
        int diagBac[] = new int[2];
        int diagViral[] = new int[2];
        String diag[] = new String[100];
        String cla[] = new String[100];

        for (int i = 0; i < 2; i++) {
            diagBac[i] = 0;
        }
        for (int i = 0; i < 2; i++) {
            diagViral[i] = 0;
        }

        System.out.println("Numero de pacientes: ");

        int n = leer.nextInt();

        for (int i = 0; i < n; i++) {
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
                    diagBac[0]++;

            }
            //Bacillus cereus
            if (datos[i][2].equalsIgnoreCase("si") && datos[i][3].equalsIgnoreCase("si")) {
                if (datos[i][4].equalsIgnoreCase("no") && datos[i][5].equalsIgnoreCase("no") && datos[i][6].equalsIgnoreCase("no")){
                    diag[i] = "Bacillus cereus";
                    cla[i] = "Bacteriano";
                    diagBac[1]++;
                }

            }

           
            //Taenia saginata
            if (datos[i][4].equalsIgnoreCase("si") && datos[i][5].equalsIgnoreCase("si")) {
                if (datos[i][2].equalsIgnoreCase("no") && datos[i][3].equalsIgnoreCase("no") && datos[i][6].equalsIgnoreCase("no")) {
                    diag[i] = "Taenia saginata";
                    cla[i] = "Parasitaria";

                }

            }

            //Norovirus 2 3 6 9
            if (datos[i][2].equalsIgnoreCase("si") && datos[i][3].equalsIgnoreCase("si") && datos[i][5].equalsIgnoreCase("si") && datos[i][6].equalsIgnoreCase("si")) {
                if (datos[i][4].equalsIgnoreCase("no")) {
                    diag[i] = "Norovirus";
                    cla[i] = "Viral";
                    diagViral[0]++;

                }

            }

            //Rotavirus 3 9 6
            if (datos[i][3].equalsIgnoreCase("si") && datos[i][6].equalsIgnoreCase("si")) {
                if (datos[i][2].equalsIgnoreCase("no") && datos[i][4].equalsIgnoreCase("no") && datos[i][5].equalsIgnoreCase("no")) {
                    diag[i] = "Rotavirus";
                    cla[i] = "Viral";
                    diagViral[1]++;

                }

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
        
        int may=-1, iMay=0;
        for (int i = 0; i < 7; i++) {
            if(diagBac[i] > may){
                may = diagBac[i];
                iMay = i;
            }
        }
        
        System.out.println("Diagnostico mayor presentado en la clasificacion bacteriana: ");
         switch (iMay) {
            case 0:
                System.out.println("Staphylococcus aureus");
                break;
            case 1:
                System.out.println("Bacillus cereus");
                break;
            case 2:
                System.out.println("Taenia saginata");
                break;
            
        }
         
        for (int i = 0; i < 3; i++) {
            if(diagBac[i] > may){
                may = diagBac[i];
                iMay = i;
            }
        }
        
        System.out.println("Diagnostico mayor presentado en la clasificacion viral: ");
         switch (iMay) {
            case 3:
                System.out.println("Norovirus");
                break;
            case 4:
                System.out.println("Rotavirus");
                break;
        }

        

    }

}
