package com.axxes

import java.util.stream.Stream

interface TestResultListener {

    fun resultsUploaded(): Stream<TestResult>

}