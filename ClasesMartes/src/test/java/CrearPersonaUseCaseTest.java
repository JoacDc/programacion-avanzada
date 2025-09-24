import Persona.Input.CrearPersonaInput;
import Persona.Output.GuardarPersonaRepositorio;
import Persona.UseCase.CrearPersonaUseCase;
import org.example.Persona;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CrearPersonaUseCaseTest {

    @Mock
    GuardarPersonaRepositorio repositorio;

    @InjectMocks
    CrearPersonaUseCase usecase;

    @Test
    void CrearPersona() {
        // arrange
        when(repositorio.existePersona("12456789")).thenReturn(false);
        when(repositorio.guardarPersona(any(Persona.class))).thenReturn(true);

        // act
        Boolean result = usecase.crearPersona(
                "nombre", "apellido", "12456789",
                LocalDate.of(2000, 1, 2), 180.0f, 80.0f);

        // assert
        Assertions.assertTrue(result);
        verify(repositorio).existePersona("12456789");
        verify(repositorio).guardarPersona(any(Persona.class));
    }

    @Test
    void CrearPersona_AtributosInvalido() {
        // act
        Boolean result = usecase.crearPersona(
                "nombre", null, "12456789",
                LocalDate.of(2000, 1, 2), 180.0f, 80.0f);

        // assert
        Assertions.assertFalse(result);
        verify(repositorio, never()).guardarPersona(any());
    }

    @Test
    void CrearPersona_FallaPorqueRepositorioNoGuarda() {
        // arrange
        String dniNuevo = "12345678";

        when(repositorio.existePersona(dniNuevo)).thenReturn(false);
        when(repositorio.guardarPersona(any(Persona.class))).thenReturn(false);

        // act
        Boolean result = usecase.crearPersona(
                "nombre", "apellido", dniNuevo,
                LocalDate.of(2001, 3, 15), 182.0f, 82.0f);

        // assert
        Assertions.assertFalse(result);

        verify(repositorio).existePersona(dniNuevo);
        verify(repositorio).guardarPersona(any(Persona.class));
    }

    @Test
    void CrearPersona_NombreInvalido() {
        // act
        Boolean result = usecase.crearPersona(
                "", "apellido", "12456789",
                LocalDate.of(2000, 1, 2), 180.0f, 80.0f);

        // assert
        Assertions.assertFalse(result);
        verify(repositorio, never()).existePersona(any());
        verify(repositorio, never()).guardarPersona(any());
    }

    @Test
    void CrearPersona_FallaPorDniConFormatoInvalido() {
        // arrange
        String dniInvalido = "12345ABC";

        // act
        Boolean result = usecase.crearPersona(
                "nombre", "apellido", dniInvalido,
                LocalDate.of(2000, 1, 2), 180.0f, 80.0f);

        // assert
        Assertions.assertFalse(result);
        verify(repositorio, never()).existePersona(anyString());
        verify(repositorio, never()).guardarPersona(any(Persona.class));
    }
}

