public class Estudiante extends Persona {
    private double id;
    private double genero;
    private double notaLiteratura;
    private double notaBiologia;
    private double noraGeografia;

    public Estudiante(double id, double genero, double notaLiteratura, double notaBiologia, double noraGeografia){
        super(id, genero);
        this.notaLiteratura = notaLiteratura;
        this.notaBiologia = notaBiologia;
        this.noraGeografia = noraGeografia;
    }

    public double getGenero() {
        return genero;
    }

    public double getId() {
        return id;
    }

    public double getNoraGeografia() {
        return noraGeografia;
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

    public void setNotaGeografia(double noraGeografia) {
        this.noraGeografia = noraGeografia;
    }

    public void setNotaLiteratura(double notaLiteratura) {
        this.notaLiteratura = notaLiteratura;
    }

    
    public double porcentajeRegulares(){
        int res = 0;

        if(notaBiologia > 6 && notaBiologia <= 8){
            res++;
        }

        if(notaLiteratura > 6 && notaLiteratura <= 8){
            res++;
        }

        if(noraGeografia > 6 && noraGeografia <= 8){
            res++;
        }


        return res*100/3;
    }
    
}
