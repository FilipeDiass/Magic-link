package com.filipedias.controller;

import com.filipedias.model.Email;
import com.filipedias.validation.MagicLinkValidation;
import com.sun.net.httpserver.HttpExchange;
import lombok.extern.log4j.Log4j2;

import java.io.InputStream;

import static com.filipedias.utils.HttpHelper.sendReply;

@Log4j2
public class MagicLinkController {

    public static void post (HttpExchange exchange) {
        try (InputStream is = exchange.getRequestBody()) {
            Email email = MagicLinkValidation.bodyValidation(is);

            String message = String.format("Email recebido com sucesso: %s", email.getEmail());
            sendReply(exchange, message, 200);

            log.info("Email recebido com sucesso: {}", email.getEmail());
        } catch (IllegalArgumentException e) {
            sendReply(exchange, "Erro de validação: " + e.getMessage(), 400);
            log.error("Erro de validação: {}", e.getMessage(), e);
        } catch (Exception e) {
            sendReply(exchange, "Erro inesperado: " + e.getMessage(), 500);
            log.error("Erro inesperado: {}", e.getMessage(), e);
        }
    }

}
