package br.com.i7solution.vtex.apivtex;

import java.io.IOException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.*;

import br.com.i7solution.vtex.config.PropertiesConfig;
import br.com.i7solution.vtex.tools.Ferramentas;
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

    public OrderDTO getPedidoPorId(Long orderId) throws IOException {
        var props = properties.getProperties();
        var result = new OrderDTO();
        HttpResponse<OrderDTO> response = null;
        try {
            String url = props.getProperty("properties.vtex.url") +
                    DadosVtex.endPointPedidos +
                    "/" + orderId;

            response = Unirest.get(url)
                    .header("Content-Type", "application/json")
                    .header("X-VTEX-API-AppKey", props.getProperty("properties.vtex.appkey"))
                    .header("X-VTEX-API-AppToken", props.getProperty("properties.vtex.apptoken"))
                    .asObject(OrderDTO.class);

            if (response.getStatus() == 200) {
                result = response.getBody();
            } else {
                String msgErro = "HttpStatus: " + response.getStatus() + " \n";
                var msg = response.mapError(HashMap.class);
                if (msg != null) {
                    if (msg.containsKey("Message")) msgErro += msg.get("Message") + " \n";
                    if (msg.containsKey("message")) msgErro += msg.get("message") + " \n";
                }
                throw new UnirestException(msgErro);
            }
            return result;
        } catch (UnirestException e) {
            log.warn("[getPedidos] - Erro: " + e.getMessage());
            return null;
        }
    }

    /* Status possíveis:
    waiting-for-sellers-confirmation - pendente
    payment-pending - bloqueado
    payment-approved - liberado
    ready-for-handling - montado
    handling - montado
    invoiced - faturado
    canceled - cancelado
    */
    public List<OrderDTO> getPedidos(String status, Long diasPedidos) throws IOException {
        var props = properties.getProperties();
        List<OrderDTO> result = new ArrayList<OrderDTO>();
        HttpResponse<OrdersDTO> response = null;
        try {
            Date dtPedidos = Date.from(Instant.now().minus(diasPedidos, ChronoUnit.DAYS));
            String dtInicio = Ferramentas.dataFormatada(dtPedidos, "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
            String dtFim = Ferramentas.dataFormatada(Date.from(Instant.now()), "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

            var temPedidos = true;
            int pag = 1;
            while (temPedidos) {
                String url = props.getProperty("properties.vtex.url") + DadosVtex.endPointPedidos;

                response = Unirest.get(url)
                        .header("Content-Type", "application/json")
                        .header("X-VTEX-API-AppKey", props.getProperty("properties.vtex.appkey"))
                        .header("X-VTEX-API-AppToken", props.getProperty("properties.vtex.apptoken"))
                        .queryString("per_page", 30)
                        .queryString("page", pag)
                        .queryString("f_status", status)
                        .queryString("f_creationDate", "creationDate:[" + dtInicio + " TO " + dtFim + "]")
                        .asObject(OrdersDTO.class);

                if (response.getStatus() == 200) {
                    if (response.getBody().getList().length > 0) {
                        var listaPedidos = response.getBody().getList();
                        result.addAll(Arrays.asList(listaPedidos));
                    }

                    temPedidos = pag < response.getBody().getPaging().getPages();
                    ++pag;
                } else {
                    String msgErro = "HttpStatus: " + response.getStatus() + " \n";
                    var msg = response.mapError(HashMap.class);
                    if (msg != null) {
                        if (msg.containsKey("Message")) msgErro += msg.get("Message") + " \n";
                        if (msg.containsKey("message")) msgErro += msg.get("message") + " \n";
                    }
                    throw new UnirestException(msgErro);
                }
            }
            return result;
        } catch (UnirestException e) {
            log.warn("[getPedidos] - Erro: " + e.getMessage());
            return null;
        }
    }

}
