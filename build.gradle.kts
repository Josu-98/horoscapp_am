// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false
    //Dagger Hilt
    id("com.google.dagger.hilt.android") version "2.51.1" apply false
    id("org.jetbrains.kotlin.kapt") version "1.9.20" apply false
    //SafeArgs
    //If project has both Java and Kotlin, remove the .kotlin at the end
    id("androidx.navigation.safeargs.kotlin") version "2.7.7" apply false

}