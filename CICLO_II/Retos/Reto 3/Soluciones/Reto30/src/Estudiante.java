public class Estudiante extends Persona {

    private double notaIdioma;
    private double notaHistoria;
    private double notaLiteratura;

    public Estudiante(double id, double genero, double notaIdioma, double notaHistoria, double notaLiteratura){
        super(id, genero);
        this.notaIdioma = notaIdioma;
        this.notaHistoria = notaHistoria;
        this.notaLiteratura = notaLiteratura;
    }

    public int contarSobresalientes(){
        int res = 0;

        if(notaHistoria > 80 && notaHistoria <=90){
            res++;
        }

        if(notaIdioma > 80 && notaIdioma <=90){
            res++;
        }

        if(notaLiteratura > 80 && notaLiteratura <=90){
            res++;
        }

        return res;
    }

    public double getNotaHistoria() {
        return notaHistoria;
    }

    public double getNotaIdioma() {
        return notaIdioma;
    }

    public double getNotaLiteratura() {
        return notaLiteratura;
    }

    public void setNotaHistoria(double notaHistoria) {
        this.notaHistoria = notaHistoria;
    }

    public void setNotaIdioma(double notaIdioma) {
        this.notaIdioma = notaIdioma;
    }

    public void setNotaLiteratura(double notaLiteratura) {
        this.notaLiteratura = notaLiteratura;
    }
    
}
