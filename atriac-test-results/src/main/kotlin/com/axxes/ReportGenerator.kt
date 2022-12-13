package com.axxes

import io.quarkus.vertx.ConsumeEvent
import io.vertx.core.eventbus.Message
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class ReportGenerator(val eventPublisher: EventPublisher, val hackService: HackService) {
    @ConsumeEvent(SwimSpeedComputedEvent.address)
    fun onMessage (event: Message<SwimSpeedComputedEvent>) {
        val swimSpeed = event.body().swimSpeed

        val htmlString = "<html><body><h1>Hello ${event.body().name}</h1><table>" +
                "<tr>" +
                    "<th>Relax</th>" +
                    "<th>Cruise</th>" +
                    "<th>CSS</th>" +
                    "<th>MediumHard</th>" +
                    "<th>Hard</th>" +
                    "<th>FullOut</th>" +
                "</tr>" +
                "<tr>" +
                    "<td>${swimSpeed.getRelax()}</td>" +
                    "<td>${swimSpeed.getCruise()}</td>" +
                    "<td>${swimSpeed.getCSS()}</td>" +
                    "<td>${swimSpeed.getMediumHard()}</td>" +
                    "<td>${swimSpeed.getHard()}</td>" +
                    "<td>${swimSpeed.getFullOut()}</td>" +
                "</tr>" +
                "</table>" +
                "<img src=\"http://localhost:8080/chart/400.svg\" alt=\"Chart\">" +
                "</body></html>"

        hackService.set(htmlString)
    }
}
