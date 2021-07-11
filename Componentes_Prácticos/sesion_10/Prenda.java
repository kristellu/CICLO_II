public class Prenda extends Producto{
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

    public void mostrar(){
        System.out.println(getCodigo() + " - " + getDesc() + " - " + getpCompra() + " - " + getpVenta() + 
        " - " + getcBodega() + " - " + getcMinRequerida() + " - " + getcMaxPermitida() + " - " + talla + 
        " - " + plancha);
    }

}