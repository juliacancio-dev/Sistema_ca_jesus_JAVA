package com.sistemacajesus.sistemaestoque.repository;

import com.sistemacajesus.sistemaestoque.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
    Optional<Produto> findByMarca(String marca);
}