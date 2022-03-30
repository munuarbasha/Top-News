/**
 * object class for gradle dependencies used in this project
 */
object Libraries {

    //androidx support
    const val androidxCore = "androidx.core:core-ktx:${GradleVersions.androidxCore}"
    const val androidxAppCompat =
        "androidx.appcompat:appcompat:${GradleVersions.androidxAppCompat}"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${GradleVersions.constraintLayout}"

    //Coroutines
    const val coroutinesCore =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${GradleVersions.coroutinesVersion}"
    const val coroutinesAndroid =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${GradleVersions.coroutinesVersion}"

    //Retrofit
    const val retrofit = "com.squareup.retrofit2:retrofit:${GradleVersions.retrofitVersion}"
    const val gsonConverter =
        "com.squareup.retrofit2:converter-gson:${GradleVersions.retrofitVersion}"

    // Logging Interceptor
    const val loggingInterceptor =
        "com.squareup.okhttp3:logging-interceptor:${GradleVersions.loggingInterceptor}"

    //material design
    const val materialDesign = "com.google.android.material:material:${GradleVersions.material}"

    // Navigation Component
    const val navComponentFragment =
        "androidx.navigation:navigation-fragment-ktx:${GradleVersions.navComponentVersion}"
    const val navComponentUI = "androidx.navigation:navigation-ui-ktx:${GradleVersions.navComponentVersion}"

    // Android Jetpack Paging
    const val pagination = "androidx.paging:paging-runtime:${GradleVersions.pagingVersion}"

    //Hilt for di
    const val hilt = "com.google.dagger:hilt-android:${GradleVersions.hiltVersion}"
    const val hiltAndroidCompiler =
        "com.google.dagger:hilt-android-compiler:${GradleVersions.hiltVersion}"

    //Glide for image rendering
    const val glide = "com.github.bumptech.glide:glide:${GradleVersions.glideVersion}"
    const val glideCompiler = "com.github.bumptech.glide:compiler:${GradleVersions.glideVersion}"
    //Timber for Logs
    const val timber = "com.jakewharton.timber:timber:${GradleVersions.timberVersion}"

    const val junit = "junit:junit:${GradleVersions.junitVersion}"
    const val androidxJunit = "androidx.test.ext:junit:${GradleVersions.androidxJunit}"
    const val androidxEspresso =
        "androidx.test.espresso:espresso-core:${GradleVersions.androidxEspresso}"

    const val mokito =  "org.mockito:mockito-all:${GradleVersions.mockito}"
    const val mockitoCore = "org.mockito:mockito-core:${GradleVersions.mockitoCore}"
    const val mockitoInline = "org.mockito:mockito-inline:${GradleVersions.mockitoInlineVersion}"
    const val arcCore =  "androidx.arch.core:core-testing:${GradleVersions.androidArchCoreTesting}"
    const val coroutinesTest =  "org.jetbrains.kotlinx:kotlinx-coroutines-test:${GradleVersions.coroutinesTestVersion}"
}