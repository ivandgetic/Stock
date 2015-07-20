package org.ivandgetic.stock.task;

import android.os.AsyncTask;

import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.ivandgetic.stock.fragment.OptionFragment;
import org.ivandgetic.stock.service.MyService;
import org.ivandgetic.stock.unit.StockUnit;

import java.io.IOException;
import java.net.MalformedURLException;

/**
 * Created by ivandgetic on 2015/7/20 0020.
 */
public class OptionStockRefreshTask extends AsyncTask<Void, Void, String> {

    @Override
    protected String doInBackground(Void... params) {
        String resultString = null;
        String inquireCode = null;

        for (String tempString : MyService.optionStockCodeList) {
            if (inquireCode == null) {
                inquireCode = tempString;
            } else {
                inquireCode = inquireCode + "," + tempString;
            }
        }
        try {
            HttpClient httpClient = new DefaultHttpClient();
            HttpGet httpGet = new HttpGet("http://hq.sinajs.cn/list=" + inquireCode);
            ResponseHandler<String> responseHandler = new BasicResponseHandler();
            String responseBody = httpClient.execute(httpGet, responseHandler);
            resultString = new String(responseBody.getBytes("GBK"), "GBK");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultString;
    }

    @Override
    protected void onPostExecute(String s) {
        System.out.println(s);
        String[] information = s.split(";");
        for (int i = 0; i < information.length - 1; i++) {
            MyService.optionStockUnitList.set(i, new StockUnit((information[i].split(",")[0]).split("\"")[1], MyService.optionStockCodeList.get(i).substring(2, 8), Float.valueOf(information[i].split(",")[3]), ((Float.valueOf(information[i].split(",")[3]) - Float.valueOf(information[i].split(",")[2])) / Float.valueOf(information[i].split(",")[2])) * 100));
        }
        OptionFragment.optionStockAdapter.notifyDataSetChanged();
        OptionFragment.swipeRefreshLayout.setRefreshing(false);
        super.onPostExecute(s);
    }
}
