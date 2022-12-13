package com.axxes

import java.time.Duration

data class Timings (val timings: List<Duration>) {
    fun get200m(): List<Duration> {
        return timings.subList(4, 6)
    }

    fun get400m(): List<Duration> {
        return timings.subList(0, 4)
    }
}


