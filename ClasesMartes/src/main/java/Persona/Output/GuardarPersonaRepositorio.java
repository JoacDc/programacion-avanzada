package Persona.Output;

import org.example.Persona;

public interface GuardarPersonaRepositorio {

    boolean guardarPersona(Persona persona);
    boolean existePersona(String dni);

}
