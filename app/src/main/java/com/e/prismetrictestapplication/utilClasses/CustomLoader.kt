package com.e.prismetrictestapplication.utilClasses

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import com.e.prismetrictestapplication.R

class CustomLoader : Dialog {
    constructor(context: Context) : super(context) {}
    constructor(context: Context?, themeResId: Int) : super(context!!, themeResId) {
        setContentView(R.layout.progress_view)
    }

    protected constructor(
        context: Context,
        cancelable: Boolean,
        cancelListener: DialogInterface.OnCancelListener?
    ) : super(context, cancelable, cancelListener) {
    }
}