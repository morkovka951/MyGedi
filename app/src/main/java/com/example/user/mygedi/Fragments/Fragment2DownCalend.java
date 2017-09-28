package com.example.user.mygedi.Fragments;
        import android.app.Fragment;
        import android.os.Bundle;
        import android.support.annotation.Nullable;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ArrayAdapter;
        import android.widget.ListView;

        import com.example.user.mygedi.R;

/**
 * Created by Morkovka on 09.07.2017.
 */

public class Fragment2DownCalend extends Fragment{

    String[] name = { "Лампа", "Лошадь", "Доска", "Кофе", "Фломастер", "Кепка", "Сапочи", "Лосось", "Джинсы" };

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment2_down_calend, container, false);
        ListView lvFrag2 = (ListView)view.findViewById(R.id.lvFrag2);
        ArrayAdapter <String> adapter = new ArrayAdapter<String>(getActivity().getApplicationContext(), R.layout.list_view_frag1, name);
        lvFrag2.setAdapter(new ArrayAdapter<String>(view.getContext(), R.layout.list_view_frag1, name));
        return view;

    }

}
