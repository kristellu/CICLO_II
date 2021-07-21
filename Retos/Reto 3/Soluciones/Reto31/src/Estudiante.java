public class Estudiante extends Persona{
    private double notaQuimica;
    private double notaIdioma;
    private double notaHistoria;

    public Estudiante(double id, double genero, double notaQuimica, double notaIdioma, double notaHistoria){
        super(id, genero);
        this.notaQuimica = notaQuimica;
        this.notaIdioma = notaIdioma;
        this.notaHistoria = notaHistoria;
    }

    
    public double getNotaHistoria() {
        return notaHistoria;
    }

    public double getNotaIdioma() {
        return notaIdioma;
    }

    public double getNotaQuimica() {
        return notaQuimica;
    }
    
    public void setNotaHistoria(double notaHistoria) {
        this.notaHistoria = notaHistoria;
    }

    public void setNotaIdioma(double notaIdioma) {
        this.notaIdioma = notaIdioma;
    }

    public void setNotaQuimica(double notaQuimica) {
        this.notaQuimica = notaQuimica;
    }

    public int contarRegulares(){
        int res = 0;

        if(notaHistoria > 2.5 && notaHistoria <=3.5){
            res++;
        }

        if(notaIdioma > 2.5 && notaIdioma <=3.5){
            res++;
        }

        if(notaQuimica > 2.5 && notaQuimica <=3.5){
            res++;
        }

        return res;
    }
    
}
