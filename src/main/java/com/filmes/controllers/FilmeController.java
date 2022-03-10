package com.filmes.controllers;

import com.filmes.models.Filme;
import com.filmes.repositories.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class FilmeController {

    @Autowired
    FilmeRepository filmeRepository;

    @GetMapping("/filmes")
    public ModelAndView verTodosFilmes(){
        List<Filme> listaFilmes = new ArrayList<>();

        listaFilmes = filmeRepository.findAll();

        ModelAndView mv = new ModelAndView("filmes/filmes");
        mv.addObject("listaFilmes", listaFilmes);

        return mv;
    }


    @GetMapping("/index")
    public String index(){

        return "filmes/index";
    }

    @GetMapping("/cadastro")
    public String cadastrar(){

        return "filmes/cadastro";
    }

    @PostMapping("/cadastrar")
    public String cadastrarFilme(Filme filme){

        filmeRepository.save(filme);

        return "redirect:/filmes";
    }

    @GetMapping("/filmes/deletar/{id}")
    public String deletar(@PathVariable Long id){

        filmeRepository.deleteById(id);
        return "redirect:/filmes";
    }

    @GetMapping("/{id}/editar")
    public ModelAndView paginaEditar(@PathVariable Long id){

        Optional<Filme> filme = filmeRepository.findById(id);

        if(filme.isPresent()){
            ModelAndView mv = new ModelAndView("filmes/edicao");
            mv.addObject("filme",filme.get());
            return mv;
        }else{
            return new ModelAndView("redirect:/filmes");
        }

    }

    @PostMapping("/editar")
    public String editarFilme(Filme filme){

        System.out.println();
        System.out.println(filme);
        System.out.println();

        filmeRepository.save(filme);

        return "redirect:/filmes";
    }



}
