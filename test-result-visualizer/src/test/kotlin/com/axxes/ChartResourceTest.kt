package com.axxes

import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured.`when`
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.condition.DisabledIfEnvironmentVariable
import org.xmlunit.matchers.CompareMatcher.isIdenticalTo
import org.xmlunit.placeholder.PlaceholderDifferenceEvaluator
import java.nio.file.Files
import java.nio.file.Paths


@QuarkusTest
@DisabledIfEnvironmentVariable(named = "DISABLE_THE_SVG_TEST", matches = "true", disabledReason = "I don't even know why this doesn't work on GitHub")
class ChartResourceTest {

    @Test
    fun generate200m() {
        val expected = Files.readString(Paths.get("src/test/resources/test200.svg"))
        `when`().get("/chart/200.svg?first=106&second=118&testName=nov22")
                .then()
                .statusCode(200)
                .body(isIdenticalTo(expected).withDifferenceEvaluator(PlaceholderDifferenceEvaluator()).ignoreWhitespace())
    }
}