plugins {
    kotlin("multiplatform") version "1.8.0"
}

kotlin {
    js(IR) {
        browser {
            commonWebpackConfig {
                cssSupport {
                    enabled = true
                }
            }
        }
        binaries.executable()
    }
    sourceSets {
        val jsMain by getting {
            dependencies {
                implementation("org.jetbrains.compose.web:web:1.0.0-alpha4-build340")
            }
        }
    }
}
