plugins {
    alias(libs.plugins.yongniverse.android.library)
}

android {
    namespace = "com.yongjincompany.core.base"

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(project(":core:exception"))

    implementation(libs.androidx.lifecycle.viewmodel)
    implementation(libs.kotlinx.coroutines.core)
}