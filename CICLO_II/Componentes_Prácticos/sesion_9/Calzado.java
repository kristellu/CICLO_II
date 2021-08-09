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


}
