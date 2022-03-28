package com.news.topnews.common.utils

import android.content.Context
import android.view.View
import androidx.appcompat.app.AlertDialog
import com.news.topnews.common.R

/**
 * Util class to display Alert dialog
 */
class AlertDialogUtils {
    companion object {
        private fun showAlertDialog(
            context: Context,
            title: String? = null,
            message: String? = null,
            positiveButtonTitle: String? = null,
            negativeButtonTitle: String? = null,
            positiveOnClickListener: View.OnClickListener? = null,
            negativeOnClickListener: View.OnClickListener? = null
        ) {
            val builder = AlertDialog.Builder(context)

            title?.let {
                builder.setTitle(it)
            }

            message?.let {
                builder.setMessage(it)
            }

            builder.setCancelable(false)

            positiveButtonTitle?.let {
                builder.setPositiveButton(positiveButtonTitle) { _, _ ->
                    positiveOnClickListener?.onClick(null)
                }
            }

            negativeButtonTitle?.let {
                builder.setNegativeButton(negativeButtonTitle) { _, _ ->
                    negativeOnClickListener?.onClick(null)

                }
            }

            builder.show()
        }

        fun showError(context: Context, message: String?, positiveOnClickListener: View.OnClickListener? = null) {
            val errorMessage = if (message.isNullOrEmpty()) {
                context.getString(R.string.generic_error_message)
            } else {
                message
            }
            showAlertDialog(
                context,
                errorMessage,
                positiveButtonTitle = context.getString(R.string.ok),
                positiveOnClickListener = positiveOnClickListener
            )
        }
    }
}