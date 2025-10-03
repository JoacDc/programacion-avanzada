package org.example;

import Persona.Exception.PersonaException;

import java.time.LocalDate;

public class Persona {

    private String nombre;
    private String apellido;
    private String dni;
    private LocalDate fechaNacimiento;
    private float altura;
    private float peso;

    private Persona(String nombre, String apellido, LocalDate fechaNacimiento, String dni, float altura, float peso) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.dni = dni.replace(".","");
        this.altura = altura;
        this.peso = peso;
    }

    public static Persona create(String nombre,
                                 String apellido,
                                 LocalDate fechaNacimiento,
                                 String dni,
                                 float altura,
                                 float peso) {
        LocalDate localDate = LocalDate.now();

        if(fechaNacimiento.isAfter(localDate)) {
            throw new PersonaException("Fecha invalida");
        }

        if(nombre == null || nombre.isEmpty() || apellido == null || apellido.isEmpty()) {
            throw new PersonaException("Espacios en blanco");
        }

        if((dni == null) || dni.isBlank()) {
            throw new PersonaException("Campo Dni Vacio: corregir");
        }

        String dniFormat = dni.replace(".","");

        if(dniFormat.length() > 8 || dniFormat.length() < 6) {
            throw new PersonaException("DNI mal Escrito");
        }

        if(peso < 2.5f){
            throw new PersonaException("Peso invalido");
        }

        if(altura < 0.40f){
            throw new PersonaException("Altura invalida");
        }

        return new Persona(nombre, apellido, fechaNacimiento, dniFormat, altura, peso);
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public String getDni(){
        return this.dni;
    }

    public LocalDate getFechaNacimiento() {
        return this.fechaNacimiento;
    }

    public float getAltura() {
        return this.altura;
    }

    public float getPeso(){
        return this.peso;
    }

}
