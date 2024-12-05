plugins {
    id("kotlin-kapt")
    id ("com.android.application")
    id ("kotlin-android")
}

android {
    namespace = "com.example.lab11"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.lab11"
        minSdk = 24
        targetSdk = 34
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
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    implementation (libs.androidx.core.ktx.v160)
    implementation (libs.kotlin.stdlib)
    implementation (libs.material.v140)


    val room_version = "2.6.1"
    val lifecycle_version = "2.7.0"
    val nav_version = "2.7.6"

    // Room Database
    implementation (libs.androidx.room.runtime)
    kapt (libs.androidx.room.compiler)
    implementation ("androidx.room:room-ktx:$room_version")

    // ViewModel & LiveData
    implementation (libs.androidx.lifecycle.viewmodel.ktx)
    implementation (libs.androidx.lifecycle.livedata.ktx)

    // Navigation Component
    implementation (libs.androidx.navigation.fragment.ktx)
    implementation (libs.androidx.navigation.ui.ktx)

    // Material Design
    implementation (libs.material.v1110)

    // Coroutines
    implementation (libs.kotlinx.coroutines.android)

    // MPAndroidChart
    implementation (libs.mpandroidchart)
}