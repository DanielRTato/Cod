````mermaid
sequenceDiagram
    participant Usuario
    participant View
    participant Controller
    participant Model

    Usuario->>View: Selecciona opción "Eliminar coche"
    View->>Usuario: Solicita matrícula
    Usuario->>View: Proporciona matrícula
    View->>Controller: eliminarCocheC(matrícula)
    Controller->>Model: eliminarCoche(matrícula)
    Model-->>Controller: true/false
    Controller-->>View: Resultado de eliminación
    View-->>Usuario: Muestra mensaje de éxito o error

    Usuario->>View: Selecciona opción "Buscar coche"
    View->>Usuario: Solicita matrícula
    Usuario->>View: Proporciona matrícula
    View->>Controller: buscarCocheC(matrícula)
    Controller->>Model: getCoche(matrícula)
    Model-->>Controller: Coche/null
    Controller-->>View: Coche encontrado o no
    View-->>Usuario: Muestra detalles o mensaje de error

    Usuario->>View: Selecciona opción "Listar coches por velocidad"
    View->>Usuario: Solicita velocidad mínima
    Usuario->>View: Proporciona velocidad mínima
    View->>Controller: listarCochesPorVelocidadC(velocidadMinima)
    Controller->>Model: listarCochesPorVelocidad(velocidadMinima)
    Model-->>Controller: Lista de coches
    Controller-->>View: Lista de coches
    View-->>Usuario: Muestra lista o mensaje de error


````

````mermaid
sequenceDiagram
    participant View
    participant Controller
    participant Model

    View->>Controller: eliminarCocheC(matrícula)
    Controller->>Model: eliminarCoche(matrícula)
    Model-->>Controller: true/false
    Controller-->>View: Resultado de eliminación
    View-->>View: Muestra mensaje de éxito o error

    View->>Controller: buscarCocheC(matrícula)
    Controller->>Model: getCoche(matrícula)
    Model-->>Controller: Coche/null
    Controller-->>View: Coche encontrado o no
    View-->>View: Muestra detalles o mensaje de error

    View->>Controller: listarCochesPorVelocidadC(velocidadMinima)
    Controller->>Model: listarCochesPorVelocidad(velocidadMinima)
    Model-->>Controller: Lista de coches
    Controller-->>View: Lista de coches
    View-->>View: Muestra lista o mensaje de error
````

````mermaid
sequenceDiagram
    participant View
    participant Controller
    participant Model

    activate View
    View->>Controller: eliminarCocheC(matrícula)
    activate Controller
    Controller->>Model: eliminarCoche(matrícula)
    activate Model
    Model-->>Controller: true/false
    deactivate Model
    Controller-->>View: Resultado de eliminación
    deactivate Controller
    View-->>View: Muestra mensaje de éxito o error
    deactivate View

    activate View
    View->>Controller: buscarCocheC(matrícula)
    activate Controller
    Controller->>Model: getCoche(matrícula)
    activate Model
    Model-->>Controller: Coche/null
    deactivate Model
    Controller-->>View: Coche encontrado o no
    deactivate Controller
    View-->>View: Muestra detalles o mensaje de error
    deactivate View

    activate View
    View->>Controller: listarCochesPorVelocidadC(velocidadMinima)
    activate Controller
    Controller->>Model: listarCochesPorVelocidad(velocidadMinima)
    activate Model
    Model-->>Controller: Lista de coches
    deactivate Model
    Controller-->>View: Lista de coches
    deactivate Controller
    View-->>View: Muestra lista o mensaje de error
    deactivate View
````
