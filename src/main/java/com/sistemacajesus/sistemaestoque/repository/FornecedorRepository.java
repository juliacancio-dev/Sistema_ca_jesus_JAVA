package com.sistemacajesus.sistemaestoque.repository;

import com.sistemacajesus.sistemaestoque.model.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor, Integer> {
    List<Fornecedor> findByNomeContainingIgnoreCaseOrEmailContainingIgnoreCaseOrCnpjContainingIgnoreCase (String nome, String email, String cnpj);
}