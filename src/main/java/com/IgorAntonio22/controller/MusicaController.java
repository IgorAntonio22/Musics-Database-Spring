package com.IgorAntonio22.controller;

import com.IgorAntonio22.model.Musica;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.IgorAntonio22.service.MusicaService;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class MusicaController {

    @Autowired
    MusicaService musicaService;

    @PostMapping(value = "/musica", name = "incluirMusica")
    void incluirMusica(@RequestBody Musica musica) {
        musicaService.cadastrarMusica(musica.getNome().toLowerCase(), musica.getArtista().getNome().toLowerCase());
    }

    @GetMapping(value = "/musica", name = "getMusicas")
    List<Musica> getMusicas() {
        return musicaService.listarMusicas();
    }


    @GetMapping(value = "/musica/{nomeDoArtista}", name = "getMusicas")
    List<Musica> getMusicasPeloNomeDoArtista(@PathVariable String nomeDoArtista) {
       return musicaService.buscaMusicaPorArtista(nomeDoArtista);
    }
}
