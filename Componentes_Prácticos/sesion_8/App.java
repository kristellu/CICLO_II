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
            System.out.println("Digite el precio de venta del producto: ");
            int vVenta = leer.nextInt();
            System.out.println("Digite la cantidad en bodega del producto: ");
            int cantB = leer.nextInt();
            System.out.println("Digite la cantidad minima requerida en bodega: ");
            int cMin = leer.nextInt();
            System.out.println("Digite la cantidad maxima permitida en bodega: ");
            int cMPer = leer.nextInt();

            productos[i] = new Producto(cod, valor, vVenta, cantB, cMin, cMPer);
        }

        

        /*
        Verificar productos a pedir: recorrer el vector de productos y arrojar una alerta en caso tal se deba solicitar el pedido al proveedor.
Producto con mayor cantidad de unidades: indicar cuál es el código del producto que tiene mayor cantidad de unidades en bodega, si hay varios que cumplen con la condición, indicar el primero de ellos.
Total a pagar por pedido a realizar: leer un código de producto y una cantidad de unidades de compra, indicar el total a pagar por ese pedido. Para ello utilice el método creado en la clase Producto pasando por parámetro la cantidad de unidades de compra.
Modificar cantidad mínima requerida en bodega: leer código de producto y el nuevo valor para la cantidad de unidades mínimas requeridas, validar en el método set de la variable correspondiente que la nueva cantidad no sea menor a 0, en caso de serlo establecer la cantidad mínima como 0.
Vender producto: solicite el código de un producto a vender y las unidades correspondientes, calcule el valor de la factura con descuento y sin descuento. Validar que existan las unidades necesarias para la venta y modificar las unidades existentes despues de la venta utilizando el metodo set de la variable correspondiente.
        */

        System.out.println("Menú de opciones");
        System.out.println("Opcion 1: Verificar productos a pedir");
        System.out.println("Opcion 2: Producto con mayor cantidad de unidades");
        System.out.println("Opcion 3: Total a pagar por pedido a realizar");
        System.out.println("Opcion 4: Modificar cantidad mínima requerida en bodega");
        System.out.println("Opcion 5: Vender producto");
        System.out.println("Digite la opción deseada: ");
        int op = leer.nextInt();

        switch(op){
            case 1:
                for(int i = 0; i < n; i++){            
                    if(productos[i].solicitar()){
                        System.out.println("Alerta Generada para el código " + productos[i].getCodigo());
                    }else{
                        System.out.println("No se solicitara producto de código " + productos[i].getCodigo());
                    }
                }  
            break;

            case 2:
                int may = -1;
                Producto pMen = productos[0];
                for(int i = 0; i < n; i++){            
                    if(productos[i].getcBodega() > may){
                        may = productos[i].getcBodega();
                        pMen = productos[i];
                    }
                }  
                System.out.println("El codigo del producto con el mayor numero de unidades en bodega es " + pMen.getCodigo());
            break;

            case 3:
                System.out.println("Digite el codigo del producto a pedir: ");
                int cp = leer.nextInt();
                System.out.println("Digite las unidades de compra del producto a pedir: ");
                int uc = leer.nextInt();
                for(int i = 0; i < n; i++){            
                    if(productos[i].getCodigo() == cp){
                        System.out.println("El total a pagar es: " + productos[i].totalAPagar(uc));
                    }
                }  
            break;

            case 4:
                System.out.println("Digite el codigo del producto: ");
                cp = leer.nextInt();
                System.out.println("Digite la nueva cantidad minima requerida en bodega para el producto: ");
                int cmn = leer.nextInt();
                for(int i = 0; i < n; i++){            
                    if(productos[i].getCodigo() == cp){
                        productos[i].setcMinRequerida(cmn);
                    }
                }  
            break;

            case 5:
                System.out.println("Digite el codigo del producto a vender: ");
                cp = leer.nextInt();
                System.out.println("Digite la cantidad a vender: ");
                int cv = leer.nextInt();
                for(int i = 0; i < n; i++){            
                    if(productos[i].getCodigo() == cp){
                        if(cv <= productos[i].getcBodega()){
                            double tvSD = cv * productos[i].getpVenta();
                            double tvCD = cv * (productos[i].getpVenta() * Producto.pDescuento);

                            System.out.println("Valor de factura con descuento: " + tvCD);
                            System.out.println("Valor de factura sin descuento: " + tvSD);
                            productos[i].setcBodega(productos[i].getcBodega() - cv );
                        }
                    }
                }  
            break;

        }

        

        
    
    }
}
