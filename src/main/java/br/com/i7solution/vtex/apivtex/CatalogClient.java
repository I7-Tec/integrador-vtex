package br.com.i7solution.vtex.apivtex;

import br.com.i7solution.vtex.apivtex.dtos.*;
import br.com.i7solution.vtex.config.PropertiesConfig;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import kong.unirest.GenericType;
import lombok.extern.log4j.Log4j2;
import org.hibernate.mapping.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import kong.unirest.UnirestException;

import java.io.IOException;
import java.util.HashMap;

@Log4j2
@Service
public class CatalogClient {

    @Autowired
    private PropertiesConfig properties;

    public CategoryDTO getCategorias() throws IOException {
        var props = properties.getProperties();
        String url = props.getProperty("properties.vtex.url") + DadosVtex.endPointCategoria + "/?an=" + DadosVtex.sellers;

        HttpResponse<CategoryDTO> response = null;
        try {
            response = Unirest.get(url).header("Content-Type", "application/json")
                    .header("X-VTEX-API-AppKey", props.getProperty("properties.vtex.appkey"))
                    .header("X-VTEX-API-AppToken", props.getProperty("properties.vtex.apptoken"))
                    .asObject(CategoryDTO.class);
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        if (response != null) {
            return response.getBody();
        }

        return null;
    }

    public CategoryDTO getCategoriaPorId(String id) throws IOException {
        var props = properties.getProperties();
        String url = props.getProperty("properties.vtex.url") + DadosVtex.endPointCategoria + id + "?an=" + DadosVtex.sellers;

        HttpResponse<CategoryDTO> response = null;
        try {
            response = Unirest.get(url).header("Content-Type", "application/json")
                    .header("X-VTEX-API-AppKey", props.getProperty("properties.vtex.appkey"))
                    .header("X-VTEX-API-AppToken", props.getProperty("properties.vtex.apptoken"))
                    .asObject(CategoryDTO.class);
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        if (response != null) {
            return response.getBody();
        }

        return null;
    }

    public BrandDTO getMarcas() throws IOException {
        var props = properties.getProperties();
        String url = props.getProperty("properties.vtex.url") + DadosVtex.endPointMarcas + "?an=" + DadosVtex.sellers;
        HttpResponse<BrandDTO> response = null;
        try {
            response = Unirest.get(url).header("Content-Type", "application/json")
                    .header("X-VTEX-API-AppKey", props.getProperty("properties.vtex.appkey"))
                    .header("X-VTEX-API-AppToken", props.getProperty("properties.vtex.apptoken"))
                    .asObject(BrandDTO.class);
            return response.getBody();
        } catch (UnirestException e) {
            e.printStackTrace();
            return null;
        }
    }

    public BrandDTO getMarcaPorId(String id) throws IOException {
        var props = properties.getProperties();
        String url = props.getProperty("properties.vtex.url") + DadosVtex.endPointMarcas + id + "?an=" + DadosVtex.sellers;
        HttpResponse<BrandDTO> response = null;
        try {
            response = Unirest.get(url).header("Content-Type", "application/json")
                    .header("X-VTEX-API-AppKey", props.getProperty("properties.vtex.appkey"))
                    .header("X-VTEX-API-AppToken", props.getProperty("properties.vtex.apptoken"))
                    .asObject(BrandDTO.class);
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        if (response != null) {
            return response.getBody();
        }

        return null;
    }

    public ProductDTO getProdutoPorId(Long id) throws IOException {
        var props = properties.getProperties();
        String url = props.getProperty("properties.vtex.url") + DadosVtex.endPointProdutoGet + id;
        HttpResponse<ProductDTO> response = null;
        try {
            response = Unirest.get(url).header("Content-Type", "application/json")
                    .header("X-VTEX-API-AppKey", props.getProperty("properties.vtex.appkey"))
                    .header("X-VTEX-API-AppToken", props.getProperty("properties.vtex.apptoken"))
                    .asObject(ProductDTO.class);
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        if (response != null) {
            return response.getBody();
        }

        return null;
    }

    public SkuDTO getSKUPorRefId(String refId) throws IOException {
        var props = properties.getProperties();
        String url = props.getProperty("properties.vtex.url") + DadosVtex.endPointSku;
        HttpResponse<SkuDTO> response = null;
        try {
            response = Unirest.get(url)
                    .header("Content-Type", "application/json")
                    .header("X-VTEX-API-AppKey", props.getProperty("properties.vtex.appkey"))
                    .header("X-VTEX-API-AppToken", props.getProperty("properties.vtex.apptoken"))
                    .queryString("refId", refId)
                    .asObject(SkuDTO.class);

            if (response.isSuccess()) {
                return response.getBody();
            }
            return null;
        } catch (UnirestException e) {
            log.warn("[getSKUPorRefId] Erro: " + e.getMessage());
            return null;
        }
    }

    public Boolean postProduto(ProductInclusaoDTO dados) throws IOException {
        var props = properties.getProperties();
        String url = props.getProperty("properties.vtex.url") + DadosVtex.endPointProdutoPost;
        HttpResponse<ProductInclusaoDTO> response = null;
        log.info("Produto à ser incluido: " + dados.toString());
        try {
            response = Unirest.post(url)
                    .header("Content-Type", "application/json")
                    .header("X-VTEX-API-AppKey", props.getProperty("properties.vtex.appkey"))
                    .header("X-VTEX-API-AppToken", props.getProperty("properties.vtex.apptoken"))
                    .body(dados)
                    .asObject(ProductInclusaoDTO.class);

            log.info("Status Code Post Produto: " + response.getStatus());
            return response.isSuccess();

        } catch (UnirestException e) {
            log.warn("[postProduto] Erro: " + e.getMessage());
            return false;
        }
    }

    public SkuInclusaoDTO postSku(SkuInclusaoDTO sku) throws IOException {
        var props = properties.getProperties();
        String url = props.getProperty("properties.vtex.url") + DadosVtex.endPointSku;
        HttpResponse<SkuInclusaoDTO> response = null;
        try {
            response = Unirest.post(url)
                    .header("Content-Type", "application/json")
                    .header("X-VTEX-API-AppKey", props.getProperty("properties.vtex.appkey"))
                    .header("X-VTEX-API-AppToken", props.getProperty("properties.vtex.apptoken"))
                    .body(sku)
                    .asObject(SkuInclusaoDTO.class);

            if (response.getStatus() == 200) {
                log.warn("[postSku] Sucesso: Status " + response.getStatus());
                return response.getBody();
            } else {
                String msgErro = "HttpStatus: " + response.getStatus() + " - ";
                var msg = response.mapError(HashMap.class);
                if (msg != null) {
                    if (msg.containsKey("Message")) msgErro += msg.get("Message") + "\n";
                    if (msg.containsKey("message")) msgErro += msg.get("message") + "\n";
                }
                throw new UnirestException(msgErro);
            }
        } catch (UnirestException e) {
            log.warn("[postSku] Erro: " + e.getMessage());
            return null;
        }
    }

    public SkuFileDTO[] getSkuFile(Long skuId) throws IOException {
        var props = properties.getProperties();
        String url = props.getProperty("properties.vtex.url") +
                DadosVtex.endPointSku +
                "/" + skuId +
                "/file";
        HttpResponse<SkuFileDTO[]> response = null;
        try {
            response = Unirest.get(url)
                    .header("Content-Type", "application/json")
                    .header("X-VTEX-API-AppKey", props.getProperty("properties.vtex.appkey"))
                    .header("X-VTEX-API-AppToken", props.getProperty("properties.vtex.apptoken"))
                    .asObject(SkuFileDTO[].class);

            if (response.getStatus() == 200) {
                var result = response.getBody();
                if (result.length > 0) return result;
                return null;
            }
            return null;
        } catch (UnirestException e) {
            log.warn("[getSkuFile] Erro: " + e.getMessage());
            return null;
        }
    }

    public boolean postSkuFile(SkuFileDTO skuFile) throws IOException {
        var props = properties.getProperties();
        String url = props.getProperty("properties.vtex.url") +
                DadosVtex.endPointSku +
                "/" + skuFile.getSkuId() +
                "/file";
        HttpResponse<SkuFileDTO> response = null;
        try {
            response = Unirest.post(url)
                    .header("Content-Type", "application/json")
                    .header("X-VTEX-API-AppKey", props.getProperty("properties.vtex.appkey"))
                    .header("X-VTEX-API-AppToken", props.getProperty("properties.vtex.apptoken"))
                    .body(skuFile)
                    .asObject(SkuFileDTO.class);

            if (response.getStatus() == 200) {
                return true;
            } else {
                String msgErro = "HttpStatus: " + response.getStatus() + " - ";
                var msg = response.mapError(HashMap.class);
                if (msg != null) {
                    if (msg.containsKey("Message")) msgErro += msg.get("Message") + "\n";
                    if (msg.containsKey("message")) msgErro += msg.get("message") + "\n";
                }
                throw new UnirestException(msgErro);
            }
        } catch (UnirestException e) {
            log.warn("[postSkuFile] Erro: " + e.getMessage());
            return false;
        }
    }

    public SkuDTO getSKURefId(String refId) throws IOException {
        var props = properties.getProperties();
        String url = props.getProperty("properties.vtex.url") + DadosVtex.endPointSku;
        HttpResponse<SkuDTO> response = null;
        try {
            var request = Unirest.get(url)
                    .queryString("refId", refId)
                    .header("Content-Type", "application/json")
                    .header("X-VTEX-API-AppKey", props.getProperty("properties.vtex.appkey"))
                    .header("X-VTEX-API-AppToken", props.getProperty("properties.vtex.apptoken"));

            response = request.asObject(SkuDTO.class);
            if (response.getStatus() == 200) {
                return response.getBody();
            } else if (response.getStatus() == 404) {
                return null;
            } else {
                throw new UnirestException("HttpStatus: " + response.getStatus());
            }
        } catch (UnirestException e) {
            log.warn("[getSKURefId] Erro: " + e.getMessage());
            return null;
        }
    }

    public ProductDTO getProdutoRefId(String refId) throws IOException {
        var props = properties.getProperties();
        String url = props.getProperty("properties.vtex.url") + DadosVtex.endPointProdutoPorRefId + refId;
        HttpResponse<ProductDTO> response = null;
        try {
            var request = Unirest.get(url)
                    .header("Content-Type", "application/json")
                    .header("X-VTEX-API-AppKey", props.getProperty("properties.vtex.appkey"))
                    .header("X-VTEX-API-AppToken", props.getProperty("properties.vtex.apptoken"));

            response = request.asObject(ProductDTO.class);

            if (response.isSuccess()) {
                return response.getBody();
            }
            return null;
        } catch (UnirestException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String[] getSkuEan(String skuId) throws IOException {
        var props = properties.getProperties();
        String url = props.getProperty("properties.vtex.url") +
                DadosVtex.endPointSku +
                "/" + skuId +
                "/ean";
        HttpResponse<String[]> response = null;
        try {
            response = Unirest.get(url)
                    .header("Content-Type", "application/json")
                    .header("X-VTEX-API-AppKey", props.getProperty("properties.vtex.appkey"))
                    .header("X-VTEX-API-AppToken", props.getProperty("properties.vtex.apptoken"))
                    .asObject(String[].class);

            if (response.getStatus() == 200) {
                return response.getBody();
            }
            return null;
        } catch (UnirestException e) {
            log.warn("[getSkuEan] - Erro: " + e.getMessage());
            return null;
        }
    }

    public boolean postSkuEan(String skuId, String ean) throws IOException {
        var props = properties.getProperties();
        String url = props.getProperty("properties.vtex.url") +
                DadosVtex.endPointSku +
                "/" + skuId +
                "/ean/" + ean;
        HttpResponse<String> response = null;
        try {
            response = Unirest.post(url)
                    .header("Content-Type", "application/json")
                    .header("X-VTEX-API-AppKey", props.getProperty("properties.vtex.appkey"))
                    .header("X-VTEX-API-AppToken", props.getProperty("properties.vtex.apptoken"))
                    .asString();

            return response.getStatus() == 200;
        } catch (UnirestException e) {
            log.warn("[postSkuEan] - Erro: " + e.getMessage());
            return false;
        }
    }
}
