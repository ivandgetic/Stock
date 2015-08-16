package org.ivandgetic.stock.activity;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toolbar;

import org.ivandgetic.stock.R;
import org.ivandgetic.stock.service.MyService;

public class StockDetailActivity extends Activity {
    private ActionBar actionBar;
    private TextView stockName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stock_detail);
        actionBar = getActionBar();
        actionBar.setTitle(MyService.optionStockUnitList.get(getIntent().getIntExtra("position",0)).getName());
        //actionBar.setDisplayShowCustomEnabled(true);
        //View view = LayoutInflater.from(this).inflate(R.layout.actionbar_stock_detail, null);
        //stockName = (TextView) view.findViewById(R.id.stockName);
        //stockName.setText(MyService.optionStockUnitList.get(getIntent().getIntExtra("position",0)).getName());
        //actionBar.setCustomView(view);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_stock_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
