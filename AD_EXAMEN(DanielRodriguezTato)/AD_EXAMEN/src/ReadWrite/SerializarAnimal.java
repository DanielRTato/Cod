package ReadWrite;

import Model.Animal;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class SerializarAnimal {

    public static void serializarAnimaisMod(String ruta, List<Animal> listaAnimais) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ruta))) {
            oos.writeObject(listaAnimais);
            System.out.println("Serialización comnpleta con exito en: " + ruta);

        } catch (IOException e) {
            System.out.println("Error al serializar: " + e.getMessage());

        }
    }


}
