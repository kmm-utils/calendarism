@Suppress("DSL_SCOPE_VIOLATION")  // TODO: Remove once KTIJ-19369 is fixed

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

val javaVersionValue = rootProject.extra["javaVersion"] as JavaVersion
val kotlinCompilerExtensionValue = rootProject.extra["kotlinCompilerExtension"] as String

val moduleNameValue = rootProject.extra["moduleName"] as String

val targetSdkValue = rootProject.extra["targetSdk"] as Int
val minSdkValue = rootProject.extra["minSdk"] as Int

val versionCodeValue = rootProject.extra["versionCode"] as Int
val versionNameValue = rootProject.extra["versionName"] as String

android {
    namespace = moduleNameValue
    compileSdk = targetSdkValue

    defaultConfig {
        applicationId = moduleNameValue
        minSdk = minSdkValue
        targetSdk = targetSdkValue
        versionCode = versionCodeValue
        versionName = versionNameValue

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = javaVersionValue
        targetCompatibility = javaVersionValue
    }
    kotlinOptions {
        jvmTarget = javaVersionValue.majorVersion
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = kotlinCompilerExtensionValue
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(libs.androidx.core.ktx.stable)

    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.bundles.compose.ui)
    implementation(libs.bundles.compose.material.phone)
    implementation(libs.bundles.compose.material.icons)
    debugImplementation(libs.bundles.compose.debug)

    implementation(libs.bundles.androidx.emoji2)

    implementation(libs.bundles.androidx.activity)
    implementation(libs.bundles.androidx.appcompat)

    testImplementation(libs.junit)

    androidTestImplementation(libs.androidx.test.ktx)
    androidTestImplementation(libs.androidx.test.core)
    androidTestImplementation(libs.bundles.androidx.test.espresso)

    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    debugImplementation(libs.androidx.compose.ui.test.manifest)
}