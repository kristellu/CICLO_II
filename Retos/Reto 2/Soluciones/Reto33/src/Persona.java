public class Persona {
    private double id;
    private double genero;
    private double notaMat;
    private double notaInf;
    private double notaFis;

    public Persona(double id, double genero, double notaMat, double notaInf, double notaFis){
        this.id = id;
        this.genero = genero;
        this.notaMat = notaMat;
        this.notaInf = notaInf;
        this.notaFis = notaFis;
    }

    public double getGenero() {
        return genero;
    }

    public double getId() {
        return id;
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

    public void setGenero(double genero) {
        this.genero = genero;
    }

    public void setId(double id) {
        this.id = id;
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
