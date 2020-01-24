package com.example.sqlite_android.dao;

public class Coche {

    String matricula;
    String marca;
    String modelo;
    int caballos;
    String color;

    public Coche(String matricula, String marca, String modelo, int caballos, String color) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.caballos = caballos;
        this.color = color;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getCaballos() {
        return caballos;
    }

    public void setCaballos(int caballos) {
        this.caballos = caballos;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return "Coche{" +
                "matricula='" + matricula + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", caballos=" + caballos +
                ", color='" + color + '\'' +
                '}';
    }

}
