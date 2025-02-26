package com.primeira.appSpringApi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class M_ProdutoJson {
    @JsonProperty
    private String produto;

    @JsonProperty
    private String quantidade;

    @JsonProperty
    private String min;

    @JsonProperty
    private String max;

    @JsonProperty
    private String custo_medio;

    @JsonProperty
    private String ultima_compra;

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    public String getMin() {
        return min;
    }

    public void setMin(String min) {
        this.min = min;
    }

    public String getMax() {
        return max;
    }

    public void setMax(String max) {
        this.max = max;
    }

    public String getCusto_medio() {
        return custo_medio;
    }

    public void setCusto_medio(String custo_medio) {
        this.custo_medio = custo_medio;
    }

    public String getUltima_compra() {
        return ultima_compra;
    }

    public void setUltima_compra(String ultima_compra) {
        this.ultima_compra = ultima_compra;
    }
}
