plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "org.siddhartVerma.seekhoanime"
    compileSdk = 35

    defaultConfig {
        applicationId = "org.siddhartVerma.seekhoanime"
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

        buildFeatures {
            viewBinding = true
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

    //pagination
    implementation(libs.androidx.paging.runtime.ktx)
    // Retrofit
    implementation(libs.retrofit)
    implementation(libs.converter.gson)
    // Room
    implementation(libs.androidx.room.runtime)
    kapt(libs.androidx.room.compiler)
    // Kotlin Extensions (KTX) for Room
    implementation (libs.androidx.room.ktx)
    // Coroutines
    implementation(libs.kotlinx.coroutines.android)

    implementation(libs.hilt.android) // Use the latest version
    kapt(libs.hilt.android.compiler) // Annotation processor
    kapt (libs.androidx.hilt.compiler)
    // Hilt dependencies
    implementation(libs.hilt.android)
    kapt (libs.hilt.compiler)
    // Hilt ViewModel extension
    implementation (libs.androidx.hilt.navigation.fragment)
    // ViewModel and LiveData
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.lifecycle.livedata.ktx)
    // Google Maps
    implementation(libs.play.services.maps)
    // Material Design
    implementation(libs.material)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.fragment.ktx)
    //glide
    implementation (libs.glide)
}
kapt {
    correctErrorTypes = true
}