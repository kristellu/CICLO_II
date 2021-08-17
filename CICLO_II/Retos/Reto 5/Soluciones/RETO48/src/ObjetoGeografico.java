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

    private double id;
    private String municipio;

    public ObjetoGeografico(double id, String municipio) {
        this.id = id;
        this.municipio = municipio;
    }

    public double getId() {
        return id;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setId(double id) {
        this.id = id;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }
}
