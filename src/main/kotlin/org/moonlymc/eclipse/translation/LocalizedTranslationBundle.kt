package org.moonlymc.eclipse.translation

interface LocalizedTranslationBundle {
    val locale : List<String>
    fun translate(translatable: Translatable, args : Map<String, Any>? = null) : String?
}