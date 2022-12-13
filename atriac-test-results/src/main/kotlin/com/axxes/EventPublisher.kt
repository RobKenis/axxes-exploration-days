package com.axxes

import io.vertx.core.eventbus.EventBus
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class EventPublisher(val eventBus: EventBus) {
    fun <T> publish(event: Event<T>) {
        eventBus.publish(event.address(), event.payload())
    }
}