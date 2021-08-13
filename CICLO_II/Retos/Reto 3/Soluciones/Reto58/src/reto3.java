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

        //Nombre y municipio de cada cuerpo de agua        
        String nombre_municipio;
        for (int i = 0; i < num; i++) {
            nombre_municipio = datos[i].getNombre()+" "+datos[i].getMunicipio();
            System.out.println(nombre_municipio);
        }

        //Numero de cuerpos de agua con nivel de riesgo entre ALTO e INVIABLE SANITARIAMENTE
        double cont = 0;
        for (int i = 0; i < num; i++) {
            if (datos[i].getIrca() > 35 && datos[i].getIrca() <= 100) {
                cont++;
            }

        }
        System.out.println(String.format("%.2f", cont));

        //Nombre de los municipios con cuerpos de agua con nivel de riesgo ALTO
        double contm = 0;
        for (int i = 0; i < num; i++) {
            if (datos[i].getIrca() > 35 && datos[i].getIrca() <= 80) {
                System.out.print(datos[i].getMunicipio()+ " ");
                contm++;
            }
        }
        if (contm == 0) {
            System.out.print("NA");
        }
        
        //nivel de riesgo mas alto
        double max = -1;
        String nivel_alto = "";
        for (int i = 0; i < num; i++) {
            if (datos[i].getIrca() > max) {
                max = datos[i].getIrca();
                nivel_alto = datos[i].nivel();                
            }
        }        
        System.out.println("\n"+nivel_alto);

    }

}