public class Paciente {
    private String nombre;
    private String cedula;
    private String genero;
    private double muestra1;
    private double muestra2;
    private double muestra3;

    public Paciente(String nombre, String cedula, String genero, double muestra1, double muestra2, double muestra3) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.genero = genero;
        this.muestra1 = muestra1;
        this.muestra2 = muestra2;
        this.muestra3 = muestra3;
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
    public double getMuestra1() {
        return muestra1;
    }
    public double getMuestra2() {
        return muestra2;
    }
    public double getMuestra3() {
        return muestra3;
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
    public void setMuestra1(double muestra1) {
        this.muestra1 = muestra1;
    }
    public void setMuestra2(double muestra2) {
        this.muestra2 = muestra2;
    }
    public void setMuestra3(double muestra3) {
        this.muestra3 = muestra3;
    }
    public int getPuntaje(){
        int ptpp=0;

        if (genero.equals("M")) {
            //Masculino
            if (muestra1 < 0.74 || muestra1 > 1.35) {
                ptpp += 5;
            }
        } else {
            //Femenino
            if (muestra1 < 0.59 || muestra1 > 1.04) {
                ptpp += 5;
            }
        }

        if (genero.equals("M")) {
            //Masculino
            if (muestra2 < 0.74 || muestra2 > 1.35) {
                ptpp += 5;
            }
        } else {
            //Femenino
            if (muestra2 < 0.59 || muestra2 > 1.04) {
                ptpp += 5;
            }
        }

        if (genero.equals("M")) {
            //Masculino
            if (muestra3 < 0.74 || muestra3 > 1.35) {
                ptpp += 5;
            }
        } else {
            //Femenino
            if (muestra3 < 0.59 || muestra3 > 1.04) {
                ptpp += 5;
            }
        }

        return ptpp;

    }

    
    
}
