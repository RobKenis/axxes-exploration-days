package com.axxes

import io.quarkus.vertx.ConsumeEvent
import io.vertx.mutiny.core.eventbus.Message
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class CSSCalculator(val eventPublisher: EventPublisher) {
    @ConsumeEvent(TestResultReceivedEvent.address)
    fun consume (message : Message<TestResultReceivedEvent>) {
        val athleteName = message.body().name
        val athleteTimings = message.body().testResult.timings
        val athleteSwimSpeed = SwimSpeed(athleteTimings.getFull400m(), athleteTimings.getFull200m())

        eventPublisher.publish(SwimSpeedComputedEvent(athleteName, athleteSwimSpeed))
    }
}
