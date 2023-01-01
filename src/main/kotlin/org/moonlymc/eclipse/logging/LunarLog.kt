package org.moonlymc.eclipse.logging

object LunarLog {
    val d = LogLevel("DEBUG", "d", 1)
    val i = LogLevel("INFO", "i", 2)
    val w = LogLevel("WARN", "w", 3)
    val e = LogLevel("ERROR", "e", Int.MAX_VALUE)
    val PANIC = LogLevel("PANIC", "PANIC", Int.MAX_VALUE)
    
    var handler : LogHandler = LogHandler.NOOP


    fun log(entry : Entry) {
        handler.handle(entry)
    }
}