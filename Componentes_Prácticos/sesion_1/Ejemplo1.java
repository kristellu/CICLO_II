import java.util.Scanner;

public class Ejemplo1 {
    public static void main(String[] args) {
        //Uso de condicionales simples
        
        Scanner leer = new Scanner(System.in);
        
        System.out.println("Ingrese la cantidad minima requerida: ");
        int cantidadMinima = leer.nextInt();
        
        System.out.println("Ingrese la cantidad actual en bodega: ");
        int cantidadBodega = leer.nextInt();

        if (cantidadBodega < cantidadMinima) {
            System.out.println("Realizar pedido a proveedor");
        } 

	if (cantidadBodega >= cantidadMinima) {
            System.out.println("NO es necesario realizar pedido a proveedor");
        }
    }
}
