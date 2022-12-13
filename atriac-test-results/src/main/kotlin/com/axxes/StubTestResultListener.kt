package com.axxes

import io.vertx.core.eventbus.EventBus
import java.time.Duration
import java.time.LocalDate
import java.time.temporal.ChronoUnit
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class StubTestResultListener(private val eventBus: EventBus) : TestResultListener {

    override fun resultsUploaded(): TestResultBatchReceivedEvent {

        val testResults = listOf(
                TestResult(
                        "Dylan",
                        "John",
                        LocalDate.now(),
                        "dylan.honorez@axxes.com",
                        Timings(listOf(
                                Duration.of(2, ChronoUnit.MINUTES),
                                Duration.of(4, ChronoUnit.MINUTES),
                                Duration.of(6, ChronoUnit.MINUTES),
                                Duration.of(8, ChronoUnit.MINUTES),
                                Duration.of(1, ChronoUnit.MINUTES),
                                Duration.of(3, ChronoUnit.MINUTES),
                        ))
                )
        )

        val event = TestResultBatchReceivedEvent("testBatch", testResults)
        eventBus.publish(event.address(), event.payload())
        return event
    }
}
