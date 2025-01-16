plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.ksp)
    alias(libs.plugins.serialization)
    alias(libs.plugins.navigation.safeargs)
}

android {
    namespace = "com.mdubovikov.waterdrop"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.mdubovikov.waterdrop"
        minSdk = 26
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"
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
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }

    kotlinOptions {
        jvmTarget = "21"
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.dagger.core)
    ksp(libs.dagger.compiler)
    implementation(libs.retrofit)
    implementation(libs.retrofit.converter)
    implementation(libs.okhttp.logging.interceptor)
    implementation(libs.serialization.json)
    implementation(libs.navigation.ui)
    implementation(libs.navigation.fragment)
    implementation(libs.glide)
    ksp(libs.glide.compiler)
}