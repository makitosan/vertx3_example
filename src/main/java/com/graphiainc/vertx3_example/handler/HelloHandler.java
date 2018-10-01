package com.graphiainc.vertx3_example.handler;

import io.vertx.core.Handler;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.RoutingContext;

public class HelloHandler implements Handler<RoutingContext>{

	@Override
	public void handle(RoutingContext routingContext) {
		System.out.println(routingContext.request().absoluteURI());

  	  // This handler will be called for every request
  	  HttpServerResponse response = routingContext.response();
  	  response.putHeader("content-type", "text/plain");

  	  // Write to the response and end it
  	  response.end("Hello World from Vert.x-Web!");
		
	}

}
