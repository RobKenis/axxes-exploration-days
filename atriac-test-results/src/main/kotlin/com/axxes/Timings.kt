package com.axxes

import java.time.Duration

@JvmInline
value class Timings (private val timings: List<Duration>) {
    fun get200m(): List<Duration> {
        return timings.subList(4, 6)
    }

    fun get400m(): List<Duration> {
        return timings.subList(0, 4)
    }

    fun getFull400m (): Duration {
        return timings[3]
    }

    fun getFull200m (): Duration {
        return timings[5]
    }
}


