plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    //Dagger Hilt
    id ("kotlin-kapt")
    id ("dagger.hilt.android.plugin")
    //SafeArgs
    id("androidx.navigation.safeargs.kotlin")
}

android {
    namespace = "com.josu64.horoscapp_am"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.josu64.horoscapp_am"
        minSdk = 26
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    //Enable view binding
    buildFeatures{
        viewBinding = true
    }

    //JVM to version 8 (For some reason it crashes the compilation)
//    kotlin{
//        jvmToolchain(8)
//    }

}

dependencies {

    //SafeArgs (unnecessary, apparently)
    // https://mvnrepository.com/artifact/androidx.navigation.safeargs/androidx.navigation.safeargs.gradle.plugin
    //implementation("androidx.navigation.safeargs:androidx.navigation.safeargs.gradle.plugin:2.7.7")


    //Dagger Hilt
    implementation("com.google.dagger:hilt-android:2.51.1")
    kapt ("com.google.dagger:hilt-compiler:2.51.1")

    //Nav version variable to keep consistency between versions
    val navVersion: String = "2.7.7"
    //NavComponent
    implementation("androidx.navigation:navigation-fragment-ktx:$navVersion")
    implementation("androidx.navigation:navigation-ui-ktx:$navVersion")

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}