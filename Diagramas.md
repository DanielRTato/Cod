````mermaid
sequenceDiagram
    participant View
    participant Controller
    participant Model
    View->>Controller: crearCocheC(modelo, matricula)
    Controller->>Model: crearCoche(modelo, matricula)
    Model-->>Controller: Coche
    Controller-->>View: Coche
    View->>View: mostrarCoche(coche)
````
`````mermaid

sequenceDiagram
    participant View
    participant Controller
    participant Model
    View->>Controller: mostrarVelocidadC(matricula)
    Controller->>Model: getVelocidad(matricula)
    Model-->>Controller: velocidad
    Controller-->>View: velocidad
    View->>View: System.out.println(velocidad)
`````