/**
 * Configuration of all gradle build plugins
 */
object Plugins {
    const val ANDROID_APPLICATION = "com.android.application"
    const val ANDROID_DYNAMIC_FEATURE = "com.android.dynamic-feature"
    const val ANDROID_LIBRARY = "com.android.library"

    const val DETEKT = "io.gitlab.arturbosch.detekt"

    const val JAVA_LIBRARY = "java-library"

    const val KOTLIN = "kotlin"
    const val KOTLIN_ANDROID = "android"

    const val KTLINT = "org.jlleitschuh.gradle.ktlint"
    const val UPDATE_DEPENDENCIES = "com.github.ben-manes.versions"
}