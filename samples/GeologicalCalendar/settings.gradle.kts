pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()

        maven("https://oss.sonatype.org/content/repositories/snapshots")
        maven("https://s01.oss.sonatype.org/content/repositories/releases/")
    }
}

@Suppress("UnstableApiUsage")
dependencyResolutionManagement {
    val dotEnv = file("../../.env")
    if (dotEnv.exists()) {
        dotEnv.readLines().forEach {
            if (it.isNotEmpty() && !it.startsWith("#")) {
                val pos = it.indexOf("=")
                val key = it.substring(0, pos)
                val value = it.substring(pos + 1)

                if (System.getenv(key) == null) {
                    System.setProperty(key, value)
                }
            }
        }
    }

    repositories {
        google()
        mavenCentral()

        maven("https://oss.sonatype.org/content/repositories/snapshots")
        maven("https://s01.oss.sonatype.org/content/repositories/releases/")

        maven("https://maven.pkg.github.com/kmm-utils/version-catalog") {
            credentials {
                username = System.getenv("GITHUB_ACTOR")
                    ?: System.getenv("USERNAME") ?: System.getProperty("USERNAME")
                password = System.getenv("GITHUB_TOKEN")
                    ?: System.getenv("TOKEN") ?: System.getProperty("TOKEN")
            }
        }
    }
    versionCatalogs {
        create("libs") {
            from("kmm.utils:version-catalog:0.4")

            version("java", "17")
            version("min-sdk-stable", "21")
            version("target-sdk-stable", "33")
            version("kotlin-compiler-extension", "1.5.1")
        }
    }
}

rootProject.name = "Geological Calendar"
include(":app")
 