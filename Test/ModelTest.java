import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ModelTest {
    static Model m;
    static Coche coche;

    @BeforeEach
    public void setUp() {
        // Limpiamos el parking antes de cada test
        Model.parking.clear();
    }

    // Tests para crear coches
    @Test
    public void testCrearCocheValido() {
        Coche c = Model.crearCoche("Tesla Model 3", "1234ABC");

        assertNotNull(c);
        assertEquals("Tesla Model 3", c.modelo);
        assertEquals("1234ABC", c.matricula);
        assertEquals(0, c.velocidad);
        assertEquals(1, Model.parking.size());
    }

    @Test
    public void testCrearCocheConMatriculaDuplicada() {
        Model.crearCoche("Audi A4", "1111AAA");
        Coche duplicado = Model.crearCoche("BMW X5", "1111AAA");

        assertNull(duplicado);
        assertEquals(1, Model.parking.size());
    }

    // Tests para obtener coches
    @Test
    public void testGetCocheExistente() {
        Model.crearCoche("Renault Megane", "9999ZZZ");
        Coche encontrado = Model.getCoche("9999ZZZ");

        assertNotNull(encontrado);
        assertEquals("Renault Megane", encontrado.modelo);
    }

    @Test
    public void testGetCocheInexistente() {
        Coche noEncontrado = Model.getCoche("0000XXX");

        assertNull(noEncontrado);
    }

    // Tests para velocidad
    @Test
    public void testCambiarVelocidad() {
        Model.crearCoche("Seat León", "5555LLL");
        int nuevaVelocidad = Model.cambiarVelocidad("5555LLL", 120);

        assertEquals(120, nuevaVelocidad);
        assertEquals(120, Model.getVelocidad("5555LLL"));
    }

    @Test
    public void testCambiarVelocidadCocheInexistente() {
        int resultado = Model.cambiarVelocidad("9999XXX", 100);

        assertEquals(-1, resultado);
    }

    @Test
    public void testAumentarVelocidad() {
        Model.crearCoche("Ford Focus", "4444FFF");
        Model.cambiarVelocidad("4444FFF", 50);
        int nuevaVelocidad = Model.aumentarV("4444FFF", 30);

        assertEquals(80, nuevaVelocidad);
    }

    @Test
    public void testDisminuirVelocidad() {
        Model.crearCoche("Volkswagen Golf", "3333GGG");
        Model.cambiarVelocidad("3333GGG", 100);
        int nuevaVelocidad = Model.disminuirV("3333GGG", 40);

        assertEquals(60, nuevaVelocidad);
    }

    @Test
    public void testVelocidadNoNegativa() {
        Model.crearCoche("Hyundai Tucson", "2222HHH");
        Model.cambiarVelocidad("2222HHH", 30);
        int nuevaVelocidad = Model.disminuirV("2222HHH", 50);

        assertEquals(0, nuevaVelocidad);
    }

    // Tests para eliminar coches
    @Test
    public void testEliminarCocheExistente() {
        Model.crearCoche("Kia Sportage", "7777KKK");
        boolean eliminado = Model.eliminarCoche("7777KKK");

        assertTrue(eliminado);
        assertEquals(0, Model.parking.size());
    }

    @Test
    public void testEliminarCocheInexistente() {
        boolean resultado = Model.eliminarCoche("8888YYY");

        assertFalse(resultado);
    }

    // Tests para listar coches por velocidad
    @Test
    public void testListarCochesPorVelocidad() {
        Model.crearCoche("Coche1", "1111AAA"); // velocidad 0 por defecto
        Model.crearCoche("Coche2", "2222BBB");
        Model.cambiarVelocidad("2222BBB", 80);
        Model.crearCoche("Coche3", "3333CCC");
        Model.cambiarVelocidad("3333CCC", 120);

        ArrayList<Coche> rapidos = Model.listarCochesPorVelocidad(50);

        assertEquals(2, rapidos.size());
        assertTrue(rapidos.stream().anyMatch(c -> c.matricula.equals("2222BBB")));
        assertTrue(rapidos.stream().anyMatch(c -> c.matricula.equals("3333CCC")));
    }

    @Test
    public void testListarCochesPorVelocidadSinResultados() {
        Model.crearCoche("Coche1", "1111AAA");
        Model.crearCoche("Coche2", "2222BBB");

        ArrayList<Coche> rapidos = Model.listarCochesPorVelocidad(100);

        assertTrue(rapidos.isEmpty());
    }

    // Tests para el Controller
    @Test
    public void testControllerCrearCoche() {
        Coche c = Controller.crearCocheC("Peugeot 308", "8888PPP");

        assertNotNull(c);
        assertEquals("Peugeot 308", c.modelo);
        assertEquals("8888PPP", c.matricula);
    }

    @Test
    public void testControllerMostrarVelocidad() {
        Controller.crearCocheC("Fiat 500", "9999FFF");
        Controller.cambiarVelocidadC("9999FFF", 75);
        int velocidad = Controller.mostrarVelocidadC("9999FFF");

        assertEquals(75, velocidad);
    }









    @Test
    void velocidadInvalida() {

        Model noValido = new Model();
        assertEquals(-1, noValido.disminuirV("uisgfj",12));
    }

    @Test
    void crearCoche2() {
        Coche coche = Model.crearCoche("Ferrari" ,"12345pa");
        assertEquals("Ferrari", coche.modelo);
        assertEquals("12345pa", coche.matricula);
    }
}









