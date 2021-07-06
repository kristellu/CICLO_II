import java.util.Scanner;


public class App {
    public static void main(String[] args) throws Exception {
        Producto[] productos = new Producto[100];
        Scanner leer = new Scanner(System.in);

        System.out.println("Digite la cantidad de productos");
        int n = leer.nextInt();

        for(int i = 0; i < n; i++){
            System.out.println("Digite el codigo del producto: ");
            int cod = leer.nextInt();
            System.out.println("Digite el precio de compra del producto: ");
            int valor = leer.nextInt();
            System.out.println("Digite la cantidad en bodega del producto: ");
            int cantB = leer.nextInt();
            System.out.println("Digite la cantidad minima requerida en bodega: ");
            int cMin = leer.nextInt();
            
            productos[i] = new Producto(cod, valor, cantB, cMin);
        }

        int men = 1000000000;
        Producto pMen = productos[0];
        for(int i = 0; i < n; i++){            
            if(productos[i].solicitar()){
                System.out.println("Alerta Generada para el código " + productos[i].getCodigo());
            }else{
                System.out.println("No se solicitara producto de codigo " + productos[i].getCodigo());
            }
            if(productos[i].getcBodega() < men){
                men = productos[i].getcBodega();
                pMen = productos[i];
            }
        }  
        
        System.out.println("El codigo del producto con el menor numero de unidades en bodega es " + pMen.getCodigo());
    }
}
