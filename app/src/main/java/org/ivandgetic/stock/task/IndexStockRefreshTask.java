package org.ivandgetic.stock.task;

import android.os.AsyncTask;

import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.ivandgetic.stock.unit.StockUnit;
import org.ivandgetic.stock.fragment.OverallFragment;
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
            HttpGet httpGet = new HttpGet("http://hq.sinajs.cn/list=sh000001,sz399001,sz399006");
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
        String SZZS=(s.split(";"))[0];
        String SZCZ=(s.split(";"))[1];
        String CYBZ=(s.split(";"))[2];
        Float SZZSzrPrice = Float.valueOf(SZZS.split(",")[2]);
        Float SZZSdqPrice = Float.valueOf(SZZS.split(",")[3]);
        Float SZCZzrPrice = Float.valueOf(SZCZ.split(",")[2]);
        Float SZCZdqPrice = Float.valueOf(SZCZ.split(",")[3]);
        Float CYBZzrPrice = Float.valueOf(CYBZ.split(",")[2]);
        Float CYBZdqPrice = Float.valueOf(CYBZ.split(",")[3]);
        MyService.stockOverallList.set(0, new StockUnit("上证指数", SZZSdqPrice, SZZSdqPrice - SZZSzrPrice, ((SZZSdqPrice - SZZSzrPrice) / SZZSzrPrice) * 100));
        MyService.stockOverallList.set(1, new StockUnit("上证指数", SZCZdqPrice, SZCZdqPrice - SZCZzrPrice, ((SZCZdqPrice - SZCZzrPrice) / SZCZzrPrice) * 100));
        MyService.stockOverallList.set(2, new StockUnit("上证指数", CYBZdqPrice, CYBZdqPrice - CYBZzrPrice, ((CYBZdqPrice - CYBZzrPrice) / CYBZzrPrice) * 100));
        OverallFragment.update();
    }
}
