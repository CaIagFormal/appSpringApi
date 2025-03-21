package com.primeira.appSpringApi.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class M_Produto {

    public M_Produto(M_ProdutoJson json) {
        this.produto = json.getProduto();
        this.quantidade = Long.valueOf(json.getQuantidade());
        this.min = Integer.valueOf(json.getMin());
        this.max = Integer.valueOf(json.getMax());
        this.custo_medio = Double.valueOf(json.getCusto_medio());
        try {
            this.ultima_compra = LocalDate.parse(json.getUltima_compra(), DateTimeFormatter.ISO_DATE);
        } catch (Exception e) {
            this.ultima_compra = null;
        }

    }

    private String produto;

    private Long quantidade;

    private Integer min;

    private Integer max;

    private double custo_medio;

    private LocalDate ultima_compra;

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

    public Integer getMin() {
        return min;
    }

    public void setMin(Integer min) {
        this.min = min;
    }

    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }

    public double getCusto_medio() {
        return custo_medio;
    }

    public void setCusto_medio(double custo_medio) {
        this.custo_medio = custo_medio;
    }

    public LocalDate getUltima_compra() {
        return ultima_compra;
    }

    public void setUltima_compra(LocalDate ultima_compra) {
        this.ultima_compra = ultima_compra;
    }

    public String toString() {
        return "{\"produto\":\""+this.produto+"\"," +
                "\"quantidade\":"+this.quantidade+"," +
                "\"min\":"+this.min+"," +
                "\"min\":"+this.min+"," +
                "\"max\":"+this.max+"," +
                "\"custo_medio\":"+this.custo_medio+"," +
                "\"ultima_compra\":\""+this.ultima_compra.format(DateTimeFormatter.ISO_DATE)+"\"" +
                "}";
    }
}
