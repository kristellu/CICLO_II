import java.util.Scanner;

public class Sesion3{
    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);

        String[] listaCodigo;
        int[][] tablaCantidadBodega = new int[100][100];
        int[][] tablaCantidadMinima = new int[100][100];
        
        System.out.println("Digite los codigos de productos separados por espacio: ");
        String linea = leer.nextLine();
        listaCodigo = linea.split(" ");
        int productos = listaCodigo.length;
        System.out.println(productos);
        
        System.out.println("Digite la tabla de las cantidades en bodega separando las filas por punto y coma y las cantidades por espacio: ");
        linea = leer.nextLine();
        String[] filas = linea.split(";");
        int sedes = filas.length;
        for(int i = 0; i < sedes; i++){
            String[] cantidades = filas[i].split(" ");
            for (int j = 0; j < productos; j++) {
                String num = cantidades[j];
                tablaCantidadBodega[i][j] = Integer.parseInt(num);
            }
        }
        
        System.out.println("Digite la tabla de las cantidades minimas requeridas separando las filas por punto y coma y las cantidades por espacio: ");
        linea = leer.nextLine();
        filas = linea.split(";");
        for(int i = 0; i < sedes; i++){
            String[] cantidades = filas[i].split(" ");
            for (int j = 0; j < productos; j++) {
                String num = cantidades[j];
                tablaCantidadMinima[i][j] = Integer.parseInt(num);
            }
        }
       
        for (int i = 0; i < sedes; i++) {
            for (int j = 0; j < productos; j++) {
                if (tablaCantidadBodega[i][j] < tablaCantidadMinima[i][j]) {
                    System.out.println("Se debe solicitar producto "+ listaCodigo[j] + " en sede "+ i);
                }
            }
        }
        
        double prom;
        for (int i = 0; i < productos; i++) {
            prom = 0;
            for (int j = 0; j < sedes; j++) {
                prom += tablaCantidadBodega[i][j];
            }
            prom = prom / sedes;
            System.out.println("El promedio de productos del codigo " + listaCodigo[i] + " es " + prom);
        }
    }
}
