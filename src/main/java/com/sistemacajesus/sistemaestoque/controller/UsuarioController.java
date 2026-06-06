package com.sistemacajesus.sistemaestoque.controller;

import com.sistemacajesus.sistemaestoque.model.Usuario;
import com.sistemacajesus.sistemaestoque.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public String Listar(@RequestParam(required = false) String termo, Model model){
        List<Usuario> usuarios;

        if(termo != null && !termo.isBlank()){
            usuarios = usuarioService.buscarPorTermo(termo);
        } else {
            usuarios = usuarioService.listarTodos();
        }

        model.addAttribute("usuarios", usuarios);
        return "usuario/lista";
    }

    //FORMULARIO (CADASTRO)
    @GetMapping("/novo")
    public String novo(Model model){
        model.addAttribute("usuario", new Usuario());
        return "usuario/formulario";
    }

    //FORMULARIO (EDITAR)
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model model){
        usuarioService.buscarPorId(id).ifPresent(usuario -> model.addAttribute("usuario", usuario));
        return "usuario/formulario";
    }

    //FORMULARIO (SALVAR)
    @PostMapping("/salvar")
    public String salvar (@ModelAttribute Usuario usuario){
        if(usuario.getId() != null){
            usuarioService.buscarPorId(usuario.getId()).ifPresent(u -> {
                if(usuario.getSenha() == null || usuario.getSenha().isEmpty()){
                    usuario.setSenha(u.getSenha());
                }
            });
        }
        usuarioService.salvar(usuario);
        return "redirect:/usuarios";
    }

    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable Integer id) {
        usuarioService.deletar(id);
        return "redirect:/usuarios";
    }

}
