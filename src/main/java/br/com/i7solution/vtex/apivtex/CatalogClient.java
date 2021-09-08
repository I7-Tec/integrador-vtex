package br.com.i7solution.vtex.apivtex;

import br.com.i7solution.vtex.apivtex.dtos.*;
import org.springframework.stereotype.Service;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import kong.unirest.UnirestException;

@Service
public class CatalogClient {

    public CategoryDTO getCategorias() {
        String url = DadosVtex.url + DadosVtex.endPointCategoria ;

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

        return null;
    }

    public CategoryDTO getCategoriaPorId(String id) {
        String url = DadosVtex.url + DadosVtex.endPointCategoria +"/" + id ;

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

        return null;
    }

    public BrandDTO getMarcas() {
        String url = DadosVtex.url + DadosVtex.endPointMarcas ;
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

        return null;
    }

    public BrandDTO getMarcaPorId(String id) {
        String url = DadosVtex.url + DadosVtex.endPointMarcas + "/" + id ;
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

        return null;
    }

    public ProductDTO getProdutoPorId(Long id) {
        String url = DadosVtex.url + DadosVtex.endPointProdutoGet + id;
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

        return null;
    }

    public SkusDTO getSKUs() {
        String url = DadosVtex.url + DadosVtex.endPointSku;
        HttpResponse<SkusDTO> response = null;
        try {
            response = Unirest.get(url).header("Content-Type", "application/json")
                    .header("X-VTEX-API-AppKey", DadosVtex.appKey)
                    .header("X-VTEX-API-AppToken", DadosVtex.appToken)
                    .asObject(SkusDTO.class);
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        if (response != null) {
            return response.getBody();
        }

        return null;
    }

    public SkuDTO getSKUPorId(String id) {
        String url = DadosVtex.url + DadosVtex.endPointSku +"/"+ id;
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

        return null;
    }


    public void postSku(SkuInclusaoDTO sku) {
        String url = DadosVtex.url + DadosVtex.endPointSku;
        HttpResponse<SkuInclusaoDTO> response = null;

        try {
            response = Unirest.post(url).header("Content-Type", "application/json")
                    .header("X-VTEX-API-AppKey", DadosVtex.appKey)
                    .header("X-VTEX-API-AppToken", DadosVtex.appToken)
                    .body(sku)
                    .asObject(SkuInclusaoDTO.class);
            response.getBody();
        } catch (UnirestException e) {
            e.printStackTrace();
        }
    }

    public SkuDTO getSKURefId(String refId) {
        String url = DadosVtex.url + DadosVtex.endPointSkuRefIdGet + refId;
        HttpResponse<SkuDTO> response = null;
        try {
            response = Unirest.get(url)
                    .queryString("refId", refId)
                    .header("Content-Type", "application/json")
                    .header("X-VTEX-API-AppKey", DadosVtex.appKey)
                    .header("X-VTEX-API-AppToken", DadosVtex.appToken)
                    .asObject(SkuDTO.class);
            return response.getBody();
        } catch (UnirestException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void postProduto(ProductInclusaoDTO dados) {
        String url = DadosVtex.url + DadosVtex.endPointProdutoPost;
        HttpResponse<ProductInclusaoDTO> response = null;
        try {
            response = Unirest.post(url)
                    .header("Content-Type", "application/json")
                    .header("X-VTEX-API-AppKey", DadosVtex.appKey)
                    .header("X-VTEX-API-AppToken", DadosVtex.appToken)
                    .body(dados)
                    .asObject(ProductInclusaoDTO.class);
            response.getBody();
        } catch (UnirestException e) {
            e.printStackTrace();
        }
    }

    public ProductDTO getProdutoRefId(String refId) {
        String url = DadosVtex.url + DadosVtex.endPointProdutoGet + "/" + refId;
        HttpResponse<ProductDTO> response = null;
        try {
            response = Unirest.get(url)
                    .header("Content-Type", "application/json")
                    .header("X-VTEX-API-AppKey", DadosVtex.appKey)
                    .header("X-VTEX-API-AppToken", DadosVtex.appToken)
                    .asObject(ProductDTO.class);
            return response.getBody();
        } catch (UnirestException e) {
            e.printStackTrace();
            return null;
        }
    }

    public SkuInclusaoDTO postSKURefId(SkuInclusaoDTO refId) {
        String url = DadosVtex.url + DadosVtex.endPointPostRefId + refId;
        HttpResponse<SkuInclusaoDTO> response = null;
        try {
            response = Unirest.post(url)
                    .queryString("refId", refId)
                    .header("Content-Type", "application/json")
                    .header("X-VTEX-API-AppKey", DadosVtex.appKey)
                    .header("X-VTEX-API-AppToken", DadosVtex.appToken)
                    .asObject(SkuInclusaoDTO.class);
            return response.getBody();
        } catch (UnirestException e) {
            e.printStackTrace();
            return null;
        }
    }

    public SkuDTO getSKU() {
        String url = DadosVtex.url + DadosVtex.endPointSku;
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
        return null;
    }
}
