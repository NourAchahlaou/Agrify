/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agrify.entities;

/**
 *
 * @author alien kami sama
 */
public class Animal {
    private int idAnimal;
    private String especeAnimal;
    private String sexeRation;
    private double poidsmaxRation;
    private double poidsminRation;
    private int ageAnimal;
    private int nombreAnimal;

    public Animal(int idAnimal, String especeAnimal, String sexeRation, double poidsmaxRation, double poidsminRation, int ageAnimal, int nombreAnimal) {
        this.idAnimal = idAnimal;
        this.especeAnimal = especeAnimal;
        this.sexeRation = sexeRation;
        this.poidsmaxRation = poidsmaxRation;
        this.poidsminRation = poidsminRation;
        this.ageAnimal = ageAnimal;
        this.nombreAnimal = nombreAnimal;
    }

    public Animal() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // Getters and Setters
    public int getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(int idAnimal) {
        this.idAnimal = idAnimal;
    }

    public String getEspeceAnimal() {
        return especeAnimal;
    }

    public void setEspeceAnimal(String especeAnimal) {
        this.especeAnimal = especeAnimal;
    }

    public String getSexeRation() {
        return sexeRation;
    }

    public void setSexeRation(String sexeRation) {
        this.sexeRation = sexeRation;
    }

    public double getPoidsmaxRation() {
        return poidsmaxRation;
    }

    public void setPoidsmaxRation(double poidsmaxRation) {
        this.poidsmaxRation = poidsmaxRation;
    }

    public double getPoidsminRation() {
        return poidsminRation;
    }

    public void setPoidsminRation(double poidsminRation) {
        this.poidsminRation = poidsminRation;
    }

    public int getAgeAnimal() {
        return ageAnimal;
    }

    public void setAgeAnimal(int ageAnimal) {
        this.ageAnimal = ageAnimal;
    }

    public int getNombreAnimal() {
        return nombreAnimal;
    }

    public void setNombreAnimal(int nombreAnimal) {
        this.nombreAnimal = nombreAnimal;
    }
}
