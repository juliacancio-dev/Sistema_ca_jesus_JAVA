package com.sistemacajesus.sistemaestoque.controller;

import com.sistemacajesus.sistemaestoque.model.Movimentacao;
import com.sistemacajesus.sistemaestoque.service.MovimentacaoService;
import com.sistemacajesus.sistemaestoque.service.ProdutoService;
import com.sistemacajesus.sistemaestoque.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/movimentacoes")
public class MovimentacaoController {

    @Autowired
    private MovimentacaoService movimentacaoService;

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("movimentacoes", movimentacaoService.listarTodos());
        return "movimentacao/lista";
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("movimentacao", new Movimentacao());
        model.addAttribute("produtos", produtoService.listarTodos());
        model.addAttribute("usuarios", usuarioService.listarTodos());
        return "movimentacao/formulario";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model model) {
        movimentacaoService.buscarPorId(id).ifPresent(mov -> {
            model.addAttribute("movimentacao", mov);
            model.addAttribute("produtos", produtoService.listarTodos());
            model.addAttribute("usuarios", usuarioService.listarTodos());
        });
        return "movimentacao/formulario";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Movimentacao movimentacao) {
        // Busca o produto real pela marca enviada no formulário
        if (movimentacao.getProduto() != null && movimentacao.getProduto().getMarca() != null) {
            produtoService.buscarPorMarca(movimentacao.getProduto().getMarca())
                    .ifPresentOrElse(
                            movimentacao::setProduto,
                            () -> { throw new RuntimeException("Produto não encontrado"); }
                    );
        }

        // Busca o usuário pelo id (se informado), caso contrário define null
        if (movimentacao.getUsuario() != null && movimentacao.getUsuario().getId() != null) {
            usuarioService.buscarPorId(movimentacao.getUsuario().getId())
                    .ifPresentOrElse(
                            movimentacao::setUsuario,
                            () -> movimentacao.setUsuario(null)
                    );
        } else {
            movimentacao.setUsuario(null);
        }

        movimentacaoService.salvar(movimentacao);
        return "redirect:/movimentacoes";
    }


    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable Integer id) {
        movimentacaoService.deletar(id);
        return "redirect:/movimentacoes";
    }
}