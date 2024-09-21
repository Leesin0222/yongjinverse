plugins {
    alias(libs.plugins.yongniverse.android.library)
    alias(libs.plugins.yongniverse.hilt)
    alias(libs.plugins.kotlin.serialization)
}

android {
    namespace = "com.yongjincompany.core.data"

    flavorDimensions += "version"
    productFlavors {
        create("dev") {
            dimension = "version"
            buildConfigField("String", "BASE_URL", "\"https://c.com/\"")
        }
        create("stag") {
            dimension = "version"
            buildConfigField("String", "BASE_URL", "\"https://b.com/\"")
        }
        create("prod") {
            dimension = "version"
            buildConfigField("String", "BASE_URL", "\"https://a.com/\"")
        }
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.retrofit.core)
    implementation(libs.retrofit.kotlin.serialization)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.okhttp)
    implementation(libs.okhttp.logging)

    implementation(project(":core:domain"))
    implementation(project(":core:exception"))
}