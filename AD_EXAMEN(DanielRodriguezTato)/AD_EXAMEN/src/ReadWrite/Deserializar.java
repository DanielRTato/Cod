package ReadWrite;

import Model.Animal;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class Deserializar {

    public static void deserializarAnimal (String ruta) {
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ruta))) {

            List<Animal> listaAnimais = (List<Animal>)  ois.readObject();
            System.out.println("Deserializacion correcta");

            for (Animal a : listaAnimais){
                System.out.println(a);
            }
        } catch (IOException | ClassNotFoundException e ) {
            System.out.println("Error al deserializar: " + e.getMessage());
        }
    }
}
