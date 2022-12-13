package com.axxes

import io.quarkus.vertx.ConsumeEvent
import io.vertx.core.eventbus.Message
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class TestResultReceivedListener {

    @ConsumeEvent("TEST_RESULTS_RECEIVED")
    fun consume(message: Message<TestResultBatchReceivedEvent>) {
        println(message.body().toString())
    }

}