package com.graphiainc.vertx3_example.handler;

import org.junit.Test;

import com.graphiainc.vertx3_example.WebTestBase;

import io.vertx.core.http.HttpMethod;

public class MessageHandlerTest extends WebTestBase {
	@Override
	public void setUp() throws Exception {
		super.setUp();
		router.route().handler(new MessageHandler("junit"));
	}


	@Test
	public void testGETWithBody() throws Exception {
		router.route().handler(rc -> {
			System.out.println("invoked " + rc.response().bytesWritten());
			assertEquals(16, rc.response().bytesWritten());
			// assertNotNull(rc.getBody());
			System.out.println(rc.getBodyAsString());
			// 既にコミット済みであればここでDBの検証等を行う
			rc.response().end();
		});
		testRequest(HttpMethod.GET, "/", 200, "OK", "message is junit");
		// こっちの実装方法だとここではassert入れられない
	}
	
	@Test
	public void test_syncRequest() throws Exception {
		router.route().handler(rc -> {
			System.out.println("invoked " + rc.response().bytesWritten());
			assertEquals(16, rc.response().bytesWritten());
			// assertNotNull(rc.getBody());
			System.out.println(rc.getBodyAsString());
			// 既にコミット済みであればここでDBの検証等を行っても良いし、下で行っても良い
			rc.response().end();
		});
		// 同期的にテストを実行する感じ
		testSyncRequest(HttpMethod.GET.name(), "/hogehoge", 200, "OK", "message is junit");
		// もしDBの検証等するならここ以下で行う assert 等
	}
}
