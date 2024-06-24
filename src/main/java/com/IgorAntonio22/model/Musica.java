package com.IgorAntonio22.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name = "musica")
public class Musica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @ManyToOne
    @JoinColumn(name = "artista_id")
    @JsonIgnoreProperties("musicas")
    private Artista artista;
    public Musica() {

    }

    public Musica(String nome_da_música, Artista nome_do_artista) {
        this.nome = nome_da_música;
        this.artista = nome_do_artista;
    }

    public Musica(long l, String s, Artista artista) {

    }

    public Musica(String s) {
        this.nome = s;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    @Override
    public String toString() {
        return String.format("Musica{id=%d, nome='%s', artistaNome='%s, artistaId=%d'}", id, nome, artista.getNome(), artista.getId());
    }
}
