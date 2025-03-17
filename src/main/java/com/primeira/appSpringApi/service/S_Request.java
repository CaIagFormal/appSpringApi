package com.primeira.appSpringApi.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.primeira.appSpringApi.model.M_Produto;
import com.primeira.appSpringApi.model.M_ProdutoJson;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class S_Request {

    private RestTemplate rest_template = new RestTemplate();
    List<M_ProdutoJson> mapApi;

    public List<M_Produto> requestApi(String iso,String server) throws JsonProcessingException {
        System.out.println("Comunicando com '"+server + ":8080/API/" + iso+"'...");
        mapApi = new ObjectMapper().readValue(
                rest_template.getForObject(server + ":8080/API/" + iso,
                        String.class), new TypeReference<List<M_ProdutoJson>>(){});

        List<M_Produto> m_apis = new ArrayList<>();

        for (M_ProdutoJson json: mapApi) {
            m_apis.add(new M_Produto(json));
        }

        return m_apis;
    }

}
