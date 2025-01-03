package com.filipedias.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.HttpExchange;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.Map;

@Log4j2
public class HttpHelper {

    public static void sendReply (HttpExchange exchange, String message, int statusCode) {
        try (OutputStream os = exchange.getResponseBody()) {
            exchange.getResponseHeaders().add("Content-Type", "application/json; charset=UTF-8");

            Map<String, Object> responseMap = new LinkedHashMap<>();
            responseMap.put("status_code", statusCode);
            responseMap.put("message", message);

            ObjectMapper mapper = new ObjectMapper();
            String reply = mapper.writeValueAsString(responseMap);

            exchange.sendResponseHeaders(statusCode, reply.getBytes(StandardCharsets.UTF_8).length);
            os.write(reply.getBytes());
        } catch (IOException e) {
            log.error("Erro ao enviar resposta HTTP: {}", e.getMessage(), e);
        }
    }

}
