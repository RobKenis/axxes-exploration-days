package com.axxes

data class TestResultBatchReceivedEvent(val name: String,
                                        val testResults: List<TestResult>): Event<TestResultBatchReceivedEvent> {

    override fun address(): String {
        return "TEST_RESULTS_RECEIVED"
    }

    override fun payload(): TestResultBatchReceivedEvent {
        return this
    }
}
