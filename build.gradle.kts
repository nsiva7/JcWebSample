plugins {
    kotlin("js") version "1.7.0"
}

repositories {
    mavenCentral()
}

kotlin {
    js {
        browser {
            webpackTask {
                output.libraryTarget = "umd"
            }
        }
        binaries.executable()
    }
}

tasks {
    register<Copy>("copyDistributions") {
        from("build/distributions")
        into("docs")
    }
}
