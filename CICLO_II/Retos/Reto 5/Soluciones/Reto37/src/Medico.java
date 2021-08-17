import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Medico extends Persona {

    private String especialidad;

    public Medico (){
        super(0, 0, null);
        this.especialidad = null;
    }


    public Medico (int id, String nombre, int genero, String especialidad){
        super(id, genero, nombre);
        this.especialidad= especialidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad= especialidad;
    }
  }
