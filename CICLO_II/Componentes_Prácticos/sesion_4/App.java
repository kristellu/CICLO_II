import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        Scanner leer = new Scanner(System.in);
        System.out.println("Digite el codigo del producto: ");
        int cod = leer.nextInt();
        System.out.println("Digite el precio de compra del producto: ");
        int valor = leer.nextInt();
        System.out.println("Digite la cantidad en bodega del producto: ");
        int cantB = leer.nextInt();
        System.out.println("Digite la cantidad minima requerida en bodega: ");
        int cMin = leer.nextInt();
        
        Producto p = new Producto(cod, valor, cantB, cMin);

        if(p.solicitar()){
            System.out.println("Alerta Generada");
        }else{
            System.out.println("No se solicitara producto");
        }
        
        
    }
}
