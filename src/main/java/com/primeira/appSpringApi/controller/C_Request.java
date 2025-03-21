package com.primeira.appSpringApi.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.primeira.appSpringApi.model.M_Produto;
import com.primeira.appSpringApi.service.S_Request;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class C_Request {

    private final S_Request s_request;

    public C_Request(S_Request s_request) {
        this.s_request = s_request;
    }

    @GetMapping("/")
    public String getIndex() {
        return "redirect:/consultor";
    }

    @GetMapping("/consultor")
    public String getConsultor() {
        return "consultor";
    }

    @GetMapping("/comprador")
    public String getComprador() {
        return "comprador";
    }

    @PostMapping("/faltando")
    public String faltando(@RequestParam("data") String data,@RequestParam("endereco") String endereco, Model model) throws JsonProcessingException {
        List<M_Produto> request =  s_request.requestApi(data,endereco);
        List<M_Produto> produtos = new ArrayList<>();
        for (M_Produto produto: request) {
            if (produto.getMin()<produto.getQuantidade()) {
                continue;
            }
            produtos.add(produto);
        }
        model.addAttribute("produtos",produtos);
        return "pv/produtos";
    }

    @PostMapping("/enviarproduto")
    @ResponseBody
    public String enviarProduto(@RequestParam("dados") String dados) throws JsonProcessingException {
        s_request.produtoApi(dados);

        return "PLACEHOLDER";
    }
}
