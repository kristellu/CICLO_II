/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.reto64;

/**
 *
 * @author acer nitro5
 */
public class CuerpoDeAgua {

    private String nombre;
    private double id;
    private String municipio;
    private double irca;

    public CuerpoDeAgua(String nombre, double id, String municipio, double irca) {
        this.nombre = nombre;
        this.id = id;
        this.municipio = municipio;
        this.irca = irca;
    }

    public String getNombre() {
        return nombre;
    }

    public double getId() {
        return id;
    }

    public String getMunicipio() {
        return municipio;
    }

    public double getIrca() {
        return irca;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setId(double id) {
        this.id = id;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
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
