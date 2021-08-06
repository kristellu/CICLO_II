import java.sql.Time;

public class Horario {

    private int id;
    private String dia;
    private Time hora;

    public Horario(int id, String dia, Time hora) {
        this.id = id;
        this.dia = dia;
        this.hora = hora;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getDia() {
        return dia;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public Time getHora() {
        return hora;
    }
}
