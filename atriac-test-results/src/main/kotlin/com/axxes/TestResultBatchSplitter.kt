package com.axxes

import io.quarkus.vertx.ConsumeEvent
import io.vertx.core.eventbus.Message
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class TestResultBatchSplitter(val eventPublisher: EventPublisher) {

    @ConsumeEvent(TestResultBatchReceivedEvent.address)
    fun consume(message: Message<TestResultBatchReceivedEvent>) {
        message.body().testResults.parallelStream()
                .map { result: TestResult -> TestResultReceivedEvent(message.body().name, result) }
                .forEach (eventPublisher::publish)
    }
}