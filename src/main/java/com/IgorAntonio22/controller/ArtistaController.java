package com.IgorAntonio22.controller;

import com.IgorAntonio22.model.Artista;
import com.IgorAntonio22.repository.ArtistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.IgorAntonio22.service.ArtistaService;

@RestController
@RequestMapping("/api/v1")
public class ArtistaController {

    @Autowired
    ArtistaService artistaService;


    @PostMapping(value = "/artista", name = "postArtista")
    public void incluirArtista(@RequestBody Artista artista) {
        artistaService.cadastrarArtista(artista.getNome().toLowerCase(), artista.getTipo().toLowerCase());
    }

    @GetMapping(value = "/artista/{nome}", name = "getArtista")
    public void getDadosDoArtistaPeloNome(@PathVariable String nome) {
        artistaService.pesquisarDadosSobreUmArtista(nome);
    }
}
