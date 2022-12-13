package com.axxes

data class TestResultBatchReceivedEvent(val name: String,
                                        val testResults: List<TestResult>) : Event<TestResultBatchReceivedEvent> {

    companion object {
        const val address = "TEST_RESULTS_BATCH_RECEIVED"
    }

    override fun address(): String {
        return address
    }

    override fun payload(): TestResultBatchReceivedEvent {
        return this
    }
}
