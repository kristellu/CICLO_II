public class Persona {

    private int id;
    private int genero;
    private String nombre;

    public Persona(int id, int genero, String nombre){
        this.id = id;
        this.genero = genero;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getGenero() {
        return genero;
    }

    public int getId() {
        return id;
    }

    public void setGenero(int genero) {
        this.genero = genero;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
