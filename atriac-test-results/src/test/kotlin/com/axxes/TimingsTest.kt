package com.axxes


import com.axxes.Timings
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import java.time.Duration
import java.time.temporal.ChronoUnit

class TimingsTest {

    private val timingsUnderTest = Timings(
            listOf(
                    Duration.of(2, ChronoUnit.MINUTES),
                    Duration.of(4, ChronoUnit.MINUTES),
                    Duration.of(6, ChronoUnit.MINUTES),
                    Duration.of(8, ChronoUnit.MINUTES),
                    Duration.of(1, ChronoUnit.MINUTES),
                    Duration.of(3, ChronoUnit.MINUTES),
            ))

    @Test
    fun get200m() {
        Assertions.assertThat(timingsUnderTest.get200m()).isEqualTo(
                listOf(
                        Duration.of(1, ChronoUnit.MINUTES),
                        Duration.of(3, ChronoUnit.MINUTES),
                )
        )
    }

    @Test
    fun get400m() {
        Assertions.assertThat(timingsUnderTest.get400m()).isEqualTo(
                listOf(
                        Duration.of(2, ChronoUnit.MINUTES),
                        Duration.of(4, ChronoUnit.MINUTES),
                        Duration.of(6, ChronoUnit.MINUTES),
                        Duration.of(8, ChronoUnit.MINUTES)
                )
        )
    }
}