package org.moonlymc.eclipse.logging

fun interface LogHandler {
    fun handle(entry: Entry)

    companion object {
        val NOOP = LogHandler {  _ -> }
    }
}

