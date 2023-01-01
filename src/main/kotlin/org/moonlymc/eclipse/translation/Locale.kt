package org.moonlymc.eclipse.translation

interface Locale : Translatable {
    val languageCode : String
    val countryCode : String?
    val aliases : Array<String>

    val id get() = "$languageCode${if (countryCode.isNullOrBlank()) "" else "-$countryCode"}"
}