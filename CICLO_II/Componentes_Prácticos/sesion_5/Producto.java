public class Producto {
    private int codigo;
    private int pCompra;
    private int cBodega;
    private int cMinRequerida;

    public Producto(int codigo, int pCompra, int cBodega, int cMinRequerida) {
        this.codigo = codigo;
        this.pCompra = pCompra;
        this.cBodega = cBodega;
        this.cMinRequerida = cMinRequerida;
    }

    public boolean solicitar(){
        if(cBodega < cMinRequerida){
            return true;
        }else{
            return false;
        }

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
        this.cMinRequerida = cMinRequerida;
    }

    public void setpCompra(int pCompra) {
        this.pCompra = pCompra;
    }

    
}
