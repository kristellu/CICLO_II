public class Persona {
    private double id;
    private double genero;
    private double notaBiologia;
    private double notaHistoria;
    private double notaLiteratura;

    public Persona(double id, double genero, double notaHistoria, double notaLiteratura, double notaBiologia){
        this.id = id;
        this.genero = genero;
        this.notaBiologia = notaBiologia;
        this.notaHistoria = notaHistoria;
        this.notaLiteratura = notaLiteratura;
    }

    public double getGenero() {
        return genero;
    }

    public double getId() {
        return id;
    }

    public double getNotaHistoria() {
        return notaHistoria;
    }

    public double getNotaBiologia() {
        return notaBiologia;
    }

    public double getNotaLiteratura() {
        return notaLiteratura;
    }

    public void setGenero(double genero) {
        this.genero = genero;
    }

    public void setId(double id) {
        this.id = id;
    }

    public void setNotaHistoria(double notaHistoria) {
        this.notaHistoria = notaHistoria;
    }

    public void setNotaBiologia(double notaBiologia) {
        this.notaBiologia = notaBiologia;
    }

    public void setNotaLiteratura(double notaLiteratura) {
        this.notaLiteratura = notaLiteratura;
    }

    public int contarDeficientes(){
        int res = 0;

        if(notaHistoria >= 0 && notaHistoria <=3){
            res++;
        }

        if(notaBiologia >=0 && notaBiologia <=3){
            res++;
        }

        if(notaLiteratura >=0 && notaLiteratura <=3){
            res++;
        }

        return res;
    }
    
}
