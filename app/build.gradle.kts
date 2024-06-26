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
        getByName("release") {
            isMinifyEnabled = false
            isDebuggable = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            resValue("string", "appName", "HoroscApp")
            buildConfigField("String", "BASE_URL", "\"https://newastro.vercel.app/\"")
        }

        getByName("debug") {
            buildConfigField("String", "BASE_URL", "\"https://newastro-debug.vercel.app/\"")
            resValue("string", "appName", "[DEBUG] HoroscApp")
            isDebuggable = true
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
        //Activate viewBinding
        viewBinding = true
        //Activate buildConfig
        buildConfig = true
    }

    //JVM to version 8 (For some reason it crashes the compilation)
//    kotlin{
//        jvmToolchain(8)
//    }

}

dependencies {

    testImplementation("org.junit.jupiter:junit-jupiter:5.8.1")
    testImplementation("org.junit.jupiter:junit-jupiter:5.8.1")
    testImplementation("org.junit.jupiter:junit-jupiter:5.8.1")
    val camVersion: String = "1.3.3"

    //AndroidX Camera
    // https://mvnrepository.com/artifact/androidx.camera/camera-core
    implementation("androidx.camera:camera-core:$camVersion")
    // https://mvnrepository.com/artifact/androidx.camera/camera-camera2
    implementation("androidx.camera:camera-camera2:$camVersion")
    // https://mvnrepository.com/artifact/androidx.camera/camera-lifecycle
    implementation("androidx.camera:camera-lifecycle:$camVersion")
    // https://mvnrepository.com/artifact/androidx.camera/camera-view
    implementation("androidx.camera:camera-view:$camVersion")
    // https://mvnrepository.com/artifact/androidx.camera/camera-extensions
    implementation("androidx.camera:camera-extensions:$camVersion")



    //SafeArgs (unnecessary, apparently)
    // https://mvnrepository.com/artifact/androidx.navigation.safeargs/androidx.navigation.safeargs.gradle.plugin
    //implementation("androidx.navigation.safeargs:androidx.navigation.safeargs.gradle.plugin:2.7.7")

    //Retrofit, GSON & LoggingInterceptor
    // https://mvnrepository.com/artifact/com.squareup.retrofit2/retrofit
    implementation("com.squareup.retrofit2:retrofit:2.11.0")
    // https://mvnrepository.com/artifact/com.squareup.retrofit2/converter-gson
    implementation("com.squareup.retrofit2:converter-gson:2.11.0")
    // https://mvnrepository.com/artifact/com.squareup.okhttp3/logging-interceptor
    implementation("com.squareup.okhttp3:logging-interceptor:4.12.0")


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

    //Testing
    // https://mvnrepository.com/artifact/io.kotlintest/kotlintest-runner-junit5
    testImplementation("io.kotlintest:kotlintest-runner-junit5:3.4.2")
    // https://mvnrepository.com/artifact/io.mockk/mockk
    testImplementation("io.mockk:mockk:1.13.11")


    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}