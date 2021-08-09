public class Prenda extends Producto implements Vista{
    private String talla;
    private boolean plancha;

    public Prenda(int codigo, String des, int pCompra, int pVenta, 
    int cBodega, int cMinRequerida, int cMaxPermitida, String talla, boolean plancha) {
        super(codigo, des, pCompra, pVenta, cBodega, cMinRequerida, cMaxPermitida);
        this.talla = talla;
        this.plancha = plancha;
    }

    public String getTalla() {
        return talla;
    }
    public boolean getPlancha() {
        return plancha;
    }
    public void setTalla(String talla) {
        this.talla = talla;
    }
    public void setPlancha(boolean plancha) {
        this.plancha = plancha;
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
        System.out.println(getCodigo() + " - " + getDesc() + " - " + getpCompra() + " - " + getpVenta() + 
        " - " + getcBodega() + " - " + getcMinRequerida() + " - " + getcMaxPermitida() + " - " + talla + 
        " - " + plancha);
        
    }

    @Override
    public void mostrarLite1() {
        System.out.println(getCodigo() + " - " + getDesc()); 
        
    }

    @Override
    public void mostrarLite2() {
        System.out.println(getCodigo() + " - " + getDesc() + " - " + getpCompra() + " - " + getpVenta()); 
        
    }

}