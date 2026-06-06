package com.sistemacajesus.sistemaestoque.repository;

import com.sistemacajesus.sistemaestoque.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    List<Usuario> findByNomeContainingIgnoreCaseOrEmailContainingIgnoreCaseOrCpfContainingIgnoreCase(String nome, String email, String cpf);

}
