/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.animales.model;

/**
 *
 * @author dandres
 */
public class AnimalesModel {
    
    private int idAnimal;
    private String raza;
    private String nombre;
    private int edad;
    private String genero;
    private String alimentacion;

    public AnimalesModel() {
    }

    

    public AnimalesModel(int idAnimal, String raza, String nombre, int edad, String genero, String alimentacion) {
        this.idAnimal = idAnimal;
        this.raza = raza;
        this.nombre = nombre;
        this.edad = edad;
        this.genero = genero;
        this.alimentacion = alimentacion;
    }

    public int getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(int idAnimal) {
        this.idAnimal = idAnimal;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getAlimentacion() {
        return alimentacion;
    }

    public void setAlimentacion(String alimentacion) {
        this.alimentacion = alimentacion;
    }
    
    
}
