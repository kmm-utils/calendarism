@file:Suppress("UNUSED_VARIABLE")

import org.jetbrains.kotlin.gradle.dsl.JsModuleKind.MODULE_COMMONJS
import org.jetbrains.kotlin.gradle.dsl.JsModuleKind.MODULE_UMD
import java.net.URI

@Suppress("DSL_SCOPE_VIOLATION")  // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.kotlin.serialization)
    `maven-publish`
}

val javaVersionValue = rootProject.extra["javaVersion"] as JavaVersion
val moduleNameValue = rootProject.extra["moduleName"] as String
val outputJsFilenameValue = rootProject.extra["outputJsFilename"] as String

@OptIn(org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi::class)
kotlin {
    jvmToolchain {
        languageVersion.set(JavaLanguageVersion.of(javaVersionValue.getInt()))
    }

    targetHierarchy.default()

    androidTarget() {
        publishAllLibraryVariants()

        compilations.all {
            kotlinOptions {
                jvmTarget = javaVersionValue.majorVersion
            }
        }
    }

    js(IR) {
        moduleName = moduleNameValue

        compilations["main"].packageJson {
            customField("hello", mapOf("one" to 1, "two" to 2))
        }

        generateTypeScriptDefinitions()

        browser {
            commonWebpackConfig {
                cssSupport {
                    enabled.set(true)
                }
            }

            webpackTask {
                outputFileName = outputJsFilenameValue
                output.libraryTarget = "commonjs2"
            }

            testTask {
                enabled = false
                useKarma {
                    useIe()
                    useSafari()
                    useFirefox()
                    useChrome()
                    useChromeCanary()
                    useChromeHeadless()
                    usePhantomJS()
                    useOpera()
                }
            }
        }

        nodejs {
            useCommonJs()
        }
    }

    jvm {
        compilations.all {
            kotlinOptions {
                jvmTarget = javaVersionValue.majorVersion
            }
        }
    }

    targets {
        js {
            browser {
                compilations.all {
                    compilerOptions.configure {
                        moduleKind.set(MODULE_UMD)
                    }
                }
            }

            nodejs {
                compilations.all {
                    compilerOptions.configure {
                        moduleKind.set(MODULE_COMMONJS)
                    }
                }
            }

            compilations.all {
                compilerOptions.configure {
                    sourceMap.set(true)
                }
            }

            binaries.executable()
        }
    }

    val publicationsFromMainHost = listOf(jvm(), js(IR)).map { it.name } + "kotlinMultiplatform"

    publishing {
        publications {
            matching { it.name in publicationsFromMainHost }.all {
                val targetPublication = this@all
                tasks.withType<AbstractPublishToMaven>()
                    .matching { it.publication == targetPublication }
                    .configureEach { onlyIf { findProperty("isMainHost") == "true" } }
            }
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(libs.kotlinx.coroutines.core)

                implementation(kotlin("reflect"))
                implementation(libs.kotlinx.serialization.core.core)
                implementation(libs.kotlinx.serialization.json)
            }
        }

        val jsMain by getting {
            dependsOn(commonMain)

            dependencies {
            }
        }

        val androidMain by getting {
            dependsOn(commonMain)
        }

        val commonTest by getting {
            dependsOn(commonMain)

            dependencies {
                implementation(kotlin("test"))
            }
        }

        val jsTest by getting {
            dependsOn(jsMain)
            dependsOn(commonTest)

            dependencies {
            }
        }

        val androidUnitTest by getting {
            dependsOn(androidMain)
            dependsOn(commonTest)
        }

        val androidInstrumentedTest by getting {
            dependsOn(androidMain)
            dependsOn(commonTest)
        }
    }
}

fun JavaVersion.getInt(): Int {
    return this.ordinal + 1
}

tasks.withType<Wrapper> {
    gradleVersion = "8.0"
    distributionType = Wrapper.DistributionType.ALL
}

group = "kmm.utils"
version = "0.01"

publishing {
    publications {
        create<MavenPublication>("maven") {
            artifactId = "calendarism"

            if (components.isEmpty()) logger.lifecycle(">>> EMPTY Components!")
            from(components["kotlin"])

            pom {
                name.set("Kotlin Mobile Multiplatform Calendarism Utils")
                description.set("Methods and classes to do transformations and operations on different calendars")
                url.set("https://github.com/kmm-utils/calendarism")
                licenses {
                    license {
                        name.set("MIT")
                        url.set("https://mit-license.org/")
                    }
                }
                developers {
                    developer {
                        id.set("arlm")
                        name.set("Alexandre Rocha Lima e Marcondes")
                        email.set("alexandre.marcondes@gmail.com")
                    }
                }
                scm {
                    connection.set("scm:git:git://github.com:kmm-utils/calendarism.git")
                    developerConnection.set("scm:git:ssh://git@github.com:kmm-utils/calendarism.git")
                    url.set("https://github.com/kmm-utils/calendarism")
                }
            }
        }
    }

    repositories {
        maven {
            name = "GitHubPackages"
            url = URI.create("https://maven.pkg.github.com/kmm-utils/calendarism")
            credentials {
                username = System.getenv("GITHUB_ACTOR") ?: System.getenv("USERNAME")
                password = System.getenv("GITHUB_TOKEN") ?: System.getenv("TOKEN")
            }
        }
    }
}

android {
    val minSdkValue = rootProject.extra["minSdk"] as Int
    val targetSdkValue = rootProject.extra["targetSdk"] as Int

    namespace = rootProject.extra["libraryId"] as String
    compileSdk = targetSdkValue

    defaultConfig {
        minSdk = minSdkValue

        consumerProguardFiles("consumer-rules.pro")
    }

    buildFeatures {
        compose = false
    }

    packaging {
        resources {
            pickFirsts += "**/*.proto"
            excludes += "/META-INF/*"
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

        debug {
            isMinifyEnabled = false

            matchingFallbacks += listOf("release")
        }
    }

    compileOptions {
        sourceCompatibility = javaVersionValue
        targetCompatibility = javaVersionValue
    }

    dependencies {
        implementation(libs.androidx.collection.ktx)

        implementation(libs.kotlinx.coroutines.android)

        testImplementation(libs.junit)
        androidTestImplementation(libs.bundles.androidx.test.espresso)

    }
}