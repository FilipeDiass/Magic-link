package com.filipedias.server;

import com.sun.net.httpserver.HttpServer;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;
import java.net.InetSocketAddress;

@Log4j2
public class Server {

    public static void start () {
        try {
            HttpServer server = HttpServer.create(new InetSocketAddress(3333), 0);
            Router.routes(server);

            server.start();
            log.info("✅ Servidor rodando em http://localhost:3333/magiclink");
        } catch (IOException e) {
            log.error("❌ Erro ao iniciar o servidor: {}", e.getMessage());
        }
    }

}
