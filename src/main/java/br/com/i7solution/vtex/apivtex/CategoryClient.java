package br.com.i7solution.vtex.apivtex;

import br.com.i7solution.vtex.apivtex.dtos.BrandInclusaoDTO;
import br.com.i7solution.vtex.apivtex.dtos.CategoryInclusaoDTO;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import kong.unirest.UnirestException;
import org.springframework.stereotype.Service;

@Service
public class CategoryClient {

    public CategoryInclusaoDTO postCategory(CategoryInclusaoDTO category) {
        String url = DadosVtex.url + DadosVtex.endPointMarcas;
        HttpResponse<CategoryInclusaoDTO> response = null;
        try {
            response = Unirest.post(url)
                    .header("Content-Type", "application/json")
                    .header("X-VTEX-API-AppKey", DadosVtex.appKey)
                    .header("X-VTEX-API-AppToken", DadosVtex.appToken)
                    .body(category)
                    .asObject(CategoryInclusaoDTO.class);
            return response.getBody();
        } catch (UnirestException e) {
            e.printStackTrace();
            return null;
        }
    }
}

