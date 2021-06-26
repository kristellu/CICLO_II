import java.util.Scanner;

public class Ejemplo7 {

    //Estructura Ciclica
    public static void main(String[] args) {
        boolean clientesXAtender = true;
        int cantidadClientes = 1;
        int totalVendido = 0;

        while (clientesXAtender) {
            System.out.println("Cliente " + cantidadClientes);

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

            System.out.println("¿Hay clientes por atender? (si o no) ");
            String nuevoCliente = leer.next();
            
            if (nuevoCliente.equals("no")) {
                clientesXAtender = false;
            }
            cantidadClientes++;
            totalVendido = totalVendido + totalFactura;
        }

        System.out.println("Total vendido: " + totalVendido);

    }
}
