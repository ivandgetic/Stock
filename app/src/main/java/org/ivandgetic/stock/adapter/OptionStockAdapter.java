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
        return  MyService.optionStockUnitList.size();
    }

    @Override
    public StockUnit getItem(int position) {
        return  MyService.optionStockUnitList.get(position);
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
        textViewPrice.setText(decimalFormat.format(stock.getPrice()));
        TextView textViewQuoteChange = ((TextView) convertView.findViewById(R.id.quoteChange));
        textViewQuoteChange.setText(decimalFormat.format(stock.getQuoteChange()) + "%");
        if (stock.getQuoteChange() > 0) {
            textViewPrice.setTextColor(Color.RED);
            textViewQuoteChange.setTextColor(Color.RED);
        } else if (stock.getQuoteChange() == 0) {
            textViewPrice.setTextColor(Color.WHITE);
            textViewQuoteChange.setTextColor(Color.WHITE);
        } else if (stock.getQuoteChange() < 0) {
            textViewPrice.setTextColor(Color.GREEN);
            textViewQuoteChange.setTextColor(Color.GREEN);
        }
        return convertView;
    }
}
