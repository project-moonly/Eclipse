package org.moonlymc.eclipse.translation

class LocalizedTranslationBundleSequenceProvider {
    suspend fun loadBundleSequence(
        locales : List<String>,
        fallbackLocale: String,
        fetch : suspend (locale : String) -> String?
    ) : LocalizedTranslationBundleSequence {
        val bundles = (locales + fallbackLocale).mapNotNull { locale ->
            fetch.invoke(locale)?.let { source ->
                FluentAdapter(listOf(locale), source)
            }
        }
        return LocalizedTranslationBundleSequence(bundles)
    }
}