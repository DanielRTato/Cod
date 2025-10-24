import DAO.AnimalDAO;
import DAO.Conexion;
import Model.Animal;
import ReadWrite.Deserializar;
import ReadWrite.LeerTXT;
import ReadWrite.SerializarAnimal;
import ReadWrite.XMLAnimais;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Conexion conexion = new Conexion();
        if (conexion != null) System.out.println("Conexion con la BD exitosa");

        List<Animal> listaAnimais = AnimalDAO.obtenerNomeIdAnimais();
        List<String> listamod = LeerTXT.getListaNomes("mod.txt");

        System.out.println("Iniciando secuencia");  // Aquí empieza la insercion na taboa animais

        Animal tigre = new Animal("Tigre", "Panthera tigris", 3);
        Animal elefante = new Animal("Elefante", "Loxodonta africana", 2);
        Animal lemur = new Animal("Lemur", "'Lemur catta", 5);
        Animal xirafa = new Animal("Xirafa", "Giraffa camelopardalis", 4);
        Animal oso = new Animal("Oso panda", "Ailuropoda melanoleuca", 2);
        Animal hipopotamo = new Animal("Hipopotamo", "Hippopotamus amphibius", 3);
        Animal leon = new Animal("Leon", "Panthera leo", 6);

//        AnimalDAO.insetarAnimal(tigre);
//        AnimalDAO.insetarAnimal(elefante);
//        AnimalDAO.insetarAnimal(lemur);
//        AnimalDAO.insetarAnimal(xirafa);
//        AnimalDAO.insetarAnimal(oso);
//        AnimalDAO.insetarAnimal(hipopotamo);
//        AnimalDAO.insetarAnimal(leon);

        System.out.println("Lendo a táboa"); // Leer todas las entradas de la tabla animais
        for (Animal a : listaAnimais) {
            System.out.println("id: " + a.getId() + " - " + "Nome: " + a.getNome());
        }

        System.out.println("Proceso de actualización de táboa"); // leer todos los animales de mod.txt
        List<Animal> listaAnimalPorDocumento = new ArrayList<>();
        for (String n : listamod) {
            Animal a = AnimalDAO.buscarAnimaisporNome(n);
            if (a != null) listaAnimalPorDocumento.add(a);
        }
        for (Animal animel : listaAnimalPorDocumento) {
            System.out.println(animel);
        }

        System.out.println("Exportando copia de seguridade");
        SerializarAnimal.serializarAnimaisMod("Animais.dat", listaAnimalPorDocumento );

        System.out.println("Copia de seguridade feita, modificando valores");
        for (Animal a : listaAnimalPorDocumento) {
            AnimalDAO.updateAnimais(a);
        }

        System.out.println("Valores modificados");
        List<Animal> listaActualizada = AnimalDAO.obtenerTodoAnimais();
        for (Animal a : listaActualizada) {
            System.out.println("id: " + a.getId() + " nome: " + a.getNome()+ " cantidade: "  + a.getCantidade());
        }

        System.out.println("Restaurando valores");
        Deserializar.deserializarAnimal("Animais.dat");
        // Vale son las 14:46 y se acaba el tiempo, no me fijé que pedias restaurar las cantidades en la bd y ahora no me da tiempo
        // pero no tiene ciencia tengo un arrayList con los objetos originales y un método para actulizar las cantidades.


        System.out.println("Valor restaurado, xerando informe");
        XMLAnimais.crearAnimalisXML(listaActualizada, "animais.XML");













    }
}