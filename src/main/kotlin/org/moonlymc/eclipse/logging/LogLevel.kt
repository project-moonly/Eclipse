package org.moonlymc.eclipse.logging

import java.util.*

data class LogLevel(
    val name : String,
    val symbol : String,
    val severity : Int
) {

    operator fun invoke(msg : String) : Entry {
        return Entry(this, Date().time, msg, null)
    }

    operator fun invoke(throwable: Throwable, msg: String) : Entry {
        return Entry(this, Date().time, msg, throwable)
    }
}