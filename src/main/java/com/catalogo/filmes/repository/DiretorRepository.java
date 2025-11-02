package com.catalogo.filmes.repository;

import com.catalogo.filmes.model.Diretor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiretorRepository extends JpaRepository<Diretor, Long> {
}
