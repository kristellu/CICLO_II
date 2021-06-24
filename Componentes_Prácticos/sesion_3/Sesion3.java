import java.util.Scanner;

public class ListasTablas{
    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);

        System.out.println("Introduzca el numero de productos");
        int productos = leer.nextInt();

        System.out.println("Introduzca el numero de sedes");
        int sedes = leer.nextInt();

        int[] listaCodigo = new int[productos];
        int[][] tablaCantidadBodega = new int[productos][sedes];
        int[][] tablaCantidadMinima = new int[productos][sedes];
        String resultado = "";
        
        for (int i = 0; i < productos; i++) {
            System.out.println("Introduzca el codigo del producto " + i);
            listaCodigo[i] = leer.nextInt();

            for (int j = 0; j < sedes; j++) {
                System.out.println("Introduzca la cantidad en bodega de producto " + i + " sede " + j);
                tablaCantidadBodega[i][j] = leer.nextInt();

                System.out.println("Introduzca la cantidad minima requerida de producto " + i + " sede " + j);
                tablaCantidadMinima[i][j] = leer.nextInt();
            }
        }
        
        leer.close();

        for (int i = 0; i < productos; i++) {
            for (int j = 0; j < sedes; j++) {
                if (tablaCantidadBodega[i][j] < tablaCantidadMinima[i][j]) {
                    resultado += "Se debe solicitar producto "+ listaCodigo[i] + " en sede "+j +"\n";
                }
            }
        }

        System.out.println(resultado);
    }
}
