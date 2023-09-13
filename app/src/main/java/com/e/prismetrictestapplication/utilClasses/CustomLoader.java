package com.e.prismetrictestapplication.utilClasses;

import android.app.Dialog;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.e.prismetrictestapplication.R;


public class CustomLoader extends Dialog {
    public CustomLoader(@NonNull Context context) {
        super(context);
    }

    public CustomLoader(Context context, int themeResId) {
        super(context, themeResId);
        setContentView(R.layout.progress_view);
    }

    protected CustomLoader(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }
}
