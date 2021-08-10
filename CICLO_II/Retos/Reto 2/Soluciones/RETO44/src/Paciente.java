public class Paciente {
    private String nombre;
    private String cedula;
    private int edad;
    private String ciudad;
    private String eps;
    private String enfermedad;

    public Paciente(String nombre, String cedula, String edad, String ciudad, String eps, String enfermedad) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.edad = Integer.parseInt(edad);
        this.ciudad = ciudad;
        this.eps = eps;
        this.enfermedad = enfermedad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public int getEdad() {
        return edad;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getEps() {
        return eps;
    }

    public String getEnfermedad() {
        return enfermedad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setEps(String eps) {
        this.eps = eps;
    }

    public void setEnfermedad(String enfermedad) {
        this.enfermedad = enfermedad;
    }

    public String clasificarEdad(){
        String res = "";
        if (edad >= 21 && edad <= 30) {
            res = "Joven adulto";
        } else if (edad >= 30 && edad <= 60) {
            res =  "Adulto";
        } else if (edad > 60) {
            res = "Tercera edad";
        }
        return res;
    }

}
