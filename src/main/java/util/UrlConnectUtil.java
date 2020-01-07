package util;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class UrlConnectUtil {

    @Test
    public void test() {
        System.out.println(getUrlData("http://hhwoa2.gdyd.com/indikm/doc/docstorage_1.nsf/suPrintXMLeip?openagent"));
    }

    public String getUrlData(String url) {
        String dataStr;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            URL connectUrl = new java.net.URL(url);
            HttpURLConnection httpURLConnection = (HttpURLConnection) connectUrl.openConnection();
            httpURLConnection.connect();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
            while ((dataStr = bufferedReader.readLine()) != null) {
                stringBuilder.append(dataStr);
            }
            return stringBuilder.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
