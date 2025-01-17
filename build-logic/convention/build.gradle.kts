import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    `kotlin-dsl`
}

group = "com.yongjincompany.convention.yongniverse"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

kotlin {
    compilerOptions {
        jvmTarget = JvmTarget.JVM_17
    }
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.android.tools.common)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.ksp.gradlePlugin)
    compileOnly(libs.hilt.gradlePlugin)
}

tasks {
    validatePlugins {
        enableStricterValidation = true
        failOnWarning = true
    }
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "yongniverse.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }
        register("androidLibrary") {
            id = "yongniverse.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }
        register("hilt") {
            id = "yongniverse.hilt"
            implementationClass = "HiltConventionPlugin"
        }
        register("jvmLibrary") {
            id = "yongniverse.jvm.library"
            implementationClass = "JvmLibraryConventionPlugin"
        }
    }
}