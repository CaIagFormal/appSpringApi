package com.primeira.appSpringApi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class M_EnviarProdutoJson {
    @JsonProperty
    private String filial;

    @JsonProperty
    private String produto;

    @JsonProperty
    private String quantidade;

    @JsonProperty
    private String fornecedor;

    @JsonProperty
    private String data;

    public String getFilial() {
        return filial;
    }

    public void setFilial(String filial) {
        this.filial = filial;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String qtd) {
        this.quantidade = qtd;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
