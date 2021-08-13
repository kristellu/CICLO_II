public class Calzado extends Producto{
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

    public void mostrar(){
        System.out.println(getCodigo() + " - " + getDesc() + " - " + getpCompra() + " - " + getpVenta() + 
        " - " + getcBodega() + " - " + getcMinRequerida() + " - " + getcMaxPermitida() + " - " + talla);
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


}
