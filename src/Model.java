import java.util.ArrayList;

public class Model {
    static ArrayList<Coche> parking = new ArrayList<>();

    /**
     * Crea un nuevo coche en el parking
     * @param modelo
     * @param matricula
     * @return el Coche
     */
    public static Coche crearCoche(String modelo, String matricula) {
        Coche aux = new Coche(modelo, matricula);
        parking.add(aux);
        return aux;
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

    /**
     * Elimina un coche del parking
     * @param matricula
     * @return true si se eliminó, false si no se encontró
     */
    public static boolean eliminarCoche(String matricula) {
        Coche coche = getCoche(matricula);
        if (coche != null) {
            parking.remove(coche);
            return true;
        }
        return false;
    }

    /**
     * Lista los coches con velocidad superior a un valor dado
     * @param velocidadMinima
     * @return lista de coches que cumplen la condición
     */
    public static ArrayList<Coche> listarCochesPorVelocidad(int velocidadMinima) {
        ArrayList<Coche> resultado = new ArrayList<>();
        for (Coche coche : parking) {
            if (coche.velocidad > velocidadMinima) {
                resultado.add(coche);
            }
        }
        return resultado;
    }

}