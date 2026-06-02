package com.sistemacajesus.sistemaestoque.controller;

import com.sistemacajesus.sistemaestoque.model.Produto;
import com.sistemacajesus.sistemaestoque.service.FornecedorService;
import com.sistemacajesus.sistemaestoque.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private FornecedorService fornecedorService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("produtos", produtoService.listarTodos());
        return "produto/lista";
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("produto", new Produto());
        model.addAttribute("fornecedores", fornecedorService.listarTodos());
        return "produto/formulario";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model model) {
        produtoService.buscarPorId(id).ifPresent(produto -> {
            model.addAttribute("produto", produto);
            model.addAttribute("fornecedores", fornecedorService.listarTodos());
        });
        return "produto/formulario";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Produto produto) {
        // O Spring já converte o ID do fornecedor vindo do formulário (campo "fornecedor.id")
        // para o objeto Fornecedor associado (graças ao relacionamento ManyToOne)
        produtoService.salvar(produto);
        return "redirect:/produtos";
    }

    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable Integer id) {
        produtoService.deletar(id);
        return "redirect:/produtos";
    }
}