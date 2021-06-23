import java.util.Scanner;

public class Ejemplo6 {
    //Estructura Ciclica
    public static void main(String[] args) {
        
        Scanner leer = new Scanner(System.in);
        
        System.out.println("Ingrese la cantidad de tipos de productos comprados: ");
        int cantidadTipoProductos = leer.nextInt();
        
        int cantidadProducto;
        int valorProducto;
        int totalFactura = 0;
        for (int i = 1; i <= cantidadTipoProductos; i++) {
            System.out.println("Ingrese la cantidad del producto " + i + ": ");
            cantidadProducto = leer.nextInt();
            
            System.out.println("Ingrese el valor del producto " + i + ": ");
            valorProducto = leer.nextInt();

            totalFactura = totalFactura + (cantidadProducto * valorProducto);
        }
        
        System.out.println("Total factura: " + totalFactura);
        
    }
}
