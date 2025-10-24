package DAO;

import Model.Animal;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AnimalDAO {

    public static void insetarAnimal(Animal animal) {
        String consulta = "insert into animais (nome, especie, cantidade) values (?,?,?)";

        try (Connection conn = Conexion.conexion();
             PreparedStatement stmt = conn.prepareStatement(consulta, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, animal.getNome());
            stmt.setString(2, animal.getEspecie());
            stmt.setInt(3, animal.getCantidade());
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                animal.setId(rs.getInt(1));
            }
            System.out.println("Animal " + animal.getNome() + " insertado correctamente");
        } catch (SQLException e) {
            System.out.println("Error al insertar na taboa animais: " + e.getMessage());
        }
    }


    public static List<Animal> obtenerNomeIdAnimais() {
        List<Animal> listaAnimal = new ArrayList<>();
        String consulta = "select * from animais";

        try(Connection conn = Conexion.conexion();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(consulta)) {

            while (rs.next()) {
                Animal animal = new Animal(
                        rs.getInt("id"),
                        rs.getString("nome")
                );
                listaAnimal.add(animal);
            }
        } catch (SQLException e) {
            System.out.println("Error en el select de animais: " + e.getMessage());
        }
        return listaAnimal;
    }

    public static void updateAnimais(Animal animal){
        String consulta = "update animais set cantidade = ? where nome like ?";

        try (Connection conn = Conexion.conexion();
        PreparedStatement stmt = conn.prepareStatement(consulta)) {

            stmt.setInt(1, animal.getCantidade()*3);
            stmt.setString(2, animal.getNome());

            int filas = stmt.executeUpdate();
            if (filas > 0) {
                System.out.println("Animal actualizado correctamente: " + animal.getNome());
            }
        }catch (SQLException e) {
            System.out.println("Error al actualizar el animal: " + e.getMessage());
        }
    }


    public static Animal buscarAnimaisporNome(String nome) {
        List<Animal> listaAnimal = new ArrayList<>();
        String consulta = "select * from animais where nome = ?";

        try(Connection conn = Conexion.conexion();
           PreparedStatement ps = conn.prepareStatement(consulta)) {

            ps.setString(1,nome);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Animal(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("especie"),
                        rs.getInt("cantidade")
                );
            }

        } catch (SQLException e) {
            System.out.println("Error ao buscar animais por nome: " + e.getMessage());
        }
        return null;
    }



    public static List<Animal> obtenerTodoAnimais() {
        List<Animal> listaAnimal = new ArrayList<>();
        String consulta = "select * from animais";

        try(Connection conn = Conexion.conexion();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(consulta)) {

            while (rs.next()) {
                Animal animal = new Animal(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("especie"),
                        rs.getInt("cantidade")
                );
                listaAnimal.add(animal);
            }
        } catch (SQLException e) {
            System.out.println("Error en el select de animais: " + e.getMessage());
        }
        return listaAnimal;
    }}

