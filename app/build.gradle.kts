plugins {
    alias(libs.plugins.yongniverse.android.application)
    alias(libs.plugins.yongniverse.hilt)
}

android {
    namespace = "com.yongjincompany.yongninverse"

    defaultConfig {
        applicationId = "com.yongjincompany.yongniverse"

        versionCode = 1_0_0_0_0_0
        versionName = "1.0.0"
    }

    buildTypes {
        debug {
            isDebuggable = true
            isMinifyEnabled = false
        }
        release {
            isDebuggable = false
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro",
            )
        }
    }

    flavorDimensions += "version"
    productFlavors {
        create("dev") {
            dimension = "version"
            applicationIdSuffix = ".dev"
            versionNameSuffix = "-dev"
            manifestPlaceholders["appName"] = "용니버스-dev"
        }

        create("prod") {
            dimension = "version"
            manifestPlaceholders["appName"] = "용니버스"
        }
    }

    buildFeatures {
        viewBinding = true
        buildConfig = true
    }
}

fun getApiKey(propertyKey: String): String {
    return com.android.build.gradle.internal.cxx.configure.gradleLocalProperties(rootDir, providers)
        .getProperty(propertyKey)
}

dependencies {
    implementation(project(":core:domain"))
    implementation(project(":core:data"))

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
   // testImplementation(libs.junit)
   // androidTestImplementation(libs.androidx.junit)
   // androidTestImplementation(libs.androidx.espresso.core)

}