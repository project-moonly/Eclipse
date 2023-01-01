


@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.kotlin)
    alias(libs.plugins.versioning)
    `maven-publish`
}

group = "org.moonlymc"
version = versioning.info.full


dependencies {
    api(libs.bundles.kotlin.core)
    api(libs.bundles.kotlin.script)
    api(libs.bundles.konf)
    api(libs.minestom)
    api(libs.logging)
    api(libs.bundles.fluent)
}

publishing {
    publications {
        create<MavenPublication>("local") {
            groupId = "org.moonlymc"
            artifactId = "Eclipse"
            version = rootProject.version.toString()

            from(components["java"])
        }
    }
}




