package com.primeira.appSpringApi.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class M_EnviarProduto {
    public M_EnviarProduto(M_EnviarProdutoJson json) {
        this.produto = json.getProduto();
        this.quantidade = Long.valueOf(json.getQuantidade());
        this.fornecedor = json.getFornecedor();
        try {
            this.data = LocalDate.parse(json.getData(), DateTimeFormatter.ISO_DATE);
        } catch (Exception e) {
            this.data = null;
        }

    }

    private String produto;

    private Long quantidade;

    private String fornecedor;

    private LocalDate data;

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public Long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Long quantidade) {
        this.quantidade = quantidade;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String toString() {
        return "{\"produto\":\""+this.produto+"\"," +
                "\"quantidade\":"+this.quantidade+"," +
                "\"fornecedor\":\""+this.fornecedor+"\"," +
                "\"ultima_compra\":\""+this.data.format(DateTimeFormatter.ISO_DATE)+"\"" +
                "}";
    }
}
