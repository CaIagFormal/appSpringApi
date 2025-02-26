package com.primeira.appSpringApi.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.primeira.appSpringApi.model.M_Produto;
import com.primeira.appSpringApi.service.S_Request;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Controller;

@Controller
public class C_Request {

    private final S_Request s_request;

    public C_Request(S_Request s_request) {
        this.s_request = s_request;
    }

    @PostConstruct
    public void startup() throws JsonProcessingException {
        for (M_Produto produto : s_request.requestApi("2025-02-26")) {
            System.out.println(produto);
        }
    }
}
