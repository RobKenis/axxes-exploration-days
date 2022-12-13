package com.axxes

interface Event<T> {

    fun address(): String

    fun payload(): T

}