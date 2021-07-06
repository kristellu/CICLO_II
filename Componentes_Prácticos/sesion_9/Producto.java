public class Producto {
    private int codigo;
    private String desc;
    private int pCompra;
    private int pVenta;
    private int cBodega;
    private int cMinRequerida;
    private int cMaxPermitida;
    static double pDescuento = 0.01;

    public Producto(int codigo, String desc, int pCompra, int pVenta, int cBodega, int cMinRequerida, int cMaxPermitida) {
        this.codigo = codigo;
        this.desc = desc;
        this.pCompra = pCompra;
        this.cBodega = cBodega;
        this.cMinRequerida = cMinRequerida;
        this.cMaxPermitida = cMaxPermitida;
        this.pVenta = pVenta;
    }

    public boolean solicitar(){
        if(cBodega < cMinRequerida){
            return true;
        }else{
            return false;
        }
    }

    public int getpVenta() {
        return pVenta;
    }
    
    public void setpVenta(int pVenta) {
        this.pVenta = pVenta;
    }

    public int totalAPagar(int unidades){
        return unidades * pCompra;
    }

    public int getcMaxPermitida() {
        return cMaxPermitida;
    }

    public void setcMaxPermitida(int cMaxPermitida) {
        this.cMaxPermitida = cMaxPermitida;
    }

    public int getCodigo() {
        return codigo;
    }

    public int getcBodega() {
        return cBodega;
    }

    public int getcMinRequerida() {
        return cMinRequerida;
    }

    public int getpCompra() {
        return pCompra;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setcBodega(int cBodega) {
        this.cBodega = cBodega;
    }

    public void setcMinRequerida(int cMinRequerida) {

        if(cMinRequerida < 0){
            this.cMinRequerida = 0;
        }else{
            this.cMinRequerida = cMinRequerida;
        }
        
    }

    public void setpCompra(int pCompra) {
        this.pCompra = pCompra;
    }

    
}
