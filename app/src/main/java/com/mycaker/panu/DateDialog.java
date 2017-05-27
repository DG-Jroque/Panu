package com.mycaker.panu;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

/**
 * Created by Carlos on 27/05/2017.
 */

@SuppressLint("ValidFragment")
public class DateDialog  extends DialogFragment implements
        DatePickerDialog.OnDateSetListener{

    EditText tx;
    public DateDialog(View v){
        tx=(EditText)v;
    }

    public Dialog onCreateDialog(Bundle saveInstaceState){
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        // Create a new instance of DatePickerDialog and return it
        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int day) {
        String date= day+"-"+month+"-"+year;
        tx.setText(date);
    }
}

