package com.IgorAntonio22.MusicsDatabase;

import com.IgorAntonio22.model.Artista;
import com.IgorAntonio22.model.Musica;
import com.IgorAntonio22.service.ArtistaService;
import com.IgorAntonio22.service.MusicaService;
import com.IgorAntonio22.repository.ArtistaRepository;
import com.IgorAntonio22.repository.MusicaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class MusicaServiceTest {

    @Mock
    private MusicaRepository musicaRepository;

    @Mock
    private ArtistaRepository artistaRepository;

    @Mock
    private ArtistaService artistaService;

    @InjectMocks
    private MusicaService musicaService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCadastrarMusica_ExistenteArtista() {

        String nomeMusica = "Musica Teste";
        String nomeArtista = "Artista Teste";
        Artista artistaExistente = new Artista();
        artistaExistente.setNome(nomeArtista);

        when(artistaRepository.encontrarArtistaPeloNome(nomeArtista)).thenReturn(artistaExistente);

        musicaService.cadastrarMusica(nomeMusica, nomeArtista);

        verify(musicaRepository, times(1)).save(any(Musica.class));
    }

    @Test
    public void testCadastrarMusica_NovoArtista() {

        String nomeMusica = "Musica Teste";
        String nomeArtista = "Artista Novo";
        String tipoArtista = "Tipo Novo";

        when(artistaRepository.encontrarArtistaPeloNome(nomeArtista)).thenReturn(null);
        doNothing().when(artistaService).cadastrarArtista(nomeArtista, tipoArtista);
        when(artistaRepository.encontrarArtistaPeloNome(nomeArtista)).thenReturn(new Artista());

        musicaService.cadastrarMusica(nomeMusica, nomeArtista);

        verify(musicaRepository, times(1)).save(any(Musica.class));
    }

    @Test
    public void testListarMusicas() {

        List<Musica> musicasMock = new ArrayList<>();
        musicasMock.add(new Musica());
        musicasMock.add(new Musica());


        when(musicaRepository.findAll()).thenReturn(musicasMock);

        List<Musica> musicasRetornadas = musicaService.listarMusicas();

        assertEquals(musicasMock.size(), musicasRetornadas.size());
    }

}

