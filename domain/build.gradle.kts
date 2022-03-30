plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("kotlin-parcelize")
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
}

dependencies {

    implementation(Libraries.androidxCore)
    //Coroutines
    implementation(Libraries.coroutinesCore)
    implementation(Libraries.coroutinesAndroid)
    //Retrofit
    implementation(Libraries.retrofit)
    implementation(Libraries.gsonConverter)
    implementation(Libraries.loggingInterceptor)
    //Hilt for di
    implementation(Libraries.hilt)
    kapt(Libraries.hiltAndroidCompiler)
    //test
    implementation(Libraries.junit)
    implementation(Libraries.androidxJunit)
    testImplementation(Libraries.arcCore)
    testImplementation(Libraries.mockitoCore)
    testImplementation(Libraries.coroutinesTest)
    testImplementation(Libraries.mockitoInline)

}