package com.news.topnews.common.utils

import android.app.Dialog
import android.content.Context
import android.view.Window
import com.news.topnews.common.R

object ProgressDialogUtil {
    fun setProgressDialog(context: Context): Dialog {
        val dialog = Dialog(context)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.circular_progress_indicator_view)
        return dialog
    }
}