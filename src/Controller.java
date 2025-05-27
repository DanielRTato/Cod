import java.lang.module.ModuleDescriptor;
import java.util.ArrayList;

public class Controller {
    /**
     * Crea un nuevo coche en el parking
     * @param modelo
     * @param matricula identificador unico del coche
     * @return el Coche
     */
    public static Coche crearCocheC(String modelo, String matricula) {
        return Model.crearCoche(modelo, matricula);
    }

    /**
     * Muestra todos los coches del parking
     */
    public static void mostrarCochesC() {
        for (Coche coche : Model.parking) {
            View.mostrarCoche(coche);
        }
    }

    /**
     * Crea unos coches al iniciarse el programa
     */
    public static void inicioC() {
        Model.crearCoche("asd", "123po");
        Model.crearCoche("qwe", "098z");
        Model.crearCoche("zxc", "456x");
    }

    /**
     * Cambia la velocidad de un coche
     * @param matricula
     * @param velocidad
     * @return la nueva velocidad del coche o -1 si no existe
     */
    public static int cambiarVelocidadC(String matricula, int velocidad) {
        return Model.cambiarVelocidad(matricula, velocidad);
    }

    /**
     * Muestra la velocidad de un coche
     * @param matricula
     * @return la velocidad del coche
     */
    public static int mostrarVelocidadC(String matricula) {
        return Model.getVelocidad(matricula);
    }

    /**
     * Elimina un coche del parking
     * @param matricula
     * @return true si se eliminó, false si no se encontró
     */
    public static boolean eliminarCocheC(String matricula) {
        return Model.eliminarCoche(matricula);
    }

    /**
     * Busca un coche por matrícula y lo muestra
     * @param matricula
     */
    public static void buscarCocheC(String matricula) {
        Coche coche = Model.getCoche(matricula);
        if (coche != null) {
            View.mostrarCoche(coche);
        } else {
            System.out.println("Coche no encontrado.");
        }
    }

    /**
     * Lista los coches con velocidad superior a un valor dado
     * @param velocidadMinima
     */
    public static void listarCochesPorVelocidadC(int velocidadMinima) {
        ArrayList<Coche> coches = Model.listarCochesPorVelocidad(velocidadMinima);
        if (!coches.isEmpty()) {
            for (Coche coche : coches) {
                View.mostrarCoche(coche);
            }
        } else {
            System.out.println("No hay coches con velocidad superior a " + velocidadMinima + " km/h.");
        }
    }

}


/*
         Crear tres coches
        Model.crearCoche("LaFerrari", "SBC 1234");
        Model.crearCoche("Alpine", "HYU 4567");
        Model.crearCoche("Aston Martin", "FGH 3333");

        Coche ferrari = Model.getCoche("SBC 1234");
        // modifica la velocidad
        int nuevaVelocidad = Model.cambiarVelocidad("SBC 1234", 30);

        // recoje la velocidad y la muestra (tarea de la View)
        boolean hecho = View.muestraVelocidad("SBC 1234", Model.getVelocidad("SBC 1234"));

        if (hecho) {
            System.out.println("Correcto");
        } else {
            System.out.println("Error");
        }

        int velocidadActual = Model.aumentarV("SBC 1234", 10);
        Model.disminuirV("SBC 1234", 5);

        if (velocidadActual != -1) {
            System.out.println(Model.getVelocidad("SBC 1234"));
        } else {
            System.out.println("Error");
        }

*/


