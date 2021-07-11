public class Calzado extends Producto implements Vista{
    private int talla;

    public Calzado(int codigo, String des, int pCompra, int pVenta, 
    int cBodega, int cMinRequerida, int cMaxPermitida, int talla) {
        super(codigo, des, pCompra, pVenta, cBodega, cMinRequerida, cMaxPermitida);
        this.talla = talla;
    }

    public int getTalla() {
        return talla;
    }

    public void setTalla(int talla) {
        this.talla = talla;
    }

    //solicitar pedido
    public boolean solicitar(){
        if(getcBodega()  < getcMinRequerida()){
            return true;
        }else{
            return false;
        }
    }

    //total a pagar
    public int totalAPagar(int unidades){
        return unidades * getpCompra();
    }

    @Override
    public void mostrarTodo() {
        // TODO Auto-generated method stub
        System.out.println(getCodigo() + " - " + getDesc() + " - " + getpCompra() + " - " + getpVenta() + 
        " - " + getcBodega() + " - " + getcMinRequerida() + " - " + getcMaxPermitida() + " - " + talla);
    }

    @Override
    public void mostrarLite1() {
        // TODO Auto-generated method stub
        System.out.println(getCodigo() + " - " + getDesc()); 
    }

    @Override
    public void mostrarLite2() {
        // TODO Auto-generated method stub
        System.out.println(getCodigo() + " - " + getDesc() + " - " + getpCompra() + " - " + getpVenta());  
    }

}
