package com.axxes

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import java.time.Duration
import java.time.temporal.ChronoUnit


class SwimSpeedTest {
    val testResult = SwimSpeed(Duration.of(4, ChronoUnit.MINUTES),
        Duration.of(90, ChronoUnit.SECONDS))

    @Test
    fun retrieveCssFromSwimSpeed () {
        Assertions.assertThat(testResult.getCSS()).isEqualTo (Duration.of(75, ChronoUnit.SECONDS))
    }

    @Test
    fun retrieveRelaxSwimSpeed () {
        Assertions.assertThat(testResult.getRelax()).isEqualTo(Duration.of(85, ChronoUnit.SECONDS))
    }

    @Test
    fun retrieveCruiseSwimSpeed () {
        Assertions.assertThat(testResult.getCruise()).isEqualTo(Duration.of(80, ChronoUnit.SECONDS))
    }

    @Test
    fun retrieveMediumHardSwimSpeed () {
        Assertions.assertThat(testResult.getMediumHard()).isEqualTo(Duration.of(70, ChronoUnit.SECONDS))
    }

    @Test
    fun retrieveHardSwimSpeed () {
        Assertions.assertThat(testResult.getHard()).isEqualTo(Duration.of(65, ChronoUnit.SECONDS))
    }

    @Test
    fun retrieveFullOutSwimSpeed () {
        Assertions.assertThat(testResult.getFullOut()).isEqualTo(Duration.of(60, ChronoUnit.SECONDS))
    }
}