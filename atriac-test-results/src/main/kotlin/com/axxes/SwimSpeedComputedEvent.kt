package com.axxes

data class SwimSpeedComputedEvent (val name:String, val swimSpeed: SwimSpeed): Event<SwimSpeedComputedEvent> {
    companion object {
        const val address = "SWIM_SPEED_COMPUTED"
    }

    override fun address(): String {
        return address
    }

    override fun payload(): SwimSpeedComputedEvent {
        return this
    }
}