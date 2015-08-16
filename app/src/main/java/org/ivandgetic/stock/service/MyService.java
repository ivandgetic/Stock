package org.ivandgetic.stock.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.IBinder;
import android.widget.Toast;

import org.ivandgetic.stock.AppConfig;
import org.ivandgetic.stock.task.IndexStockRefreshTask;
import org.ivandgetic.stock.task.OptionStockRefreshTask;
import org.ivandgetic.stock.unit.StockUnit;

import java.util.ArrayList;
import java.util.List;

public class MyService extends Service {
    public static List<StockUnit> stockOverviewList = new ArrayList<StockUnit>();
    public static List<StockUnit> optionStockUnitList = new ArrayList<StockUnit>();
    public static List<String> optionStockCodeList = new ArrayList<String>();

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        stockOverviewList.add(new StockUnit("上证指数", "0.00", "0.00", "0.00"));
        stockOverviewList.add(new StockUnit("深证成指", "0.00", "0.00", "0.00"));
        stockOverviewList.add(new StockUnit("创业板指", "0.00", "0.00", "0.00"));
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    if (AppConfig.isOpen) {
                        new IndexStockRefreshTask().execute();
                        new OptionStockRefreshTask().execute();
                    }
                    try {
                        Thread.sleep(6000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            thread.start();
        } else {
            Toast.makeText(this, "没有网络连接", Toast.LENGTH_SHORT).show();
        }
        optionStockCodeList.add("002506");
        optionStockCodeList.add("600868");
        optionStockCodeList.add("600876");
        optionStockCodeList.add("000417");
        optionStockCodeList.add("002006");
        optionStockCodeList.add("300111");
        optionStockCodeList.add("002298");
        optionStockCodeList.add("300170");
        optionStockCodeList.add("002345");
        optionStockCodeList.add("002367");
        for (int i = 0; i < optionStockCodeList.size(); i++) {
            optionStockUnitList.add(new StockUnit("null", "000000", 0.00f, 0.00f, 0.00f));
        }
    }


}
