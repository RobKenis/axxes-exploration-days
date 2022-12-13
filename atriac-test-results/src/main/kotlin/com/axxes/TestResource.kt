package com.axxes

import java.lang.IllegalArgumentException
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("/kotlin")
class TestResource(val testResultListener: TestResultListener) {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    fun test(): String {
        testResultListener.resultsUploaded()
        return "hello reload"
    }

    @GET
    @Path("/fail")
    @Produces(MediaType.TEXT_PLAIN)
    fun fail(): String {
        testResultListener.resultsUploaded()
        throw IllegalArgumentException("Failed!")
    }


}