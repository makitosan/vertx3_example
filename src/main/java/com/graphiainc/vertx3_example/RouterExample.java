package com.graphiainc.vertx3_example;

import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.Router;

/**
 *
 */
public class RouterExample 
{
    public static void main( String[] args )
    {
    	Vertx vertx = Vertx.vertx();
    	HttpServer server = vertx.createHttpServer();

    	Router router = Router.router(vertx);

    	router.route().handler(routingContext -> {
    		System.out.println(routingContext.request().absoluteURI());

    	  // This handler will be called for every request
    	  HttpServerResponse response = routingContext.response();
    	  response.putHeader("content-type", "text/plain");

    	  // Write to the response and end it
    	  response.end("Hello World from Vert.x-Web!");
    	});

    	server.requestHandler(router::accept).listen(8080);    	
    }
}
