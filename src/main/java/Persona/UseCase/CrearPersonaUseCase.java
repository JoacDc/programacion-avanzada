package Persona.UseCase;

import Persona.Exception.PersonaException;
import Persona.Exception.RepositorioException;
import Persona.Input.CrearPersonaInput;
import Persona.Output.GuardarPersonaRepositorio;
import org.example.Persona;

import java.time.LocalDate;

public class CrearPersonaUseCase implements CrearPersonaInput{

    private GuardarPersonaRepositorio guardarPersonaRepositorio;

    public CrearPersonaUseCase(GuardarPersonaRepositorio repositorio) {
        GuardarPersonaRepositorio guardarPersonaRepositorio1 = this.guardarPersonaRepositorio;
        this.guardarPersonaRepositorio = repositorio;
    }


    @Override
    public Boolean crearPersona(String nombre, String apellido, String dni, LocalDate fechaNacimiento, float altura, float peso) {
        try {

            if (dni == null || !dni.matches("\\d{7,8}")) {
                throw new PersonaException("Formato de DNI inválido");
            }


            if (this.guardarPersonaRepositorio.existePersona(dni)) {
                throw new PersonaException("Persona ya existe");
            }


            Persona persona = Persona.create(nombre, apellido, fechaNacimiento, dni, altura, peso);

            if (!this.guardarPersonaRepositorio.guardarPersona(persona)) {
                throw new RepositorioException("Algo salió mal al guardar");
            }

            return true;

        } catch (PersonaException | RepositorioException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

}
