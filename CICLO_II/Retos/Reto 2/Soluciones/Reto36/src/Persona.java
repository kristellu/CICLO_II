public class Persona {
    private double id;
    private double genero;    
    private double notaHistoria;
    private double notaLiteratura;
    private double notaBiologia;

    public Persona(double id, double genero, double notaHistoria, double notaLiteratura, double notaBiologia){
        this.id = id;
        this.genero = genero;
        this.notaLiteratura = notaLiteratura;
        this.notaBiologia = notaBiologia;
        this.notaHistoria = notaHistoria;
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

    public void setNotaBiologia(double notaBiologia) {
        this.notaBiologia = notaBiologia;
    }

    public void setNotaHistoria(double notaHistoria) {
        this.notaHistoria = notaHistoria;
    }

    public void setNotaLiteratura(double notaLiteratura) {
        this.notaLiteratura = notaLiteratura;
    }

    
    public int contarReprobados(){
        int res = 0;

        if(notaBiologia < 60){
            res++;
        }

        if(notaLiteratura < 60){
            res++;
        }

        if(notaLiteratura < 60){
            res++;
        }


        return res;
    }
    
}
