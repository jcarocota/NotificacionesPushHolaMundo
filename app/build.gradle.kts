plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.ebc.notificacionespushholamundo"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.ebc.notificacionespushholamundo"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    val work_version = "2.10.1"

    // (Java only)
    implementation("androidx.work:work-runtime:$work_version")

    // Kotlin + coroutines
    implementation("androidx.work:work-runtime-ktx:$work_version")

    // optional - RxJava2 support
    implementation("androidx.work:work-rxjava2:$work_version")

    // optional - GCMNetworkManager support
    implementation("androidx.work:work-gcm:$work_version")

    // optional - Test helpers
    androidTestImplementation("androidx.work:work-testing:$work_version")

    // optional - Multiprocess support
    implementation("androidx.work:work-multiprocess:$work_version")
}