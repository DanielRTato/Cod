package ReadWrite;

import Model.Animal;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileWriter;
import java.util.List;

public class XMLAnimais {

    public static void crearAnimalisXML(List<Animal> listaAnimal, String ruta) {
        try {
            XMLOutputFactory factory = XMLOutputFactory.newFactory();
            XMLStreamWriter writer = factory.createXMLStreamWriter(new FileWriter(ruta));

            writer.writeStartDocument("1.0");
            writer.writeStartElement("Animais");

            for (Animal animal : listaAnimal) {
                writer.writeStartElement("animal");
                writer.writeAttribute("id", String.valueOf(animal.getId()));

                writer.writeStartElement("nome");
                writer.writeCharacters(animal.getNome());
                writer.writeEndElement();

                writer.writeStartElement("especie");
                writer.writeCharacters(animal.getEspecie());
                writer.writeEndElement();

                writer.writeStartElement("cantidade");
                writer.writeCharacters(String.valueOf(animal.getCantidade()));
                writer.writeEndElement();

                writer.writeEndElement(); // </animal>
            }

            writer.writeEndElement(); // </animais>
            writer.writeEndDocument();
            writer.flush();
            writer.close();

            System.out.println("Archivo Xml creado correctamente");


        }catch (Exception e) {
            System.out.println("Error al crear el XMl: " + e.getMessage());
        }
    }
}
