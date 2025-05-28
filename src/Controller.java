import java.lang.module.ModuleDescriptor;

public class Controller {
    /**
     * Crea un nuevo coche en el parking
     * @param modelo
     * @param matricula
     * @return el Coche
     */
    public static Coche crearCocheC(String modelo, String matricula, int distanciaActual, int deposito) {
        return Model.crearCoche(modelo, matricula, distanciaActual, deposito);
    }

    // FUNCIONES DEL EXAMEN
    /**
     * Avanza un coche la distancia indicada por los metros introducidos
     * @param matricula
     * @param metros
     */
    public static void avanzarC(String matricula, int metros) {
        Model.avanzarC(matricula, metros);
    }

    /**
     * Repostar gasolina a un coche
     * @param matricula identificador unico del coche
     * @param litros cantidad a repostar
     * @return la cantidad actual del deposito del coche
     */
    public static int ponerGasolinaC(String matricula, int litros) {
        return Model.ponerGasolinaM(matricula, litros);
    }
    // FIN DE LAS FUNCIONES DEL EXAMEN



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
    public void inicioC() {
        Model.crearCoche("asd", "123po", 0, 50);
        Model.crearCoche("qwe", "098z", 100, 60);
        Model.crearCoche("zxc", "456x", 200, 70);
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


