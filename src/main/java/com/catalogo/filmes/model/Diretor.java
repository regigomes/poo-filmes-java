package com.catalogo.filmes.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("DIRETOR")
@NoArgsConstructor
public class Diretor extends Pessoa {

    public Diretor(String nome) {
        super(nome);
    }
}
