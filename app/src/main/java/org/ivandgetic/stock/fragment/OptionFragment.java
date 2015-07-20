package org.ivandgetic.stock.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import org.ivandgetic.stock.adapter.OptionStockAdapter;
import org.ivandgetic.stock.R;
import org.ivandgetic.stock.task.OptionStockRefreshTask;

public class OptionFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {
    public static SwipeRefreshLayout swipeRefreshLayout;
    public static OptionStockAdapter optionStockAdapter;
    private Button button;
    private ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_section_optional, container, false);
        listView = (ListView) rootView.findViewById(R.id.listView);
        optionStockAdapter = new OptionStockAdapter();
        listView.setAdapter(optionStockAdapter);
        optionStockAdapter.notifyDataSetChanged();
        button = (Button) rootView.findViewById(R.id.addButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //todo
            }
        });
        swipeRefreshLayout = (SwipeRefreshLayout) rootView.findViewById(R.id.swipe_container);
        swipeRefreshLayout.setColorScheme(android.R.color.holo_blue_bright, android.R.color.holo_green_light, android.R.color.holo_orange_light, android.R.color.holo_red_light);
        swipeRefreshLayout.setOnRefreshListener(this);
        return rootView;
    }


    @Override
    public void onRefresh() {
        new Handler().post(new Runnable() {
            @Override
            public void run() {
                new OptionStockRefreshTask().execute();
            }
        });
    }
}
