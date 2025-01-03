package com.filipedias.server;

import com.filipedias.controller.MagicLinkController;
import com.sun.net.httpserver.HttpServer;
import lombok.extern.log4j.Log4j2;

import static com.filipedias.utils.HttpHelper.sendReply;

@Log4j2
public class Router {

    public static void routes (HttpServer server) {
        server.createContext("/magiclink", exchange -> {
            switch (exchange.getRequestMethod()) {
                case "POST":
                    MagicLinkController.post(exchange);
                    break;
                default:
                    String message = String.format("Método '%s' não é permitido! Use 'POST'.", exchange.getRequestMethod());
                    sendReply(exchange, message, 405);
                    break;
            }
        });
    }
}
