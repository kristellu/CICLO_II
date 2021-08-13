public class Producto {
    int codigo;
    int pCompra;
    int cBodega;
    int cMinRequerida;

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

    
}
