package br.com.i7solution.vtex.apivtex;

import br.com.i7solution.vtex.apivtex.dtos.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import kong.unirest.UnirestException;

@Log4j2
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

        return null;
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

        return null;
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

        return null;
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


    public SkuDTO postSku(SkuDTO sku) {
        String url = DadosVtex.url + DadosVtex.endPointSku;
        HttpResponse<SkuDTO> response = null;


        try {
            response = Unirest.post(url).header("Content-Type", "application/json")
                    .header("X-VTEX-API-AppKey", DadosVtex.appKey)
                    .header("X-VTEX-API-AppToken", DadosVtex.appToken)
                    .body(sku)
                    .asObject(SkuDTO.class);

        } catch (UnirestException e) {
            e.printStackTrace();
        }
        if (response != null) {
            return response.getBody();
        }
        return null;
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

    public ProductInclusaoDTO postProduto(ProductInclusaoDTO dados) {
        String url = "http://tb0921.vtexcommercestable.com.br/api//catalog/pvt/product";
        HttpResponse<ProductInclusaoDTO> response = null;
        try {
            response = Unirest.post(url)
                    .header("Content-Type", "application/json")
                    .header("X-VTEX-API-AppKey", DadosVtex.appKey)
                    .header("X-VTEX-API-AppToken", DadosVtex.appToken)
                    .body(dados)
                    .asObject(ProductInclusaoDTO.class);
                    log.info(response.getStatus());
            return response.getBody();
        } catch (UnirestException e) {
            e.printStackTrace();
            return null;
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

    public SkuDTO postSKURefId(SkuDTO refId) {
        String url = DadosVtex.url + DadosVtex.endPointPostRefId + refId;
        HttpResponse<SkuDTO> response = null;
        try {
            response = Unirest.post(url)
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
        if(response != null) {
            return response.getBody();
        }
        return null;
    }
}
