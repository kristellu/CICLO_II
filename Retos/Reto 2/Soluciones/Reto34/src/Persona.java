public class Persona {
    private double id;
    private double genero;
    private double notaInformatica;
    private double notaFisica;
    private double notaQuimica;

    public Persona(double id, double genero, double notaInformatica, double notaFisica, double notaQuimica){
        this.id = id;
        this.genero = genero;
        this.notaInformatica = notaInformatica;
        this.notaFisica = notaFisica;
        this.notaQuimica = notaQuimica;
    }

    public double getGenero() {
        return genero;
    }

    public double getId() {
        return id;
    }

    public double getNotaFisica() {
        return notaFisica;
    }

    public double getNotaInformatica() {
        return notaInformatica;
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

    public void setNotaFisica(double notaFisica) {
        this.notaFisica = notaFisica;
    }

    public void setNotaInformatica(double notaInformatica) {
        this.notaInformatica = notaInformatica;
    }

    public void setNotaQuimica(double notaQuimica) {
        this.notaQuimica = notaQuimica;
    }

    public double porcentajeSobresalientes (){
        int res = 0;
        
        if(notaFisica > 3.5 && notaFisica <=4.5){
            res++;
        }

        if(notaInformatica > 3.5 && notaInformatica <=4.5){
            res++;
        }

        if(notaQuimica > 3.5 && notaQuimica <=4.5){
            res++;
        }


        return res*100/3;
    }
    
}
