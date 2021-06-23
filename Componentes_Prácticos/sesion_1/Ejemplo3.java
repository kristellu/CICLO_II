import java.util.Scanner;

public class Ejemplo3 {
    //Uso de condicionales multiples
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        
        System.out.println("Ingrese la cantidad minima requerida: ");
        int cantidadMinima = leer.nextInt();
        
        System.out.println("Ingrese la cantidad actual en bodega: ");
        int cantidadBodega = leer.nextInt();
        
        if (cantidadBodega < cantidadMinima) {
            System.out.println("Realizar pedido a proveedor");
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
