package com.filmes.models;

import javax.persistence.*;

@Entity
public class Filme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int ano;
    private int tempo;
    private String nome;
    private String banner;
    private String genero;
    private String diretor;

    public Filme() {
    }

    public Filme(int ano, int tempo, String nome, String banner, String genero, String diretor) {
        this.ano = ano;
        this.tempo = tempo;
        this.nome = nome;
        this.banner = banner;
        this.genero = genero;
        this.diretor = diretor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getTempo() {
        return tempo;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    @Override
    public String toString() {
        return "Filme{" +
                "id=" + id +
                ", ano=" + ano +
                ", tempo=" + tempo +
                ", nome='" + nome + '\'' +
                ", banner='" + banner + '\'' +
                ", genero='" + genero + '\'' +
                ", diretor='" + diretor + '\'' +
                '}';
    }
}
