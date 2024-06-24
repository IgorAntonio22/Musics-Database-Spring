package com.IgorAntonio22.MusicsDatabase;

import com.IgorAntonio22.model.Artista;
import com.IgorAntonio22.repository.ArtistaRepository;
import com.IgorAntonio22.service.ConsultaChatGPT;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import com.IgorAntonio22.service.ArtistaService;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ArtistaServiceTest {

    @Mock
    private ArtistaRepository artistaRepository;

    @InjectMocks
    private ArtistaService artistaService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCadastrarArtista() {
        // Mocking data
        String nome = "Artista Teste";
        String tipo = "Tipo Teste";

        Artista artista = new Artista();
        artista.setNome(nome);
        artista.setTipo(tipo);

        // Configuring mock behavior
        when(artistaRepository.save(any(Artista.class))).thenReturn(artista);

        // Calling the method to be tested
        artistaService.cadastrarArtista(nome, tipo);

        // Verifying that save method was called once
        verify(artistaRepository, times(1)).save(any(Artista.class));
    }

    @Test
    public void testPesquisarDadosSobreUmArtista() {

        String nome = "Artista Teste";
        String dadosEsperados = "Dados do artista";

        when(ConsultaChatGPT.obterDadosSobreUmArtista(nome)).thenReturn(dadosEsperados);

        String dadosRetornados = artistaService.pesquisarDadosSobreUmArtista(nome);

        assertEquals(dadosEsperados, dadosRetornados);
    }
}


