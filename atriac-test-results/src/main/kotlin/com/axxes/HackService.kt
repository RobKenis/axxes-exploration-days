package com.axxes

import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class HackService {
    var tmp: String = ""

    fun set(param: String) {
        this.tmp = param
    }

    fun get(): String {
        return tmp;
    }
}
