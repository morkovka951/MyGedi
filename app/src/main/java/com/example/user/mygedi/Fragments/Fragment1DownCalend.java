package com.example.user.mygedi.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.user.mygedi.R;

/**
 * Created by Morkovka on 09.07.2017.
 */


public class Fragment1DownCalend extends Fragment {

    String[] name = {"Oleg", "Sergey", "Alekcandr"};
//    String[] surname = {"Marchenko", "Slinenko", "Elkin"};

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment1_down_calend, container, false);
        ListView lvFrag1 = (ListView)view.findViewById(R.id.lvFrag1);
        ArrayAdapter <String> adapter = new ArrayAdapter<String>(getActivity().getApplicationContext(), R.layout.list_view_frag1, name);

        lvFrag1.setAdapter(new ArrayAdapter<String>(view.getContext(), R.layout.list_view_frag1, name));


//        LinearLayout linLayoutFragm1 = (LinearLayout) getActivity().findViewById(R.id.linLayoutFragm1);
//        LayoutInflater layoutInflater = getActivity().getLayoutInflater();
//        View view = layoutInflater.inflate(R.layout.list_view_frag1, linLayoutFragm1, false);
//
//        for (int i = 0; i < name.length; i++) {
//            View view1 = layoutInflater.inflate(R.layout.list_view_frag1, linLayoutFragm1, false);
//            TextView tvNamefr1 = (TextView) view.findViewById(R.id.tvNamefr1);
//            tvNamefr1.setText(name[i]);
//
//            TextView tvSurnamefr1 = (TextView) view.findViewById(R.id.tvSurnamefr1);
//            tvSurnamefr1.setText(surname[i]);
//        }

        return (view);
        }

}