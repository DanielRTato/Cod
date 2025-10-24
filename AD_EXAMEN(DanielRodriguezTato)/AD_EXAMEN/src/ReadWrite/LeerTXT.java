package ReadWrite;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LeerTXT {

    public static List<String> getListaNomes(String ruta) {
        List<String> listaNomes = new ArrayList<>();
        File file = new File(ruta);

        if (file.exists()) {
            try {
                BufferedReader br = new BufferedReader(new FileReader(file));
                String linea;
                while ((linea = br.readLine()) != null) {
                    listaNomes.add(linea);
                }
            } catch (IOException e) {
                System.out.println("Error al leer mod.txt: " + e.getMessage());
            }
        }
        return listaNomes;
    }
}
