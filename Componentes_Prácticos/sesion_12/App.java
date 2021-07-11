import java.util.Scanner;


public class App {
    public static void main(String[] args) throws Exception {
        Calzado[] productosC = new Calzado[100];
        Prenda[] productosP = new Prenda[100];
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
            System.out.println("Digite la descripcion del producto: ");
            String desc = leer.nextLine();
            System.out.println("Digite la cantidad la talla del producto: ");
            int talla = Integer.parseInt(leer.nextLine());

            productosC[i] = new Calzado(cod, desc, valor, vVenta, cantB, cMin, cMPer, talla);
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
            System.out.println("Digite la talla del prodcuto: ");
            String talla = leer.nextLine();
            System.out.println("Digite 1 si se puede planchar el producto, 0 en caso contrario: ");
            String pla = leer.nextLine();

            if(pla.equalsIgnoreCase("1")){
                productosP[i] = new Prenda(cod, desc, valor, vVenta, cantB, cMin, cMPer, talla, true);
            }else{
                productosP[i] = new Prenda(cod, desc, valor, vVenta, cantB, cMin, cMPer, talla, false);
            }
        }

        System.out.println("Menú de opciones");
        System.out.println("Opcion 1: Consultar producto");
        System.out.println("Opcion 2: Verificar productos a pedir de calzado y prendas");
        System.out.println("Opcion 3: Calzado con mayor cantidad de unidades");
        System.out.println("Opcion 4: Prenda con mayor cantidad de unidades");
        System.out.println("Opcion 5: Modificar cantidad mínima requerida en bodega");
        System.out.println("Opcion 6: Vender producto");
        System.out.println("Digite la opción deseada: ");
        int op = Integer.parseInt(leer.nextLine());

        switch(op){
            case 1:
            System.out.println("Digite el codigo del producto: ");
                int cp = Integer.parseInt(leer.nextLine());
                System.out.println("Digite el tipo de producto (P: prenda, C: calzado): ");
                String t = leer.nextLine();
                System.out.println("Digite las unidades a vender: ");
                int cv = Integer.parseInt(leer.nextLine());
                if(t.equalsIgnoreCase("p")){
                    for(int i = 0; i < np; i++){            
                        if(cp == productosP[i].getCodigo()){
                            productosP[i].mostrarTodo();
                        }
                    } 
                }else{
                    for(int i = 0; i < nc; i++){            
                        if(cp == productosC[i].getCodigo()){
                            productosC[i].mostrarTodo();
                        }
                    } 
                }
                break;
            case 2:
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

            case 3:
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

            case 4:
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

            case 5:
                System.out.println("Digite el codigo del producto: ");
                cp = Integer.parseInt(leer.nextLine());
                System.out.println("Digite el tipo de producto (P: prenda, C: calzado): ");
                t = leer.nextLine();
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

            case 6:
                System.out.println("Digite el codigo del producto: ");
                cp = Integer.parseInt(leer.nextLine());
                System.out.println("Digite el tipo de producto (P: prenda, C: calzado): ");
                t = leer.nextLine();
                System.out.println("Digite las unidades a vender: ");
                cv = Integer.parseInt(leer.nextLine());
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
