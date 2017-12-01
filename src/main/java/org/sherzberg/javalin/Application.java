package org.sherzberg.javalin;

import io.javalin.Javalin;
import io.javalin.LogLevel;

public class Application {
    public static void main(String[] args) {

        Javalin app = Javalin.create()
                .port(7000)
                .enableStaticFiles("/public")
                .requestLogLevel(LogLevel.EXTENSIVE);

//        app.get("/", ctx -> ctx.ht);

        app.ws("/websocket", ws -> {
            ws.onConnect(session -> {

            });

            ws.onClose((session, status, message) -> {
            });

            ws.onMessage((session, message) -> {
                session.getRemote().sendString("You said: " + message);
            });
        });

        app.start();
    }
}