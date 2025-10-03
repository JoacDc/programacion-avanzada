package Persona.Input;

import java.time.LocalDate;

public interface CrearPersonaInput {
    Boolean  crearPersona(String nombre,
                          String apellido,
                          String dni,
                          LocalDate fechaNacimiento,
                          float altura,
                          float peso);
}
