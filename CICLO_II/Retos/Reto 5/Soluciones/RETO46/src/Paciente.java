public class Paciente extends Persona{
    private int edad;
    private String ciudad;
    private String eps;
    private String enfermedad;

    public Paciente(String nombre, String cedula, int edad, String ciudad, String eps, String enfermedad) {
        super(nombre, cedula);
        this.edad = edad;
        this.ciudad = ciudad;
        this.eps = eps;
        this.enfermedad = enfermedad;
    }

    public String getCiudad() {
        return ciudad;
    }

    public int getEdad() {
        return edad;
    }
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getEps() {
        return eps;
    }

    public String getEnfermedad() {
        return enfermedad;
    }

    public void setEps(String eps) {
        this.eps = eps;
    }

    public void setEnfermedad(String enfermedad) {
        this.enfermedad = enfermedad;
    }

    public String clasificarEdad(){
        String res = "";
        if (this.getEdad() >= 21 && this.getEdad() <= 30) {
            res = "Joven adulto";
        } else if (this.getEdad() > 30 && this.getEdad() <= 60) {
            res =  "Adulto";
        } else if (this.getEdad() > 60) {
            res = "Tercera edad";
        }
        return res;
    }

}
