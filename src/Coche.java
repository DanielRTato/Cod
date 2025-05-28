public class Coche {
    String matricula;
    String modelo;
    Integer velocidad;
    int distanciaActual;
    int deposito;

    public Coche(String modelo, String matricula, int distanciaActual, int deposito) {
        this.modelo = modelo;
        this.matricula = matricula;
        this.velocidad = 0;
        this.distanciaActual = distanciaActual;
        this.deposito = deposito;

    }

    @Override
    public String toString() {
        return "Coche{" +
                "matricula='" + matricula + '\'' +
                ", modelo='" + modelo + '\'' +
                ", velocidad=" + velocidad +
                '}';
    }
}
