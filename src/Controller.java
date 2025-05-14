import java.lang.module.ModuleDescriptor;

public class Controller {
    public static Coche crearCocheC(String modelo, String matricula) {
        return Model.crearCoche(modelo, matricula);
    }

    public static void mostrarCochesC() {
        for (Coche coche : Model.parking) {
            View.mostrarCoche(coche);
        }
    }

    public static void inicioC() {
        Model.crearCoche("asd", "123po");
        Model.crearCoche("qwe", "098z");
        Model.crearCoche("zxc", "456x");
    }

    public static int cambiarVelocidadC(String matricula, int velocidad) {
        return Model.cambiarVelocidad(matricula, velocidad);
    }

    public static int mostrarVelocidadC(String matricula) {
        return Model.getVelocidad(matricula);
    }
}


/*
        // Crear tres coches
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


