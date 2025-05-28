import java.util.ArrayList;

public class Model {
    static ArrayList<Coche> parking = new ArrayList<>();

    /**
     * Crea un nuevo coche en el parking
     * @param modelo
     * @param matricula
     * @return el Coche
     */
    public static Coche crearCoche(String modelo, String matricula, int distanciaActual, int deposito) {
        Coche aux = new Coche(modelo, matricula, distanciaActual, deposito);
        parking.add(aux);
        return aux;
    }

    //FUNCIONALIDADES DEL EXAMEN
    /**
     * Avanza un coche la distancia indicada por los metros introducidos
     * @param matricula
     * @param metros
     */
    public static void avanzarC(String matricula, int metros) {
        Coche coche = getCoche(matricula);
        if (coche != null && metros > 0) {
            coche.distanciaActual += metros;
            coche.deposito = coche.deposito - (metros / 4 );  // Aqui simulo que el coche tiene un consumo de 1litro por cada 4 metros
            System.out.println("El coche " + matricula + " ha avanzado " + metros + " metros.");
        } else {
            System.out.println("Coche no encontrado.");
        }


    }



    /**
     * Obtiene un coche de la lista de coches del parking
     * @param matricula
     * @return el Coche o null si no existe
     */
    public static Coche getCoche(String matricula) {
        for (Coche e : parking) {
            if (e.matricula.equals(matricula)) {
                return e;
            }
        }
        return null;
    }

    /**
     * Cambia la velocidad de un coche
     * @param matricula
     * @param v
     * @return la nueva velocidad del coche o -1 si no existe
     */
    public static int cambiarVelocidad(String matricula, int v) {
        Coche coche = getCoche(matricula);
        if (coche != null) {
            coche.velocidad = v;
            return coche.velocidad;
        }
        return -1;
    }

    /**
     * Obtiene la velocidad de un coche
     * @param matricula
     * @return la velocidad del coche o -1 si no existe
     */
    public static int getVelocidad(String matricula) {
        Coche coche = getCoche(matricula);
        return coche != null ? coche.velocidad : -1;
    }

    /**
     * Aumenta la velocidad de un coche
     * @param matricula
     * @param v
     * @return la nueva velocidad del coche o -1 si no existe
     */
    public static int aumentarV(String matricula, Integer v) {
        Coche coche = getCoche(matricula);
        if (coche != null) {
            coche.velocidad += v;
            return coche.velocidad;
        }
        return -1;
    }

    /**
     * Disminuye la velocidad de un coche
     * @param matricula
     * @param v
     * @return la nueva velocidad del coche o -1 si no existe
     */
    public static int disminuirV(String matricula, Integer v) {
        Coche coche = getCoche(matricula);
        if (coche != null) {
            coche.velocidad -= v;
            return coche.velocidad;
        }
        return -1;
    }
}