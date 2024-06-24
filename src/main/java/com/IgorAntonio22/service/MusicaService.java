package com.IgorAntonio22.service;

import com.IgorAntonio22.model.Artista;
import com.IgorAntonio22.model.Musica;
import com.IgorAntonio22.repository.ArtistaRepository;
import com.IgorAntonio22.repository.MusicaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

@Service
public class MusicaService {

    private Scanner leitura = new Scanner(System.in);
    @Autowired
    MusicaRepository musicaRepository;

    @Autowired
    ArtistaRepository artistaRepository;

    @Autowired
    ArtistaService artistaService;

    @Transactional
    public void cadastrarMusicas(String nomeDaMusica, String nomeDoArtista) {

        Artista artista = artistaRepository.encontrarArtistaPeloNome(nomeDoArtista);

        if (artista != null) {

            Musica musica = new Musica();
            musica.setNome(nomeDaMusica);
            musica.setArtista(artista);
            musicaRepository.save(musica);
        } else {

            System.out.println("Esse Artista não existe no Banco de dados!");
            System.out.println("Digite o Tipo do artista para cadastrá-lo junto com a música: ");
            String tipoDoArtista = leitura.nextLine();

            artistaService.cadastrarArtista(nomeDoArtista, tipoDoArtista);


            artista = artistaRepository.encontrarArtistaPeloNome(nomeDoArtista);

            Musica musica = new Musica();
            musica.setNome(nomeDaMusica);
            musica.setArtista(artista);
            musicaRepository.save(musica);
        }
    }

    @Transactional
    public void cadastrarMusica(String nomeDaMusica, String nomeDoArtista) {
        Artista artista = artistaRepository.encontrarArtistaPeloNome(nomeDoArtista);

        if (artista != null) {

            Musica musica = new Musica();
            musica.setNome(nomeDaMusica);
            musica.setArtista(artista);
            musicaRepository.save(musica);
        } else {

            String tipoDoArtista = "default";

            artistaService.cadastrarArtista(nomeDoArtista, tipoDoArtista);

            artista = artistaRepository.encontrarArtistaPeloNome(nomeDoArtista);

            Musica musica = new Musica();
            musica.setNome(nomeDaMusica);
            musica.setArtista(artista);
            musicaRepository.save(musica);
        }
    }


    public List<Musica> listarMusicas() {
        return musicaRepository.findAll().stream().map(musica -> {
            Musica m = new Musica();
            m.setId(musica.getId());
            m.setNome(musica.getNome());
            m.setArtista(musica.getArtista());
            return m;
        }).collect(Collectors.toList());
    }

    public void listaMusicas() {
        List<Musica> musicas = musicaRepository.findAll();
        System.out.println(musicas);
    }
    public void buscarMusicasPorArtistas(String nomeDoArtista) {
        List<Musica> musicas = musicaRepository.listaMusicasPeloNomeDoArtista(nomeDoArtista);

        if(!musicas.isEmpty()) {
            System.out.println(musicas);
        } else {
            System.out.println("Gostaria de cadastrar esse Artista? (Sim, Não)");
            var resposta = leitura.nextLine();
            if(resposta.equalsIgnoreCase("sim")) {
                System.out.println("Digite o tipo do artista: ");
                var tipoDoArtista = leitura.nextLine();
                Artista artista = new Artista();
                artista.setNome(nomeDoArtista);
                artista.setTipo(tipoDoArtista);

                artistaRepository.save(artista);
                System.out.println("Artista cadastrado com sucesso!");
            } else {
                System.out.println("Saindo...");
            }
        }
    }

    public List<Musica> buscaMusicaPorArtista(String nomeDoArtista) {
        List<Musica> musicas = musicaRepository.listaMusicasPeloNomeDoArtista(nomeDoArtista);
        return musicas;
    }
}
