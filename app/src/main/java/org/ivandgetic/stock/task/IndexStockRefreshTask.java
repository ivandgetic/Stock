package org.ivandgetic.stock.task;

import android.os.AsyncTask;

import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.ivandgetic.stock.unit.StockUnit;
import org.ivandgetic.stock.fragment.OverviewFragment;
import org.ivandgetic.stock.service.MyService;

import java.io.IOException;
import java.net.MalformedURLException;

/**
 * Created by ivandgetic on 2015/7/20 0020.
 */
public class IndexStockRefreshTask extends AsyncTask<Void, Void, String> {
    @Override
    protected String doInBackground(Void... params) {
        String resultString = null;
        try {
            HttpClient httpClient = new DefaultHttpClient();
            HttpGet httpGet = new HttpGet("http://hq.sinajs.cn/list=s_sh000001,s_sz399001,s_sz399006");
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
        String[] information = s.split(";");
        for (int i=0;i<=2;i++){
            MyService.stockOverviewList.set(i, new StockUnit(((information[i].split(","))[0].split("\""))[1], (information[i].split(","))[1], (information[i].split(","))[2], (information[i].split(","))[3]));
        }
        OverviewFragment.update();
    }
}
