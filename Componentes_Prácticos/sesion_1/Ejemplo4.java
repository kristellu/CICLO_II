import java.util.Scanner;

public class Ejemplo4 {
    //Uso de condicionales multiples
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        
        System.out.println("Ingrese la cantidad minima requerida: ");
        int cantidadMinima = leer.nextInt();
        
        System.out.println("Ingrese la cantidad actual en bodega: ");
        int cantidadBodega = leer.nextInt();

        if (cantidadBodega < cantidadMinima) {
            System.out.println("Realizar pedido a proveedor");
            
            System.out.println("Ingrese la cantidad de unidades de compra deseada: ");
            int unidadesAComprar = leer.nextInt();
            
            System.out.println("Ingrese el valor de compra del producto: ");
            int valorUnitario = leer.nextInt();

            System.out.println("Ingrese el dinero en caja: ");
            int dineroCaja = leer.nextInt();        
            
            int valorCompra = unidadesAComprar * valorUnitario;

            if (valorCompra < dineroCaja) {
                System.out.println("Si es posible realizar el pedido");
            } else {
                System.out.println("No es posible realizar el pedido");
            }

        } else {
            int unidadesRestantes = cantidadBodega - cantidadMinima;
            if (unidadesRestantes < 10) {
                System.out.println("NO es necesario realizar pedido a proveedor. " + 
                "Unidades que hacen falta vender: " + unidadesRestantes + ". "+
                "Alerta Generada");    
            } else {
                System.out.println("NO es necesario realizar pedido a proveedor. " + 
                "Unidades que hacen falta vender: " + unidadesRestantes);    
            }
            
        }
        
    }
}
