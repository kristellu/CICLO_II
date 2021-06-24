import java.util.Scanner;

public class Sesion2{
    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);

        System.out.println("Introduzca el numero de productos: ");
        int productos = leer.nextInt();

        int[] listaCodigo = new int[productos];
        int[] listaCantidadBodega = new int[productos];
        int[] listaCantidadMinima = new int[productos];
        
        
        for (int i = 0; i < productos; i++) {
            System.out.println("Introduzca el codigo del producto " + i);
            listaCodigo[i] = leer.nextInt();

            System.out.println("Introduzca la cantidad en bodega " + i);
            listaCantidadBodega[i] = leer.nextInt();

            System.out.println("Introduzca la cantidad minima requerida " + i);
            listaCantidadMinima[i] = leer.nextInt();
        }
        
        System.out.println("Codigos de productos que son necesarios pedir: ");
        int may=-1, cMay=0, men=100000, cMen=0;

        for (int i = 0; i < productos; i++) {
            if (listaCantidadBodega[i] < listaCantidadMinima[i]) {
                System.out.println(listaCodigo[i]);
            }
            
            if(listaCantidadBodega[i] < men){
                men = listaCantidadBodega[i];
                cMen = listaCodigo[i];
            }
            
            if(listaCantidadBodega[i] > may){
                may = listaCantidadBodega[i];
                cMay = listaCodigo[i];
            }
        }
        
        System.out.println("Codigo con mayor numero de unidades en bodega: " + cMay);
        System.out.println("Codigo con menor numero de unidades en bodega: " + cMen);
    }
}
