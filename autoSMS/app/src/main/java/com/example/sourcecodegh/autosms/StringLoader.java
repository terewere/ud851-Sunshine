package com.example.sourcecodegh.autosms;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.AsyncTaskLoader;

public class StringLoader extends AsyncTaskLoader {

    public StringLoader(@NonNull Context context) {
        super(context);
    }

    @Nullable
    @Override
    public Object loadInBackground() {
        return null;
    }
}
