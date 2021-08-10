public class Persona {

    private int id;
    private int num_identificacion;
    private String nombre;
    private String apellido;
    private String email;
    private int edad;
    protected Curso curso;
    protected Tipo tipo;

    public Persona(int id, int num_identificacion, String nombre, String apellido, String email, int edad, Curso curso,
            Tipo tipo) {
        this.id = id;
        this.num_identificacion = num_identificacion;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.tipo = tipo;
        this.curso = curso;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setNumIdentificacion(int num_identificacion) {
        this.num_identificacion = num_identificacion;
    }

    public int getNumIdentificacion() {
        return num_identificacion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getApellido() {
        return apellido;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getEdad() {
        return edad;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Curso getCurso() {
        return curso;
    }
}
