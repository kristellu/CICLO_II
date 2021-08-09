public class Estudiante extends Persona {
    private double notaHistoria;
    private double notaLiteratura;
    private double notaBiologia;

    public Estudiante(double id, double genero, double notaHistoria, double notaLiteratura, double notaBiologia){
        super(id, genero);
        this.notaLiteratura = notaLiteratura;
        this.notaBiologia = notaBiologia;
        this.notaHistoria = notaHistoria;
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
