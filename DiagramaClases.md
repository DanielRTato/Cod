````mermaid
classDiagram
    class App {
        +main(String[] args)
    }

    class Controller {
        +inicioC()
        +eliminarCocheC(String matricula) : boolean
        +buscarCocheC(String matricula)
        +listarCochesPorVelocidadC(int velocidadMinima)
    }

    class View {
        +menu()
        +mostrarCoche(Coche coche)
    }

    class Model {
        +crearCoche(String modelo, String matricula) : Coche
        +getCoche(String matricula) : Coche
        +cambiarVelocidad(String matricula, int v) : int
        +getVelocidad(String matricula) : int
        +aumentarV(String matricula, Integer v) : int
        +disminuirV(String matricula, Integer v) : int
        +eliminarCoche(String matricula) : boolean
        +listarCochesPorVelocidad(int velocidadMinima) : ArrayList~Coche~
    }

    class Coche {
        -String modelo
        -String matricula
        -int velocidad
    }

    App --> Controller
    App --> View
    Controller --> Model
    Model --> Coche
````