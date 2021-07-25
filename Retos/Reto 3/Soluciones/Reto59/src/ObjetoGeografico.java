/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author acer nitro5
 */
public class ObjetoGeografico {

    private String nombre;
    private double id;
    private String municipio;

    public ObjetoGeografico(String nombre, double id, String municipio) {
        this.nombre = nombre;
        this.id = id;
        this.municipio = municipio;
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

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setId(double id) {
        this.id = id;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }
}