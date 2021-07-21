public class Estudiante extends Persona {
    private double notaMat;
    private double notaInf;
    private double notaFis;

    public Estudiante(double id, double genero, double notaMat, double notaInf, double notaFis){
        super(id, genero);
        this.notaMat = notaMat;
        this.notaInf = notaInf;
        this.notaFis = notaFis;
    }

    public double getNotaMat() {
        return notaMat;
    }

    public double getNotaInf() {
        return notaInf;
    }

    public double getNotaFis() {
        return notaFis;
    }

    public void setNotaMat(double notaMat) {
        this.notaMat = notaMat;
    }

    public void setNotaFis(double notaFis) {
        this.notaFis = notaFis;
    }

    public void setNotaInf(double notaInf) {
        this.notaInf = notaInf;
    }

    public int contarExcelentes (){
        int res = 0;
        
        if(notaFis > 90 && notaFis <=100){
            res++;
        }

        if(notaInf > 90 && notaInf <=100){
            res++;
        }

        if(notaMat > 90 && notaMat <=100){
            res++;
        }

        return res;
    }
    
}
