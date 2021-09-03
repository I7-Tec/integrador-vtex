package br.com.i7solution.vtex.apivtex;

import br.com.i7solution.vtex.apivtex.dtos.*;
import br.com.i7solution.vtex.clients.dtos.ProdutoDTO;
import org.springframework.stereotype.Service;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import kong.unirest.UnirestException;

@Service
public class CatalogClient {

    public CategoryDTO getCategorias() {
        String url = DadosVtex.url + DadosVtex.endPointCategoria + "/?an=" + DadosVtex.sellers;

        HttpResponse<CategoryDTO> response = null;
        try {
            response = Unirest.get(url).header("Content-Type", "application/json")
                    .header("X-VTEX-API-AppKey", DadosVtex.appKey)
                    .header("X-VTEX-API-AppToken", DadosVtex.appToken)
                    .asObject(CategoryDTO.class);
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        if (response != null) {
            return response.getBody();
        }

        return null ;
    }

    public CategoryDTO getCategoriaPorId(String id) {
        String url = DadosVtex.url + DadosVtex.endPointCategoria + id + "?an=" + DadosVtex.sellers;

        HttpResponse<CategoryDTO> response = null;
        try {
            response = Unirest.get(url).header("Content-Type", "application/json")
                    .header("X-VTEX-API-AppKey", DadosVtex.appKey)
                    .header("X-VTEX-API-AppToken", DadosVtex.appToken)
                    .asObject(CategoryDTO.class);
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        if (response != null) {
            return response.getBody();
        }

        return null ;
    }

    public BrandDTO getMarcas() {
        String url = DadosVtex.url + DadosVtex.endPointMarcas + "?an=" + DadosVtex.sellers;
        HttpResponse<BrandDTO> response = null;
        try {
            response = Unirest.get(url).header("Content-Type", "application/json")
                    .header("X-VTEX-API-AppKey", DadosVtex.appKey)
                    .header("X-VTEX-API-AppToken", DadosVtex.appToken)
                    .asObject(BrandDTO.class);
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        if (response != null) {
            return response.getBody();
        }

        return null ;
    }

    public BrandDTO getMarcaPorId(String id) {
        String url = DadosVtex.url + DadosVtex.endPointMarcas + id + "?an=" + DadosVtex.sellers;
        HttpResponse<BrandDTO> response = null;
        try {
            response = Unirest.get(url).header("Content-Type", "application/json")
                    .header("X-VTEX-API-AppKey", DadosVtex.appKey)
                    .header("X-VTEX-API-AppToken", DadosVtex.appToken)
                    .asObject(BrandDTO.class);
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        if (response != null) {
            return response.getBody();
        }

        return null ;
    }

    public ProductDTO getProdutoPorId(Long id) {
        String url = DadosVtex.url + DadosVtex.endPointProduto + id;
        HttpResponse<ProductDTO> response = null;
        try {
            response = Unirest.get(url).header("Content-Type", "application/json")
                    .header("X-VTEX-API-AppKey", DadosVtex.appKey)
                    .header("X-VTEX-API-AppToken", DadosVtex.appToken)
                    .asObject(ProductDTO.class);
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        if (response != null) {
            return response.getBody();
        }

        return null ;
    }

    public SkuDTO getSKU() {
        String url = DadosVtex.url + DadosVtex.endPointProduto + "?an=" + DadosVtex.sellers;
        HttpResponse<SkuDTO> response = null;
        try {
            response = Unirest.get(url).header("Content-Type", "application/json")
                    .header("X-VTEX-API-AppKey", DadosVtex.appKey)
                    .header("X-VTEX-API-AppToken", DadosVtex.appToken)
                    .asObject(SkuDTO.class);
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        if (response != null) {
            return response.getBody();
        }

        return null ;
    }

    public SkuDTO getSKUPorId(String id) {
        String url = DadosVtex.url + DadosVtex.endPointProduto + id + "?an=" + DadosVtex.sellers;
        HttpResponse<SkuDTO> response = null;
        try {
            response = Unirest.get(url).header("Content-Type", "application/json")
                    .header("X-VTEX-API-AppKey", DadosVtex.appKey)
                    .header("X-VTEX-API-AppToken", DadosVtex.appToken)
                    .asObject(SkuDTO.class);
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        if (response != null) {
            return response.getBody();
        }

        return null ;
    }

    public SkuInclusao postSku(SkuInclusao dados) {
        String url = DadosVtex.url + DadosVtex.endPointProduto + "?an=" + DadosVtex.sellers;
        HttpResponse<SkuInclusao> response = null;
        try {
            response = Unirest.post(url).header("Content-Type", "application/json")
                    .header("X-VTEX-API-AppKey", DadosVtex.appKey)
                    .header("X-VTEX-API-AppToken", DadosVtex.appToken)
                    .body(dados).asObject(SkuInclusao.class);
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        if (response != null) {
            return response.getBody();
        }
        return null ;
    }

    public SkusDTO getSKUs() {
        String url = DadosVtex.url + DadosVtex.endPointProduto + "?an=" + DadosVtex.sellers;
        HttpResponse<SkusDTO> response = null;
        try {
            response = Unirest.get(url)
                    .header("Content-Type", "application/json")
                    .header("X-VTEX-API-AppKey", DadosVtex.appKey)
                    .header("X-VTEX-API-AppToken", DadosVtex.appToken)
                    .asObject(SkusDTO.class);
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        if (response != null) {
            return response.getBody();
        }
        return   null;
    }






    public ProductInclusao postProduto(ProductInclusao dados) {
        String url = DadosVtex.url + DadosVtex.endPointProduto;
        HttpResponse<ProductInclusao> response = null;
        System.out.println(url);
        try {
            response = Unirest.post(url)
                    .header("Content-Type", "application/json")
                    .header("X-VTEX-API-AppKey", DadosVtex.appKey)
                    .header("X-VTEX-API-AppToken",DadosVtex.appToken)
                    .body(dados)
                    .asObject(ProductInclusao.class);
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        if (response != null) {
            return response.getBody();
        }
        return null ;
    }

}
