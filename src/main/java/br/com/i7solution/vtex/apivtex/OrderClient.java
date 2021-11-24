package br.com.i7solution.vtex.apivtex;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import br.com.i7solution.vtex.config.PropertiesConfig;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.i7solution.vtex.apivtex.dtos.OrderDTO;
import br.com.i7solution.vtex.apivtex.dtos.OrdersDTO;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import kong.unirest.UnirestException;

@Service
@Log4j2
public class OrderClient {

    @Autowired
    private PropertiesConfig properties;

    public OrderDTO getPedidoPorId(String orderId) throws IOException {
        var props = properties.getProperties();
        String url = props.getProperty("properties.vtex.url") + DadosVtex.endPointProdutoGet + orderId.toString() + "?an=" + DadosVtex.sellers;
        HttpResponse<OrderDTO> response = null;
        try {
            response = Unirest.get(url).header("Content-Type", "application/json")
                    .header("X-VTEX-API-AppKey", props.getProperty("properties.vtex.appkey"))
                    .header("X-VTEX-API-AppToken", props.getProperty("properties.vtex.apptoken"))
                    .asObject(OrderDTO.class);

            if (response.getStatus() == 200) {
                return response.getBody();
            } else {
                String msgErro = "HttpStatus: " + response.getStatus() + " ";
                var msg = response.mapError(HashMap.class);
                if (msg != null) {
                    if (msg.containsKey("message")) msgErro += msg.containsKey("message");
                    if (msg.containsKey("Message")) msgErro += msg.containsKey("Message");
                }
                throw new UnirestException(msgErro);
            }
        } catch (UnirestException e) {
            log.warn("[getPedidoPorId] - Erro: " + e.getMessage());
            return null;
        }
    }

    public List<OrderDTO> getPedidosPorStatus(String status) throws IOException {
        var props = properties.getProperties();
        List<OrderDTO> result = new ArrayList<>();
        HttpResponse<OrdersDTO> response = null;
        try {
            var temPedidos = true;
            int pag = 1;
            while (temPedidos) {
                String url = props.getProperty("properties.vtex.url") + DadosVtex.endPointPedidos + DadosVtex.sellers + "&perPage=50&page=" + pag
                        + "&status=" + status;

                response = Unirest.get(url).header("Content-Type", "application/json")
                        .header("X-VTEX-API-AppKey", props.getProperty("properties.vtex.appkey"))
                        .header("X-VTEX-API-AppToken", props.getProperty("properties.vtex.apptoken"))
                        .asObject(OrdersDTO.class);

                Arrays.stream(response.getBody().getOrders()).map(result::add);

                ++pag;
                temPedidos = !(response.getBody().getPageCount() < response.getBody().getPerPage());
            }
            return result;
        } catch (UnirestException e) {
            log.warn("[getPedidosPorData] - Erro: " + e.getMessage());
            return null;
        }
    }

    public List<OrderDTO> getPedidosPorData(String dataIni, String dataFim) throws IOException {
        var props = properties.getProperties();
        List<OrderDTO> result = new ArrayList<>();
        HttpResponse<OrdersDTO> response = null;
        try {
            var temPedidos = true;
            int pag = 1;
            while (temPedidos) {
                String url = props.getProperty("properties.vtex.url") + "/oms/orders/?an=" + DadosVtex.sellers + "&perPage=50&page=" + pag +
                        "&creationDateStart=" + dataIni + "&creationDateEnd=" + dataFim;

                response = Unirest.get(url)
                        .header("Content-Type", "application/json")
                        .header("X-VTEX-API-AppKey", props.getProperty("properties.vtex.appkey"))
                        .header("X-VTEX-API-AppToken", props.getProperty("properties.vtex.apptoken"))
                        .asObject(OrdersDTO.class);

                var list = response.getBody().getOrders();
                for (var i = 0; i < list.length; i++) {
                    result.add(list[i]);
                }

                ++pag;
                temPedidos = !(response.getBody().getPageCount() < response.getBody().getPerPage());
            }
            return result;
        } catch (UnirestException e) {
            log.warn("[getPedidosPorData] - Erro: " + e.getMessage());
            return null;
        }
    }

}
