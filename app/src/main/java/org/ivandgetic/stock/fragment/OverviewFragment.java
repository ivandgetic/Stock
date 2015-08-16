package org.ivandgetic.stock.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.ivandgetic.stock.R;
import org.ivandgetic.stock.service.MyService;

import java.text.DecimalFormat;

public class OverviewFragment extends Fragment {
    private static TextView SZZSprice, SZZSchange, SZZSquoteChange;
    private static TextView SZCZprice, SZCZchange, SZCZquoteChange;
    private static TextView CYBZprice, CYBZchange, CYBZquoteChange;

    public static void update() {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        //上证指数
        SZZSprice.setText(decimalFormat.format(MyService.stockOverviewList.get(0).getPrice()));
        SZZSchange.setText(decimalFormat.format(MyService.stockOverviewList.get(0).getChange()));
        SZZSquoteChange.setText(decimalFormat.format(MyService.stockOverviewList.get(0).getQuoteChange()) + "%");
        //深证成指
        SZCZprice.setText(decimalFormat.format(MyService.stockOverviewList.get(1).getPrice()));
        SZCZchange.setText(decimalFormat.format(MyService.stockOverviewList.get(1).getChange()));
        SZCZquoteChange.setText(decimalFormat.format(MyService.stockOverviewList.get(1).getQuoteChange()) + "%");
        //创业板指
        CYBZprice.setText(decimalFormat.format(MyService.stockOverviewList.get(2).getPrice()));
        CYBZchange.setText(decimalFormat.format(MyService.stockOverviewList.get(2).getChange()));
        CYBZquoteChange.setText(decimalFormat.format(MyService.stockOverviewList.get(2).getQuoteChange()) + "%");
        //改变字体颜色
        if (MyService.stockOverviewList.get(0).getChange() > 0) {
            SZZSprice.setTextColor(Color.RED);
            SZZSchange.setTextColor(Color.RED);
            SZZSquoteChange.setTextColor(Color.RED);
        } else if (MyService.stockOverviewList.get(0).getChange() == 0) {
            SZZSprice.setTextColor(Color.BLACK);
            SZZSchange.setTextColor(Color.BLACK);
            SZZSquoteChange.setTextColor(Color.BLACK);
        } else if (MyService.stockOverviewList.get(0).getChange() < 0) {
            SZZSprice.setTextColor(0xFF009900);
            SZZSchange.setTextColor(0xFF009900);
            SZZSquoteChange.setTextColor(0xFF009900);
        }
        if (MyService.stockOverviewList.get(1).getChange() > 0) {
            SZCZprice.setTextColor(Color.RED);
            SZCZchange.setTextColor(Color.RED);
            SZCZquoteChange.setTextColor(Color.RED);
        } else if (MyService.stockOverviewList.get(1).getChange() == 0) {
            SZCZprice.setTextColor(Color.BLACK);
            SZCZchange.setTextColor(Color.BLACK);
            SZCZquoteChange.setTextColor(Color.BLACK);
        } else if (MyService.stockOverviewList.get(1).getChange() < 0) {
            SZCZprice.setTextColor(0xFF009900);
            SZCZchange.setTextColor(0xFF009900);
            SZCZquoteChange.setTextColor(0xFF009900);
        }
        if (MyService.stockOverviewList.get(2).getChange() > 0) {
            CYBZprice.setTextColor(Color.RED);
            CYBZchange.setTextColor(Color.RED);
            CYBZquoteChange.setTextColor(Color.RED);
        } else if (MyService.stockOverviewList.get(2).getChange() == 0) {
            CYBZprice.setTextColor(Color.BLACK);
            CYBZchange.setTextColor(Color.BLACK);
            CYBZquoteChange.setTextColor(Color.BLACK);
        } else if (MyService.stockOverviewList.get(2).getChange() < 0) {
            CYBZprice.setTextColor(0xFF009900);
            CYBZchange.setTextColor(0xFF009900);
            CYBZquoteChange.setTextColor(0xFF009900);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_section_overview, container, false);
        //上证指数
        SZZSprice = (TextView) rootView.findViewById(R.id.SZZSprice);
        SZZSchange = (TextView) rootView.findViewById(R.id.SZZSchange);
        SZZSquoteChange = (TextView) rootView.findViewById(R.id.SZZSquoteChange);
        //深证成指
        SZCZprice = (TextView) rootView.findViewById(R.id.SZCZprice);
        SZCZchange = (TextView) rootView.findViewById(R.id.SZCZchange);
        SZCZquoteChange = (TextView) rootView.findViewById(R.id.SZCZquoteChange);
        //创业板指
        CYBZprice = (TextView) rootView.findViewById(R.id.CYBZprice);
        CYBZchange = (TextView) rootView.findViewById(R.id.CYBZchange);
        CYBZquoteChange = (TextView) rootView.findViewById(R.id.CYBZquoteChange);
        return rootView;
    }

}
