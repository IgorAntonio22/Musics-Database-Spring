package com.IgorAntonio22.service;

import com.IgorAntonio22.model.Artista;
import com.IgorAntonio22.repository.ArtistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArtistaService {

    @Autowired
    ArtistaRepository artistaRepository;

    public void cadastrarArtista(String nome, String tipo) {
        Artista artista = new Artista();
        artista.setNome(nome);
        artista.setTipo(tipo);

        artistaRepository.save(artista);
    }

    public String pesquisarDadosSobreUmArtista(String nome) {
        var dados = ConsultaChatGPT.obterDadosSobreUmArtista(nome);
        System.out.println("Dados sobre o artista" + dados);
        return dados;
    }

}
