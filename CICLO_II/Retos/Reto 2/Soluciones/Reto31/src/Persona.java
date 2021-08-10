public class Persona {
    private double id;
    private double genero;
    private double notaQuimica;
    private double notaIdioma;
    private double notaHistoria;

    public Persona(double id, double genero, double notaQuimica, double notaIdioma, double notaHistoria){
        this.id = id;
        this.genero = genero;
        this.notaQuimica = notaQuimica;
        this.notaIdioma = notaIdioma;
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

    public double getNotaIdioma() {
        return notaIdioma;
    }

    public double getNotaQuimica() {
        return notaQuimica;
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
