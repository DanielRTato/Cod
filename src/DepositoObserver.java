public class DepositoObserver {
    final static int MINIMO = 10; // el nivel minimo para que salte la alerta
    /**
     * @param coche ek cocoche que ha cambiado de depósito
     * Comprueba si el depósito está por debajo del mínimo y, si es así, muestra una alerta.
     */
    public static void update(Coche coche) {
        if (coche.deposito < MINIMO) {
            // Avisamos de que el depósito está bajo
            View.alertaRepostar(coche.matricula, coche.deposito);
        }
    }
}
