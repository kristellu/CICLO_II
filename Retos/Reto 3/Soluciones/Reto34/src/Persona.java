public class Persona {
    private double id;
    private double genero;

    public Persona(double id, double genero){
        this.id = id;
        this.genero = genero;
    }

    public double getGenero() {
        return genero;
    }

    public double getId() {
        return id;
    }

    public void setGenero(double genero) {
        this.genero = genero;
    }

    public void setId(double id) {
        this.id = id;
    }
    
}
