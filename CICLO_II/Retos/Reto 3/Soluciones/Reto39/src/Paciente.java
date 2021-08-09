public class Paciente extends Persona {
    private double muestra1;
    private double muestra2;
    private double muestra3;
    private double muestra4;

    public Paciente(String nombre, String cedula, String genero, 
    double muestra1, double muestra2, double muestra3, double muestra4) {
        super(nombre, cedula, genero);
        this.muestra1 = muestra1;
        this.muestra2 = muestra2;
        this.muestra3 = muestra3;
        this.muestra4 = muestra4;
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
    public double getMuestra4() {
        return muestra4;
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
    public void setMuestra4(double muestra4) {
        this.muestra4 = muestra4;
    }
    public int getPuntaje(){
        int ptpp = 0;
        
        if (this.getGenero().equals("M")) {
            //Masculinoptpp
            if (muestra1 < 0.74 || muestra1 > 1.35) {
                ptpp += 10;
            }
        } else {
            //Femenino
            if (muestra1 < 0.59 || muestra1 > 1.04) {
                ptpp += 10;
            }
        }

        if (this.getGenero().equals("M")) {
            //Masculino
            if (muestra2 < 0.74 || muestra2 > 1.35) {
                ptpp += 10;
            }
        } else {
            //Femenino
            if (muestra2 < 0.59 || muestra2 > 1.04) {
                ptpp += 10;
            }
        }

        if (this.getGenero().equals("M")) {
            //Masculino
            if (muestra3 < 14 || muestra3 > 26) {
                ptpp += 10;
            }
        } else {
            //Femenino
            if (muestra3 < 11 || muestra3 > 20) {
                ptpp += 10;
            }
        }
        
        if (this.getGenero().equals("M")) {
            //Masculino
            if (muestra4 < 14 || muestra4 > 26) {
                ptpp += 10;
            }
        } else {
            //Femenino
            if (muestra4 < 11 || muestra4 > 20) {
                ptpp += 10;
            }
        }

        return ptpp;
    }

    
    
}
