package org.ivandgetic.stock.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.IBinder;
import android.widget.Toast;

import org.ivandgetic.stock.task.IndexStockRefreshTask;
import org.ivandgetic.stock.unit.StockUnit;

import java.util.ArrayList;
import java.util.List;

public class MyService extends Service {
    public static List<StockUnit> stockOverallList = new ArrayList<StockUnit>();
    public static List<StockUnit> optionStockUnitList = new ArrayList<StockUnit>();
    public static List<String> optionStockCodeList=new ArrayList<String>();

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        stockOverallList.add(new StockUnit("上证指数", 0f, 0f, 0f));
        stockOverallList.add(new StockUnit("深证成指", 0f, 0f, 0f));
        stockOverallList.add(new StockUnit("创业板指", 0f, 0f, 0f));
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            new IndexStockRefreshTask().execute();
        } else {
            Toast.makeText(this, "没有网络连接", Toast.LENGTH_SHORT).show();
        }
        MyService.optionStockUnitList.add(new StockUnit("向日葵", "300111", 0.00f, 0.00f));
        MyService.optionStockUnitList.add(new StockUnit("鑫龙电器", "002298", 0.00f, 0.00f));
        MyService.optionStockUnitList.add(new StockUnit("汉得信息", "300170", 0.00f, 0.00f));
        optionStockCodeList.add("sz300111");
        optionStockCodeList.add("sz002298");
        optionStockCodeList.add("sz300170");
    }


}
