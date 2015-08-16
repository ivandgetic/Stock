package org.ivandgetic.stock.adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.ivandgetic.stock.R;
import org.ivandgetic.stock.activity.MainActivity;
import org.ivandgetic.stock.service.MyService;
import org.ivandgetic.stock.unit.StockUnit;

import java.text.DecimalFormat;

/**
 * Created by ivandgetic on 2015/7/19 0019.
 */
public class OptionStockAdapter extends BaseAdapter {

    @Override
    public int getCount() {
        return MyService.optionStockUnitList.size();
    }

    @Override
    public StockUnit getItem(int position) {
        return MyService.optionStockUnitList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        StockUnit stock = getItem(position);
        convertView = LayoutInflater.from(MainActivity.getMainActivity()).inflate(R.layout.option_stock, null);
        TextView textViewName = ((TextView) convertView.findViewById(R.id.name));
        textViewName.setText(stock.getName());
        TextView textViewCode = ((TextView) convertView.findViewById(R.id.code));
        textViewCode.setText(stock.getCode() + "");
        TextView textViewPrice = ((TextView) convertView.findViewById(R.id.price));
        TextView textViewQuoteChange = ((TextView) convertView.findViewById(R.id.quoteChange));
        TextView textViewChange = (TextView) convertView.findViewById(R.id.change);
        if (stock.getPrice() > 0) {
            textViewPrice.setText(decimalFormat.format(stock.getPrice()));
            textViewQuoteChange.setText(decimalFormat.format(stock.getQuoteChange()) + "%");
            textViewChange.setText(decimalFormat.format(stock.getChange()));
        } else {
            textViewPrice.setText("--");
            textViewQuoteChange.setText("--");
            textViewChange.setText("--");
        }


        if (stock.getQuoteChange() > 0) {
            textViewPrice.setTextColor(Color.RED);
            textViewQuoteChange.setTextColor(Color.RED);
            textViewChange.setTextColor(Color.RED);
        } else if (stock.getQuoteChange() == 0) {
            textViewPrice.setTextColor(Color.BLACK);
            textViewQuoteChange.setTextColor(Color.BLACK);
            textViewChange.setTextColor(Color.BLACK);
        } else if (stock.getQuoteChange() < 0) {
            textViewPrice.setTextColor(0xFF009900);
            textViewQuoteChange.setTextColor(0xFF009900);
            textViewChange.setTextColor(0xFF009900);
        }

        return convertView;
    }
}
