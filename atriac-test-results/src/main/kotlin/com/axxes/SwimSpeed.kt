package com.axxes

import java.time.Duration
import java.time.temporal.ChronoUnit

data class SwimSpeed(private val duration400: Duration, private val duration200: Duration) {
    fun getCSS(): Duration {
        return duration400.minus(duration200).dividedBy(2)
    }

    fun getRelax(): Duration {
        return getCSS().plus(Duration.of(10, ChronoUnit.SECONDS));
    }

    fun getCruise(): Duration {
        return getCSS().plus(Duration.of(5, ChronoUnit.SECONDS));
    }

    fun getMediumHard(): Duration {
        return getCSS().minus(Duration.of(5, ChronoUnit.SECONDS));
    }

    fun getHard(): Duration {
        return getCSS().minus(Duration.of(10, ChronoUnit.SECONDS));
    }

    fun getFullOut(): Duration {
        return getCSS().minus(15, ChronoUnit.SECONDS);
    }
}
