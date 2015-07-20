package org.ivandgetic.stock.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.ivandgetic.stock.R;
import org.ivandgetic.stock.service.MyService;

import java.text.DecimalFormat;

public class OverallFragment extends Fragment {
    private static TextView SZZSprice, SZZSchange, SZZSquoteChange;
    private static TextView SZCZprice, SZCZchange, SZCZquoteChange;
    private static TextView CYBZprice, CYBZchange, CYBZquoteChange;
    private TextView SZZSname, SZCZname, CYBZname;
    private SwipeRefreshLayout swipeRefreshLayout;

    public static void update() {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        //上证指数
        SZZSprice.setText(decimalFormat.format(MyService.stockOverallList.get(0).getPrice()));
        SZZSchange.setText(decimalFormat.format(MyService.stockOverallList.get(0).getChange()));
        SZZSquoteChange.setText(decimalFormat.format(MyService.stockOverallList.get(0).getQuoteChange()) + "%");
        //深证成指
        SZCZprice.setText(decimalFormat.format(MyService.stockOverallList.get(1).getPrice()));
        SZCZchange.setText(decimalFormat.format(MyService.stockOverallList.get(1).getChange()));
        SZCZquoteChange.setText(decimalFormat.format(MyService.stockOverallList.get(1).getQuoteChange()) + "%");
        //创业板指
        CYBZprice.setText(decimalFormat.format(MyService.stockOverallList.get(2).getPrice()));
        CYBZchange.setText(decimalFormat.format(MyService.stockOverallList.get(2).getChange()));
        CYBZquoteChange.setText(decimalFormat.format(MyService.stockOverallList.get(2).getQuoteChange()) + "%");
        //改变字体颜色
        if (MyService.stockOverallList.get(0).getChange() > 0) {
            SZZSprice.setTextColor(Color.RED);
            SZZSchange.setTextColor(Color.RED);
            SZZSquoteChange.setTextColor(Color.RED);
        } else if (MyService.stockOverallList.get(0).getChange() == 0) {
            SZZSprice.setTextColor(Color.WHITE);
            SZZSchange.setTextColor(Color.WHITE);
            SZZSquoteChange.setTextColor(Color.WHITE);
        } else if (MyService.stockOverallList.get(0).getChange() < 0) {
            SZZSprice.setTextColor(Color.GREEN);
            SZZSchange.setTextColor(Color.GREEN);
            SZZSquoteChange.setTextColor(Color.GREEN);
        }
        if (MyService.stockOverallList.get(1).getChange() > 0) {
            SZCZprice.setTextColor(Color.RED);
            SZCZchange.setTextColor(Color.RED);
            SZCZquoteChange.setTextColor(Color.RED);
        } else if (MyService.stockOverallList.get(1).getChange() == 0) {
            SZCZprice.setTextColor(Color.WHITE);
            SZCZchange.setTextColor(Color.WHITE);
            SZCZquoteChange.setTextColor(Color.WHITE);
        } else if (MyService.stockOverallList.get(1).getChange() < 0) {
            SZCZprice.setTextColor(Color.GREEN);
            SZCZchange.setTextColor(Color.GREEN);
            SZCZquoteChange.setTextColor(Color.GREEN);
        }
        if (MyService.stockOverallList.get(2).getChange() > 0) {
            CYBZprice.setTextColor(Color.RED);
            CYBZchange.setTextColor(Color.RED);
            CYBZquoteChange.setTextColor(Color.RED);
        } else if (MyService.stockOverallList.get(2).getChange() == 0) {
            CYBZprice.setTextColor(Color.WHITE);
            CYBZchange.setTextColor(Color.WHITE);
            CYBZquoteChange.setTextColor(Color.WHITE);
        } else if (MyService.stockOverallList.get(2).getChange() < 0) {
            CYBZprice.setTextColor(Color.GREEN);
            CYBZchange.setTextColor(Color.GREEN);
            CYBZquoteChange.setTextColor(Color.GREEN);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_section_overall, container, false);
        //上证指数
        SZZSname = (TextView) rootView.findViewById(R.id.SZZSname);
        SZZSprice = (TextView) rootView.findViewById(R.id.SZZSprice);
        SZZSchange = (TextView) rootView.findViewById(R.id.SZZSchange);
        SZZSquoteChange = (TextView) rootView.findViewById(R.id.SZZSquoteChange);
        //深证成指
        SZCZname = (TextView) rootView.findViewById(R.id.SZCZname);
        SZCZprice = (TextView) rootView.findViewById(R.id.SZCZprice);
        SZCZchange = (TextView) rootView.findViewById(R.id.SZCZchange);
        SZCZquoteChange = (TextView) rootView.findViewById(R.id.SZCZquoteChange);
        //创业板指
        CYBZname = (TextView) rootView.findViewById(R.id.CYBZname);
        CYBZprice = (TextView) rootView.findViewById(R.id.CYBZprice);
        CYBZchange = (TextView) rootView.findViewById(R.id.CYBZchange);
        CYBZquoteChange = (TextView) rootView.findViewById(R.id.CYBZquoteChange);
        return rootView;
    }

}
