package com.graphiainc.vertx3_example;

import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerResponse;

/**
 * <p>httpリクエストを受け取り Hello world! を返すVert.xサーバーを起動する。
 * 実行後に以下コマンドで動作確認できる。<br>
 * curl -i http://localhost:8080
 * </p>
 */
public class App 
{
    public static void main( String[] args )
    {
    	Vertx vertx = Vertx.vertx();
    	HttpServer server = vertx.createHttpServer();

    	server.requestHandler(request -> {
    		System.out.println(request.absoluteURI());

    	  // This handler gets called for each request that arrives on the server
    	  HttpServerResponse response = request.response();
    	  response.putHeader("content-type", "text/plain");

    	  // Write to the response and end it
    	  response.end("Hello World!");
    	});

    	server.listen(8080);    	
    }
}
