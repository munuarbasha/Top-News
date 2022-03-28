plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

android {
    compileSdk = Configs.compileSdk

    defaultConfig {
        minSdk = Configs.minSdk
        targetSdk = Configs.targetSdk

        testInstrumentationRunner = Configs.testInstrumentationRunner
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        debug {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        dataBinding = true
    }
}

dependencies {

    //Androidx libs
    implementation(Libraries.androidxCore)
    implementation(Libraries.androidxAppCompat)
    //material design
    implementation(Libraries.materialDesign)
    //Glide for image rendering
    implementation(Libraries.glide)
    kapt(Libraries.glideCompiler)
    //Timber for logs
    api(Libraries.timber)
    //test
    implementation(Libraries.junit)
    implementation(Libraries.androidxJunit)
    implementation(Libraries.androidxEspresso)
}