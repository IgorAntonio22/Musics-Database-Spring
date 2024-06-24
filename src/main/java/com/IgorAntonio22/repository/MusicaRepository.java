package com.IgorAntonio22.repository;

import com.IgorAntonio22.model.Musica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MusicaRepository extends JpaRepository<Musica, Long> {

    @Query("SELECT m FROM Musica m JOIN FETCH m.artista WHERE LOWER(m.artista.nome) = LOWER(:nomeDoArtista)")
    List<Musica> listaMusicasPeloNomeDoArtista(@Param("nomeDoArtista") String nomeDoArtista);

    @Query("SELECT m FROM Musica m JOIN FETCH m.artista")
    List<Musica> findAllMusicasWithArtista();
}
