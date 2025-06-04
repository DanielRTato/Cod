import org.w3c.dom.ls.LSOutput;

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
     * Notifica a los observadores del cambio de depósito de un coche
     * @param coche el coche que ha cambiado su depósito
     */
    public static void notifyObserversDeposito(Coche coche) {
        DepositoObserver.update(coche);
    }

    /**
     * Avanza un coche la distancia indicada por los metros introducidos
     * @param matricula identificador unico de cada coche
     * @param metros distancia que avanza el coche
     */
    public static void avanzarM(String matricula, int metros) {
        Coche coche = getCoche(matricula);
        if (coche != null && metros > 0) {
            coche.distanciaActual += metros;
            coche.deposito = coche.deposito - (coche.velocidad * metros) / 100;  // Aqui simulo que a mayor velocidad mayor consumo tiene
            System.out.println("El coche " + matricula + " ha avanzado " + metros + " metros.");
            notifyObserversDeposito(coche); // Avisa al observer del cambio en el depósito
        } else {
            System.out.println("Coche no encontrado.");
        }
    }
    /**
     * Repoene la gasolina de un coche
     * @param matricula identificador unico del coche
     * @param litros cantidad a repostar
     * @return la cantidad actual del deposito del coche
     */
    public static int ponerGasolinaM (String matricula, int litros) {
        Coche coche = getCoche(matricula);

        coche.deposito += litros;
        notifyObserversDeposito(coche); // Avisa al observer del cambio en el depósito
        return coche.deposito;
    }
    // FIN DE LAS FUNCIONALIDADES DEL EXAMEN

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