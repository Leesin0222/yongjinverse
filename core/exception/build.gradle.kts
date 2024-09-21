plugins {
    alias(libs.plugins.yongniverse.android.library)
}

android {
    namespace = "com.yongjincompany.core.exception"
}

dependencies {
    implementation(libs.retrofit.core)
}