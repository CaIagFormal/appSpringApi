package com.primeira.appSpringApi.model;

import com.fasterxml.jackson.annotation.JsonAnySetter;

import java.util.ArrayList;
import java.util.List;
import com.primeira.appSpringApi.model.M_ProdutoJson;

public class M_RespostaApi {

    private List<M_ProdutoJson> produtos = new ArrayList<>();

    @JsonAnySetter
    public void setProdutos(M_ProdutoJson valor) {
        produtos.add(valor);
    }

    public List<M_ProdutoJson> getProdutos() {
        return produtos;
    }
}
