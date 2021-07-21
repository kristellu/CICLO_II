public class Estudiante extends Persona {
    private double notaBiologia;
    private double notaHistoria;
    private double notaLiteratura;

    public Estudiante(double id, double genero, double notaHistoria, double notaLiteratura, double notaBiologia){
        super(id, genero);
        this.notaBiologia = notaBiologia;
        this.notaHistoria = notaHistoria;
        this.notaLiteratura = notaLiteratura;
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
