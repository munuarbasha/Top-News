/**
 * object class for build plugin information
 */
object BuildPlugins {
    const val buildTools = "com.android.tools.build:gradle:${GradleVersions.buildTools}"
    const val kotlinGradle = "org.jetbrains.kotlin:kotlin-gradle-plugin:${GradleVersions.kotlinGradlePlugin}"
    const val navSafeArgs = "androidx.navigation:navigation-safe-args-gradle-plugin:${GradleVersions.navComponentVersion}"
    const val hiltGradlePlugin = "com.google.dagger:hilt-android-gradle-plugin:${GradleVersions.hiltVersion}"
}