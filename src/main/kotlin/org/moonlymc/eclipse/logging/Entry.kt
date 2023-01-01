package org.moonlymc.eclipse.logging

data class Entry(
    val level : LogLevel,
    val time : Long,
    val message : String,
    val throwable : Throwable?,
    val data :MutableMap<String, Any> = mutableMapOf()
) {

    fun log() {
        LunarLog.log(this)
    }
}