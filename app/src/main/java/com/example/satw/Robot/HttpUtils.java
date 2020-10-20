package com.example.satw.Robot;

import com.google.gson.Gson;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Date;

public class HttpUtils {

    /**
     * 傳送訊息到伺服器
     *
     * @param message ：傳送的訊息
     * @return：訊息物件
     */
    public static ChatMessage sendMessage(String message) {
        ChatMessage chatMessage = new ChatMessage();
        String gsonResult = doGet(message);
        Gson gson = new Gson();
        Result result = null;
        if (gsonResult != null) {
            try {
                result = gson.fromJson(gsonResult, Result.class);
                chatMessage.setMessage(result.getText());
            } catch (Exception e) {
                chatMessage.setMessage("伺服器繁忙，請稍候再試...");
            }
        }
        chatMessage.setData(new Date());
        chatMessage.setType(ChatMessage.Type.INCOUNT);
        return chatMessage;
    }

    /**
     * get請求
     *
     * @param message ：傳送的話
     * @return：資料
     */
    public static String doGet(String message) {
        String result = "";
        String url = setParmat(message);
        System.out.println("------------url = " + url);
        InputStream is = null;
        ByteArrayOutputStream baos = null;
        try {
            URL urls = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) urls
                    .openConnection();
            connection.setReadTimeout(5 * 1000);
            connection.setConnectTimeout(5 * 1000);
            connection.setRequestMethod("GET");

            is = connection.getInputStream();
            baos = new ByteArrayOutputStream();
            int len = -1;
            byte[] buff = new byte[1024];
            while ((len = is.read(buff)) != -1) {
                baos.write(buff, 0, len);
            }
            baos.flush();
            result = new String(baos.toByteArray());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (baos != null) {
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    /**
     * 設定引數
     *
     * @param message : 資訊
     * @return ： url
     */
    private static String setParmat(String message) {
        String url = "";
        try {
            url = Config.URL_KEY + "?" + "key=" + Config.APP_KEY + "&info="
                    + URLEncoder.encode(message, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return url;
    }
}
