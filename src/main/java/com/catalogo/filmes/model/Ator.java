package com.catalogo.filmes.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("ATOR")
@NoArgsConstructor
public class Ator extends Pessoa {

    public Ator(String nome) {
        super(nome);
    }
}
