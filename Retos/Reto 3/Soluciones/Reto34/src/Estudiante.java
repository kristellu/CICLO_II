public class Estudiante extends Persona{
    private double notaInformatica;
    private double notaFisica;
    private double notaQuimica;

    public Estudiante(double id, double genero, double notaInformatica, double notaFisica, double notaQuimica){
        super(id, genero);
        this.notaInformatica = notaInformatica;
        this.notaFisica = notaFisica;
        this.notaQuimica = notaQuimica;
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
