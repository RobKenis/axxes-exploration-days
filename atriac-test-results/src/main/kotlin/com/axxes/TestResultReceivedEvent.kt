package com.axxes

data class TestResultReceivedEvent(val name: String,
                                   val testResult: TestResult) : Event<TestResultReceivedEvent> {
    companion object {
        const val address = "TEST_RESULT_RECEIVED"
    }

    override fun address(): String {
        return address
    }

    override fun payload(): TestResultReceivedEvent {
        return this
    }
}
