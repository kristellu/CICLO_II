public class Curso {

    private int id;
    private String nombre;
    protected Persona instructor;
    protected Horario horario;

    public Curso(int id, String nombre, Persona instructor, Horario horario) {
        this.id = id;
        this.nombre = nombre;
        this.instructor = instructor;
        this.horario = horario;
    }

    public Curso() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setInstructor(Persona instructor) {
        this.instructor = instructor;
    }

    public Persona getInstructor() {
        return instructor;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public Horario getHorario() {
        return horario;
    }

    @Override
    public String toString() {
        return id + "-" + nombre;
    }
}
