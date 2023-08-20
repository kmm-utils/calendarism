@Suppress("DSL_SCOPE_VIOLATION")  // TODO: Remove once KTIJ-19369 is fixed

// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
}

val javaVersion by extra(JavaVersion.toVersion(libs.versions.java.get()))
val kotlinCompilerExtension by extra(libs.versions.kotlin.compiler.extension.get())

val minSdk by extra(libs.versions.min.sdk.stable.get().toInt())
val targetSdk by extra(libs.versions.target.sdk.stable.get().toInt())

val versionCode by extra(1)
val versionName by extra("1.0.0")

var moduleName by extra("kmm.utils.sample.geologicalcalendar")