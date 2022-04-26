plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
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
    implementation(project(Models.domain))
    implementation(project(Models.common))

    //Androidx libs
    implementation(Libraries.androidxCore)
    implementation(Libraries.androidxAppCompat)
    implementation(Libraries.constraintLayout)

    //Coroutines
    implementation(Libraries.coroutinesCore)
    implementation(Libraries.coroutinesAndroid)

    //material design
    implementation(Libraries.materialDesign)

    // Navigation Component
    implementation(Libraries.navComponentFragment)
    implementation(Libraries.navComponentUI)


    //Hilt for di
    implementation(Libraries.hilt)
    kapt(Libraries.hiltAndroidCompiler)

    //Glide for image rendering
    implementation(Libraries.glide)
    kapt(Libraries.glideCompiler)

    //test
    implementation(Libraries.junit)
    androidTestImplementation(Libraries.androidxJunit)
    androidTestImplementation(Libraries.androidxEspresso)
    testImplementation(Libraries.mokito)
    androidTestImplementation(Libraries.mockitoCore)
    testImplementation(Libraries.arcCore)
    testImplementation(Libraries.coroutinesTest)
}