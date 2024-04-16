plugins {
    alias(libs.plugins.androidApplication)
}

android {
    namespace = "com.emu.emupdfnativeplugin"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.emu.emupdfnativeplugin"
        minSdk = 32
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        ndk {
            abiFilters += listOf("x86_64")
        }
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
    externalNativeBuild {
        cmake {
            path = file("src/main/cpp/CMakeLists.txt")
        }
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    testImplementation(libs.junit)
}