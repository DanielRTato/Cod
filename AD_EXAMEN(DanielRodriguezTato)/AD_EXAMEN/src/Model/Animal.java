package Model;

import java.io.Serializable;

public class Animal implements Serializable {
    private int id;
    private String nome;
    private String especie;
    private int cantidade;

    public Animal(int id, String nome, String especie, int cantidade) {
        this.id = id;
        this.nome = nome;
        this.especie = especie;
        this.cantidade = cantidade;
    }

    public Animal(String nome, String especie, int cantidade) {
        this.nome = nome;
        this.especie = especie;
        this.cantidade = cantidade;
    }

    public Animal(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", especie='" + especie + '\'' +
                ", cantidade=" + cantidade +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public int getCantidade() {
        return cantidade;
    }

    public void setCantidade(int cantidade) {
        this.cantidade = cantidade;
    }
}
