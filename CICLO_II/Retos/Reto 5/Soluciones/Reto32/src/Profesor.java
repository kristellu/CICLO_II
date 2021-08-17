import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Profesor extends Persona {

    private String materia;
    private int idMateria;

    public Profesor(){
        super(0, 0, null);
        this.nota = 0;
        this.materia = null;
        this.idMateria = 0;
    }


    public Profesor(int id, String nombre, int genero, int idMateria, String materia){
        super(id, genero, nombre);
        this.idMateria = idMateria;
        this.materia = materia;
    }

    public int getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(int idMateria) {
        this.idMateria = idMateria;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

  }
