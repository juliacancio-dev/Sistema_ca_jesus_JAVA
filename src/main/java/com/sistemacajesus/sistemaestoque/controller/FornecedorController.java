package com.sistemacajesus.sistemaestoque.controller;

import com.sistemacajesus.sistemaestoque.model.Fornecedor;
import com.sistemacajesus.sistemaestoque.service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/fornecedores")
public class FornecedorController {

    @Autowired
    private FornecedorService fornecedorService;

    @GetMapping
    public String listar(@RequestParam(required = false) String termo, Model model) {
        List<Fornecedor> fornecedores;

        if (termo != null && !termo.isBlank()) {
            fornecedores = fornecedorService.buscarPorTermo(termo);
        } else {
            fornecedores = fornecedorService.listarTodos();
        }

        model.addAttribute("fornecedores", fornecedores);
        return "fornecedor/lista";
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("fornecedor", new Fornecedor());
        return "fornecedor/formulario";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model model) {
        fornecedorService.buscarPorId(id).ifPresent(f -> model.addAttribute("fornecedor", f));
        return "fornecedor/formulario";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Fornecedor fornecedor) {
        fornecedorService.salvar(fornecedor);
        return "redirect:/fornecedores";
    }

    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable Integer id) {
        fornecedorService.deletar(id);
        return "redirect:/fornecedores";
    }
}