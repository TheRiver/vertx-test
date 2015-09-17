package com.randomlyrudy.test;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;

/**
 * Created by rudy on 9/17/15.
 */
public class MyFirstVerticle extends AbstractVerticle {

    @Override
    public void start(Future<Void> fut) throws Exception {
        vertx
                .createHttpServer()
                .requestHandler(r -> r.response().end("<h1>Hello!</h1>"))
                .listen(8080, result -> {
                    if (result.succeeded()) {
                        fut.complete();
                    } else {
                        fut.fail(result.cause());
                    }
                });
    }
}
