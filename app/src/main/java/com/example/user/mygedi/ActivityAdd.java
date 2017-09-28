package com.example.user.mygedi;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.kyleduo.switchbutton.SwitchButton;

import java.text.DateFormatSymbols;
import java.util.Calendar;

public class ActivityAdd extends AppCompatActivity {

    Button ibArrowBackActivAdd, btDayTo, btDayFrom;
    SwitchButton sbAllDay;
    LinearLayout llDayTo, llDayFrom, llMore, llImportantTask, llRequiredAnswer, llHideAssigned, llReminder, llRepeat, llTimezone;
    TextView tvTimezone;
    int year_x, month_x, day_x;
    static final int DIALOG_ID = 0;
    String dataTOFROM;

    private static final String MyLOG = "myLogs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        //------------------------------------------------------------Arrow Back
        ibArrowBackActivAdd = (Button) findViewById(R.id.ibArrowBackActivAdd);
        ibArrowBackActivAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.ibArrowBackActivAdd:
                        finish();
                }
            }
        });

        //------------------------------------------------------------SwitchButton All Day
        sbAllDay = (SwitchButton) findViewById(R.id.sbAllDay);
        sbAllDay.setChecked(false);
        sbAllDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.sbAllDay:
                        if (sbAllDay.isChecked() == true) {
                            if (llImportantTask.getVisibility() == View.GONE) {
                                llImportantTask.setVisibility(View.GONE);
                                llRequiredAnswer.setVisibility(View.GONE);
                                llHideAssigned.setVisibility(View.GONE);
                                llReminder.setVisibility(View.GONE);
                                llRepeat.setVisibility(View.GONE);
                                llTimezone.setVisibility(View.GONE);
                            } else {
                                llImportantTask.setVisibility(View.VISIBLE);
                                llRequiredAnswer.setVisibility(View.VISIBLE);
                                llHideAssigned.setVisibility(View.VISIBLE);
                                llReminder.setVisibility(View.VISIBLE);
                                llRepeat.setVisibility(View.VISIBLE);
                                llTimezone.setVisibility(View.VISIBLE);
                            }
                        }
                }

            }
        });
        //------------------------------------------------------------Day TO
        llDayTo = (LinearLayout) findViewById(R.id.llDayTo);
        btDayTo = (Button) findViewById(R.id.btDayTo);

        final Calendar cal = Calendar.getInstance();
        year_x = cal.get(Calendar.YEAR);
        month_x = cal.get(Calendar.MONTH);
        day_x = cal.get(Calendar.DAY_OF_MONTH);
        showDialogOnButtonClick();

        //------------------------------------------------------------Day FROM
        llDayFrom = (LinearLayout) findViewById(R.id.llDayFrom);
        btDayFrom = (Button) findViewById(R.id.btDayFrom);
        year_x = cal.get(Calendar.YEAR);
        month_x = cal.get(Calendar.MONTH);
        day_x = cal.get(Calendar.DAY_OF_MONTH);
        showDialogOnButtonClick();


        //------------------------------------------------------------Button ...MORE
        llMore = (LinearLayout) findViewById(R.id.llMore);
        llMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.llMore:
                        if (llImportantTask.getVisibility() == View.GONE) {
                            llImportantTask.setVisibility(View.VISIBLE);
                            llRequiredAnswer.setVisibility(View.VISIBLE);
                            llHideAssigned.setVisibility(View.VISIBLE);
                            llReminder.setVisibility(View.VISIBLE);
                            llRepeat.setVisibility(View.VISIBLE);
                            llTimezone.setVisibility(View.VISIBLE);
                        } else {
                            llImportantTask.setVisibility(View.GONE);
                            llRequiredAnswer.setVisibility(View.GONE);
                            llHideAssigned.setVisibility(View.GONE);
                            llReminder.setVisibility(View.GONE);
                            llRepeat.setVisibility(View.GONE);
                            llTimezone.setVisibility(View.GONE);
                        }
                }
            }
        });

        llImportantTask = (LinearLayout) findViewById(R.id.llImportantTask);
        llImportantTask.setVisibility(View.GONE);

        llRequiredAnswer = (LinearLayout) findViewById(R.id.llRequiredAnswer);
        llRequiredAnswer.setVisibility(View.GONE);

        llHideAssigned = (LinearLayout) findViewById(R.id.llHideAssigned);
        llHideAssigned.setVisibility(View.GONE);

        llReminder = (LinearLayout) findViewById(R.id.llReminder);
        llReminder.setVisibility(View.GONE);

        llRepeat = (LinearLayout) findViewById(R.id.llRepeat);
        llRepeat.setVisibility(View.GONE);

        llTimezone = (LinearLayout) findViewById(R.id.llTimezone);
        tvTimezone = (TextView) findViewById(R.id.tvTimezone);
        llTimezone.setVisibility(View.GONE);

    }

    public void showDialogOnButtonClick() {
        btDayTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(DIALOG_ID);
            }
        });
    }


    @Override
    protected Dialog onCreateDialog(int id) {
        if (id == DIALOG_ID)
            return new DatePickerDialog(this, dpickerListner, year_x, month_x, day_x);
        return null;
    }

    private DatePickerDialog.OnDateSetListener dpickerListner = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            year_x = year;
            month_x = month;
            day_x = dayOfMonth;
            String monthString = theMonth(month_x);
            switch (view.getId()) {
                case R.id.btDayTo:
                    btDayTo.setText(day_x + " " + monthString + " " + year_x);
                    break;
                case R.id.btDayFrom:
                    btDayFrom.setText(day_x + " " + monthString + " " + year_x);
                    break;
            }


        }
    };

    public static String theMonth(int m) {
        String month1 = "invalid";
        DateFormatSymbols dfs = new DateFormatSymbols();
        String[] months = dfs.getMonths();
        if (m >= 0 && m <= 11) {
            month1 = months[m];
        }
        return month1;
    }
}
