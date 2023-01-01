package org.moonlymc.eclipse.translation
private val re = "(.+?)([A-Z])".toRegex()

private fun String.camelCase2SnakeCase(): String {
    return re.replace(this) { m -> "${m.groups[1]?.value}_${m.groups[2]?.value}" }.lowercase()
}

interface Translatable {
    val name : String
    val prefix : String
    val messageID : String
        get() = "$prefix-" + (name.let { s ->
            if (s.firstOrNull { c -> c in 'a'..'z'} != null){
                s.camelCase2SnakeCase()
            } else s
        }).replace('_', '-').lowercase()
}