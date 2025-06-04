public class DepositoObserver {
    final static int MINIMO = 10; // el nivel minimo para que salte la alerta
    /**
     * Se ejecuta cuando cambia el nivel del depósito de un coche.
     * @param coche ek cocoche que ha cambiado de depósito
     */
    public static void update(Coche coche) {
        if (coche.deposito < MINIMO) {
            // Avisamos de que el depósito está bajo
            View.alertaRepostar(coche.matricula, coche.deposito);
        }
    }
}
