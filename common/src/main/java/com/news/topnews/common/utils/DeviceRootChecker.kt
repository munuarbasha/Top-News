package com.news.topnews.common.utils

import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import timber.log.Timber
import java.io.BufferedReader
import java.io.File
import java.io.IOException
import java.io.InputStreamReader
/**
 * Util class to verify device root status
 */
object DeviceRootChecker {

    fun isRooted(context: Context): Boolean {
        val isTestBuild = isTestBuild
        val hasSuperuserAPK = hasSuperuserAPK()
        val hasChainFireSuperSU = hasChainFireSuperUser(context)
        val hasSU = hasSU()

        return isTestBuild || hasSuperuserAPK || hasChainFireSuperSU || hasSU
    }

    /* Checker methods  */
    private val isTestBuild: Boolean
        get() {
            val buildTags = Build.TAGS
            return buildTags != null && buildTags.contains("test-keys")
        }

    private fun hasSuperuserAPK(): Boolean {
        return try {
            val file = File("/system/app/Superuser.apk")
            file.exists()
        } catch (e: Exception) {
            false
        }
    }

    private fun hasChainFireSuperUser(context: Context): Boolean {
        return isSuPackageInstalled(context)
    }

    private fun hasSU(): Boolean {
        val su = "su"
        return su.findBinary() || executeCommand(
            arrayOf(
                "/system/xbin/which",
                su
            )
        ) || executeCommand(
            arrayOf(
                "/system/xbin/which",
                "/su"
            )
        ) || executeCommand(arrayOf("which", su))
    }

    private fun String.findBinary(): Boolean {
        val places = arrayOf(
            "/sbin/",
            "/system/bin/",
            "/system/xbin/",
            "/data/local/xbin/",
            "/data/local/bin/",
            "/system/sd/xbin/",
            "/system/bin/failsafe/",
            "/data/local/"
        )
        for (where in places) {
            if (File(where + this).exists()) {
                return true
            }
        }
        return false
    }

    private fun executeCommand(command: Array<String>): Boolean {
        var localProcess: Process? = null
        var inputStreamReader: BufferedReader? = null
        return try {
            localProcess = Runtime.getRuntime().exec(command)
            inputStreamReader = BufferedReader(InputStreamReader(localProcess.inputStream))
            inputStreamReader.readLine() != null
        } catch (e: Exception) {
            false
        } finally {
            localProcess?.destroy()
            if (inputStreamReader != null) {
                try {
                    inputStreamReader.close()
                } catch (e: IOException) {
                    Timber.e(e)
                    e.printStackTrace()
                }
            }
        }
    }
    /* Helper methods to check whether the su package is installed  */
    private fun isSuPackageInstalled(context: Context): Boolean {
        val pm: PackageManager = context.packageManager
        val superUserPackage = "eu.chainfire.supersu"
        return try {
            pm.getPackageInfo(superUserPackage, PackageManager.GET_ACTIVITIES)
            true
        } catch (e: PackageManager.NameNotFoundException) {
            false
        }
    }
}