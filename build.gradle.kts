


@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.kotlin)
    alias(libs.plugins.versioning)
    `maven-publish`
}

group = "org.moonlymc"
version = versioning.info.full


dependencies {
    implementation(libs.bundles.kotlin.core)
    implementation(libs.bundles.kotlin.script)
    implementation(libs.bundles.konf)
    implementation(libs.minestom)
    implementation(libs.logging)
    implementation(libs.bundles.fluent)
}

publishing {
    publications {
        create<MavenPublication>("jitpack") {
            groupId = "com.github.project-moonly"
            artifactId = "Eclipse"
            version = rootProject.version.toString()

            from(components["java"])
        }
    }
}




