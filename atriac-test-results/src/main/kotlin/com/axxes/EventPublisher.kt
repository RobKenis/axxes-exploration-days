package com.axxes

import io.quarkus.logging.Log
import io.vertx.core.eventbus.EventBus
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class EventPublisher(val eventBus: EventBus) {
    fun <T> publish(event: Event<T>) {
        Log.infov("Publishing event {0} to address [{1}]", event.payload(), event.address())
        eventBus.publish(event.address(), event.payload())
    }
}