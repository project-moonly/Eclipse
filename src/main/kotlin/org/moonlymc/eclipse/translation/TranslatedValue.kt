package org.moonlymc.eclipse.translation

data class TranslatedValue(
    val translatable: Translatable,
    val message : String,
    val localeUsed : String?,
    val localeIndex : Int
) {
    val bestTranslationUsed : Boolean = localeIndex == 0
    val fallbackLocaleUsed : Boolean = localeIndex > 0
    val noTranslationFound : Boolean = localeIndex < 0
}