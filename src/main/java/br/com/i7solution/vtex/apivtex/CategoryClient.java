package br.com.i7solution.vtex.apivtex;

import br.com.i7solution.vtex.apivtex.dtos.BrandInclusaoDTO;
import br.com.i7solution.vtex.apivtex.dtos.CategoryInclusaoDTO;
import br.com.i7solution.vtex.config.PropertiesConfig;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import kong.unirest.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class CategoryClient {

    @Autowired
    private PropertiesConfig properties;

    public CategoryInclusaoDTO postCategory(CategoryInclusaoDTO category) throws IOException {
        var props = properties.getProperties();
        String url = props.getProperty("properties.vtex.url") + DadosVtex.endPointCategoria;
        HttpResponse<CategoryInclusaoDTO> response = null;
        var mapper =new ObjectMapper();
        try {
            response = Unirest.post(url)
                    .header("Content-Type", "application/json")
                    .header("X-VTEX-API-AppKey", props.getProperty("properties.vtex.appkey"))
                    .header("X-VTEX-API-AppToken", props.getProperty("properties.vtex.apptoken"))
                    .body(category)
                    .asObject(CategoryInclusaoDTO.class);
            System.out.println(response.getStatus());
            System.out.println(mapper.writeValueAsString(response.getBody()));
            return response.getBody();
        } catch (UnirestException e) {
            e.printStackTrace();
            return null;
        }
    }
}

