package org.moonlymc.eclipse.translation

class LocalizedTranslationBundleSequence(val bundles : List<LocalizedTranslationBundle>) {

    fun format(
        translatable: Translatable,
        args : Map<String, Any>? = null,
        fallback : String = translatable.name
    ): TranslatedValue {
        var localeUsed = 0
        return this.bundles.firstNotNullOfOrNull {
            it.translate(translatable, args)?.let { m ->
                TranslatedValue(
                    translatable = translatable,
                    message = m,
                    localeUsed = it.locale.takeIf { locales -> locales.isNotEmpty() }?.first(),
                    localeIndex = localeUsed
                )
            }.also {
                localeUsed++
            }
        } ?: TranslatedValue(translatable, fallback, null, -1)
    }
}