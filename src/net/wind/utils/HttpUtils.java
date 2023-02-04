package net.wind.utils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

/**
 * createTime 2022/10/7 0007
 * fileName HttpUtils
 *
 * @author WindStream
 */

public class HttpUtils {
    public static String doGet(String URL){
        //String[] htmlCode = {"#","%","&","+"," ","\\","=","?"};
        //String[] encode = {"[wind1]","[wind2]","[wind3]","[wind4]","[wind5]","[wind6]","[wind7]","[wind8]"};
        URL=URL.replace(" ","[wind1]").replace("#","[wind2]").replace("+","[wind3]").replace("\n","[wind5]").replace("\\","[wind4]");//.replace("\n","[wind5]");
        //String URL=URL1.replace(" ","[wind1337:sp]");
        HttpURLConnection conn = null;
        InputStream is = null;
        BufferedReader br = null;
        StringBuilder result = new StringBuilder();
        try{
            java.net.URL url = new URL(URL);

            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            conn.setConnectTimeout(15000);
            conn.setReadTimeout(60000);
            conn.setRequestProperty("Accept", "application/json");

            conn.connect();
            if (200 == conn.getResponseCode()){
                is = conn.getInputStream();
                br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                String line;
                while ((line = br.readLine()) != null){
                    result.append(line);
                    //System.out.println(line);
                }
            }else{
                return "null";
            }
        }catch (MalformedURLException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                if(br != null){
                    br.close();
                }
                if(is != null){
                    is.close();
                }
            }catch (IOException ioe){
                ioe.printStackTrace();
            }
            conn.disconnect();
        }
        return result.toString().replace("[wind1]"," ").replace("[wind2]","#").replace("[wind3]","+").replace("[wind4]","\\").replace("[wind5]","\n");//.replace("[wind5]","\n");
        //return result.toString().replace("[wind1337:sp]"," ").replace("[wind1337]","\n");
    }
    public static Map<String, Object> doPost(String url, String content) {
        Map<String, Object> result = new HashMap<String, Object>();
        String errorStr = "";
        String status = "";
        String response = "";
        PrintWriter out = null;
        BufferedReader in = null;
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            HttpURLConnection httpUrlConnection = (HttpURLConnection) conn;
            // 设置请求属性
            httpUrlConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
            //httpUrlConnection.setRequestProperty("", "2.1");
            // 发送POST请求必须设置如下两行
            httpUrlConnection.setDoOutput(true);
            httpUrlConnection.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(httpUrlConnection.getOutputStream());
            // 发送请求参数
            out.write(content);
            // flush输出流的缓冲
            out.flush();
            httpUrlConnection.connect();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(httpUrlConnection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                response += line;
            }
            status = new Integer(httpUrlConnection.getResponseCode()).toString();
        } catch (Exception e) {
            //System.out.println("发送 POST 请求出现异常！" + e);
            errorStr = e.getMessage();
        }
        // 使用finally块来关闭输出流、输入流
        finally {
            try {
                if (out != null) { out.close();}
                if (in != null) {in.close();}
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        result.put("errorStr", errorStr);
        result.put("response", response);
        result.put("status", status);
        return result;
    }
}
