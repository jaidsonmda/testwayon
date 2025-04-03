package dev.jaidson;

import java.util.Objects;

class Pessoa {
    private String nome;
    private int cpf;

    public Pessoa(String nome, int cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // Comparação com a própria instância
        if (obj == null || getClass() != obj.getClass()) return false; // Verifica o tipo de classe

        Pessoa pessoa = (Pessoa) obj;
        return cpf == pessoa.cpf && Objects.equals(nome, pessoa.nome); // Compara os atributos relevantes
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, cpf); // Gera um código hash baseado nos atributos
    }
}
