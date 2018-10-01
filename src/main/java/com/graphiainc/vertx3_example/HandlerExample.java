package com.graphiainc.vertx3_example;

import com.graphiainc.vertx3_example.handler.MessageHandler;

import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.ext.web.Router;

/**
 * <p>routeの動作検証するためのコード。以下のcurlコマンド等で動作検証可能。
 * curl -i http://localhost:8080/message/hello <br>
 * curl -i http://localhost:8080/message/a <br>
 * </p>
 *
 */
public class HandlerExample 
{
    public static void main( String[] args )
    {
    	Vertx vertx = Vertx.vertx();
    	HttpServer server = vertx.createHttpServer();

    	Router router = Router.router(vertx);

    	router.route("/message/hello").handler(new MessageHandler("hello"));
    	router.route("/message/bye").handler(new MessageHandler("bye"));
    	router.route("/message/*").handler(new MessageHandler("unknown"));
    	router.route().handler(rc -> {rc.response().end();}); // response().end() しないと resource not found になっちゃうので

    	server.requestHandler(router::accept).listen(8080);    	
    }
}
