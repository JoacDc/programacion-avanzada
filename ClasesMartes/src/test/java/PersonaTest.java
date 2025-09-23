import org.example.Persona;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;




public class PersonaTest {

    @Test
    @Order(1)
    @DisplayName("Verificar objeto")
    public void test() {
        Persona p1 = new Persona("Joaquin",
                "del Canto",
                LocalDate.of(1990, 1, 1),
                "12.345.678",
                180,
                84);

        assertEquals("Joaquin", p1.getNombre());
    }

    @Test
    @Order(2)
    @DisplayName("Atributos correctos")
    public void create_AtributosCorrectos_Success() {
        Persona nuevaPersona = Persona.create("Juan",
                "Perez",
                LocalDate.of(2000, 1, 1),
                "12.345.678",
                180.0f,
                80.5f);

        Assertions.assertNotNull(nuevaPersona);
        Assertions.assertEquals("Perez", nuevaPersona.getApellido());
    }

    @Test
    @Order(3)
    @DisplayName("Campo apellido vacio")
    public void campo_apellido_vacio() {
        Exception exception = assertThrows(IllegalArgumentException.class, ()
                -> Persona.create("Juan",
                "",
                LocalDate.of(2000,1,1),
                "12.345.678",
                180.0f,
                80.5f)
        );

        Assertions.assertEquals("Espacios en blanco", exception.getMessage());
    }

    @Test
    @Order(4)
    @DisplayName("Campo nombre vacio")
    public void campo_Nombre_Vacio() {
        Exception exception = assertThrows(IllegalArgumentException.class, ()
                -> Persona.create("",
                "perez",
                LocalDate.of(2000,1,1),
                "12.345.678",
                180.0f,
                80.5f)
        );

        Assertions.assertEquals("Espacios en blanco", exception.getMessage());
    }

    @Test
    @Order(5)
    @DisplayName("Campo nombre y apelldio vacios")
    public void campos_Nombre_Y_Apellido_Vacios() {
        Exception exception = assertThrows(IllegalArgumentException.class, ()
                -> Persona.create("",
                "",
                LocalDate.of(2000,1,1),
                "12.345.678",
                180.0f,
                80.5f)
        );

        Assertions.assertEquals("Espacios en blanco", exception.getMessage());
    }

    @Test
    @Order(6)
    @DisplayName("Comprobacion de Metdos Getters")
    public void comprobacion_Metodos_Getters() {
        Persona persona = Persona.create("Juan",
                "perez",
                LocalDate.of(2000,1,1),
                "12.345.678",
                180.0f,
                80.5f);

        Assertions.assertEquals("Juan",persona.getNombre());
        Assertions.assertEquals("perez",persona.getApellido());
        Assertions.assertEquals("12.345.678",persona.getDni());
        Assertions.assertEquals(180.0f ,persona.getAltura());
        Assertions.assertEquals(80.5f ,persona.getPeso());
        Assertions.assertEquals(LocalDate.of(2000,1,1) ,persona.getFechaNacimiento());

    }


    @Test
    @Order(7)
    @DisplayName("DNI Vacio")

    public void campo_dni_Vacio() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> Persona.create("Juan",
                        "perez",
                        LocalDate.of(2000,1,1),
                        " ",
                        180.0f,
                        80.5f)
        );

        Assertions.assertEquals("Espacios en blanco en DNI", exception.getMessage());
    }

    @Test
    @Order(8)
    @DisplayName("DNI con menos de seis digitos")

    public void campo_dni_con_menos_digitos() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> Persona.create("Juan",
                        "perez",
                        LocalDate.of(2000,1,1),
                        "12345",
                        180.0f,
                        80.5f)
        );

        Assertions.assertEquals("DNI mal Escrito", exception.getMessage());
    }

    @Test
    @Order(9)
    @DisplayName("DNI con digitos demas")

    public void campo_dni_con_digitos_demas() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> Persona.create("Juan",
                        "perez",
                        LocalDate.of(2000,1,1),
                        "123456789",
                        180.0f,
                        80.5f)
        );

        Assertions.assertEquals("DNI mal Escrito", exception.getMessage());
    }

    @Test
    @Order(10)
    @DisplayName("DNI formateado sin puntos")

    public void campo_dni_formateado() {
        Persona persona = new Persona("Juan",
                "perez",
                LocalDate.of(2000,1,1),
                "12.345.678",
                180.0f,
                80.5f);

        //Assertions.assertEquals("12345678", persona.FormatDni(persona.getDni()));
    }

    @Test
    @Order(11)
    @DisplayName("Campo Peso Invalido")

    public void campo_Peso_Invalido() {
        Exception excpetion = assertThrows(IllegalArgumentException.class,
                () -> Persona.create("Juan",
                        "perez",
                        LocalDate.of(2000,1,1),
                        "12345678",
                        180.0f,
                        1.5f)
        );
        Assertions.assertEquals("Peso invalido", excpetion.getMessage());
    }

    @Test
    @Order(12)
    @DisplayName("Campo altura Invalido")

    public void campo_Altura_Invalido() {
        Exception excpetion = assertThrows(IllegalArgumentException.class,
                () -> Persona.create("Juan",
                        "perez",
                        LocalDate.of(2000,1,1),
                        "12345678",
                        0.1f,
                        67.5f)
        );
        Assertions.assertEquals("Altura invalida", excpetion.getMessage());
    }

    @Test
    @Order(13)
    @DisplayName("Fecha Invalida")

    public void campo_fecha_Invalida() {
        Exception excpetion = assertThrows(IllegalArgumentException.class,
                () -> Persona.create("Juan",
                        "perez",
                        LocalDate.of(2024,12,1),
                        "12345678",
                        180.1f,
                        67.5f)
        );
        Assertions.assertEquals("Fecha invalida", excpetion.getMessage());
    }
}