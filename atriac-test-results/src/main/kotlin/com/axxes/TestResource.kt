package com.axxes

import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("/kotlin")
class TestResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    fun test(): String {
        return "hello"
    }
}