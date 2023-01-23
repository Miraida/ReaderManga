package com.example.core_ui.extension

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.example.core_ui.R
import com.google.android.material.snackbar.Snackbar

fun View.visible(visibility: Boolean) {
    this.visibility = if (visibility) View.VISIBLE else View.GONE
}

fun View.showKeyboard() {
    this.requestFocus()
    val inputMethodManager =
        context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.showSoftInput(this, InputMethodManager.SHOW_IMPLICIT)
}

fun View.hideKeyboard() {
    val inputMethodManager =
        context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(windowToken, 0)
}

fun showSnackbar(
    v: View, message: String,
    inflater: LayoutInflater,
    type: String,
    duration: Int = Snackbar.LENGTH_SHORT,
) {
    val customView: View = inflater.inflate((R.layout.custom_toast_error), null)
    val textView = customView.findViewById<TextView>(R.id.toastMsgTv)

    textView.text = message
    if (type == "ERROR") {
        customView.findViewById<ImageView>(R.id.attentionIcon).setImageResource(R.drawable.ic_error)
        customView.background =
            ContextCompat.getDrawable(v.context, R.drawable.bg_custom_toast_error)
    } else {
        customView.findViewById<ImageView>(R.id.attentionIcon)
            .setImageResource(R.drawable.ic_check_circle_outline)
        customView.background =
            ContextCompat.getDrawable(v.context, R.drawable.bg_custom_toast_success)
    }
    val snackBar = Snackbar.make(v, message, duration)

    val snackBarLayout = snackBar.view as Snackbar.SnackbarLayout

    snackBarLayout.setPadding(0, 0, 0, 0)

    snackBarLayout.addView(customView)
    snackBar.show()

}

fun ImageView.load(url: String) {
    Glide.with(this).load(url).into(this)
}