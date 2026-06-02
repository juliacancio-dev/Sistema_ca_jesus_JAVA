package com.sistemacajesus.sistemaestoque.service;

import com.sistemacajesus.sistemaestoque.model.Movimentacao;
import com.sistemacajesus.sistemaestoque.repository.MovimentacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovimentacaoService {

    @Autowired
    private MovimentacaoRepository movimentacaoRepository;

    public List<Movimentacao> listarTodos() {
        return movimentacaoRepository.findAll();
    }

    public Optional<Movimentacao> buscarPorId(Integer id) {
        return movimentacaoRepository.findById(id);
    }

    public Movimentacao salvar(Movimentacao movimentacao) {
        return movimentacaoRepository.save(movimentacao);
    }

    public void deletar(Integer id) {
        movimentacaoRepository.deleteById(id);
    }
}