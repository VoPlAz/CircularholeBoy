package net.wind;

import net.wind.core.Config.MakeConfig;
import net.wind.core.Listening.ListenMain;
import net.wind.utils.HttpUtils;


import java.io.*;
import java.net.*;
import java.util.*;


/**
 * createTime 2022/10/7 0007
 * fileName BoyLoader
 *
 * @author WindStream
 */

public class BoyLoader {
    //梦开始的的地方
    //Load Infomation With Program
    public static String SoftWareName = "CircularHoleBoy";//圆孔小子
    public static String ProgramVersion = "v10 Lite";
    public static String Author = "WindStream";
    public static String Team = "StreamLgiht";
    public static String sqlitSigh = File.separator;
    public static List<String> Host_List = new ArrayList<String>();
    public static String WorkingDir = System.getProperty("user.dir");
    public static String phpClient = "";
    public static String sip;
    public static String usedIP;
    public static int userPort;

    //Build Main Class
    public static void main(String[] args) throws IOException, InterruptedException {
        //Use The LoaderText() to Show Boot Text
        LoaderText();

        //MakeConfig
        if(MakeConfig.isFirst()) {
            //startListen
            ListenMain.StartListening();
        }else {
            //Get Listen Address
            Scanner sc = new Scanner(System.in);
            print("For In ---> "+sip);
            print("For Out ---> "+getIp());
            /*print(">>>Press The Listen Address:","");
            usedIP = sc.next();
            print(usedIP);
            print(">>>Press The Listen Port[11451]:","");
            userPort = sc.nextInt();
            print(userPort);*/

            //MakePayload
            MakeConfig.makeconfigDir("Payload");

            //MakePayload.createPayload(usedIP,userPort);

            //MakeConfig
            MakeConfig.makeconfigDir("Config");

            //forward to Listen
            ListenMain.StartListening();
        }
    }



    //Load Info
    private static void LoaderText(){
        print(SoftWareName + " | " +ProgramVersion+" && By StreamLgiht");
        print();

        //Load System Info
        {
            try {
                InetAddress ip = InetAddress.getLocalHost();
                sip = ip.getHostAddress();
            } catch (UnknownHostException e) {
                sip = "Unknown";
                throw new RuntimeException(e);
            }
            String SystemName = getLocalSystemName();
            String IP = getIp();
            print("Local Info:");
            print("Your SystemName ----> " + SystemName);
            print("Your Computer IP ----> " + getIp()+" / ("+sip+")");
        }

        print();
        //Show The Licence
        print("This Program is under MIT Licence , Please Follow The MIT Licence.");

        //test dir
        //print(WorkingDir);
    }
    //Get Server Ip
    public static String getIp(){
        String IP = HttpUtils.doGet("http://ident.me/");
        return IP;
    }


    //Get The Name With Local System,return Like Windows 7
    private static String getLocalSystemName(){
        Properties sysProperty = System.getProperties();
        String systemName = sysProperty.getProperty("os.name");

        return systemName;
    }


        //ReBuild Print Like Python : print("HelloWorld")
        private static final String dend = "\n";
        public static void print (String Info, String end){
        System.out.print(Info + end);
    }
        public static void print ( boolean Info, String end){
        System.out.print(Info + end);
    }
        public static void print ( char Info, String end){
        System.out.print(Info + end);
    }
        public static void print ( int Info, String end){
        System.out.print(Info + end);
    }
        public static void print (Long Info, String end){
        System.out.print(Info + end);
    }
        public static void print ( char[] Info, String end){
        System.out.print(Info + end);
    }
        public static void print (Object Info, String end){
        System.out.print(Info + end);
    }
        public static void print ( float Info, String end){
        System.out.print(Info + end);
    }
        public static void print ( double Info, String end){
        System.out.print(Info + end);
    }
        public static void print (String Info){
        System.out.print(Info + dend);
    }
        public static void print ( boolean Info){
        System.out.print(Info + dend);
    }
        public static void print ( char Info){
        System.out.print(Info + dend);
    }
        public static void print ( int Info){
        System.out.print(Info + dend);
    }
        public static void print (Long Info){
        System.out.print(Info + dend);
    }
        public static void print ( char[] Info){
        System.out.print(Info + dend);
    }
        public static void print (Object Info){
        System.out.print(Info + dend);
    }
        public static void print ( float Info){
        System.out.print(Info + dend);
    }
        public static void print ( double Info){
        System.out.print(Info + dend);
    }
        public static void print () {
        System.out.print(dend);
    }

    //The Rebuild End

}
