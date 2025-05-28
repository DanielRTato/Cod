import java.util.Scanner;

public class View {

    public static void mostrarCoche(Coche aux) {
        System.out.println("Modelo: " + aux.modelo + "matricula: " + aux.matricula);
    }

    public static void menu() {
        Scanner teclado = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Elige una opción:");
            System.out.println("0. Mostrar coches");
            System.out.println("1. Crear coche");
            System.out.println("2. Cambiar velocidad");
            System.out.println("3. Mostrar velocidad");
            System.out.println("4. Salir");
            System.out.println("5. Avanzar coche");

            opcion = teclado.nextInt();
            teclado.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 0:
                    System.out.println("Mostrando coches:");
                    Controller.mostrarCochesC();
                    break;

                case 1:
                    System.out.println("Introduce el modelo:");
                    String modelo = teclado.nextLine();
                    System.out.println("Introduce la matrícula:");
                    String matricula = teclado.nextLine();
                    Coche aux1 = Controller.crearCocheC(modelo, matricula, 0, 50);
                    View.mostrarCoche(aux1);
                    if (aux1!= null) mostrarCoche(aux1);
                    else System.out.println("Parametros no validos");
                    break;

                case 2:
                    System.out.println("Introduce la matrícula:");
                    matricula = teclado.nextLine();
                    System.out.println("Introduce la nueva velocidad:");
                    int nvelocidad = teclado.nextInt();
                    if (Controller.cambiarVelocidadC(matricula, nvelocidad) != -1) {
                        System.out.println("Velocidad cambiada correctamente.");
                    } else {
                        System.out.println("Coche no encontrado.");
                    }
                    break;

                case 3:
                    System.out.println("Introduce la matrícula del coche:");
                    matricula = teclado.nextLine();
                    int velocidad = Controller.mostrarVelocidadC(matricula);
                    if (velocidad != -1) {
                        System.out.println("La velocidad del coche es: " + velocidad + " km/h");
                    } else {
                        System.out.println("Coche no encontrado.");
                    }
                    break;

                case 4:
                    System.out.println("Saliendo...");
                    break;

                case 5:
                    System.out.println("Introduce la matrícula del coche:");
                    matricula = teclado.nextLine();
                    System.out.println("Introduce la distancia a avanzar (en metros):");
                    int metros = teclado.nextInt();
                    Controller.avanzarC(matricula, metros);
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 4);
    }

    /**
     * Muestra la velocidad de un coche
     * @param matricula
     * @param v
     * @return true si la velocidad se muestra correctamente
     */
    public static boolean muestraVelocidad(String matricula, Integer v) {
        System.out.println(matricula + ": " + v + " km/h");
        return true;
    }
}