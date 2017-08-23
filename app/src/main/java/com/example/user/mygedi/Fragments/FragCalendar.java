package com.example.user.mygedi.Fragments;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.mygedi.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import sun.bob.mcalendarview.CellConfig;
import sun.bob.mcalendarview.listeners.OnDateClickListener;
import sun.bob.mcalendarview.listeners.OnExpDateClickListener;
import sun.bob.mcalendarview.listeners.OnMonthScrollListener;
import sun.bob.mcalendarview.utils.CurrentCalendar;
import sun.bob.mcalendarview.views.DefaultCellView;
import sun.bob.mcalendarview.views.ExpCalendarView;
import sun.bob.mcalendarview.vo.DateData;

/**
 * Created by Morkovka on 03.07.2017.
 */

public class FragCalendar extends Fragment implements View.OnClickListener {


    private TextView YearMonthTv;
    private TextView tvMonth;
    private TextView tvDay;
    private TextView tvYear;
    private ExpCalendarView expCalendarView;
    private View lastClickedView;
    private DateData lastClickedDate = CurrentCalendar.getCurrentDateData();
    View view;
    Fragment1DownCalend fragment1DownCalend;
    Fragment2DownCalend fragment2DownCalend;
    Button myTask;
    Button taskOoFriend;
    FragmentTransaction fTrans;


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_calendar, container, false);

        expCalendarView = ((ExpCalendarView) view.findViewById(R.id.calendar_exp));
        tvMonth = (TextView) view.findViewById(R.id.tvMonth);
        tvDay = (TextView) view.findViewById(R.id.tvDay);
        tvYear = (TextView) view.findViewById(R.id.tvYear);

        setHasOptionsMenu(true);

        //tvMonth.setText(String .valueOf((Calendar.getInstance().get(Calendar.MONTH) + 1)));
        Calendar cal=Calendar.getInstance();
        SimpleDateFormat month_date = new SimpleDateFormat("MMMM");
        tvMonth.setText(month_date.format(cal.getTime()));


        tvDay.setText(String .valueOf((Calendar.getInstance().get(Calendar.DAY_OF_WEEK_IN_MONTH)+ 1)));
        Log.d("day", tvDay.toString());
        tvYear.setText(String .valueOf((Calendar.getInstance().get(Calendar.YEAR))));

        //FRAGMENTS
        fragment1DownCalend = new Fragment1DownCalend();
        fragment2DownCalend = new Fragment2DownCalend();

        //BUTTONS OF FRAGMENTS
        myTask = (Button)view.findViewById(R.id.myTask);
        taskOoFriend = (Button)view.findViewById(R.id.taskOoFriend);

        fTrans = getFragmentManager().beginTransaction();
        fTrans.replace(R.id.frgmCont, fragment1DownCalend);
        fTrans.commit();

        myTask.setOnClickListener(this);
        taskOoFriend.setOnClickListener(this);





//      Set up listeners.
        expCalendarView.setOnDateClickListener(new OnExpDateClickListener()).setOnMonthScrollListener(new OnMonthScrollListener() {
            @Override
            public void onMonthChange(int year, int month){


                Calendar cal = Calendar.getInstance();
                SimpleDateFormat month_date = new SimpleDateFormat("MMMM");
                cal.set(Calendar.MONTH, month);
                SimpleDateFormat dayName = new SimpleDateFormat("EEEE");
                Date day = new Date();
                //String day_name = day.format;
                String month_name = month_date.format(cal.getTime());
                tvMonth.setText(month_name);
                tvYear.setText(String.valueOf(year));

            }

            @Override
            public void onMonthScroll(float positionOffset) {
                 Log.i("listener", "onMonthScroll:" + positionOffset);
            }
        });

        imageInit();

        expCalendarView.setOnDateClickListener(new OnDateClickListener() {
            @Override
            public void onDateClick(View view, DateData date) {
                Log.d("data1", date.getDayString());
                if (view instanceof DefaultCellView) {

                    if (lastClickedView != null) {
                        if (lastClickedView == view) {
                            return;
                        }
                        if (lastClickedDate.equals(CurrentCalendar.getCurrentDateData())) {
                            ((DefaultCellView) lastClickedView).setDateToday();
                        } else {
                            ((DefaultCellView) lastClickedView).setDateNormal();
                        }
                    }
                    ((DefaultCellView) view).setDateChoose();
                    lastClickedView = view;
                    lastClickedDate = date;
                }
            }
        });

        expCalendarView.markDate(2016, 10, 16);
        return view;
    }


    private boolean ifExpand = true;

    private void imageInit() {
        final ImageView expandIV = (ImageView) view.findViewById(R.id.main_expandIV);
        expandIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ifExpand) {
                    CellConfig.Month2WeekPos = CellConfig.middlePosition;
                    CellConfig.ifMonth = false;
                    expandIV.setImageResource(R.drawable.ic_hideon);
                    expCalendarView.shrink();
                } else {
                    CellConfig.Week2MonthPos = CellConfig.middlePosition;
                    CellConfig.ifMonth = true;
                    expandIV.setImageResource(R.drawable.ic_hideonoff);
                    expCalendarView.expand();
                }
                ifExpand = !ifExpand;
            }
        });
    }

    @Override
    public void onClick(View v) {
        fTrans = getFragmentManager().beginTransaction();
        switch (v.getId()){
            case R.id.myTask:
                fTrans.replace(R.id.frgmCont, fragment1DownCalend);
                myTask.setBackgroundResource(R.drawable.but_mytask_click);
                taskOoFriend.setBackgroundResource(R.drawable.but_taskfriend_unclick);
                break;
            case R.id.taskOoFriend:
                fTrans.replace(R.id.frgmCont, fragment2DownCalend);
                myTask.setBackgroundResource(R.drawable.but_mytask_unclick);
                taskOoFriend.setBackgroundResource(R.drawable.but_taskfriend_click);
                break;
        }
        fTrans.addToBackStack(null);
        fTrans.commit();
    }
}
