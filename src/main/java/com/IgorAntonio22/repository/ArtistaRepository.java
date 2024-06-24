package com.IgorAntonio22.repository;

import com.IgorAntonio22.model.Artista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistaRepository extends JpaRepository<Artista, Long> {

    @Query("select a from Artista a WHERE LOWER(a.nome) = LOWER(:nome)")
    Artista encontrarArtistaPeloNome(@Param("nome") String nome);
}
