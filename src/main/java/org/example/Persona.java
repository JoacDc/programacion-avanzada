package org.example;

import java.time.LocalDate;

public class Persona {

    private String nombre;
    private String apellido;
    private String dni;
    private LocalDate fechaNacimiento;
    private float altura;
    private float peso;


    public Persona(String nombre, String apellido, LocalDate fechaNacimiento, String dni, float altura, float peso) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.dni = dni;
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
            throw new IllegalArgumentException("Fecha invalida");
        }

        if(nombre == null || nombre.isBlank() || apellido == null || apellido.isBlank()) {
            throw new IllegalArgumentException("Espacios en blanco");
        }

        if(dni == null || dni.isBlank()) {
            throw new IllegalArgumentException("Espacios en blanco en DNI");
        }

        if(dni.length() > 8 || dni.length() < 6) {
            throw new IllegalArgumentException("DNI mal Escrito");
        }

        if(peso < 2.5f){
            throw new IllegalArgumentException("Peso invalido");
        }

        if(altura < 0.40f){
            throw new IllegalArgumentException("Altura invalida");
        }

        return new Persona(nombre, apellido, fechaNacimiento, dni, altura, peso);
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

    public String formatDni(){

        return this.dni.replace(".","");
    };

}
