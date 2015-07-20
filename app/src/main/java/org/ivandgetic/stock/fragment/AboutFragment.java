package org.ivandgetic.stock.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.ivandgetic.stock.R;

public class AboutFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_section_about, container, false);
        ((TextView) rootView.findViewById(R.id.textView)).setText("关于");
        return rootView;
    }


}
