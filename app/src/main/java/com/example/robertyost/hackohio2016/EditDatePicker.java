package com.example.robertyost.hackohio2016;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Context;
import android.icu.util.Calendar;
import android.icu.util.TimeZone;
import android.os.Build;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

/**
 * Created by robertyost on 11/19/16.
 */

public class EditDatePicker implements View.OnClickListener, DatePickerDialog.OnDateSetListener {

    EditText dateTxt;
    private int day, month, year;
    private Context context;

    public EditDatePicker(Context context, int editTextViewId)
    {
        Activity activity = (Activity) context;
        this.dateTxt = (EditText)activity.findViewById(editTextViewId);
        dateTxt.setOnClickListener(this);
        this.context = context;
    }

    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
        year = i;
        month = i1;
        day = i2;
        updateDisplay();
    }

    @TargetApi(Build.VERSION_CODES.N)
    @Override
    public void onClick(View view) {
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());

        DatePickerDialog dialog = new DatePickerDialog(context, this, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        dialog.show();
    }

    // updates the date in the birth date editText
    private void updateDisplay() {
        dateTxt.setText(new StringBuilder().append(day).append("/").append(month + 1).append("/").append(year).append(" "));
    }
}
