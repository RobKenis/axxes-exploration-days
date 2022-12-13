package com.axxes

import javax.inject.Inject
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("/result")
class KutKlasse(val hackService: HackService) {


    @GET
    @Produces(MediaType.TEXT_HTML)
    fun lol(): String {
        return hackService.get()
    }
}
