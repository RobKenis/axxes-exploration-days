package com.axxes

import java.time.LocalDate

data class TestResult(
        val athleteName: String,
        val coachName: String,
        val date: LocalDate,
        val athleteEmail: String,
        val timings: Timings
)