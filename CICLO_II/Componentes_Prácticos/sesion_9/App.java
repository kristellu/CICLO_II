import java.util.Scanner;


public class App {
    public static void main(String[] args) throws Exception {
        Producto[] productosC = new Producto[100];
        Producto[] productosP = new Producto[100];
        Scanner leer = new Scanner(System.in);

        System.out.println("Digite la cantidad de productos de calzado");
        int nc = Integer.parseInt(leer.nextLine());

        System.out.println("Digite la cantidad de productos de prendas");
        int np = Integer.parseInt(leer.nextLine());

        for(int i = 0; i < nc; i++){
            System.out.println("Digite el codigo del producto de calzado: ");
            int cod = Integer.parseInt(leer.nextLine());
            System.out.println("Digite el precio de compra del producto: ");
            int valor = Integer.parseInt(leer.nextLine());
            System.out.println("Digite el precio de venta del producto: ");
            int vVenta = Integer.parseInt(leer.nextLine());
            System.out.println("Digite la cantidad en bodega del producto: ");
            int cantB = Integer.parseInt(leer.nextLine());
            System.out.println("Digite la cantidad minima requerida en bodega: ");
            int cMin = Integer.parseInt(leer.nextLine());
            System.out.println("Digite la cantidad maxima permitida en bodega: ");
            int cMPer = Integer.parseInt(leer.nextLine());
            System.out.println("Digite la descripcion del prodcuto: ");
            String desc = leer.nextLine();

            productosC[i] = new Producto(cod, desc, valor, vVenta, cantB, cMin, cMPer);
        }

        for(int i = 0; i < np; i++){
            System.out.println("Digite el codigo del producto de prendas: ");
            int cod = Integer.parseInt(leer.nextLine());
            System.out.println("Digite el precio de compra del producto: ");
            int valor = Integer.parseInt(leer.nextLine());
            System.out.println("Digite el precio de venta del producto: ");
            int vVenta = Integer.parseInt(leer.nextLine());
            System.out.println("Digite la cantidad en bodega del producto: ");
            int cantB = Integer.parseInt(leer.nextLine());
            System.out.println("Digite la cantidad minima requerida en bodega: ");
            int cMin = Integer.parseInt(leer.nextLine());
            System.out.println("Digite la cantidad maxima permitida en bodega: ");
            int cMPer = Integer.parseInt(leer.nextLine());
            System.out.println("Digite la descripcion del prodcuto: ");
            String desc = leer.nextLine();

            productosP[i] = new Producto(cod, desc, valor, vVenta, cantB, cMin, cMPer);
        }

        /*
        1) Verificar productos a pedir: recorrer los vectores de productos y arrojar una alerta en caso 
        tal se deba solicitar el pedido al proveedor.
        2) Calzado con mayor cantidad de unidades: indicar cuál es el código del producto que tiene mayor 
        cantidad de unidades en bodega, si hay varios que cumplen con la condición, 
        indicar el primero de ellos.
        3) Prenda con mayor cantidad de unidades: indicar cuál es el código del producto que tiene mayor 
        cantidad de unidades en bodega, si hay varios que cumplen con la condición, indicar el primero de ellos.
        4) Modificar cantidad mínima requerida en bodega: leer código de producto, el tipo (calzado o prenda) 
        y el nuevo valor para la cantidad de unidades mínimas requeridas, validar en el método set de la 
        variable correspondiente que la nueva cantidad no sea menor a 0, en caso de serlo establecer la 
        cantidad mínima como 0.
        5) Vender producto: solicite el código de un producto a vender, el tipo (calzado o prenda), 
        y las unidades correspondientes, calcule el valor de la factura con descuento y sin descuento. 
        Validar que existan las unidades necesarias para la venta y modificar las unidades existentes 
        después de la venta utilizando el método set de la variable correspondiente.

*/

        System.out.println("Menú de opciones");
        System.out.println("Opcion 1: Verificar productos a pedir de calzado y prendas");
        System.out.println("Opcion 2: Calzado con mayor cantidad de unidades");
        System.out.println("Opcion 3: Prenda con mayor cantidad de unidades");
        System.out.println("Opcion 4: Modificar cantidad mínima requerida en bodega");
        System.out.println("Opcion 5: Vender producto");
        System.out.println("Digite la opción deseada: ");
        int op = Integer.parseInt(leer.nextLine());

        switch(op){
            case 1:
                for(int i = 0; i < nc; i++){            
                    if(productosC[i].solicitar()){
                        System.out.println("Alerta Generada para el código de calzado " + productosC[i].getCodigo());
                    }else{
                        System.out.println("No se solicitara producto de calzado de código " + productosC[i].getCodigo());
                    }
                }  

                for(int i = 0; i < np; i++){            
                    if(productosP[i].solicitar()){
                        System.out.println("Alerta Generada para el código de prenda " + productosP[i].getCodigo());
                    }else{
                        System.out.println("No se solicitara producto de prenda de código " + productosP[i].getCodigo());
                    }
                }  
            break;

            case 2:
                int may = -1;
                Producto pMen = productosC[0];
                for(int i = 0; i < nc; i++){            
                    if(productosC[i].getcBodega() > may){
                        may = productosC[i].getcBodega();
                        pMen = productosC[i];
                    }
                }  
                System.out.println("El codigo del producto de calzado con el mayor numero de unidades en bodega es " + pMen.getCodigo());
            break;

            case 3:
                int mayP = -1;
                Producto pMenP = productosP[0];
                for(int i = 0; i < np; i++){            
                    if(productosP[i].getcBodega() > mayP){
                        mayP = productosP[i].getcBodega();
                        pMenP = productosP[i];
                    }
                }  
                System.out.println("El codigo del producto de prenda con el mayor numero de unidades en bodega es " + pMenP.getCodigo());
            break;

            case 4:
                System.out.println("Digite el codigo del producto: ");
                int cp = Integer.parseInt(leer.nextLine());
                System.out.println("Digite el tipo de producto (P: prenda, C: calzado): ");
                String t = leer.nextLine();
                System.out.println("Digite la nueva cantidad minima requerida en bodega para el producto: ");
                int cmn = Integer.parseInt(leer.nextLine());
                if(t.equalsIgnoreCase("p")){
                    for(int i = 0; i < np; i++){            
                        if(productosP[i].getCodigo() == cp){
                            productosP[i].setcMinRequerida(cmn);
                        }
                    } 
                }else{
                    for(int i = 0; i < nc; i++){            
                        if(productosC[i].getCodigo() == cp){
                            productosC[i].setcMinRequerida(cmn);
                        }
                    } 
                }
                 
            break;

            case 5:
                System.out.println("Digite el codigo del producto: ");
                cp = Integer.parseInt(leer.nextLine());
                System.out.println("Digite el tipo de producto (P: prenda, C: calzado): ");
                t = leer.nextLine();
                System.out.println("Digite las unidades a vender: ");
                int cv = Integer.parseInt(leer.nextLine());
                if(t.equalsIgnoreCase("p")){
                    for(int i = 0; i < np; i++){            
                        if(cp == productosP[i].getCodigo() && cv <= productosP[i].getcBodega()){
                            double tvSD = cv * productosP[i].getpVenta();
                            double tvCD = cv * (productosP[i].getpVenta() * Producto.pDescuento);

                            System.out.println("Valor de factura con descuento: " + tvCD);
                            System.out.println("Valor de factura sin descuento: " + tvSD);
                            productosP[i].setcBodega(productosP[i].getcBodega() - cv );
                        }
                    } 
                }else{
                    for(int i = 0; i < nc; i++){            
                        if(cp == productosC[i].getCodigo() && cv <= productosC[i].getcBodega()){
                            double tvSD = cv * productosC[i].getpVenta();
                            double tvCD = cv * (productosC[i].getpVenta() * Producto.pDescuento);

                            System.out.println("Valor de factura con descuento: " + tvCD);
                            System.out.println("Valor de factura sin descuento: " + tvSD);
                            productosC[i].setcBodega(productosC[i].getcBodega() - cv );
                        }
                    } 
                }
            break;
        }    
    }
}
