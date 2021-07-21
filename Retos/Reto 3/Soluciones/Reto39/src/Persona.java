public class Persona {
    private String nombre;
    private String cedula;
    private String genero;

    public Persona(String nombre, String cedula, String genero) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.genero = genero;
    }

    public String getNombre() {
        return nombre;
    }
    public String getCedula() {
        return cedula;
    }
    public String getGenero() {
        return genero;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
}
