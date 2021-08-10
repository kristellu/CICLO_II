import java.util.Scanner;

public class Ejemplo5 {
    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);
        
        System.out.println("Ingrese dia de la semana: ");
        int diaSemana = leer.nextInt();
        
        System.out.println("Ingrese el total a pagar sin descuento: ");
        int totalSinDescuento = leer.nextInt();

        double descuento = 0;
        switch (diaSemana) {
            case 1:
                descuento = 0.05;
                break;
            case 2:
                descuento = 0.03;
                break;
            case 3:
                descuento = 0.1;
                break;
            case 4:
                descuento = 0.04;
                break;
            case 5:
                descuento = 0.06;
                break;
            case 6:
                descuento = 0.02;
                break;
            case 7:
                descuento = 0.01;
                break;
        }
        
        double total = totalSinDescuento - totalSinDescuento * descuento;
        System.out.println("Total a pagar: " + total);
        
    }
}
