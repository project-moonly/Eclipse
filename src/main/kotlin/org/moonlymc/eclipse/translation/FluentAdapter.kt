package org.moonlymc.eclipse.translation

import fluent.bundle.FluentBundle
import fluent.functions.cldr.CLDRFunctionFactory
import fluent.syntax.parser.FTLParser
import fluent.syntax.parser.FTLStream
import java.util.Locale

class FluentAdapter(override val locale : List<String>, private val ftlContent : String) : LocalizedTranslationBundle {

    private val bundle : FluentBundle

    override fun translate(translatable: Translatable, args: Map<String, Any>?): String? {
        return if(bundle.getMessage(translatable.messageID).isEmpty) {
            null
        } else {
            bundle.format(translatable.messageID, args?.toMutableMap() ?: mutableMapOf<String, Any>())
        }
    }

    init {
        val ftlResource = FTLParser.parse(FTLStream.of(ftlContent))
        val l = Locale.forLanguageTag(locale.first())
        bundle = FluentBundle
            .builder(l, CLDRFunctionFactory.INSTANCE).addResource(ftlResource)
            .build()

    }
}