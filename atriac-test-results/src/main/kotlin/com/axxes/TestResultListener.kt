package com.axxes

interface TestResultListener {

    fun resultsUploaded(): TestResultBatchReceivedEvent

}