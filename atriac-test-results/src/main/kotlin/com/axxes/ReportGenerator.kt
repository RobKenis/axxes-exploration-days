package com.axxes

import io.quarkus.vertx.ConsumeEvent
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class ReportGenerator {
    @ConsumeEvent(SwimSpeedComputedEvent.address)
    fun onMessage (event: SwimSpeedComputedEvent) {

    }
}