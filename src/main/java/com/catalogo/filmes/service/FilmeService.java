package com.catalogo.filmes.service;

import com.catalogo.filmes.dto.FilmeDTO;
import com.catalogo.filmes.exception.ResourceNotFoundException;
import com.catalogo.filmes.model.Ator;
import com.catalogo.filmes.model.Diretor;
import com.catalogo.filmes.model.Filme;
import com.catalogo.filmes.repository.AtorRepository;
import com.catalogo.filmes.repository.DiretorRepository;
import com.catalogo.filmes.repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FilmeService {

    @Autowired
    private FilmeRepository filmeRepository;

    @Autowired
    private DiretorRepository diretorRepository;

    @Autowired
    private AtorRepository atorRepository;

    public List<FilmeDTO> findAll() {
        return filmeRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public FilmeDTO findById(Long id) {
        Filme filme = filmeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Filme não encontrado com id: " + id));
        return convertToDTO(filme);
    }

    @Transactional
    public FilmeDTO create(FilmeDTO filmeDTO) {
        Filme filme = convertToEntity(filmeDTO);
        Filme savedFilme = filmeRepository.save(filme);
        return convertToDTO(savedFilme);
    }

    @Transactional
    public FilmeDTO update(Long id, FilmeDTO filmeDTO) {
        Filme filme = filmeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Filme não encontrado com id: " + id));

        filme.setTitulo(filmeDTO.getTitulo());
        filme.setDataLancamento(filmeDTO.getDataLancamento());
        filme.setOrcamento(filmeDTO.getOrcamento());
        filme.setDescricao(filmeDTO.getDescricao());

        if (filmeDTO.getDiretorId() != null) {
            Diretor diretor = diretorRepository.findById(filmeDTO.getDiretorId())
                    .orElseThrow(() -> new ResourceNotFoundException("Diretor não encontrado"));
            filme.setDiretor(diretor);
        }

        if (filmeDTO.getAtoresIds() != null) {
            List<Ator> atores = atorRepository.findAllById(filmeDTO.getAtoresIds());
            filme.setAtores(atores);
        }

        Filme updatedFilme = filmeRepository.save(filme);
        return convertToDTO(updatedFilme);
    }

    @Transactional
    public FilmeDTO partialUpdate(Long id, FilmeDTO filmeDTO) {
        Filme filme = filmeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Filme não encontrado com id: " + id));

        if (filmeDTO.getTitulo() != null && !filmeDTO.getTitulo().isEmpty()) {
            filme.setTitulo(filmeDTO.getTitulo());
        }
        if (filmeDTO.getDataLancamento() != null) {
            filme.setDataLancamento(filmeDTO.getDataLancamento());
        }
        if (filmeDTO.getOrcamento() != null) {
            filme.setOrcamento(filmeDTO.getOrcamento());
        }
        if (filmeDTO.getDescricao() != null) {
            filme.setDescricao(filmeDTO.getDescricao());
        }
        if (filmeDTO.getDiretorId() != null) {
            Diretor diretor = diretorRepository.findById(filmeDTO.getDiretorId())
                    .orElseThrow(() -> new ResourceNotFoundException("Diretor não encontrado"));
            filme.setDiretor(diretor);
        }
        if (filmeDTO.getAtoresIds() != null) {
            List<Ator> atores = atorRepository.findAllById(filmeDTO.getAtoresIds());
            filme.setAtores(atores);
        }

        Filme updatedFilme = filmeRepository.save(filme);
        return convertToDTO(updatedFilme);
    }

    @Transactional
    public void delete(Long id) {
        if (!filmeRepository.existsById(id)) {
            throw new ResourceNotFoundException("Filme não encontrado com id: " + id);
        }
        filmeRepository.deleteById(id);
    }

    private FilmeDTO convertToDTO(Filme filme) {
        FilmeDTO dto = new FilmeDTO();
        dto.setId(filme.getId());
        dto.setTitulo(filme.getTitulo());
        dto.setDataLancamento(filme.getDataLancamento());
        dto.setOrcamento(filme.getOrcamento());
        dto.setDescricao(filme.getDescricao());

        if (filme.getDiretor() != null) {
            dto.setDiretorId(filme.getDiretor().getId());
            dto.setDiretorNome(filme.getDiretor().getNome());
        }

        if (filme.getAtores() != null && !filme.getAtores().isEmpty()) {
            dto.setAtoresIds(filme.getAtores().stream()
                    .map(Ator::getId)
                    .collect(Collectors.toList()));
            dto.setAtoresNomes(filme.getAtores().stream()
                    .map(Ator::getNome)
                    .collect(Collectors.toList()));
        }

        return dto;
    }

    private Filme convertToEntity(FilmeDTO dto) {
        Filme filme = new Filme();
        filme.setTitulo(dto.getTitulo());
        filme.setDataLancamento(dto.getDataLancamento());
        filme.setOrcamento(dto.getOrcamento());
        filme.setDescricao(dto.getDescricao());

        if (dto.getDiretorId() != null) {
            Diretor diretor = diretorRepository.findById(dto.getDiretorId())
                    .orElseThrow(() -> new ResourceNotFoundException("Diretor não encontrado"));
            filme.setDiretor(diretor);
        }

        if (dto.getAtoresIds() != null && !dto.getAtoresIds().isEmpty()) {
            List<Ator> atores = atorRepository.findAllById(dto.getAtoresIds());
            filme.setAtores(atores);
        }

        return filme;
    }
}
