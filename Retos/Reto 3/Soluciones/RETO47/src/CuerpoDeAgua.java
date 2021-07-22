/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author acer nitro5
 */
public class CuerpoDeAgua extends ObjetoGeografico{

    private double irca;

    public CuerpoDeAgua(String nombre, double id, String municipio, double irca) {
        super(nombre, id, municipio);
        this.irca = irca;
    }

    public double getIrca() {
        return irca;
    }

    public void setIrca(double irca) {
        this.irca = irca;
    }   
    
    public String nivel() {
        String nivel_riesgo = "";
        if (irca >= 0 && irca <= 5) {
            nivel_riesgo = "SIN RIESGO";
        }
        if (irca > 5 && irca <= 14) {
            nivel_riesgo = "BAJO";
        }
        if (irca > 14 && irca <= 35) {
            nivel_riesgo = "MEDIO";
        }
        if (irca > 35 && irca <= 80) {
            nivel_riesgo = "ALTO";
        }
        if (irca > 80 && irca <= 100) {
            nivel_riesgo = "INVIABLE SANITARIAMENTE";
        }
        return nivel_riesgo;
    }
}
