import java.util.Scanner;

public class Listas{
    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);

        System.out.println("Introduzca el numero de productos");
        int productos = leer.nextInt();

        int[] listaCodigo = new int[productos];
        int[] listaCantidadBodega = new int[productos];
        int[] listaCantidadMinima = new int[productos];
        String resultado = "Codigos de productos que son necesarios pedir: ";
        
        for (int i = 0; i < productos; i++) {
            System.out.println("Introduzca el codigo del producto " + i);
            listaCodigo[i] = leer.nextInt();

            System.out.println("Introduzca la cantidad en bodega " + i);
            listaCantidadBodega[i] = leer.nextInt();

            System.out.println("Introduzca la cantidad minima requerida " + i);
            listaCantidadMinima[i] = leer.nextInt();
        }
        leer.close();

        for (int i = 0; i < productos; i++) {
            if (listaCantidadBodega[i] < listaCantidadMinima[i]) {
                resultado += listaCodigo[i] + ", ";
            }
        }

        System.out.println(resultado);
    }
}
